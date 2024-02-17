package com.team9889.ftc2023.test;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.team9889.ftc2023.subsystems.Robot;

@TeleOp
public class TestGrabberServo extends LinearOpMode {

    Robot mRobot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        mRobot.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()){
            mRobot.mLift.set_Grabber_Open(gamepad1.b, gamepad1.a);
        }

    }
}
