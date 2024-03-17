package com.team9889.ftc2023.opmode.JustPark;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous(group = "Red", name = "🔻 Red Audience Side Just Park 🟥"
//        , preselectTeleOp = "TeleOp"
)

@Disabled
public class FarRedRRJustParkNotReadyYet extends LinearOpMode {
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


        while (opModeInInit()) {
            telemetry.addData("first level", first_level);
            telemetry.addData("Side", side);
            mRobot.mCamera.telemetryTfod(telemetry);
            side = mRobot.mCamera.side();
            if (gamepad1.y){
                first_level = true;
            } else if (gamepad1.a) {
                first_level = false;
            }
        }

        final boolean finalFirst_level = first_level;

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
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(14))
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
                            .strafeToLinearHeading(new Vector2d(67, -11), Math.toRadians(-180))
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
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(19.5))
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.brake_on())
                            .afterDisp(35, mRobot.mLift.setgrabber(false, true))
                            .afterDisp(40, mRobot.mIntake.Transfer())
                            .afterDisp(53, mRobot.mLift.setgrabber(false, false))
                            .afterDisp( 58, mRobot.mIntake.Off())
                            .afterDisp(60, () -> mRobot.mIntake.brake_off())
                            .strafeToLinearHeading(new Vector2d(67, -11), Math.toRadians(-180))
                            .build());








        } else if (side == Robot.BackDrop.RIGHT) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(60))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
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
                            .afterDisp(63, mRobot.mIntake.Off())
                            .afterDisp(63, mRobot.mLift.setgrabber(false, false))
                            .strafeToLinearHeading(new Vector2d(67, -11), Math.toRadians(-180))
                            .build());
        }

        mRobot.mLift.setPower(0);
        mRobot.mLift.intake_position();
        mRobot.mIntake.setPower(-0.3);
        sleep(750);
    }
}


