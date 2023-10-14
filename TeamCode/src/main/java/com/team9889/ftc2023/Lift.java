package com.team9889.ftc2023;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {
    DcMotor lift;
    public void init(HardwareMap hardwaremap){
        lift = hardwaremap.dcMotor.get("lift")
    }
    public void up(){
        lift.setPower(1);
    }
    public void off(){
        lift.setPower(0);
    }
    public void down(){
        lift.setPower(-1);
    }
}
