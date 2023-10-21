package com.team9889.ftc2023.subsystems;

import static java.lang.Math.PI;

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

    public void setPower(double leftStickX, double leftStickY, double rightStickX){
        double r = Math.hypot(leftStickX, leftStickY);
        double robotAngle = Math.atan2(leftStickY, leftStickX) - PI / 4;
        double rightX = rightStickX;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;
setPower(v1,v2,v3,v4);

    }
}


































//AAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHH MY BRAIN!!!!!!!!!