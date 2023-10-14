package com.team9889.ftc2023;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive { DcMotor left, right;

    public void init(HardwareMap hardwareMap){
        left=hardwareMap.dcMotor.get("left");
         right=hardwareMap.dcMotor.get("right");
        right.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setPower(double leftPower,double rightPower){
     right.setPower(rightPower);
        left.setPower(leftPower);
    }


}
