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
    DcMotor left, right, lift;
    Servo hopper;
    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        mIntake.init(hardwareMap);
        lift = hardwareMap.dcMotor.get("lift");
        hopper = hardwareMap.servo.get("hopper");

        right.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        while (opModeIsActive()){

            left.setPower(gamepad1.left_stick_y);
            right.setPower(gamepad1.right_stick_y);


            if (gamepad1.a){
                mIntake.on();}
            else if(gamepad1.b){
                mIntake.out();}
            else{
                mIntake.off();}


            if(gamepad1.right_trigger > 0.1){
                hopper.setPosition(1);}
            else if(gamepad1.left_trigger > 0.1){
                hopper.setPosition(0);}
            else{
                hopper.setPosition(0.5);}



            if (gamepad1.right_bumper){
                    lift.setPower(1);}
            else if(gamepad1.left_bumper){
                    lift.setPower(-1);}
            else{
                lift.setPower(0);}





        }


    }
}
