package com.team9889.ftc2023;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor intake;
    public void init(HardwareMap hardwareMap){
        intake = hardwareMap.dcMotor.get("intake");


    }
    public void on(){
        intake.setPower(1);
    }
    public void off(){
        intake.setPower(0);
    }
    public void out(){
        intake.setPower(-1);
    }
}

