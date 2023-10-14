package com.team9889.ftc2023;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class WeedWacker extends LinearOpMode {
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();

        while (opModeIsActive()){

            mRobot.mDrive.setPower(gamepad1.right_stick_y, gamepad1.left_stick_y);



            if (gamepad1.a){
                mRobot.mIntake.on();}
            else if(gamepad1.b){
                mRobot.mIntake.out();}
            else{
                mRobot.mIntake.off();}


            if(gamepad1.right_trigger > 0.1){
                mRobot.mhopper.on();}
            else if(gamepad1.left_trigger > 0.1){
                mRobot.mhopper.out();}
            else{
                mRobot.mhopper.off();}



            if (gamepad1.right_bumper){
                mRobot.mlift.up();}
            else if(gamepad1.left_bumper){
                mRobot.mlift.down();}
            else{
                mRobot.mlift.off();}





        }


    }
}
