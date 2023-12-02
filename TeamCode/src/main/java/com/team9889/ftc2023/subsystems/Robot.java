package com.team9889.ftc2023.subsystems;

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
        mdrone.init(hardwareMap);
    }

}


