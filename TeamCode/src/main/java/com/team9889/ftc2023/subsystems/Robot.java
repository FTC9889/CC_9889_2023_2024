package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    public Drive mDrive = new Drive();

    public Intake mIntake = new Intake();
    public ScoringLift mLift = new ScoringLift();
    public Hanger mHanger = new Hanger();
    public Drone mdrone = new Drone();

    public void init (HardwareMap hardwareMap){
        mDrive.init(hardwareMap);
        mIntake.init(hardwareMap);
        mLift.init(hardwareMap);
        mHanger.init(hardwareMap);
//        mdrone.init(hardwareMap);
    }
    public void encoder(double distance, LinearOpMode opMode){
        while (Math.abs(mDrive.front_encoder()) < distance && opMode.opModeIsActive()) opMode.sleep(10);
        mDrive.brake();
        mDrive.reset_encoder();

    }
    public double ticks_per_inch = 1.0 / ((((96.0/25.4) * Math.PI) * ((((double) 18) / ((double) 15)))) / 537.7);

    public enum BackDrop {
        LEFT, RIGHT, CENTER
    }

}


