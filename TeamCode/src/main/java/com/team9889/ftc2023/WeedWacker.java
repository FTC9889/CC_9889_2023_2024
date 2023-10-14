package com.team9889.ftc2023;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class WeedWacker extends LinearOpMode {
    Intake mIntake = new Intake();
    Drive mDrive = new Drive();

    DcMotor lift;
    Hopper mhopper = new Hopper();

    public void runOpMode() throws InterruptedException {

        mIntake.init(hardwareMap);
        mDrive.init(hardwareMap);
        lift = hardwareMap.dcMotor.get("lift");
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
                    lift.setPower(1);}
            else if(gamepad1.left_bumper){
                    lift.setPower(-1);}
            else{
                lift.setPower(0);}





        }


    }
}
