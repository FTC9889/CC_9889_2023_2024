package com.team9889.ftc2023.opmode.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class RedAutonomus extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();
        long tile = 830;
        long side_tile = 2300;

        mRobot.mDrive.setPower(0, 0.5, 0);
//        mRobot.mIntake.on();
        while (mRobot.mDrive.front_encoder() < 830 && opModeIsActive()) sleep(50);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.brake();
        sleep(500);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep(2500);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.brake();
        mRobot.mLift.score_position();



    }
}