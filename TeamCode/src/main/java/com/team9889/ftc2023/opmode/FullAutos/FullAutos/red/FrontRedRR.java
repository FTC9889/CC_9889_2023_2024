package com.team9889.ftc2023.opmode.FullAutos.FullAutos.red;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;
@Autonomous(group = "Red", name = "🔺 Red Backdrop Side 🟥"
//        , preselectTeleOp = "TeleOp"
        )
public class FrontRedRR extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //DON'T CHANGE THIS YOU WILL REGRET IT
        Pose2d beginPose = new Pose2d(16, -63.5, Math.toRadians(90));

        Robot mRobot = new Robot();

        ElapsedTime Timer = new ElapsedTime();


        mRobot.init(hardwareMap, beginPose);


        mRobot.mLift.intake_position();
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

        if (side == Robot.BackDrop.LEFT) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37 + 48, -57), Math.toRadians(110))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .build());
        } else if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37 + 48, -57), Math.toRadians(73))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .build());
        } else if(side == Robot.BackDrop.RIGHT) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37 + 48, -57), Math.toRadians(60))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(11))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake()).build());
        }

        if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .setTangent(Math.toRadians(90))
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(15, mRobot.mLift.DeploySecondStage())
                            .splineToLinearHeading(new Pose2d(51, -34, Math.toRadians(180)), 0)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                            .waitSeconds(0.5)
                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .setTangent(Math.toRadians(90))
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(15, mRobot.mLift.DeploySecondStage())
                            .strafeToLinearHeading(new Vector2d(51, -27), Math.toRadians(180))
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .setTangent(Math.toRadians(90))
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(15, mRobot.mLift.DeploySecondStage())
                            .strafeToLinearHeading(new Vector2d(51, -41), Math.toRadians(180))
                            .waitSeconds(0.5)
                            .build());

        }

        Actions.runBlocking(
                mRobot.aDrive.actionBuilder(mRobot.aDrive.pose).stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
                .stopAndAdd(mRobot.mLift.IntakePosition())
                .waitSeconds(1)
                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .stopAndAdd(mRobot.mIntake.BringBackIntake())
                .strafeToLinearHeading(new Vector2d(48, -60), Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(58, -60), Math.toRadians(180))
                .build());

//        Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
//                .stopAndAdd(() -> mRobot.mLift.intake_position())
//                .afterDisp(5, mRobot.mIntake.RetractIntake())
//
//                // Strafe Away from backdrop
//                .strafeToLinearHeading(new Vector2d(25, -10), Math.toRadians(-180))
//
//                // Drive to stack and extend Intake while moving
//                .setTangent(Math.toRadians(180))
//                .afterDisp(0.5, () -> mRobot.mIntake.vfb4thPixleDown())
//                .afterDisp(2, mRobot.mIntake.ExtendIntake(21, mRobot.aDrive))
//                .afterDisp(5, mRobot.mIntake.On())
//                .splineTo(new Vector2d(-37, -12), Math.toRadians(180))
//                //Angle for first pick up
//                .turnTo(Math.toRadians(177))
//                .stopAndAdd(() -> mRobot.mIntake.setPower(0))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
//                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
//                .stopAndAdd(() -> mRobot.mIntake.vfb2ndPixleDown())
//                //Angle for second pick up
//                .turnTo(Math.toRadians(182))
//                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(20.5))
//                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .afterDisp(0.01, mRobot.mLift.setgrabber(true, true))
//                .afterDisp(45, mRobot.mIntake.Transfer())
//                .afterDisp(60, mRobot.mIntake.Off())
//                .afterDisp(61, mRobot.mLift.setgrabber(false, false))
//                .setReversed(true)
//                .afterDisp(63, () -> mRobot.mIntake.brake_off())
//                .afterDisp(62, mRobot.mIntake.Off())
//                .splineTo(new Vector2d(20, -7), Math.toRadians(0))
//
//                .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
//                .afterDisp(10, mRobot.mLift.DeploySecondStage())
//                .afterDisp(15, () -> mRobot.mLift.setPower(1))
//                .setReversed(true)
//                .splineTo(new Vector2d(48, -24), Math.toRadians(-15))
//                .stopAndAdd(() -> mRobot.mLift.setPower(0.2))
//                .stopAndAdd(mRobot.mLift.Score())
//                .waitSeconds(0.5)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.45))
//                .stopAndAdd(() -> mRobot.mLift.setPower(-1))
//                .waitSeconds(0.5)
//                .build());

        mRobot.mIntake.ExtendIntake(3);
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mLift.intake_position();
        sleep(100);
        mRobot.mIntake.setPower(-0.5);
        sleep(650);
    }
}
