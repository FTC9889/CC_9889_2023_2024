package com.team9889.ftc2023.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    DcMotor intake, extend;
    DigitalChannel digitalTouch;
    Servo vfb, gate;
    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.dcMotor.get("intake");
        extend = hardwareMap.dcMotor.get("extend");

        vfb = hardwareMap.servo.get("lift");
        gate = hardwareMap.servo.get("gate");

        digitalTouch = hardwareMap.digitalChannel.get("liftmagnet");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        extend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    //turn on intake
    //turn off intake
    public void setPower(double power){
        if(power < 0) {
            if (digitalTouch.getState() ==false) {
                extend.setPower(power);
            } else {
                extend.setPower(0);
                extend.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                extend.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }
        } else {
            if (extend.getCurrentPosition() < 3500){
                extend.setPower(power);
            } else {
                extend.setPower(0);
            }
        }
    }

    public boolean canIntake () {
        return extend.getCurrentPosition() > 10 && !digitalTouch.getState();
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
        intake.setPower(0.2);
    }

    public void out() {
        intake.setPower(-1);
    }

    public void openGate(){
        gate.setPosition(0);
    }
    public void closeGate(){
        gate.setPosition(1);
    }

boolean vfbUp=true;
    public void vfbUp(){
        vfb.setPosition(1);
        vfbUp=true;
    }
    public void vfbDown(){
        vfb.setPosition(0);
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

    public void transfer(){
        vfbUp();
        on();
        openGate();
}

}

