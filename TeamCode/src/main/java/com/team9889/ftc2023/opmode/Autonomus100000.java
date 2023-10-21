package com.team9889.ftc2023.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.team9889.ftc2023.subsystems.Robot;

@TeleOp
public class Autonomus100000 extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();

        while (opModeIsActive()){

            mRobot.mDrive.setPower(gamepad1.right_stick_y, gamepad1.left_stick_y);



            if (gamepad1.a == true){


            }



            if(gamepad1.right_trigger > 0.1){
                mRobot.mHopper.on();}
            else if(gamepad1.left_trigger > 0.1){
                mRobot.mHopper.out();}
            else{
                mRobot.mHopper.off();}



            if (gamepad1.right_bumper){
                mRobot.mlift.up();}
            else if(gamepad1.left_bumper){
                mRobot.mlift.down();}
            else{
                mRobot.mlift.off();}





        }


    }
}
