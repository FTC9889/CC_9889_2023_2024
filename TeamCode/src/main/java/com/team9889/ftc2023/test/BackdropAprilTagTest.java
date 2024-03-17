package com.team9889.ftc2023.test;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.ftc.LazyImu;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.RobotLog;
import com.team9889.ftc2023.subsystems.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.DriveAuto;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.ArrayList;

@Autonomous
//@Disabled
public class BackdropAprilTagTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot mRobot = new Robot();
        mRobot.init(hardwareMap, new Pose2d(1, 1, Math.toRadians(-90)));

        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dTelemetry = dashboard.getTelemetry();

        mRobot.aDrive.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        mRobot.aDrive.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        mRobot.aDrive.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        mRobot.aDrive.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        while (opModeInInit()){

            mRobot.mCamera.startapriltag();

            mRobot.aDrive.updatePoseEstimate();

            double imuAngle = mRobot.aDrive.imu.get().getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
            double angle = Math.PI / 2;
            Pose2d Pose = mRobot.mCamera.RobotPose(imuAngle - angle);
            RobotLog.a("" + Math.toDegrees(imuAngle));

            dTelemetry.addData("Pose", Pose.toString());
            dTelemetry.addData("Angle", mRobot.aDrive.imu.get().getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES));

            TelemetryPacket packet = new TelemetryPacket();
            packet.fieldOverlay().setStroke("#3F51B5");
            DriveAuto.drawRobot(packet.fieldOverlay(), Pose);
            packet.fieldOverlay().setStroke("#4CAF50");
            DriveAuto.drawRobot(packet.fieldOverlay(), mRobot.aDrive.pose);

            DriveAuto.drawRobot(packet.fieldOverlay(), mRobot.aDrive.pose.minusExp(Pose));
            packet.fieldOverlay().setStroke("#7C4DFFFF");

            dashboard.sendTelemetryPacket(packet);

            if (Pose.position.x > 15 && Math.abs(Pose.position.y) > 0.01) {
                mRobot.aDrive.pose = Pose;
            }

            dTelemetry.update();
        }

         waitForStart();
    }
}
