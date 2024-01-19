package com.team9889.ftc2023.opmode.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.team9889.ftc2023.subsystems.Robot;


@Autonomous
public class FarRed extends LinearOpMode {
    Robot mRobot = new Robot();

    enum BackDrop {
        LEFT, RIGHT, CENTER
    }

    BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);

        side = BackDrop.CENTER;
        //mRobot = cool
        //Ivan = also cool
        waitForStart();
        int tile = 830;
        long side_tile = 2300;


        if(side == BackDrop.LEFT) {
            mRobot.mDrive.setPower(0, -0.2, 0, -0.2);
            while (mRobot.mDrive.get_angle() < 27 && opModeIsActive()) {
                sleep(10);
                telemetry.addData("Angle" , mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0,0,0);
            mRobot.mDrive.brake();
            mRobot.mIntake.setPower(0.5);
            sleep(200);
            mRobot.mIntake.vfbDown();
            sleep(500);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.vfbDown();
            sleep(700);
            mRobot.mIntake.slow_out();
            sleep(1000);
            mRobot.mIntake.off();
            mRobot.mIntake.vfbUp();
            mRobot.mIntake.setPower(-0.5);
            sleep(1000);
            mRobot.mIntake.setPower(0);
            mRobot.mDrive.setPower(0, 0.3, 0, 0.3);
            sleep(900);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(500);
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(tile * 2 + 200, this);
            mRobot.mDrive.setPower(0, 0, 0.2);
            while (mRobot.mDrive.get_angle() > -92 && opModeIsActive()){
                sleep(10);
                telemetry.addData("Angle", mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(tile * 4 , this);
            mRobot.mDrive.setPower(0, 0,0);
            mRobot.mDrive.brake();
            sleep(7000);
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(side_tile);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(350);
            mRobot.mLift.score_position_second_level();
            sleep(750);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(400);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(1000);
//            mRobot.mIntake.setPower(0.5);
//            sleep(500);
//            mRobot.mIntake.setPower(0);
//            sleep(50);
            mRobot.mLift.initPosition();
            sleep(500);
//            sleep(500);
//            mRobot.mIntake.setPower(-0.5);
//            sleep(500);
//            mRobot.mIntake.setPower(0);
//            sleep(50);

        }

        if (side ==BackDrop.CENTER){
            mRobot.mIntake.setPower(0.5);
            sleep(250);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.vfbDown();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(mRobot.ticks_per_inch * 16, this);
            mRobot.mIntake.slow_out();
            sleep(1000);
            mRobot.mIntake.off();
            mRobot.mIntake.vfbUp();
            mRobot.mIntake.setPower(-0.5);
            sleep(350);
            mRobot.mIntake.setPower(0);
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(225, this);
            mRobot.mDrive.setPower(0, 0, 0.2);
            while (mRobot.mDrive.get_angle() > -92 && opModeIsActive()) sleep(10);
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();

            // sleep(15000);
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder((int) (tile * 4), this);
            mRobot.mLift.score_position_second_level();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(200);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(200);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(500);
            mRobot.mLift.initPosition();
            mRobot.mDrive.setPower(0, 0, 0);
            sleep(500);
        }

        if (side == BackDrop.RIGHT) {
            mRobot.mDrive.setPower(-0.2, 0, -0.2, 0);
            while (mRobot.mDrive.get_angle() > -16 && opModeIsActive()) {
                sleep(10);
                telemetry.addData("Angle" , mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0,0,0);
            mRobot.mDrive.brake();
            mRobot.mIntake.setPower(0.5);
            sleep(500);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.vfbDown();
            sleep(500);
            mRobot.mIntake.slow_out();
            sleep(1000);
            mRobot.mIntake.off();
            mRobot.mIntake.vfbUp();
            mRobot.mIntake.setPower(-0.5);
            sleep(1000);
            mRobot.mIntake.setPower(0);
            mRobot.mDrive.setPower(0.3, 0, 0.3, 0);
            sleep(750);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(500);
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(tile * 2 + 200, this);
            mRobot.mDrive.setPower(0, 0, 0.2);
            while (mRobot.mDrive.get_angle() > -92 && opModeIsActive()){
                sleep(10);
                telemetry.addData("Angle", mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(tile * 4 , this);
            mRobot.mDrive.setPower(0, 0,0);
            mRobot.mDrive.brake();
            sleep(7000);
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(side_tile - 850);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.score_position_second_level();
            sleep(750);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(400);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(1000);
//            mRobot.mIntake.setPower(0.5);
//            sleep(500);
//            mRobot.mIntake.setPower(0);
//            sleep(50);
            mRobot.mLift.initPosition();
            sleep(500);
//            sleep(500);
//            mRobot.mIntake.setPower(-0.5);
//            sleep(500);
//            mRobot.mIntake.setPower(0);
//            sleep(50);

        }

        //mRobot.mDrive.reset_encoder();
        //mRobot.mDrive.setPower(0, 0.5, 0);
        //while (mRobot.mDrive.front_encoder() < 1150 && opModeIsActive()) sleep(50);
        //mRobot.mDrive.brake();
        //mRobot.mDrive.setPower(-0.5, 0, 0);
        //sleep(2500);
        //mRobot.mLift.score_position();
        //mRobot.mDrive.setPower(0, 0.5, 0);
//      //  mRobot.mIntake.on();
        //mRobot.mDrive.reset_encoder();
        //while (mRobot.mDrive.front_encoder() < 1150 && opModeIsActive()) sleep(50);
        //mRobot.mDrive.setPower(0, 0, 0);
        //mRobot.mDrive.brake();
        //sleep(500);
        //mRobot.mDrive.setPower(0, 0, 0);
        //mRobot.mDrive.brake();
        //mRobot.mLift.set_Grabber_Open(true, true);
        //sleep(500);
        //mRobot.mDrive.setPower(0, -0.5, 0);
        //sleep(500);
    }
}

