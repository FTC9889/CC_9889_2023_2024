package com.team9889.ftc2023.test;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous(group = "Test")
@Disabled
public class servo extends LinearOpMode{

    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException{

        mRobot.init(hardwareMap);

        waitForStart();
//        while (!gamepad1.a){
//            mRobot.mIntake.vfbUp();
//        }
//        while (gamepad1.a) sleep(10);
//
//        while (!gamepad1.a){
//            mRobot.mIntake.vfbDown();
//        }
//        while (gamepad1.a) sleep(10);
//
//        while (!gamepad1.a){
//            mRobot.mIntake.openGate();
//        }
//        while (gamepad1.a) sleep(10);
//
//        while (!gamepad1.a){
//            mRobot.mIntake.closeGate();
//        }
//        while (gamepad1.a) sleep(10);
//
//        while (!gamepad1.a){
//            mRobot.mLift.intake_position();
//        }
//        while (gamepad1.a) sleep(10);
//
//        while (!gamepad1.a){
//            mRobot.mLift.score_position();
//        }
//        while (gamepad1.a) sleep(10);

        while (!gamepad1.a){
            mRobot.mLift.set_Grabber_Open(true, true);
        }
        while (gamepad1.a) sleep(10);

        while (!gamepad1.a){
            mRobot.mLift.set_Grabber_Open(false, false);
        }
        while (gamepad1.a) sleep(10);

    }
}