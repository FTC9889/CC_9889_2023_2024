package com.team9889.ftc2023.test;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.team9889.ftc2023.subsystems.Robot;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.ArrayList;

@Autonomous
@Disabled
public class BackdropAprilTagTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot mRobot = new Robot();
        mRobot.init(hardwareMap, new Pose2d(1, 1, 0));

        while (opModeInInit()){
            mRobot.mCamera.startapriltag();
            Pose2d Pose = mRobot.mCamera.RobotPose(mRobot.aDrive.imu.get().getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));
            telemetry.addData("Pose", Pose.toString());
            telemetry.update();
        }


         waitForStart();
    }
}
