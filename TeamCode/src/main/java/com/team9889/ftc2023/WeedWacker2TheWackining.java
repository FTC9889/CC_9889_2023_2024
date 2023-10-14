package com.team9889.ftc2023;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class WeedWacker2TheWackining extends LinearOpMode {

    Drive mDrive=new Drive();

    DcMotor intake, lift;

    Servo hopper;

    @Override
    public void runOpMode() throws InterruptedException {
      intake=hardwareMap.dcMotor.get("intake");
       hopper=hardwareMap.servo.get("hopper");
       lift=hardwareMap.dcMotor.get("lift");

      mDrive.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){
mDrive.setPower(gamepad1.left_stick_y,gamepad1.right_stick_y );
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
