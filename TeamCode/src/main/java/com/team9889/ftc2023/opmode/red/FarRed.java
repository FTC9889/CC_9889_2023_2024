package com.team9889.ftc2023.opmode.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;


@Autonomous
public class FarRed extends LinearOpMode {
    Robot mRobot = new Robot();

    ElapsedTime Timer = new ElapsedTime();

    Robot.BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.init_camera(hardwareMap, telemetry, true);

        mRobot.mLift.initPosition();

        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        waitForStart();
        Timer.reset();

         side = mRobot.teamPropDetector.side;

//        side = Robot.BackDrop.LEFT;

        mRobot.mLift.set_Grabber_Open(true, true);
        mRobot.stop_team_prop_scanner();
        sleep(100);
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mBackdrop.initAprilTag(hardwareMap);

        int tile = 830;
        long side_tile = 2300;

        if(side == Robot.BackDrop.LEFT) {
            mRobot.mDrive.setPower(0, -0.2, 0, -0.2);
            while (mRobot.mDrive.get_angle() < 13 && opModeIsActive()) {
                sleep(10);
                telemetry.addData("Angle" , mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0,0,0);
            mRobot.mDrive.brake();
            mRobot.mIntake.setPower(0.5);
            sleep(200);
            mRobot.mIntake.VFBAutoPostion();
            sleep(700);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.vfbDown();
            mRobot.mIntake.slow_out();
            sleep(1000);
            mRobot.mIntake.off();
            mRobot.mIntake.vfbUp();
            mRobot.mIntake.setPower(-0.5);
            sleep(950);
            mRobot.mIntake.setPower(0);
            mRobot.mDrive.setPower(0, 0.3, 0, 0.3);
            sleep(700);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(900);
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(tile * 2 + 200, this);
            mRobot.mDrive.setPower(0, 0, 0.2);
            while (mRobot.mDrive.get_angle() < 85 && opModeIsActive()){
                sleep(10);
                telemetry.addData("Angle", mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(tile * 4 - 400, this);
            mRobot.mDrive.setPower(0, 0,0);
            mRobot.mDrive.brake();
            if(mRobot.mDrive.get_angle() < 90) {
                mRobot.mDrive.setPower(0, 0, 0.2);
                while (mRobot.mDrive.get_angle() < 94 && opModeIsActive()) {
                    telemetry.addData("gyro", mRobot.mDrive.get_angle());
                    telemetry.update();
                    sleep(10);
                }
                mRobot.mDrive.brake();
                mRobot.mDrive.reset_encoder();
            }

            mRobot.mDrive.setPower(0, 0, -0.2);
            while (mRobot.mDrive.get_angle() > 87 && opModeIsActive()) {
                telemetry.addData("gyro", mRobot.mDrive.get_angle());
                telemetry.update();
                sleep(10);
            }
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();
            sleep(Math.max((long) (30000 - 9000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(800);

            int backdrop_postion = mRobot.mBackdrop.detect_backdrop_left();
            while (Math.abs(backdrop_postion) > 5) {

                if (backdrop_postion > 5){
                    mRobot.mDrive.setPower(0.35, 0, 0);
                }else if(backdrop_postion < -5){
                    mRobot.mDrive.setPower(-0.35, 0, 0);
                }
                backdrop_postion = mRobot.mBackdrop.detect_backdrop_left();
            }
            mRobot.mDrive.brake();

            mRobot.mBackdrop.visionPortal.stopStreaming();
            sleep(350);
            mRobot.mLift.score_position_second_level();
            sleep(250);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(600);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(250);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(750);
//            mRobot.mIntake.setPower(0.5);
//            sleep(500);
//            mRobot.mIntake.setPower(0);
//            sleep(50);
            mRobot.mLift.initPosition();
            sleep(250);
//            sleep(500);
//            mRobot.mIntake.setPower(-0.5);
//            sleep(500);
//            mRobot.mIntake.setPower(0);
//            sleep(50);

        }





























        else if (side == Robot.BackDrop.CENTER){
            mRobot.mIntake.setPower(0.5);
            sleep(250);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.VFBAutoPostion();
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
            mRobot.encoder(200, this);
            mRobot.mDrive.setPower(0, 0, 0.2);
            while (mRobot.mDrive.get_angle() < 87 && opModeIsActive()) {
                telemetry.addData("gyro", mRobot.mDrive.get_angle());
                telemetry.update();
                sleep(10);
            }
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();


            sleep(Math.max((long) (30000 - 10000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder((int) (tile * 4) - 200, this);
            mRobot.mLift.score_position_second_level();
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(200);
            mRobot.mDrive.brake();

            if(mRobot.mDrive.get_angle() < 90) {
                mRobot.mDrive.setPower(0, 0, 0.2);
                while (mRobot.mDrive.get_angle() < 94 && opModeIsActive()) {
                    telemetry.addData("gyro", mRobot.mDrive.get_angle());
                    telemetry.update();
                    sleep(10);
                }
                mRobot.mDrive.brake();
                mRobot.mDrive.reset_encoder();
            }

            mRobot.mDrive.setPower(0, 0, -0.2);
            while (mRobot.mDrive.get_angle() > 90 && opModeIsActive()) {
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
            sleep(750);
            mRobot.mLift.initPosition();
            mRobot.mDrive.setPower(0, 0, 0);
            sleep(500);
        }

























        else if (side == Robot.BackDrop.RIGHT) {
            mRobot.mDrive.setPower(-0.2, 0, -0.2, 0);
            while (mRobot.mDrive.get_angle() > -32 && opModeIsActive()) {
                sleep(10);
                telemetry.addData("Angle" , mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0,0,0);
            mRobot.mDrive.brake();
            mRobot.mIntake.setPower(0.5);
            mRobot.mIntake.VFBAutoPostion();
            sleep(350);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.slow_out();
            sleep(1000);
            mRobot.mIntake.off();
            mRobot.mIntake.vfbUp();
            mRobot.mIntake.setPower(-0.5);
            sleep(450);
            mRobot.mIntake.setPower(0);
            mRobot.mDrive.setPower(0.3, 0, 0.3, 0);
            sleep(1200);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(700);
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(tile * 2 + 300, this);
            mRobot.mDrive.setPower(0, 0, 0.2);
            while (mRobot.mDrive.get_angle() < 84 && opModeIsActive()){
                sleep(10);
                telemetry.addData("Angle", mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.reset_encoder();
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(tile * 4 - 300, this);
            mRobot.mDrive.setPower(0, 0,0);
            mRobot.mDrive.brake();
            if(mRobot.mDrive.get_angle() < 87.5) {
                mRobot.mDrive.setPower(0, 0, 0.2);
                while (mRobot.mDrive.get_angle() < 94 && opModeIsActive()) {
                    telemetry.addData("gyro", mRobot.mDrive.get_angle());
                    telemetry.update();
                    sleep(10);
                }
                mRobot.mDrive.brake();
                mRobot.mDrive.reset_encoder();
            }

            mRobot.mDrive.setPower(0, 0, -0.2);
            while (mRobot.mDrive.get_angle() > 87 && opModeIsActive()) {
                telemetry.addData("gyro", mRobot.mDrive.get_angle());
                telemetry.update();
                sleep(10);
            }
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();
            sleep(Math.max((long) (30000 - 12000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(0.75, 0, 0);
            sleep(1000);
            int backdrop_postion = mRobot.mBackdrop.detect_backdrop_right();
            while (Math.abs(backdrop_postion) > 5) {

                if (backdrop_postion > 5){
                    mRobot.mDrive.setPower(0.35, 0, 0);
                }else if(backdrop_postion < -5){
                    mRobot.mDrive.setPower(-0.35, 0, 0);
                }
                backdrop_postion = mRobot.mBackdrop.detect_backdrop_right();
            }
            mRobot.mDrive.brake();


            mRobot.mBackdrop.visionPortal.stopStreaming();
            sleep(250);
            mRobot.mLift.score_position_second_level();
            sleep(500);
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(350);
            mRobot.mDrive.setPower(0, 0.25, 0);
            sleep(700);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(750);

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
            mRobot.mDrive.setPower(0, 0.5, 0);
            sleep(700);
            mRobot.mDrive.brake();

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

