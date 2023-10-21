package com.team9889.ftc2023.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class Autonomus100000 extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();

        mRobot.mDrive.setPower(0.1, 0.1, 0.1, 0.1);
        sleep(100);
        mRobot.mDrive.setPower(0, 0, 0, 0);
    }
}
