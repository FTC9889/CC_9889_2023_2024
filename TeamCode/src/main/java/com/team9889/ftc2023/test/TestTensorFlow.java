package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

import org.firstinspires.ftc.teamcode.R;

@Autonomous
@Disabled
public class TestTensorFlow extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot mRobot = new Robot();
        mRobot.init(hardwareMap);
        while (opModeInInit()){
            telemetry.addData("side", mRobot.mCamera.side());
            mRobot.mCamera.telemetryTfod(telemetry);
            telemetry.update();
        }
        waitForStart();



    }
}
