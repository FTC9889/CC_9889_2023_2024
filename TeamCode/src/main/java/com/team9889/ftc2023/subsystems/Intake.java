package com.team9889.ftc2023.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Intake {
    public DcMotorEx intake;
    public DcMotor extend;

    public int extendPosition(){
        return extend.getCurrentPosition();}
    public DigitalChannel digitalTouch;
    Servo vfb, gate;
    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        extend = hardwareMap.dcMotor.get("extend");
        extend.setDirection(DcMotorSimple.Direction.REVERSE);
        vfb = hardwareMap.servo.get("vfb");
        gate = hardwareMap.servo.get("gate");
        digitalTouch = hardwareMap.digitalChannel.get("intakemagnet");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
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
            }
        } else {
           // if (extend.getCurrentPosition() > 3500){
                extend.setPower(power);
//            } else {
//                extend.setPower(0);
//            }
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
    public void slow_out() {intake.setPower(-0.25);}

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
        return currentDraw() > 1500;
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

}

