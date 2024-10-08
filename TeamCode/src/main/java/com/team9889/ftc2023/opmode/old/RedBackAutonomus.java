package com.team9889.ftc2023.opmode.old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
@Disabled
public class RedBackAutonomus extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();
        long tile = (2500 / 3);

        mRobot.mDrive.setPower(0, 0.5, 0);
        mRobot.mIntake.on();

        mRobot.mDrive.setPower(0, 0, 0.5);
        sleep(300);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(0.5, 0.5, 0.5, 0.5);
        sleep(tile *5);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(0, 0, 0.5);
        sleep(tile * 2);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep(tile);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(0, 0.1, 0);
        sleep(500);
        mRobot.mDrive.setPower(0, -0.1, 0);
        sleep(150);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);










    }
}