package com.team9889.ftc2023.opmode.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.opmode.red.FarRed;
import com.team9889.ftc2023.subsystems.Robot;
import com.team9889.ftc2023.subsystems.Robot.BackDrop;

@Autonomous
public class FarBlue extends LinearOpMode {


    Robot mRobot = new Robot();


    BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.init_camera(hardwareMap, telemetry, false);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();



        waitForStart();
        side = mRobot.teamPropDetector.side;

        mRobot.stop_team_prop_scanner();
        sleep(100);
        mRobot.mBackdrop.initAprilTag(hardwareMap);

        int tile = 830;
        long side_tile = 2300;


        if (side == BackDrop.CENTER){
            mRobot.mIntake.setPower(0.5);
            sleep(250);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.vfbDown();
            telemetry.addData("gyro", mRobot.mDrive.get_angle());
            telemetry.update();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(mRobot.ticks_per_inch * 16, this);
            mRobot.mIntake.slow_out();
            telemetry.addData("gyro", mRobot.mDrive.get_angle());
            telemetry.update();
            sleep(1000);
            mRobot.mIntake.off();
            mRobot.mIntake.vfbUp();
            mRobot.mIntake.setPower(-0.5);
            sleep(350);
            mRobot.mIntake.setPower(0);
            telemetry.addData("gyro", mRobot.mDrive.get_angle());
            telemetry.update();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(150, this);
            mRobot.mDrive.setPower(0, 0, -0.2);
            while (mRobot.mDrive.get_angle() > -94 && opModeIsActive()) {
                telemetry.addData("gyro", mRobot.mDrive.get_angle());
                telemetry.update();
                sleep(10);
            }
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();


            // sleep(15000);
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder((int) (tile * 4) - 200, this);
            mRobot.mLift.score_position_second_level();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(200);
            mRobot.mDrive.brake();

            if(mRobot.mDrive.get_angle() > -90) {
                mRobot.mDrive.setPower(0, 0, -0.2);
                while (mRobot.mDrive.get_angle() > -94 && opModeIsActive()) {
                    telemetry.addData("gyro", mRobot.mDrive.get_angle());
                    telemetry.update();
                    sleep(10);
                }
                mRobot.mDrive.brake();
                mRobot.mDrive.reset_encoder();
            }

            mRobot.mDrive.setPower(0, 0, 0.2);
            while (mRobot.mDrive.get_angle() < -90 && opModeIsActive()) {
                telemetry.addData("gyro", mRobot.mDrive.get_angle());
                telemetry.update();
                sleep(10);
            }
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();

            int backdrop_postion = mRobot.mBackdrop.detect_backdrop_center();
            while (Math.abs(backdrop_postion) > 5) {

                if (backdrop_postion > 5){
                    mRobot.mDrive.setPower(0.4, 0, 0);
                }else if(backdrop_postion < -5){
                    mRobot.mDrive.setPower(-0.4, 0, 0);
                }
                backdrop_postion = mRobot.mBackdrop.detect_backdrop_center();
            }
            mRobot.mDrive.brake();

            mRobot.mBackdrop.visionPortal.stopStreaming();
            sleep(250);
            mRobot.mDrive.setPower(0, 0.25, 0);
            sleep(1700);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(500);
            mRobot.mLift.initPosition();
            mRobot.mDrive.setPower(0, 0, 0);
            sleep(500);
        }
//i am cool and that is true
        else if (side ==   BackDrop.RIGHT) {
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
            mRobot.mDrive.setPower(0, 0, -0.2);
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
            mRobot.mDrive.setPower(-0.5, 0, 0);
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
        else if (side ==   BackDrop.LEFT) {
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
            mRobot.mDrive.setPower(0, 0, -0.2);
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
            mRobot.mDrive.setPower(-0.5, 0, 0);
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