package com.team9889.ftc2023.opmode.blue;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Intake;
import com.team9889.ftc2023.subsystems.Robot;
//** 60.5.x ** 30.y **//
@Autonomous
public class FarBlueRR extends LinearOpMode {
    Robot mRobot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK ****************
        Pose2d beginPose = new Pose2d(-38, 63.5, Math.toRadians(-90));
        mRobot.init(hardwareMap, beginPose);

        Robot.BackDrop side = Robot.BackDrop.CENTER;

        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        waitForStart();

        mRobot.mCamera.startapriltag();

        mRobot.mCamera.pauseallcamera();


        if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(-90))
                            .splineToLinearHeading(new Vector2d(-39, 57), Math.toRadians(-90))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(400))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(1, mRobot.mIntake.BringBackIntake())
                            .splineToLinearHeading(new Vector2d(-52, 35), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(150))
                            .splineToLinearHeading(new Vector2d(-52, 27.5), Math.toRadians(-180))
                            .waitSeconds(0.75)
                            .stopAndAdd( mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(10,mRobot.mLift.setgrabber(true, true))
                            .afterDisp(20, mRobot.mIntake.Transfer())
                            .splineToLinearHeading(new Vector2d(-52, 8), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mIntake.Off())
                            .afterDisp(10, mRobot.mLift.setgrabber(false, false))
                            .afterDisp( 5, mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .splineToLinearHeading(new Vector2d(30, 8), Math.toRadians(-140))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(50))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(2)
                            .splineToLinearHeading(new Vector2d(45, 30), Math.toRadians(-180))
                            .splineToLinearHeading(new Vector2d(47.5, 30), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)

                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(-90))
                            .splineToLinearHeading(new Vector2d(-41, 55), Math.toRadians(-50))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(275))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .waitSeconds(1)
                            .stopAnendAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(1, mRobot.mIntake.BringBackIntake())
                            .splineToLinearHeading(new Vector2d(-52, 35), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(150))
                            .splineToLinearHeading(new Vector2d(-52, 26), Math.toRadians(-180))
                            .waitSeconds(0.75)
                            .stopAndAdd( mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(10, mRobot.mLift.setgrabber(true, true))
                            .afterDisp(20, mRobot.mIntake.Transfer())
                            .splineToLinearHeading(new Vector2d(-52, 8), Math.toRadians(-180))
                            .splineToLinearHeading(new Vector2d(0, 8), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mIntake.Off())
                            .afterDisp( 5, mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .spliToLinearHeading(new Vector2d(30, 8), Math.toRadians(-140))
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(50))
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(1)
                            .splineToLinearHeading(new Vector2d(45, 37.5), Math.toRadians(-180))
                            .splineToLinearHeading(new Vector2d(47.5, 37.5), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(-90))
                            .splineToLinearHeading(new Vector2d(-46, 60.5), Math.toRadians(-90))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(400))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(1, mRobot.mIntake.BringBackIntake())
                            .strafeToLinearHeading(new Vector2d(-43, 48), Math.toRadians(-165))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(400))
                            .waitSeconds(0.75)
                            .stopAndAdd( mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .strafeToLinearHeading(new Vector2d(-37, 37), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(-37, 8), Math.toRadians(-180))
                            .afterDisp( 5, mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .afterDisp(10,mRobot.mLift.setgrabber(true, true))
                            .afterDisp(20, mRobot.mIntake.Transfer())
                            .strafeToLinearHeading(new Vector2d(30, 8), Math.toRadians(-140))
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(50))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(2)
                            .strafeToLinearHeading(new Vector2d(45, 28), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(47.5, 28), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(1)
                            .strafeToLinearHeading(new Vector2d(47.5, 38), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .build());
        }

        mRobot.mIntake.setPower(0.5);
        sleep(500);
        mRobot.mLift.initPosition();
        sleep(100);
        mRobot.mIntake.setPower(-0.5);
        sleep(750);
    }
  
































}
