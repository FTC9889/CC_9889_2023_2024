package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    public Drive mDrive=new Drive();

   // public Intake mIntake = new Intake();
    public Hopper mHopper = new Hopper();
//    public Hanger mHanger = new Hanger();

    public void init (HardwareMap hardwareMap){
        mDrive.init(hardwareMap);
        //mIntake.init(hardwareMap);
        mHopper.init(hardwareMap);
        //mHanger.init(hardwareMap);
    }

}


