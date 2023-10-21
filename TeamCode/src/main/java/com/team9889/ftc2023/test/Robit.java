package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.team9889.ftc2023.subsystems.Drive;
import com.team9889.ftc2023.subsystems.Hopper;
import com.team9889.ftc2023.subsystems.Intake;
import com.team9889.ftc2023.subsystems.Hang;

public class Robit {    Drive mDrive=new Drive();
    Intake mIntake=new Intake();
Hopper mHopper=new Hopper();
Hang mLift=new Hang();

public void init (HardwareMap hardwareMap){
    mDrive.init(hardwareMap);
    mIntake.init(hardwareMap);
    mHopper.init(hardwareMap);
    mLift.init(hardwareMap);
}

}


