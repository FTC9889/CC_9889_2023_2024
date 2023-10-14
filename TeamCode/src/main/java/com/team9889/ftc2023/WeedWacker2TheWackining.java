package com.team9889.ftc2023;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class WeedWacker2TheWackining extends LinearOpMode {

  Robit mRobot=new Robit();

    DcMotor lift;

    Servo hopper;

    @Override
    public void runOpMode() throws InterruptedException {
       hopper=hardwareMap.servo.get("hopper");
       lift=hardwareMap.dcMotor.get("lift");

        mRobot.init(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            mRobot.mDrive.setPower(gamepad1.left_stick_y,gamepad1.right_stick_y );
            if (gamepad1.a){mRobot.mIntake.on();}

            else if (gamepad1.b)
            {mRobot.mIntake.out();}
            else {mRobot.mIntake.off();}
//            if(gamepad1.right_trigger > 0.1){
//                else if
//            }
        }
    }
}


















































































































































//Hello. It seems you have found me.