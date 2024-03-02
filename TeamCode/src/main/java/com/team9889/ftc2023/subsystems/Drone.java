package com.team9889.ftc2023.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Drone {

    public static double hold = 0.5;
    public static double launch = 0.9;
    Servo drone;
    public void init(HardwareMap hardwareMap) {
        drone = hardwareMap.servo.get("drone");
        do_nothing();
    }
    public void do_nothing(){
        drone.setPosition(hold);
    }

    public void shoot(){
        drone.setPosition(launch);
    }
}