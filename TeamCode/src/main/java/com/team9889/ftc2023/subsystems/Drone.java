package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Drone {
    Servo drone;
    public void init(HardwareMap hardwareMap) {
        drone = hardwareMap.servo.get("drone");
        do_nothing();
    }
    public void do_nothing(){
        drone.setPosition(0);
    }

    public void shoot(){
        drone.setPosition(1);
    }
}