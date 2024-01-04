package com.team9889.ftc2023.opmode.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.opmode.red.FarRed;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class BlueAutonomus extends LinearOpMode {
    Robot mRobot = new Robot();

    enum BackDrop {
        LEFT, RIGHT, CENTER
    }

    BlueAutonomus.BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);


        waitForStart();
        long tile = 830;
        long side_tile = 2300;

        if(side == BlueAutonomus.BackDrop.LEFT) {
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(tile);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0, -0.5);
            sleep(???);
            mRobot.mDrive.brake();
            mRobot.mIntake.out();
            mRobot.mIntake.off();
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(side_tile - 300);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0, 0.5);
            sleep(???);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, -0.5, 0);
            sleep(tile +400);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(2000);
            mRobot.mDrive.brake();
            mRobot.mLift.score_position();
            mRobot.mDrive.setPower(0, -0.5, 0);
            sleep(440);
            mRobot.mDrive.brake();
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(500);
            mRobot.mLift.intake_position();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(3000);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, -0.5, 0);
            sleep(500);
            mRobot.mDrive.brake();

        }

        if(side == BlueAutonomus.BackDrop.CENTER) {
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(830);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(side_tile);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0, -0.5);
            sleep(???);
            mRobot.mDrive.brake();
            mRobot.mLift.score_position();
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(450);
            mRobot.mDrive.brake();
            mRobot.mLift.set_Grabber_Open(true, true);
            mRobot.mLift.intake_position();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(2500);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(500);
            mRobot.mDrive.brake();
        }

        if(side == BlueAutonomus.BackDrop.RIGHT) {
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(1000);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0, 0.5);
            sleep(???);
            mRobot.mDrive.brake();
            mRobot.mIntake.out();
            mRobot.mIntake.off();
            mRobot.mLift.score_position();
            mRobot.mDrive.setPower(0, -0.5, 0);
            sleep((long) (tile * 1.5));
            mRobot.mDrive.brake();
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(500);
            mRobot.mLift.intake_position();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(3000);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, -0.5, 0);
            sleep(500);
            mRobot.mDrive.brake();

        }





//        mRobot.mDrive.setPower(0.5, 0, 0);
//        sleep(2500);
//        mRobot.mLift.score_position();
//        mRobot.mDrive.setPower(0, 0.5, 0);
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
//        mRobot.mDrive.setPower(-0.5, 0, 0);
//        sleep(2000);





    }
}