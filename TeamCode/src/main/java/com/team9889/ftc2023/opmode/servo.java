package com.team9889.ftc2023.opmode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class servo extends LinearOpMode{

    Robot mRobot = new Robot();
    public void runOpMode() throws InterruptedException{

        mRobot.init(hardwareMap);

        waitForStart();
        while (!gamepad1.a){
            mRobot.mIntake.vfbUp();
        }
        while (gamepad1.a) sleep(10);

        while (!gamepad1.b){
            mRobot.mIntake.vfbDown();
        }
        while (gamepad1.b) sleep(10);

        while (!gamepad1.x){
            mRobot.mIntake.openGate();
        }
        while (gamepad1.x) sleep(10);

        while (!gamepad1.y){
            mRobot.mIntake.closeGate();
        }
        while (gamepad1.y) sleep(10);

        while (!gamepad1.a){
            mRobot.mLift.intake_position();
        }
        while (gamepad1.a) sleep(10);

        while (!gamepad1.b){
            mRobot.mLift.score_position();
        }
        while (gamepad1.b) sleep(10);

        while (!gamepad1.x){
            mRobot.mLift.set_Grabber_Open(true, true);
        }
        while (gamepad1.x) sleep(10);

    }
}