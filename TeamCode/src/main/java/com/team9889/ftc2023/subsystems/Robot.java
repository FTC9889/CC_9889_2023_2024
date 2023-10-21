package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    public Drive mDrive=new Drive();

    public Intake mIntake = new Intake();
    public Hopper mhopper = new Hopper();
    public Hang mHang = new Hang();

    public void init (HardwareMap hardwareMap){
        mDrive.init(hardwareMap);
        mIntake.init(hardwareMap);
        mhopper.init(hardwareMap);
        mHang.init(hardwareMap);
    }

}


