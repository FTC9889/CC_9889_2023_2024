package com.team9889.ftc2023.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ScoringLift {
    Servo armL, armR; ElapsedTime timer=new ElapsedTime();
    DcMotor LiftMotor;
    DigitalChannel digitalTouch;
Servo GrabberL, GrabberR;
    public void init(HardwareMap hardwareMap){
        armR = hardwareMap.servo.get("hopperr");
        armL = hardwareMap.servo.get("hopperl");
        armL.setDirection(Servo.Direction.REVERSE);

        LiftMotor = hardwareMap.dcMotor.get("liftmotor");
        LiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        digitalTouch = hardwareMap.digitalChannel.get("liftmagnet");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);

        GrabberR = hardwareMap.servo.get("GrabberR");
        GrabberL = hardwareMap.servo.get("GrabberL");

        GrabberR.setDirection(Servo.Direction.REVERSE);


    }
    public void setPower(double power){
        if (power < 0){
            if (digitalTouch.getState()==false){
                LiftMotor.setPower(power);
            } else {
                LiftMotor.setPower(0);
                LiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                LiftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }
        } else {if (LiftMotor.getCurrentPosition() < 3001){
            LiftMotor.setPower(power);

        }else
            LiftMotor.setPower(0);

        }

    } public void setArmPosition(double position){
        armL.setPosition(position);
        armR.setPosition(position);
    }


boolean armTransfer=true;

    public void intake_position(){
       setArmPosition(0);
       armTransfer=true;


    }

    public void score_position(){
        setArmPosition(0.62);
        armTransfer=false;

    }
public boolean canTransfer(){
        return armTransfer && digitalTouch.getState();

}

public void set_Grabber_Open(boolean L,boolean R){
    if (L) {
        GrabberL.setPosition(0.59440724975323578765432234567809876524591);

    }  else {
        GrabberL.setPosition(0);
    }
    if (R) {
        GrabberR.setPosition(0.59440724975323578765432234567809876524591);

    }  else {
        GrabberR.setPosition(0);
    }
}



}
