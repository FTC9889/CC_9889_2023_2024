package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class ColorSensor_Test extends LinearOpMode {

    Robot mRobot = new Robot();

//    ColorSensor color;

    @Override
    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);

//        color = hardwareMap.get(ColorSensor.class, "Color");

        waitForStart();


        while (opModeIsActive()) {
            telemetry.addData("Red", mRobot.mIntake.color.red());
            telemetry.addData("Green", mRobot.mIntake.color.green());
            telemetry.addData("Blue", mRobot.mIntake.color.blue());
            telemetry.update();


        }

    }
}