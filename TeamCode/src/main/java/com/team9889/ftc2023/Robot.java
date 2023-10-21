package com.team9889.ftc2023;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {    Drive mDrive=new Drive();
    Intake mIntake = new Intake();
    Hopper mhopper = new Hopper();
    Lift mlift=new Lift();

    public void init (HardwareMap hardwareMap){
        mDrive.init(hardwareMap);
        mIntake.init(hardwareMap);
        mhopper.init(hardwareMap);
        mlift.init(hardwareMap);
    }

}


