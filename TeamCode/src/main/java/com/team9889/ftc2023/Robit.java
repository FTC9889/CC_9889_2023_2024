package com.team9889.ftc2023;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robit {    Drive mDrive=new Drive();
    Intake mIntake=new Intake();
Hopper mHopper=new Hopper();
Lift mLift=new Lift();

public void init (HardwareMap hardwareMap){
    mDrive.init(hardwareMap);
    mIntake.init(hardwareMap);
    mHopper.init(hardwareMap);
    mLift.init(hardwareMap);
}

}


