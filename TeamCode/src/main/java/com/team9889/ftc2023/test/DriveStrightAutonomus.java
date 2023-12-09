package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
@Disabled
public class DriveStrightAutonomus extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();
        long tile = 46 * (2500 / 3);
        sleep(15000);
        mRobot.mDrive.setPower(0, 0.5, 0);
        mRobot.mIntake.on();

        sleep(tile);
        mRobot.mIntake.off();
        mRobot.mDrive.setPower(0, 0, 0, 0);









    }
}