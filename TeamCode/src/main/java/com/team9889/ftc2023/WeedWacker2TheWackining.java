package com.team9889.ftc2023;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class WeedWacker2TheWackining extends LinearOpMode {

    DcMotor left, right, intake;
    Servo hopper;

    @Override
    public void runOpMode() throws InterruptedException {
      left=hardwareMap.dcMotor.get("left");
      right=hardwareMap.dcMotor.get("right");
      intake=hardwareMap.dcMotor.get("intake");
       hopper=hardwareMap.servo.get("hopper");


        waitForStart();

        while(opModeIsActive()){

            left.setPower(gamepad1.left_stick_y);
            right.setPower(gamepad1.right_stick_y);
            if (gamepad1.a){intake.setPower(1);}
            else if (gamepad1.b)
            {intake.setPower(-1);}
            else {intake.setPower(0);}
//            if(gamepad1.right_trigger > 0.1){
//                else if
//            }

        }

    }
}
