package com.team9889.ftc2023.opmode.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.opmode.red.FarRed;
import com.team9889.ftc2023.subsystems.Robot;
@Autonomous
public class FarBlue extends LinearOpMode {


    Robot mRobot = new Robot();


    FarBlue.BackDrop side;
    Robot.BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        side = BackDrop.RIGHT;

        waitForStart();

        int tile = 830;
        long side_tile = 2300;

//        if(side == FarBlue.BackDrop.LEFT) {
//            mRobot.mDrive.setPower(0, 0.5, 0);
//            sleep(tile);
//            mRobot.mDrive.brake();
//            mRobot.mDrive.setPower(0, 0, 0.5);
//            sleep(???);
//            mRobot.mDrive.brake();
//            mRobot.mIntake.out();
//            sleep(100);
//            mRobot.mIntake.off();
//            mRobot.mDrive.setPower(0, 0, -0.5);
//            sleep(???)
//            mRobot.mDrive.brake();
//            mRobot.mDrive.setPower(0, 0.5, 0);
//            sleep(tile * 4);
//            mRobot.mDrive.brake();
//            mRobot.mLift.score_position();
//            mRobot.mLift.set_Grabber_Open(true, true);
//            mRobot.mLift.intake_position();
//            mRobot.mDrive.setPower(0.5, 0, 0);
//            sleep(side_tile + 750);
//            mRobot.mDrive.brake();
//            mRobot.mDrive.setPower(0, 0.5, 0);
//            sleep(500);
//            mRobot.mDrive.brake();
            
//        }
<<<<<<< HEAD
        if (side == FarBlue.BackDrop.CENTER){
            mRobot.mIntake.vfbDown();
=======
>>>>>>> 4a1c03f0b9d05a29cc37514e2cdb14d4bc93d3e7
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(mRobot.ticks_per_inch * 28, this);
            mRobot.mIntake.slow_out();
            sleep(150);
            mRobot.mIntake.off();
            mRobot.mIntake.vfbUp();
            mRobot.mDrive.setPower(0, 0, -0.2);
            while (mRobot.mDrive.get_angle() > -90 && opModeIsActive()) sleep(10);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder((int) (tile * 2), this);
            mRobot.mLift.score_position();
            mRobot.encoder(tile + 200, this);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(500);
            mRobot.mLift.intake_position();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(2500);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(700, this);
            mRobot.mDrive.setPower(0, 0, 0);
        }

        else if (side == FarBlue.BackDrop.RIGHT) {
            mRobot.mDrive.setPower(-0.2, 0, -0.2, 0);
            while (mRobot.mDrive.get_angle() > -15 && opModeIsActive()) {
                sleep(10);
                telemetry.addData("Angle" , mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.setPower(0,0,0);
            mRobot.mDrive.brake();
            mRobot.mIntake.setPower(0.5);
            sleep(1000);
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
            mRobot.mDrive.setPower(0, -0.5, 0);
            mRobot.encoder(tile * 2 + 200, this);
            mRobot.mDrive.setPower(0, 0, -0.5);
            while (mRobot.mDrive.get_angle() > -87 && opModeIsActive()){
                sleep(10);
                telemetry.addData("Angle", mRobot.mDrive.get_angle());
                telemetry.update();
            }
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(tile * 3, this);
            mRobot.mDrive.setPower(-0.5, 0, 0);
            sleep(side_tile - 800);
            mRobot.mDrive.setPower(0, 0, 0);
            mRobot.mDrive.brake();
            sleep(500);
            mRobot.mLift.score_position();
            sleep(500);
            mRobot.mLift.set_Grabber_Open(true, true);
            sleep(1000);
            mRobot.mIntake.setPower(0.5);
            sleep(500);
            mRobot.mIntake.setPower(0);
            mRobot.mLift.intake_position();
            mRobot.mDrive.setPower(0.5, 0, 0);
            sleep(side_tile);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0.5, 0);
            mRobot.encoder(750, this);
            mRobot.mDrive.brake();
            mRobot.mDrive.setPower(0, 0, 0);
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