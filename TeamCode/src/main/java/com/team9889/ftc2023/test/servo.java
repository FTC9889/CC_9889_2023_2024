package com.team9889.ftc2023.test;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.team9889.ftc2023.subsystems.Robot;

@TeleOp(group = "Test")
@Config
public class servo extends LinearOpMode{
    public static double postion  = 0.1;
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException{

        mRobot.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()){


            mRobot.mIntake.vfb.setPosition(postion);




        }







    }
}