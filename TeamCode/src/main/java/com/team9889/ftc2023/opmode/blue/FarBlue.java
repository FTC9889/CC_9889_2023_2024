package com.team9889.ftc2023.opmode.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;
@Autonomous
public class FarBlue extends LinearOpMode {


    Robot mRobot = new Robot();

    enum BackDrop {
        LEFT, RIGHT, CENTER
    }

    FarBlue.BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);

        side = FarBlue.BackDrop.LEFT;

        waitForStart();

        long tile = 830;
        long side_tile = 2300;

        if(side == FarBlue.BackDrop.LEFT) {

        }
        if (side == FarBlue.BackDrop.RIGHT) {
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(tile);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0, -0.5);
            sleep(???);
            mRobot.mDrive.brake();
            mRobot.mIntake.out();
            sleep(100);
            mRobot.mIntake.off();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(side_tile + 200);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5,0);
            while (mRobot.mDrive.front_encoder() < tile * 3 && opModeIsActive()) sleep(50);
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(side_tile + 500);
            mRobot.mDrive.brake();
            mRobot.mLift.score_position();
            mRobot.mLift.set_Grabber_Open(true, true);
            mRobot.mLift.intake_position();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(side_tile + 750);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(500);
            mRobot.mDrive.brake();
        }


        if (side == FarBlue.BackDrop.CENTER) {
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(830);
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(2000);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            while (mRobot.mDrive.front_encoder() < 850 && opModeIsActive()) sleep(50);
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(8900);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, -0.5, 0);
            while (mRobot.mDrive.front_encoder() < 830 && opModeIsActive()) sleep(50);
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, 0, -0.5);
            sleep(???);
            mRobot.mDrive.brake();
            mRobot.mLift.score_position();
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(800);
            mRobot.mDrive.brake();
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(500);
            mRobot.mLift.intake_position();
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(2500);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(700);
            mRobot.mDrive.brake();
        }

//        mRobot.mDrive.setPower(-0.5, 0, 0);
//        sleep(5000);
//        mRobot.mDrive.setPower(0, 0.5, 0);
//        sleep(1660);
//        mRobot.mDrive.setPower(0.5, 0, 0);
//        sleep(2500);
//        mRobot.mLift.score_position();
//        mRobot.mDrive.setPower(0, 0.5, 0);
////        mRobot.mIntake.on();
//        mRobot.mDrive.reset_encoder();
//        while (mRobot.mDrive.front_encoder() < 1150 && opModeIsActive()) sleep(50);
//        mRobot.mDrive.setPower(0, 0, 0);
//        mRobot.mDrive.brake();
//        sleep(500);
//        mRobot.mDrive.setPower(0, 0, 0);
//        mRobot.mDrive.brake();
//        mRobot.mLift.set_Grabber_Open(true, true);
//        sleep(500);
//        mRobot.mDrive.setPower(0, -0.5, 0);
//        sleep(500);
//        mRobot.mDrive.setPower(0.5, 0, 0);
//        sleep(2000);
//
//
//    }
    }
}