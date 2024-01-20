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
            if (digitalTouch.getState()== true){
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
       setArmPosition(1);
       armTransfer=true;


    }

    public void score_position(){
        setArmPosition(0.12);
        armTransfer=false;

    }

    public void score_position_second_level(){
        setArmPosition(0.20);
    }

    public void initPosition(){
        setArmPosition(0.75);
    }
public boolean canTransfer(){
//        return armTransfer && digitalTouch.getState();
return true;
}

public boolean left_teleop_last_state = false;
    public boolean right_teleop_last_state = false;

public void set_Grabber_Open(boolean L,boolean R){
    left_teleop_last_state = L;
    right_teleop_last_state = R;
    if (L) {
        GrabberL.setPosition(0.62);

    }  else {
        GrabberL.setPosition(0.35);
    }
    if (R) {
        GrabberR.setPosition(0.65);

    }  else {
        GrabberR.setPosition(0.4);
    }
}


    public void set_Grabber_Open(boolean L,boolean R, boolean A){
        if (L) {
            GrabberL.setPosition(0.63);
        }  else {
            GrabberL.setPosition(0.4);
        }
        if (R) {
            GrabberR.setPosition(0.63);

        }  else {
            GrabberR.setPosition(0.4);
        }
    }


}
