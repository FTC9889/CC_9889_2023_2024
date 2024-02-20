package com.team9889.ftc2023.subsystems;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Intake {
    public DcMotorEx intake;
    public DcMotorEx extend;

    public int extendPosition(){
        return extend.getCurrentPosition();}
    public DigitalChannel digitalTouch;
    Servo vfb, gate;

    public ColorSensor color;


    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotorEx.class, "intake");

        extend = hardwareMap.get(DcMotorEx.class, "extend");
        extend.setDirection(DcMotorSimple.Direction.REVERSE);

        vfb = hardwareMap.servo.get("vfb");
        gate = hardwareMap.servo.get("gate");

        digitalTouch = hardwareMap.digitalChannel.get("intakemagnet");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);

        color = hardwareMap.get(ColorSensor.class, "Color");

        extend.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extend.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    //turn on intake
    //turn off intake
    public void setPower(double power){
        if(power < 0) {
            if (digitalTouch.getState()) {
                extend.setPower(power);
            } else {
                extend.setPower(0);
                if(Math.abs(extend.getCurrentPosition()) > 20) {
                    extend.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    extend.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                }
            }
        } else {
            int maxExtension = 570;
            if (extend.getCurrentPosition() < maxExtension){
                extend.setPower(power);
            } else {
                extend.setPower(0);
            }
        }
    }

    public boolean canIntake () {
        return !digitalTouch.getState();
    }
    public boolean canTransfer (){
        return digitalTouch.getState() && vfbUp;
    }

    public void on() {
        intake.setPower(1);
    }

    public void off() {
        intake.setPower(0);
    }

    public void slowOn(){
        intake.setPower(0.1);
    }

    public void out() {
        intake.setPower(-1);
    }

    public void slow_out() {intake.setPower(-0.3);}

    public void openGate(){
        gate.setPosition(.65);
    }
    public void closeGate(){
        gate.setPosition(0.47);
    }

    public double currentDraw() {
        return intake.getCurrent(CurrentUnit.MILLIAMPS);
    }

    public boolean twoPixelsInIntake() {
        return currentDraw() > 3400;
    }

    public boolean detected(){
        return color.blue() > 600;
    }

boolean vfbUp=true;
    public void vfbUp(){
        vfb.setPosition(0.67);
        vfbUp=true;
    }

    public void  VFBAutoPostion(){
        vfb.setPosition(0.1);
    }
    public void vfbDown(){
        vfb.setPosition(0.02);
        vfbUp=false;
    }

    public void vfb5thPixleDown(){
        vfb.setPosition(0.21);
    }

    public void vfb4thPixleDown(){
        vfb.setPosition(0.15);
    }

    public void vfb3rdPixleDown(){
        vfb.setPosition(0.1);
    }



    public void startIntake(){
        closeGate();
        vfbDown();
        on();
    }

    public void stopIntake(){
       vfbUp();
       slowOn();
       closeGate();
    }

    public void transfer2(){
        vfbUp();
        openGate();
        slowOn();
    }

    public void transfer(){
        vfbUp();
        on();
        openGate();
    }

    // Extend intake to position
    public class ExtendIntake implements Action {

        int postion = 300;

        public ExtendIntake(int postion){
            this.postion = postion;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            double extensionCurrent = extend.getCurrent(CurrentUnit.MILLIAMPS);
            telemetryPacket.put("Step", "Intake Extend");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extensionCurrent);
            closeGate();
            if (Math.abs(extend.getCurrentPosition()) < postion &&
                    (extensionCurrent < 7000 || Math.abs(extend.getCurrentPosition()) < postion * 0.75))
            {
                extend.setPower(1);
                return true;
            }
            else{
                extend.setPower(0);
                return false;
            }
        }
    }

    public Action ExtendIntake(double distance){
        double tpr = 145.1;
        double spoolradius = 44 / 25.4 / 2;
        int ticks = (int) ((distance * tpr) / (2 * Math.PI * spoolradius));
        return new ExtendIntake(ticks);
    }
    public class RetractIntake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "Intake Extend");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            if (Math.abs(extend.getCurrentPosition()) > 15 && digitalTouch.getState()){
                extend.setPower(-1);
                return true;
            }
            else{
                extend.setPower(0);
                return false;
            }
        }
    }

    public Action RetractIntake(){
        return new RetractIntake();
    }


    // Put Intake Down
    public class DeployIntake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "Intake Deploy");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            vfbDown();
            return false;
        }
    }

    public Action Depl0yIntake(){
        return new DeployIntake();
    }

public class BringBackIntake implements Action {
    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        telemetryPacket.put("Step", "Bring Back Intake");
        telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
        telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
        vfbUp();
        return false;
    }
}

    public Action BringBackIntake(){
        return new BringBackIntake();
    }



    // Turn Intake Off
    public class Off implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "Intake Off");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            off();
            return false;
        }
    }
    public Action Off(){
        return new Off();
    }

    public class On implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "Intake On");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            on();
            closeGate();
            return false;
        }
    }
    public Action On() {
        return new On();
    }

    // Outtake
    public class Outtake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "Intake Outtake");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            slow_out();
            return false;
        }
    }

    public class Transfer implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "Transfer");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            transfer();
            return false;
        }
    }

    public class vfb5thpixle implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "vfb5thpixle");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            vfb5thPixleDown();
            return false;
        }
    }

    public Action vfb5thpixle() {
        return new vfb5thpixle();
    }
    public Action Transfer() {
        return new Transfer();
    }

    public Action Outtake(){
        return new Outtake();
    }



}

