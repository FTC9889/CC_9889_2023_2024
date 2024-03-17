package com.team9889.ftc2023.opmode.FullAutos.FullAutos.blue;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;

//** 60.5.x ** 30.y **//
@Autonomous(group = "Blue", name = "⬇️♻️ Blue Audience Alternate Side 🟦", preselectTeleOp = "TeleOp")
public class FarBlueAlternateRR extends LinearOpMode {
    Robot mRobot = new Robot();

    ElapsedTime Timer = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK *******************************************************
        Pose2d beginPose = new Pose2d(-40, 63.5, Math.toRadians(-90));
        //****************************************************************************************BRUH****************************************************************************
        mRobot.init(hardwareMap, beginPose);

        mRobot.mLift.intake_position();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        mRobot.mCamera.red = false;
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

        if (side == Robot.BackDrop.LEFT) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-60))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .build());
        } else if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-77))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .build());
        } else if(side == Robot.BackDrop.RIGHT) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-110))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(9))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .build());
        }

            // Drive Across Field
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(mRobot.aDrive.pose).
                            strafeToLinearHeading(new Vector2d(-38, 43), Math.toRadians(-172))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(20))
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, true))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Transfer())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(-36, 59), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(33, 57), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, 27), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2)).build());

            if (side == Robot.BackDrop.LEFT) {
                Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.24))
                        .afterDisp(3, mRobot.mIntake.RetractIntake())
                        .strafeToLinearHeading(new Vector2d(49.5, 41), Math.toRadians(180))
                        .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                        .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                        .stopAndAdd(mRobot.mLift.DeploySecondStage())
                        .stopAndAdd(new Action() {
                            final ElapsedTime timer = new ElapsedTime();
                            boolean first = true;

                            @Override
                            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                                if (first) {
                                    timer.reset();
                                    first = false;
                                }

                                if (timer.milliseconds() < 600) {
                                    mRobot.mLift.setPower(1);
                                    mRobot.mLift.setArmPosition(0.25);
                                } else if (timer.milliseconds() < 800) {
                                    mRobot.mLift.setPower(0.2);
                                    mRobot.mLift.set_Grabber_Open(true, true);
                                } else if (timer.milliseconds() < 1000) {
                                    mRobot.mLift.setArmPosition(0.34);
                                    mRobot.mLift.set_Grabber_Open(true, true);
                                } else if (timer.milliseconds() < 1600) {
                                    mRobot.mLift.setPower(-1);
                                } else if (timer.milliseconds() < 1800) {
                                    mRobot.mLift.setPower(0);
                                    mRobot.mLift.intake_position();
                                }

                                return timer.milliseconds() < 2000;
                            }
                        })
                        .build());
            } else if (side == Robot.BackDrop.CENTER) {
                Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                        .stopAndAdd(mRobot.mIntake.RetractIntake())
                        .strafeToLinearHeading(new Vector2d(43, 38), Math.toRadians(-180))
                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.14, 0.255, false))
                        .waitSeconds(0.5)
                        .strafeToLinearHeading(new Vector2d(51.5, 34), Math.toRadians(-180))
                        .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                        .waitSeconds(0.4)
                        .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                        .waitSeconds(0.2)
                        .build());
            } else if (side == Robot.BackDrop.RIGHT) {
                Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                        .strafeToLinearHeading(new Vector2d(46, 45-14), Math.toRadians(180))
                        .strafeToLinearHeading(new Vector2d(48, 40-14), Math.toRadians(180))
                        .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                        .waitSeconds(0.25)
                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.26))
                        .strafeToLinearHeading(new Vector2d(48, 45), Math.toRadians(180))
                        .stopAndAdd(mRobot.mLift.DeploySecondStage())
                        .stopAndAdd(mRobot.mLift.Score())
                        .waitSeconds(0.5)
                        .build());
            }

            Vector2d pose = new Vector2d(mRobot.aDrive.pose.position.x - 5, mRobot.aDrive.pose.position.y);

            Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                    .strafeToLinearHeading(pose, Math.toRadians(-180))
                    .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                    .strafeToLinearHeading(new Vector2d(43, 58), Math.toRadians(-180))
                    .stopAndAdd(mRobot.mLift.IntakePosition())
                            .waitSeconds(0.5)
                    .stopAndAdd(mRobot.mIntake.RetractIntake())
                    .build());
        }

}
