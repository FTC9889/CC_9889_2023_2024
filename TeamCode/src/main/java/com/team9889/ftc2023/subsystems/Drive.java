package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive { DcMotor leftFront, rightFront, leftBack, rightBack;
//init hardware
    public void init(HardwareMap hardwareMap){
        leftFront=hardwareMap.dcMotor.get("LF");
         rightFront=hardwareMap.dcMotor.get("RF");
         leftBack=hardwareMap.dcMotor.get("LB");
         rightBack=hardwareMap.dcMotor.get("RB");
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setPower(double LFPower,double RFPower,double LBPower, double RBPower){
     rightFront.setPower(RFPower);
        leftFront.setPower(LFPower);
        leftBack.setPower(LBPower);
        rightBack.setPower(RBPower);
    }


}


































//AAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHH MY BRAIN!!!!!!!!!