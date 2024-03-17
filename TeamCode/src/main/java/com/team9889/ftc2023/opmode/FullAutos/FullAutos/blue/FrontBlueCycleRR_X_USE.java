package com.team9889.ftc2023.opmode.FullAutos.FullAutos.blue;


import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class FrontBlueCycleRR_X_USE extends LinearOpMode {

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
                            .setTangent(Math.toRadians(-90))
                            .afterDisp(15,() -> mRobot.mLift.setArmPosition(0.17))
                            .splineToLinearHeading(new Pose2d(45, 31, Math.toRadians(-180)), 0)
                            .strafeToLinearHeading(new Vector2d(51, 31), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mLift.Retract())
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(48, 25), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(14.5))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                             .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .splineTo(new Vector2d(25.5, 10), Math.toRadians(-180))
                            .splineTo(new Vector2d(0, 8), Math.toRadians(-175))
                            .splineTo(new Vector2d(-36, 11.75), Math.toRadians(-180))
                            .waitSeconds(0.1)
                            .stopAndAdd(() -> mRobot.mIntake.setPower(0))
                            .stopAndAdd(() -> mRobot.mIntake.vfb5thPixleDown())
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                            .waitSeconds(0.5)
                            .stopAndAdd(() -> mRobot.mIntake.setPower(-1))
                            .waitSeconds(0.1)
                            .stopAndAdd(() -> mRobot.mIntake.vfb4thPixleDown())
                            .turnTo(Math.toRadians(185))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                            .strafeToLinearHeading(new Vector2d(44, 11.75), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(44, 31), Math.toRadians(180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(50.5, 34), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .strafeToLinearHeading(new Vector2d(50.5, 31), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
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
