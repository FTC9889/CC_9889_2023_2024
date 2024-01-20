package com.team9889.ftc2023.opmode.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;
import com.team9889.ftc2023.subsystems.Robot.BackDrop;

@Autonomous
public class FarBlueJustPark extends LinearOpMode {


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
                mRobot.teamPropDetector.difvalue += 0.00000001;
            } else if (gamepad1.dpad_down) {
                if (mRobot.teamPropDetector.difvalue > 0){
                    mRobot.teamPropDetector.difvalue -= 0.00000001;
                }
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


            sleep(Math.max((long) (30000 - 5000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder((int) (tile * 4) - 200, this);

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
            sleep(Math.max((long) (30000 - 5000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(tile * 4 + 400 , this);
            mRobot.mDrive.setPower(0, 0,0);
            mRobot.mDrive.brake();



//            mRobot.mIntake.setPower(0.5);
//            sleep(500);
//            mRobot.mIntake.setPower(0);
//            sleep(50);

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
            sleep(Math.max((long) (30000 - 5000 - Timer.milliseconds()), 0));
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(tile * 4 + 400, this);
            mRobot.mDrive.setPower(0, 0,0);
            mRobot.mDrive.brake();

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