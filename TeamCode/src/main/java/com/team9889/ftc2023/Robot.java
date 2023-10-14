package com.team9889.ftc2023;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    Intake mIntake = new Intake();
    Drive mDrive = new Drive();

    Lift mlift = new Lift();
    Hopper mhopper = new Hopper();
    public void init(HardwareMap hardwaremap){
        mIntake.init(hardwaremap);
        mDrive.init(hardwaremap);
        mhopper.init(hardwaremap);
        mlift.init(hardwaremap);

    }
}

