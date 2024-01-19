package com.team9889.ftc2023.subsystems;

import static java.lang.Math.PI;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.team9889.lib.hardware.RevIMU;

public class Drive { DcMotor leftFront, rightFront, leftBack, rightBack;
//init hardware
public RevIMU imu;

    public void init(HardwareMap hardwareMap){
        leftFront=hardwareMap.dcMotor.get("LF");
        rightFront=hardwareMap.dcMotor.get("RF");
        leftBack=hardwareMap.dcMotor.get("LB");
        rightBack=hardwareMap.dcMotor.get("RB");
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        imu = new RevIMU("imu", hardwareMap);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }
    public void setPower(double LFPower,double RFPower,double LBPower, double RBPower){
        rightFront.setPower(RFPower);
        leftFront.setPower(LFPower);
        leftBack.setPower(LBPower);
        rightBack.setPower(RBPower);
    }

    public double get_angle(){
        return imu.getNormalHeading();
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

    public int front_encoder(){
        return leftFront.getCurrentPosition();

    }
    public void reset_encoder(){
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void brake(){
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE );
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE );
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE );
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE );
        setPower(0, 0, 0);
    }
}

