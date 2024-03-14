package com.team9889.ftc2023.subsystems;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@Config
public class Intake {
    public DcMotorEx intake;
    public DcMotorEx extend;

    private int offset = 0;

    private void resetExtendPosition() {
        this.offset = extend.getCurrentPosition();
    }

    public int extendPosition(){
        return extend.getCurrentPosition() - offset;
    }

    public DigitalChannel digitalTouch;
    public Servo vfb, gate, Brake;

    public static double brake_on_position = 0.1;
    public static double brake_off_position = 0.33;

    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotorEx.class, "intake");

        extend = hardwareMap.get(DcMotorEx.class, "extend");
        extend.setDirection(DcMotorSimple.Direction.REVERSE);

        Brake = hardwareMap.servo.get("Brake");
        brake_off();

        vfb = hardwareMap.servo.get("vfb");
        gate = hardwareMap.servo.get("gate");

        digitalTouch = hardwareMap.digitalChannel.get("intakemagnet");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);

        extend.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        resetExtendPosition();
    }

    public void setPower(double power){
        if (Math.abs(power) > 0.02) brake_off();

        if(power < 0) {
            if (digitalTouch.getState()) {
                extend.setPower(power);
            } else {
                extend.setPower(0);
                resetExtendPosition();
            }
        } else {
            int maxExtension = 570;
            if (extendPosition() < maxExtension){
                extend.setPower(power);
            } else {
                extend.setPower(0);
            }
        }
    }

    public void  brake_on(){
        Brake.setPosition(brake_on_position);
    }

    public void brake_off(){
        Brake.setPosition(brake_off_position);
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
        intake.setPower(0.4);
    }

    public void out() {
        intake.setPower(-1);
    }

    public void slow_out() {intake.setPower(-0.5);}

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
        vfb.setPosition(0.18);
    }

    public void vfb4thPixleDown(){
        vfb.setPosition(0.14);
    }

    public void vfb3rdPixleDown(){
        vfb.setPosition(0.11);
    }

    public void vfb2ndPixleDown(){vfb.setPosition(0.08);}



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
        off();
    }

    public void transfer(){
        vfbUp();
        on();
        openGate();
    }

    // Extend intake to position
    public class ExtendIntake implements Action {

        int postion = 300;

        boolean first = true;
        ElapsedTime timer;
        int initPosition = 0;

        public ExtendIntake(int postion){
            this.postion = postion;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            brake_off();

            if (first){
                timer = new ElapsedTime();
                initPosition = extendPosition();
                first = false;
            }

            double extensionCurrent = extend.getCurrent(CurrentUnit.MILLIAMPS);
            telemetryPacket.put("Step", "Intake Extend");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extensionCurrent);
            telemetryPacket.put("Timer", timer.milliseconds());
            closeGate();

            double error = postion - extendPosition();
            if (Math.abs(error) > 10 && timer.milliseconds() < Math.max(4000 * ((postion - initPosition) / 450), 1500))
            {
                extend.setPower(error * 0.05);
                return true;

            } else{
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

    ElapsedTime timer = new ElapsedTime();
    public class RetractIntake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            telemetryPacket.put("Step", "Intake Extend");
            telemetryPacket.put("Intake Motor Current", intake.getCurrent(CurrentUnit.MILLIAMPS));
            telemetryPacket.put("Extension Motor Current", extend.getCurrent(CurrentUnit.MILLIAMPS));
            if (Math.abs(extendPosition()) > 15 && digitalTouch.getState()){
                extend.setPower(-1);
                timer.reset();
                return true;
            } else if(timer.milliseconds() > 200) {
                extend.setPower(0);
                return false;
            } else {
                extend.setPower(-0.3);
                brake_on();
                return true;
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

