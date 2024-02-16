package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class ImuTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot mRobot = new Robot();

        Robot.BackDrop side;


        mRobot.init(hardwareMap);
//        mRobot.init_camera(hardwareMap, telemetry, true);
        mRobot.mLift.initPosition();

        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();
        waitForStart();

        while (opModeIsActive()){
            mRobot.mDrive.imu.measure_angles(telemetry);
            telemetry.update();
        }


    }
}
