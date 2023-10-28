package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hopper {
    Servo hopperl, hopperr;
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

    }

    public void score_position(){
        hopperr.setPosition(0.62);
        hopperl.setPosition(0.62);
    }

    public void middle_position(){
        hopperr.setPosition(0.45);
        hopperl.setPosition(0.45);
    }


}
