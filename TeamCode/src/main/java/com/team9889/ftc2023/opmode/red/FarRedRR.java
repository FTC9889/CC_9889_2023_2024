package com.team9889.ftc2023.opmode.red;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;


@Autonomous
public class FarRedRR extends LinearOpMode {

    Robot mRobot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK *******************************************************
        Pose2d beginPose = new Pose2d(-34, -63.5, Math.toRadians(90));
        //********************************************************************************************************************************************************************
        mRobot.init(hardwareMap, beginPose);

        Robot.BackDrop side = Robot.BackDrop.LEFT;

        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

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
                        .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(77.5))
                        .stopAndAdd(() -> mRobot.mIntake.vfb.setPosition(0.09))
                        .waitSeconds(0.50)
                        .stopAndAdd(mRobot.mIntake.Outtake())
                        .waitSeconds(0.6)
                        .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                        .waitSeconds(0.1)
                        .stopAndAdd(mRobot.mIntake.Off())
                        .stopAndAdd(mRobot.mIntake.ExtendIntake(17.5))
                        .stopAndAdd(mRobot.mLift.IntakePosition())
                        .stopAndAdd(mRobot.mIntake.RetractIntake())
                        .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(109))
                            .lineToY(-10)
                        .afterDisp(0.01, mRobot.mIntake.vfb5thpixle())
                            .turnTo(Math.toRadians(-175))
                        .stopAndAdd(mRobot.mIntake.On())
                        .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
                        .waitSeconds(1)
                        .stopAndAdd(mRobot.mIntake.BringBackIntake())
                        .stopAndAdd(mRobot.mIntake.RetractIntake())
                        .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                        .stopAndAdd(mRobot.mIntake.RetractIntake())
                        .stopAndAdd(mRobot.mIntake.Transfer())
                        .waitSeconds(1.5)
                        .stopAndAdd(mRobot.mIntake.Off())
                        .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                        .stopAndAdd(mRobot.mIntake.Off())
                            .strafeToLinearHeading(new Vector2d(38, -4), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, -31), Math.toRadians(-180))
                        .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                        .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                            .strafeToLinearHeading(new Vector2d(43, -38), Math.toRadians(-180))
                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.255))
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(51.5, -38), Math.toRadians(-180))
                        .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.4)
                        .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                        .waitSeconds(0.2)
                        .stopAndAdd(() -> mRobot.mLift.initPosition())
                            .waitSeconds(2)
                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(110))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .turnTo(Math.toRadians(90))
                            .lineToY(-11)
                            .turnTo(Math.toRadians(-175))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(18))
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Transfer())
                            .waitSeconds(1.5)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(50.5, -28), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(50.5, -32), Math.toRadians(180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .strafeToLinearHeading(new Vector2d(50.5, -36), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .stopAndAdd(() -> mRobot.mLift.initPosition())
                            .waitSeconds(0.5)
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                   .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(60))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                    .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.Outtake())
                    .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                    .turnTo(Math.toRadians(95))
                    .lineToY(-11.5)
                    .turnTo(Math.toRadians(-176))
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
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Transfer())
                    .waitSeconds(1.5)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                    .strafeToLinearHeading(new Vector2d(39, -8), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                    .strafeToLinearHeading(new Vector2d(39, -34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                    .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                    .strafeToLinearHeading(new Vector2d(50.25, -45), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                    .waitSeconds(0.25)
                    .strafeToLinearHeading(new Vector2d(50.25, -38.5), Math.toRadians(180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                    .waitSeconds(0.25)
                    .strafeToLinearHeading(new Vector2d(50, -28.5), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                    .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                    .waitSeconds(1)
                            .stopAndAdd(() -> mRobot.mLift.initPosition())
                            .waitSeconds(0.5)
                            .build());



        }
    }
}
