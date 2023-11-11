package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hopper {
    Servo hopperl, hopperr; ElapsedTime timer=new ElapsedTime();

    public void init(HardwareMap hardwareMap){
        hopperr = hardwareMap.servo.get("hopperr");
        hopperl = hardwareMap.servo.get("hopperl");
        hopperl.setDirection(Servo.Direction.REVERSE);
    }
    //turn on hopper
    //turn off hopper
    //go back hopper
    public void intake_position(){
        hopperr.setPosition(0);
        hopperl.setPosition(0);
        servoPosition=0.45;

    }

    public void score_position(){
        hopperr.setPosition(0.62);
        hopperl.setPosition(0.62);
         servoPosition=0.45;
    }

    public void middle_position(){
        hopperr.setPosition(0.45);
        hopperl.setPosition(0.45);
        servoPosition=0.45;
    }
    double servoPosition=0.45;
    public void score_TeleOp(){
        hopperr.setPosition(servoPosition);
        hopperl.setPosition(servoPosition);

        if(servoPosition < 0.62){
            servoPosition+=0.005;
        } else
            servoPosition=0.45;
    }


}
