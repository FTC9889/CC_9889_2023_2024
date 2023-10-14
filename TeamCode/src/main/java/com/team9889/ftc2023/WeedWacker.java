package com.team9889.ftc2023;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class WeedWacker extends LinearOpMode {
    Intake mIntake = new Intake();
    Drive mDrive = new Drive();

    Lift mlift = new Lift();
    Hopper mhopper = new Hopper();

    public void runOpMode() throws InterruptedException {

        mIntake.init(hardwareMap);
        mDrive.init(hardwareMap);
        mlift.init(hardwareMap);
        mhopper.init(hardwareMap);


        waitForStart();

        while (opModeIsActive()){

            mDrive.setPower(gamepad1.right_stick_y, gamepad1.left_stick_y);



            if (gamepad1.a){
                mIntake.on();}
            else if(gamepad1.b){
                mIntake.out();}
            else{
                mIntake.off();}


            if(gamepad1.right_trigger > 0.1){
                mhopper.on();}
            else if(gamepad1.left_trigger > 0.1){
                mhopper.out();}
            else{
                mhopper.off();}



            if (gamepad1.right_bumper){
                    mlift.up();}
            else if(gamepad1.left_bumper){
                    mlift.down();}
            else{
                mlift.off();}





        }


    }
}
