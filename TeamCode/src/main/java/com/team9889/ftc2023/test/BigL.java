package com.team9889.ftc2023.test;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class BigL { DcMotor lift;
    public void init(HardwareMap hardwareMap) {lift=hardwareMap.dcMotor.get("lift");}
        public void setPower(double liftPower){
        lift.setPower(liftPower);}}