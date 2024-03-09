package com.team9889.ftc2023.opmode.red;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;
@Autonomous(group = "Red", name = "🔺 Red Backdrop Side 🟥", preselectTeleOp = "TeleOp")
public class FrontRedRR extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //DON'T CHANGE THIS YOU WILL REGRET IT
        Pose2d beginPose = new Pose2d(16, -63.5, Math.toRadians(90));

        Robot mRobot = new Robot();

        ElapsedTime Timer = new ElapsedTime();


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
                            .setTangent(Math.toRadians(90))
                            .afterDisp(15, mRobot.mLift.Deploy())
                            .splineToLinearHeading(new Pose2d(49, -34, Math.toRadians(180)), 0)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mLift.Retract())
                            .waitSeconds(0.25)
                            .strafeToLinearHeading(new Vector2d(48, -24), Math.toRadians(180))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .strafeToLinearHeading(new Vector2d(48, -60), Math.toRadians(180))
                            .strafeToLinearHeading(new Vector2d(58, -60), Math.toRadians(180))
                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(90))
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(11, -43), Math.toRadians(90))
                            .turnTo(Math.toRadians(120))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .turnTo(Math.toRadians(-175))
                            .strafeToLinearHeading(new Vector2d(50.5, -28), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .stopAndAdd(() -> mRobot.mLift.initPosition())
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(new Vector2d(43, -60), Math.toRadians(180))
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(90))
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(24, -49), Math.toRadians(90))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .turnTo(Math.toRadians(180))
                            .afterDisp(5, mRobot.mLift.Deploy())
                            .strafeToLinearHeading(new Vector2d(50, -40), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mLift.Retract())
                            .strafeToLinearHeading(new Vector2d(47, -60), Math.toRadians(180))
                            .build());

        }

        mRobot.mIntake.setPower(0.5);
        sleep(500);
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mLift.intake_position();
        sleep(100);
        mRobot.mIntake.setPower(-0.5);
        sleep(650);
    }
}
