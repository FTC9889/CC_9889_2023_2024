package com.team9889.ftc2023.opmode.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.opmode.red.FarRed;
import com.team9889.ftc2023.subsystems.Robot;
import com.team9889.ftc2023.subsystems.Robot.BackDrop;

@Autonomous
public class FarBlue extends LinearOpMode {


    Robot mRobot = new Robot();

    ElapsedTime Timer = new ElapsedTime();


    BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.init_camera(hardwareMap, telemetry, false);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();
        while (opModeInInit() &&! isStopRequested()){
            if (gamepad1.dpad_up){
//                mRobot.teamPropDetector.difvalue += 0.00000001;
//            } else if (gamepad1.dpad_down) {
//                if (mRobot.teamPropDetector.difvalue > 0){
//                    mRobot.teamPropDetector.difvalue -= 0.00000001;
//                }
            }
        }

        waitForStart();

        Timer.reset();
        mRobot.mLift.set_Grabber_Open(true, true);
        side = mRobot.teamPropDetector.side;

        mRobot.stop_team_prop_scanner();
        sleep(100);
        mRobot.mBackdrop.initAprilTag(hardwareMap);
        mRobot.mLift.set_Grabber_Open(false, false);

        int tile = 830;
        long side_tile = 2300;


        if (side == BackDrop.CENTER){
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
            mRobot.encoder(150, this);
            mRobot.mDrive.setPower(0, 0, -0.2);
            while (mRobot.mDrive.get_angle() > -94 && opModeIsActive()) {
                telemetry.addData("gyro", mRobot.mDrive.get_angle());
                telemetry.update();
                sleep(10);
            }
            mRobot.mDrive.brake();
            mRobot.mDrive.reset_encoder();


            sleep(Math.max((long) (30000 - 11000 - Timer.milliseconds()), 0));
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
            sleep(1200);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(750);
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(200);
            mRobot.mDrive.brake();
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
            mRobot.mIntake.VFBAutoPostion();
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
            sleep(Math.max((long) (30000 - 9000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(-1, 0, 0);
            sleep(1100);
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
            mRobot.mDrive.setPower(0, 0.25, 0);
            sleep(1000);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(750);
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(200);
            mRobot.mDrive.brake();

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
            sleep(500);
            mRobot.mIntake.vfbDown();
            sleep(500);
            mRobot.mIntake.setPower(0);
            mRobot.mIntake.VFBAutoPostion();
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

            sleep(Math.max((long) (30000 - 10000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(-1, 0, 0);
            sleep(1200);

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
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(200);
            mRobot.mDrive.brake();
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