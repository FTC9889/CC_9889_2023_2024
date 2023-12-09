package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
@Disabled
public class Two_Servos extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Servo servo1, servo2;
        servo1 = hardwareMap.servo.get("S1");
        servo2 = hardwareMap.servo.get("S2");
        servo1.setPosition(0);
        servo2.setDirection(Servo.Direction.REVERSE);
        servo2.setPosition(0);
        waitForStart();
        servo1.setPosition(1);
        servo2.setPosition(1);

        while(opModeIsActive()) sleep(10);
    }
}
