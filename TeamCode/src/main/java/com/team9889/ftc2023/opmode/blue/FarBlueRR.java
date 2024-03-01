package com.team9889.ftc2023.opmode.blue;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Arclength;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Pose2dDual;
import com.acmerobotics.roadrunner.PosePath;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.VelConstraint;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Intake;
import com.team9889.ftc2023.subsystems.Robot;

import org.opencv.core.Mat;

//** 60.5.x ** 30.y **//
@Autonomous(group = "Blue", name = "⬇️ Blue Audience Side 🟦", preselectTeleOp = "TeleOp")
public class FarBlueRR extends LinearOpMode {
    Robot mRobot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK ****************
        Pose2d beginPose = new Pose2d(-38, 63.5, Math.toRadians(-90));
        mRobot.init(hardwareMap, beginPose);

        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        mRobot.mCamera.red = false;
        Robot.BackDrop side = Robot.BackDrop.LEFT;


        while (opModeInInit()) {
            telemetry.addData("Side", side);
            mRobot.mCamera.telemetryTfod(telemetry);
            side = mRobot.mCamera.side();
        }

        waitForStart();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mRobot.mCamera.startapriltag();
                mRobot.mCamera.pauseallcamera();

            }
        }).start();


        if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-77.5))
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(0.6)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(-109))
                            .lineToY(15)
                            .afterDisp(0.01, mRobot.mIntake.vfb5thpixle())
                            .turnTo(Math.toRadians(175))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(6))
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, true))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Transfer())
                            .waitSeconds(1.5)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .stopAndAdd(mRobot.mIntake.Off())
                            .strafeToLinearHeading(new Vector2d(38, 4), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, 31), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                            .strafeToLinearHeading(new Vector2d(43, 33), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(50.5, 33), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.1)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .waitSeconds(0.4)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.26))
                            .waitSeconds(0.4)
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .waitSeconds(0.2)
                            .stopAndAdd(mRobot.mLift.IntakePosition())
//                            .splineTo(new Vector2d(25.5, 10), Math.toRadians(-180))
//                            .stopAndAdd(() -> new Thread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mRobot.mCamera.visionPortal.setActiveCamera(mRobot.mCamera.webcam1);
//                                }
//                            }).start())
////                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
//                            .afterDisp(20, mRobot.mIntake.ExtendIntake(21))
////                            .splineTo(new Vector2d(0, 8), Math.toRadians(-175))
////                            .afterDisp(25, mRobot.mIntake.On())
//                            .splineTo(new Vector2d(-36, 11.75), Math.toRadians(-180))
//                            .stopAndAdd(mRobot.WhiteLine())
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(-1))
//                            .waitSeconds(0.1)
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(0))
//                            .stopAndAdd(() -> mRobot.mIntake.vfb4thPixleDown())
//                            .stopAndAdd(mRobot.mIntake.On())
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
//                            .waitSeconds(0.5)
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(-1))
//                            .waitSeconds(0.1)
//                            .stopAndAdd(() -> mRobot.mIntake.vfb3rdPixleDown())
//                            .turnTo(Math.toRadians(175))
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
//                            .waitSeconds(0.5)
//                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                            .stopAndAdd(mRobot.mIntake.RetractIntake())
//                            .stopAndAdd(mRobot.mIntake.Off())
//                            .stopAndAdd(mRobot.mIntake.RetractIntake())
//                            .afterDisp(5, mRobot.mLift.setgrabber(true, true))
//                            .afterDisp(7, mRobot.mIntake.RetractIntake())
//                            .afterDisp(9, mRobot.mIntake.RetractIntake())
//                            .afterDisp(10, mRobot.mIntake.Transfer())
//                            .afterDisp(27.5, mRobot.mIntake.Off())
//                            .afterDisp(30, mRobot.mLift.setgrabber(false, false))
////                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
////                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
////                            .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
//                            .setReversed(true)
//                            .splineTo(new Vector2d(20, 7), Math.toRadians(0))
//                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
//                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
//                            .splineTo(new Vector2d(50.75, 30), Math.toRadians(0))
//                            .stopAndAdd(mRobot.mLift.Score())
//                            .waitSeconds(0.5)

                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-60))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(11))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(-95))
                            .lineToY(15)
                            .turnTo(Math.toRadians(176))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(18))
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, true))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Transfer())
                            .waitSeconds(1.5)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .strafeToLinearHeading(new Vector2d(39, 8), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(39, 34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(50.5, 41), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(50.5, 38.5), Math.toRadians(180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(50, 28.5), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-112))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .turnTo(Math.toRadians(-90))
                            .lineToY(15)
                            .turnTo(Math.toRadians(175))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(19.5))
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, true))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Transfer())
                            .waitSeconds(1.5)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(50.5, 28), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .strafeToLinearHeading(new Vector2d(50.5, 36), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .build());
        }

        mRobot.mIntake.setPower(0.5);
        sleep(200);
        mRobot.mLift.setArmPosition(0.8);
        sleep(100);
        mRobot.mIntake.setPower(-0.5);
        sleep(750);
    }
}
