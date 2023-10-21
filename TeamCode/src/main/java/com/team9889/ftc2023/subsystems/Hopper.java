package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hopper {
    Servo hopperl, hopperr;
    public void init(HardwareMap hardwareMap){
        hopperr = hardwareMap.servo.get("hopper");
        hopperl = hardwareMap.servo.get("hopperl");
        hopperl.setDirection(Servo.Direction.REVERSE);
    }
    //turn on hopper
    //turn off hopper
    //go back hopper
    public void intake_position(){
        hopperr.setPosition(1);
        hopperl.setPosition(1);

    }
    public void nothing(){
        hopperr.setPosition(0.5);
        hopperl.setPosition(0.5);
    }
    public void score_position(){
        hopperr.setPosition(0);
        hopperl.setPosition(0);
    }


}
