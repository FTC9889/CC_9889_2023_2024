package com.team9889.ftc2023.opmode.FullAutos.FullAutos.red;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.AngularVelConstraint;
import com.acmerobotics.roadrunner.InstantFunction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.VelConstraint;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;


@Autonomous(group = "Red", name = "🔻 Red Audience Side 🟥"
        , preselectTeleOp = "TeleOp"
        )
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

        boolean first_level = false;
        boolean cycle = true;


        while (opModeInInit()) {
            telemetry.addData("first level", first_level);
            telemetry.addData("cycle?", cycle);
            telemetry.addData("Side", side);
            mRobot.mCamera.telemetryTfod(telemetry);
            side = mRobot.mCamera.side();
            if (gamepad1.y){
                first_level = true;
            } else if (gamepad1.a) {
                first_level = false;
            }

            if (gamepad1.dpad_up){
                cycle = true;
            } else if (gamepad1.dpad_down) {
                cycle = false;
            }
        }

        final boolean finalFirst_level = first_level;
        boolean finalCycle = cycle;


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
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(109))
                            .lineToY(-11)
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .turnTo(Math.toRadians(-175))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(4))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, true))
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .afterDisp(40, mRobot.mIntake.Transfer())
                            .afterDisp(53, mRobot.mLift.setgrabber(false, false))
                            .afterDisp( 58, mRobot.mIntake.Off())
                            .afterDisp(60, () -> mRobot.mIntake.brake_off())
                            .afterDisp(65, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(38, -4), Math.toRadians(-180))
                            .stopAndAdd(new InstantFunction() {
                                @Override
                                public void run() {
                                    if(!finalCycle) mRobot.mIntake.out();
                                }
                            })
                            .waitSeconds(cycle ? 0.01 : 11)
                            .strafeToLinearHeading(new Vector2d(38, -31), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .build());

            Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .strafeToLinearHeading(new Vector2d(43, -38), Math.toRadians(-180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.14, 0.255, finalFirst_level))
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(finalFirst_level ? 48.5 : 51.5, -38), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.4)
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .waitSeconds(0.2)
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
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .turnTo(Math.toRadians(-175))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(19))
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .afterDisp(35, mRobot.mLift.setgrabber(false, true))
                            .afterDisp(40, mRobot.mIntake.Transfer())
                            .afterDisp(53, mRobot.mLift.setgrabber(false, false))
                            .afterDisp( 58, mRobot.mIntake.Off())
                            .afterDisp(60, () -> mRobot.mIntake.brake_off())
                            .afterDisp(65, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
                            .stopAndAdd(new InstantFunction() {
                                @Override
                                public void run() {
                                    if(!finalCycle) mRobot.mIntake.out();
                                }
                            })
                            .waitSeconds(cycle ? 0.01 : 11)
                            .strafeToLinearHeading(new Vector2d(38, -29), Math.toRadians(-180))
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(finalFirst_level ? 0.15 : 0.22))
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .build());

                    Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .afterDisp(3, mRobot.mIntake.RetractIntake())
                            .strafeToLinearHeading(new Vector2d(finalFirst_level ? 48 : 49.5, finalFirst_level ? -32 : -28.5), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, finalFirst_level))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(new Action() {
                                ElapsedTime timer = new ElapsedTime();
                                boolean first = true;
                                @Override
                                public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                                    if(finalFirst_level) return false;

                                    if(first) {
                                        timer.reset();
                                        first = false;
                                    }

                                    if(timer.milliseconds() < 600) {
                                        mRobot.mLift.setPower(1);
                                        mRobot.mLift.setArmPosition(0.25);
                                    } else if(timer.milliseconds() < 800) {
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

        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(60))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(13))
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .turnTo(Math.toRadians(95))
                            .lineToY(-11.5)
                            .turnTo(Math.toRadians(-176))
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(5, mRobot.mLift.setgrabber(false, true))
                            .afterDisp(7, mRobot.mIntake.Transfer())
                            .afterDisp(63, mRobot.mLift.setgrabber(false, false))
                            .afterDisp( 64, mRobot.mIntake.Off())
                            .afterDisp(66, mRobot.mIntake.ExtendIntake(3))
                            .strafeToLinearHeading(new Vector2d(39, -8), Math.toRadians(-180))
                            .stopAndAdd(new InstantFunction() {
                                @Override
                                public void run() {
                                    if(!finalCycle) mRobot.mIntake.out();
                                }
                            })
                            .waitSeconds(cycle ? 0.01 : 11)
                            .strafeToLinearHeading(new Vector2d(39, -30), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
                            .waitSeconds(0.1)
                            .build());

            Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .strafeToLinearHeading(new Vector2d(50.25, -43), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                            .waitSeconds(0.25)
                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                            .strafeToLinearHeading(new Vector2d(50.25, -30), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(0.5)
                            .build());
        }


        if (cycle) {
            Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                    .stopAndAdd(() -> mRobot.mLift.intake_position())
                    .afterDisp(5, mRobot.mIntake.RetractIntake())

                    // Strafe Away from backdrop
                    .strafeToLinearHeading(new Vector2d(25, -10), Math.toRadians(-180))

                    // Drive to stack and extend Intake while moving
                    .setTangent(Math.toRadians(180))
                    .afterDisp(0.5, () -> mRobot.mIntake.vfb3rdPixleDown())
                    .afterDisp(2, mRobot.mIntake.ExtendIntake(18, mRobot.aDrive))
                    .afterDisp(5, mRobot.mIntake.On())
                    .splineTo(new Vector2d(-37, -14), Math.toRadians(180))
                    //Angle for first pick up
                    .turnTo(Math.toRadians(-180 ))
                    .stopAndAdd(() -> mRobot.mIntake.setPower(0))
                    .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
                    .waitSeconds(0.25)
                    .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                    .stopAndAdd(() -> mRobot.mIntake.vfbDown())
                    //Angle for second pick up
                    .turnTo(Math.toRadians(-175))
                    .waitSeconds(0.25)
                    .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                    .waitSeconds(0.25)
                    .stopAndAdd(mRobot.mIntake.BringBackIntake())
                    .stopAndAdd(mRobot.mIntake.Off())
                    .stopAndAdd(mRobot.mIntake.RetractIntake())
                    .stopAndAdd(mRobot.mIntake.On())
                    .afterDisp(0.01, mRobot.mLift.setgrabber(true, true))
                    .afterDisp(45, mRobot.mIntake.Transfer())
                    .afterDisp(61, mRobot.mIntake.Off())
                    .afterDisp(60, mRobot.mLift.setgrabber(false, false))
                    .setReversed(true)
                    .afterDisp(63, () -> mRobot.mIntake.brake_off())
                    .splineTo(new Vector2d(20, -7), Math.toRadians(0))
                    .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
                    .afterDisp(10, mRobot.mLift.DeploySecondStage())
                    .afterDisp(15, () -> mRobot.mLift.setPower(1))
                    .setReversed(true)
                    .splineTo(new Vector2d(46, -26), Math.toRadians(-15))
                    .stopAndAdd(() -> mRobot.mLift.setPower(0.2))
                    .stopAndAdd(mRobot.mLift.Score())
                    .waitSeconds(0.5)
                    .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.45))
                    .stopAndAdd(() -> mRobot.mLift.setPower(-1))
                    .waitSeconds(0.5)
                    .build());
        } else {
            Actions.runBlocking(mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                    .stopAndAdd(mRobot.mLift.Retract())
                    .waitSeconds(0.25)
                    .strafeToLinearHeading(new Vector2d(45, -10), Math.toRadians(-180)).build());
        }

        mRobot.mLift.setPower(0);
        mRobot.mLift.intake_position();
        mRobot.mIntake.ExtendIntake(0);
        sleep(750);
    }
}
