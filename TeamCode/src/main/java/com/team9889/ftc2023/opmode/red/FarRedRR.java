package com.team9889.ftc2023.opmode.red;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;


@Autonomous(group = "Red", name = "🔻 Red Audience Side 🟥", preselectTeleOp = "TeleOp")
public class FarRedRR extends LinearOpMode {

    Robot mRobot = new Robot();

    ElapsedTime Timer = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK *******************************************************
        Pose2d beginPose = new Pose2d(-33.5, -63.5, Math.toRadians(90));
        //********************************************************************************************************************************************************************
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

        if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(73))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(20))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(109))
                            .lineToY(-11)
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .turnTo(Math.toRadians(-175))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(4.5))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, true))
                            .afterDisp(0.0001, mRobot.mIntake.Transfer())
                            .afterDisp( 53, mRobot.mIntake.Off())
                            .afterDisp(55, () -> mRobot.mIntake.brake_off())
                            .afterDisp(53, mRobot.mLift.setgrabber(false, false))
                            .afterDisp(56, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(38, -4), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, -31), Math.toRadians(-180))

                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .strafeToLinearHeading(new Vector2d(43, -38), Math.toRadians(-180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.255))
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(51.5, -38), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.4)
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .waitSeconds(0.2)

                            // Start of Cycle
                            .stopAndAdd(() -> mRobot.mLift.intake_position())

                            // Strafe Away from backdrop
                            .strafeToLinearHeading(new Vector2d(25, -10), Math.toRadians(-180))

                            // Drive to stack and extend Intake while moving
                            .setTangent(Math.toRadians(180))
                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(21))
                            .afterDisp(15, mRobot.mIntake.On())
                            .splineTo(new Vector2d(-37, -14), Math.toRadians(175))
                            .stopAndAdd(() -> mRobot.mIntake.setPower(0))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                            .stopAndAdd(() -> mRobot.mIntake.vfb3rdPixleDown())
                            .turnTo(Math.toRadians(173))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(19))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .afterDisp(0.01, mRobot.mLift.setgrabber(true, true))
                            .afterDisp(1, mRobot.mIntake.Transfer())
                            .afterDisp(60, mRobot.mIntake.Off())
                            .afterDisp(61, mRobot.mLift.setgrabber(false, false))
                            .setReversed(true)
                            .afterDisp(63, () -> mRobot.mIntake.brake_off())
                            .afterDisp(62, mRobot.mIntake.Off())
                            .splineTo(new Vector2d(20, -7), Math.toRadians(0))

                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
                            .afterDisp(20, () -> mRobot.mLift.setPower(1))
                            .setReversed(true)
                            .splineTo(new Vector2d(48, -25), Math.toRadians(-25))
                            .stopAndAdd(() -> mRobot.mLift.setPower(0.2))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(0.5)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.45))
                            .stopAndAdd(() -> mRobot.mLift.setPower(-1))
                            .waitSeconds(0.5)


                            .build());

        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(110))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(90))
                            .lineToY(-11)
                            .turnTo(Math.toRadians(-175))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())

                            .afterDisp(5, mRobot.mLift.setgrabber(false, true))
                            .afterDisp(7, mRobot.mIntake.Transfer())
                            .afterDisp( 63, mRobot.mIntake.Off())
                            .afterDisp(63, mRobot.mLift.setgrabber(false, false))
                            .afterDisp(66, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(50, -28), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.23))
                            .strafeToLinearHeading(new Vector2d(49.5, -32), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(() -> mRobot.mLift.Score())
                            .waitSeconds(1)
                            .afterDisp(15, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(25, () -> mRobot.mLift.intake_position())
                            .strafeToLinearHeading(new Vector2d(49, -28.5), Math.toRadians(180))
                            .strafeToLinearHeading(new Vector2d(25, -10), Math.toRadians(-180))
                            .setTangent(Math.toRadians(180))
                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
                            .afterDisp(30, mRobot.mIntake.ExtendIntake(21))
                            .afterDisp(35, mRobot.mIntake.On())
                            .splineTo(new Vector2d(-37, -14), Math.toRadians(180))
                            .stopAndAdd(() -> mRobot.mIntake.setPower(0))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                            .stopAndAdd(() -> mRobot.mIntake.vfb3rdPixleDown())
                            .turnTo(Math.toRadians(-173))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(19))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .afterDisp(0.01, mRobot.mLift.setgrabber(true, true))
                            .afterDisp(1, mRobot.mIntake.Transfer())
                            .afterDisp(60, mRobot.mIntake.Off())
                            .afterDisp(61, mRobot.mLift.setgrabber(false, false))
                            .setReversed(true)
                            .afterDisp(63, () -> mRobot.mIntake.brake_off())
                            .afterDisp(62, mRobot.mIntake.Off())
                            .splineTo(new Vector2d(20, -7), Math.toRadians(0))

                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
                            .afterDisp(20, () -> mRobot.mLift.setPower(1))
                            .setReversed(true)
                            .splineTo(new Vector2d(48, -25), Math.toRadians(-25))
                            .stopAndAdd(() -> mRobot.mLift.setPower(0.2))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(0.5)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.45))
                            .stopAndAdd(() -> mRobot.mLift.setPower(-1))
                            .waitSeconds(0.5)
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(60))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .turnTo(Math.toRadians(95))
                            .lineToY(-11.5)
                            .turnTo(Math.toRadians(-176))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(5, mRobot.mLift.setgrabber(false, true))
                            .afterDisp(7, mRobot.mIntake.Transfer())
                            .afterDisp( 63, mRobot.mIntake.Off())
                            .afterDisp(63, mRobot.mLift.setgrabber(false, false))
                            .afterDisp(66, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(39, -8), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(39, -34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .strafeToLinearHeading(new Vector2d(50.25, -45), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .strafeToLinearHeading(new Vector2d(50, -28.5), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(0.5)

                            // Cycle
                            .afterDisp(5, () -> mRobot.mLift.intake_position())
                            .strafeToLinearHeading(new Vector2d(25, -10), Math.toRadians(-180))
                            .setTangent(Math.toRadians(180))
                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(21))
                            .afterDisp(15, mRobot.mIntake.On())
                            .splineTo(new Vector2d(-37, -14), Math.toRadians(175))
//                            .turnTo(Math.toRadians(-178))
                            .stopAndAdd(() -> mRobot.mIntake.setPower(0))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                            .stopAndAdd(() -> mRobot.mIntake.vfb3rdPixleDown())
                            .turnTo(Math.toRadians(173))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(19))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .afterDisp(0.01, mRobot.mLift.setgrabber(true, true))
                            .afterDisp(1, mRobot.mIntake.Transfer())
                            .afterDisp(60, mRobot.mIntake.Off())
                            .afterDisp(61, mRobot.mLift.setgrabber(false, false))
                            .setReversed(true)
                            .afterDisp(63, () -> mRobot.mIntake.brake_off())
                            .afterDisp(62, mRobot.mIntake.Off())
                            .splineTo(new Vector2d(20, -7), Math.toRadians(0))

                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
                            .afterDisp(20, () -> mRobot.mLift.setPower(1))
                            .setReversed(true)
                            .splineTo(new Vector2d(47, -28), Math.toRadians(-25))
                            .stopAndAdd(() -> mRobot.mLift.setPower(0.2))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(0.5)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.45))
                            .stopAndAdd(() -> mRobot.mLift.setPower(-1))
                            .waitSeconds(0.5)
                            .build());
        }

        mRobot.mLift.setPower(0);
        mRobot.mLift.intake_position();
        mRobot.mIntake.setPower(-0.3);
        sleep(750);
    }
}
