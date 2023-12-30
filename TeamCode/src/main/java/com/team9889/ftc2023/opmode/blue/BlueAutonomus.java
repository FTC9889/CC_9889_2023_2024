package com.team9889.ftc2023.opmode.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class BlueAutonomus extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);


        waitForStart();
        long tile = 830;
        long side_tile = 2300;


        mRobot.mDrive.setPower(0.5, 0, 0);
        sleep(2500);
        mRobot.mLift.score_position();
        mRobot.mDrive.setPower(0, 0.5, 0);
        mRobot.mDrive.reset_encoder();
        while (mRobot.mDrive.front_encoder() < 1150 && opModeIsActive()) sleep(50);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.brake();
        sleep(500);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.brake();
        mRobot.mLift.set_Grabber_Open(true, true);
        sleep(500);
        mRobot.mDrive.setPower(0, -0.5, 0);
        sleep(500);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep(2000);





    }
}