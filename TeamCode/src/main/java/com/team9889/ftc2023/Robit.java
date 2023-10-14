package com.team9889.ftc2023;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robit {    Drive mDrive=new Drive();
    Intake mIntake=new Intake();

public void init (HardwareMap hardwareMap){
    mDrive.init(hardwareMap);
    mIntake.init(hardwareMap);
}

}


