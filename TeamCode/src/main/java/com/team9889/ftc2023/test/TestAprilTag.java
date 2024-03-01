package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;
import com.team9889.ftc2023.subsystems.Robot.BackDrop;

@Autonomous
@Disabled
public class TestAprilTag extends LinearOpMode {


    Robot mRobot = new Robot();


    BackDrop side;

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);
//        mRobot.init_camera(hardwareMap, telemetry, false);
        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        side = BackDrop.CENTER;
//        mRobot.stop_team_prop_scanner();
        sleep(100);
//        mRobot.mBackdrop.initAprilTag(hardwareMap);


        waitForStart();
//        side = mRobot.teamPropDetector.side;




//        int backdrop_postion = mRobot.mBackdrop.detect_backdrop_right();
//        while (Math.abs(backdrop_postion) > 5) {
//
//            if (backdrop_postion > 5){
//                mRobot.mDrive.setPower(0.4, 0, 0);
//            }else if(backdrop_postion < -5){
//                mRobot.mDrive.setPower(-0.4, 0, 0);
//            } else if (backdrop_postion == 6) {
//                mRobot.mDrive.setPower(0, 0, 0);
//            }
//            backdrop_postion = mRobot.mBackdrop.detect_backdrop_right();
//            telemetry.addData("backdrop", backdrop_postion);
//            telemetry.update();
//            sleep(20);
//        }
//        mRobot.mDrive.brake();

    }
}