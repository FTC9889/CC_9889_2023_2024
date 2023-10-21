package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hang {
    DcMotor Hang;
    public void init(HardwareMap hardwaremap){
        Hang = hardwaremap.dcMotor.get("lift");
    }

    // lift up
    // go down
    // turn off
    public void up(){
        Hang.setPower(1);
    }
    public void off(){
        Hang.setPower(0);
    }
    public void down(){
        Hang.setPower(-1);
    }
}
