package com.team9889.ftc2023;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hopper {
    Servo hopper;
    public void init(HardwareMap hardwareMap){
        hopper = hardwareMap.servo.get("hopper");
    }
    public void on(){
        hopper.setPosition(1);
    }
    public void off(){
        hopper.setPosition(0.5);
    }
    public void out(){
        hopper.setPosition(0);
    }
}
