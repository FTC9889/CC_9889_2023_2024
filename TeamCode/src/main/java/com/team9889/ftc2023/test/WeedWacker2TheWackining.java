package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;
import com.team9889.ftc2023.subsystems.Drive;
import com.team9889.ftc2023.subsystems.Intake;


@TeleOp
@Disabled
public class WeedWacker2TheWackining extends LinearOpMode {

    Drive mDrive = new Drive();
    Intake mIntake = new Intake();

    DcMotor lift;

    Servo hopper;

    @Override
    public void runOpMode() throws InterruptedException {
       hopper=hardwareMap.servo.get("hopper");
       lift=hardwareMap.dcMotor.get("lift");

      mDrive.init(hardwareMap);
mIntake.init(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
//mDrive.setPower(gamepad1.left_stick_y,gamepad1.right_stick_y );
            if (gamepad1.a){mIntake.on();}
            else if (gamepad1.b)
            {mIntake.out();}
            else {mIntake.off();}
//            if(gamepad1.right_trigger > 0.1){
//                else if
//            }

        }

    }
}
