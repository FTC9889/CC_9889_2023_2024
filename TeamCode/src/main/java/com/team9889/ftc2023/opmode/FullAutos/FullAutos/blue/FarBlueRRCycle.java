package com.team9889.ftc2023.opmode.FullAutos.FullAutos.blue;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;

//** 60.5.x ** 30.y **//
@Autonomous(group = "Blue", name = "⬇️ Blue Audience Side 🟦")
//        , preselectTeleOp = "TeleOp")
public class FarBlueRRCycle extends LinearOpMode {
    Robot mRobot = new Robot();

    ElapsedTime Timer = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK ****************
        Pose2d beginPose = new Pose2d(-38, 63.5, Math.toRadians(-90));
        mRobot.init(hardwareMap, beginPose);

        mRobot.mLift.intake_position();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        mRobot.mCamera.red = false;
        Robot.BackDrop side = Robot.BackDrop.LEFT;

        mRobot.mLED.off();

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
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-75))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(20))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(-109))
                            .lineToY(15)
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .waitSeconds(0.1)
                            .turnTo(Math.toRadians(175))
                            .stopAndAdd(() -> mRobot.mIntake.brake_off())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(4))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, true))
                            .afterDisp(0.0001, mRobot.mIntake.Transfer())
                            .afterDisp( 53, mRobot.mIntake.Off())
                            .afterDisp(55, () -> mRobot.mIntake.brake_off())
                            .afterDisp(53, mRobot.mLift.setgrabber(false, false))
                            .afterDisp(56, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(38, 4), Math.toRadians(-180))

                            // Move to in front of apriltags
                            .strafeToLinearHeading(new Vector2d(38, 31), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                            .strafeToLinearHeading(new Vector2d(43, 33), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(50.5, 33), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.4)
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .waitSeconds(0.5)

                            // Beginning of Cycle
                            .stopAndAdd(() -> mRobot.mLift.intake_position())

                            // Strafe Away from backdrop
                            .strafeToLinearHeading(new Vector2d(25, 10), Math.toRadians(-180))

                            // Drive to stack and extend Intake while moving
                            .setTangent(Math.toRadians(180))
                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(21))
                            .afterDisp(15, mRobot.mIntake.On())
                            .splineTo(new Vector2d(-37, 14), Math.toRadians(175))
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
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                            .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
                            .setReversed(true)
                            .afterDisp(63, () -> mRobot.mIntake.brake_off())
                            .afterDisp(62, mRobot.mIntake.Off())
                            .splineTo(new Vector2d(20, 7), Math.toRadians(0))

                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
                            .afterDisp(20, () -> mRobot.mLift.setPower(1))
                            .setReversed(true)
                            .splineTo(new Vector2d(48, 25), Math.toRadians(25))
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
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-60))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(-95))
                            .lineToY(15)
                            .turnTo(Math.toRadians(176))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .stopAndAdd(mRobot.mIntake.On())
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(13))
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.Off())
                            .afterDisp(5, mRobot.mLift.setgrabber(false, true))
                            .afterDisp(7, mRobot.mIntake.Transfer())
                            .afterDisp( 63, mRobot.mIntake.Off())
                            .afterDisp(63, mRobot.mLift.setgrabber(false, false))
                            .afterDisp(66, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(39, 8), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(39, 32), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .strafeToLinearHeading(new Vector2d(50.5, 41), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(50, 38.5), Math.toRadians(180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .waitSeconds(0.25)
                            .afterDisp(5, mRobot.mLift.Deploy())
                            .afterDisp(10, mRobot.mLift.Score())
                            .afterDisp(15, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(25, () -> mRobot.mLift.intake_position())
                            .strafeToLinearHeading(new Vector2d(49, 28.5), Math.toRadians(180))
                            .strafeToLinearHeading(new Vector2d(25, 10), Math.toRadians(-180))
                            .setTangent(Math.toRadians(180))
                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
                            .afterDisp(30, mRobot.mIntake.ExtendIntake(21))
                            .afterDisp(35, mRobot.mIntake.On())
                            .splineTo(new Vector2d(-37, 14), Math.toRadians(180))
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
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                            .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
                            .setReversed(true)
                            .afterDisp(63, () -> mRobot.mIntake.brake_off())
                            .afterDisp(62, mRobot.mIntake.Off())
                            .splineTo(new Vector2d(20, 7), Math.toRadians(0))

                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
                            .afterDisp(20, () -> mRobot.mLift.setPower(1))
                            .setReversed(true)
                            .splineTo(new Vector2d(48, 25), Math.toRadians(25))
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
                            .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-112))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
//                            .stopAndAdd(mRobot.mIntake.Outtake())
//                            .waitSeconds(0.5)
//                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .turnTo(Math.toRadians(-90))
                            .lineToY(15)
                            .turnTo(Math.toRadians(175))
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
                            .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .strafeToLinearHeading(new Vector2d(50.5, 28), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .strafeToLinearHeading(new Vector2d(50.5, 36), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(0.5)
//                            .strafeToLinearHeading(new Vector2d(50.5, 33), Math.toRadians(-180))
//                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
//                            .waitSeconds(0.5)
                            .afterDisp(5, () -> mRobot.mLift.intake_position())
                            .strafeToLinearHeading(new Vector2d(25, 10), Math.toRadians(-180))
                            .setTangent(Math.toRadians(180))
                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(21))
                            .afterDisp(15, mRobot.mIntake.On())
                            .splineTo(new Vector2d(-37, 14), Math.toRadians(175))
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
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                            .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
                            .setReversed(true)
                            .afterDisp(63, () -> mRobot.mIntake.brake_off())
                            .afterDisp(62, mRobot.mIntake.Off())
                            .splineTo(new Vector2d(20, 7), Math.toRadians(0))

                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
                            .afterDisp(20, () -> mRobot.mLift.setPower(1))
                            .setReversed(true)
                            .splineTo(new Vector2d(47, 28), Math.toRadians(25))
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
        mRobot.mIntake.setPower(-0.5);
        sleep(750);
    }
}
