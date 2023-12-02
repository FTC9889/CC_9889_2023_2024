package com.team9889.ftc2023.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class RedAutonomus extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();
        long tile = (2500 / 3);

        mRobot.mDrive.setPower(0, 0.5, 0);
        mRobot.mIntake.on();

        sleep((long) (tile * 2));
        mRobot.mIntake.off();
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep(tile * 2);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(0, 0.25, 0);
        sleep(1000);
        mRobot.mDrive.setPower(0, -0.25, 0);
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