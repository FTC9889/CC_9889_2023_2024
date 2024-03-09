package com.team9889.ftc2023.opmode.red;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;


@Autonomous(group = "Red", name = "🔻♻️ Red Audience Alternate Side 🟥", preselectTeleOp = "TeleOp")
public class FarRedAlternateRR extends LinearOpMode {

    Robot mRobot = new Robot();

    ElapsedTime Timer = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK *******************************************************
        Pose2d beginPose = new Pose2d(-34, -63.5, Math.toRadians(90));
        //********************************************************************************************************************************************************************
        mRobot.init(hardwareMap, beginPose);

        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        mRobot.mCamera.red = true;
        Robot.BackDrop side = Robot.BackDrop.CENTER;


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
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(77.5))
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(0.6)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .strafeToLinearHeading(new Vector2d(-36, -48), Math.toRadians(160))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
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
                            .strafeToLinearHeading(new Vector2d(-36, -59), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(33, -59), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .strafeToLinearHeading(new Vector2d(43, -33), Math.toRadians(-180))
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(51.5, -36), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.1)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .waitSeconds(0.4)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.26))
                            .waitSeconds(0.4)
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .waitSeconds(0.2)
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(43, -63), Math.toRadians(-180))
                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(112))
                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .waitSeconds(0.5)
                .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(-36, -48), Math.toRadians(160))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
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
                            .strafeToLinearHeading(new Vector2d(-36, -59), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(33, -59), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
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
                            .waitSeconds(0.5)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(43, -63), Math.toRadians(-180))
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
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(11))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .strafeToLinearHeading(new Vector2d(-36, -48), Math.toRadians(160))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
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
                            .strafeToLinearHeading(new Vector2d(-36, -59), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(33, -59), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(50.5, -41), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(50.5, -38.5), Math.toRadians(180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(50, -35.5), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(0.5)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(43, -63), Math.toRadians(-180))
                            .build());



        }
    }
}
