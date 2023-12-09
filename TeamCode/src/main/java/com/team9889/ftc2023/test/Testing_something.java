package com.team9889.ftc2023.test;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

@TeleOp
@Disabled
public class Testing_something extends LinearOpMode{
    NormalizedColorSensor colorsensor1, colorsensor2;
    DcMotor test;


    @Override
    public void runOpMode() throws InterruptedException {

        colorsensor1 = hardwareMap.get(RevColorSensorV3.class, "color_sensor1");
        colorsensor2 = hardwareMap.get(RevColorSensorV3.class, "color_sensor2");
        test = hardwareMap.get(DcMotorEx.class, "test");

        AnalogInput analogInput = hardwareMap.get(AnalogInput.class,"analoginput");

        waitForStart();
        int target = 0;
        while(opModeIsActive()){

            test.setTargetPosition(target);
            test.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            test.setPower(1);
            test.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

            if (!test.isBusy())
                target+=1000;

            telemetry.addData("color red", colorsensor1.getNormalizedColors().red);
            telemetry.addData("color blue", colorsensor1.getNormalizedColors().blue);
            telemetry.addData("color green", colorsensor1.getNormalizedColors().green);
            telemetry.addData("color red", colorsensor2.getNormalizedColors().red);
            telemetry.addData("color blue", colorsensor2.getNormalizedColors().blue);
            telemetry.addData("color green", colorsensor2.getNormalizedColors().green);
            telemetry.addData("breakbeam",analogInput.getVoltage());
            telemetry.update();


        }
    }
}
