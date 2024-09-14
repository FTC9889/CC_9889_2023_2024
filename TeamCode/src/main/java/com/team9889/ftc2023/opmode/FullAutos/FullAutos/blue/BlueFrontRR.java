package com.team9889.ftc2023.opmode.FullAutos.FullAutos.blue;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous(group = "Blue", name = "⬆️ Blue Backdrop Side 🟦", preselectTeleOp = "TeleOp")
public final class BlueFrontRR extends LinearOpMode {
    Robot mRobot = new Robot();

    ElapsedTime Timer = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
//******//DON'T CHANGE THIS YOU WILL REGRET IT//**********************************************************************************************************//////////////////////////////////********************
        Pose2d beginPose = new Pose2d(11, 63.5, Math.toRadians(-90));
//********************************************************************************************

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

        if (side == Robot.BackDrop.RIGHT) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(13, 57), Math.toRadians(-110))
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
                            .strafeToLinearHeading(new Vector2d(-37 + 48, 57), Math.toRadians(-73))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .build());
        } else if(side == Robot.BackDrop.LEFT) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(-37 + 48, 57), Math.toRadians(-60))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(12))
                            .waitSeconds(0.25)
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                            .stopAndAdd(mRobot.mIntake.RetractIntake()).build());
        }

        if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .setTangent(Math.toRadians(-90))
                            .afterDisp(15, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(22, mRobot.mLift.DeploySecondStage())
                            .splineToLinearHeading(new Pose2d(52.5, 33, Math.toRadians(180)), 0)
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                            .waitSeconds(0.5)
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .setTangent(Math.toRadians(-90))
                            .afterDisp(15, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(22, mRobot.mLift.DeploySecondStage())
                            .strafeToLinearHeading(new Vector2d(52.5, 28), Math.toRadians(180))
                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                            .setTangent(Math.toRadians(-90))
                            .afterDisp(15, mRobot.mIntake.ExtendIntake(3))
                            .afterDisp(22, mRobot.mLift.DeploySecondStage())
                            .strafeToLinearHeading(new Vector2d(52.5, 39

                            ), Math.toRadians(180))
                            .waitSeconds(0.5)
                            .build());

        }

        Actions.runBlocking(
                mRobot.aDrive.actionBuilder(mRobot.aDrive.pose)
                        .stopAndAdd(mRobot.mLift.Score())
                        .waitSeconds(1)
                        .stopAndAdd(mRobot.mLift.IntakePosition())
                        .waitSeconds(1)
                        .stopAndAdd(mRobot.mIntake.RetractIntake())
                        .stopAndAdd(mRobot.mIntake.BringBackIntake())
                        .strafeToLinearHeading(new Vector2d(48, 60), Math.toRadians(180))
                        .strafeToLinearHeading(new Vector2d(58, 60), Math.toRadians(180))
                        .build());


        Actions.runBlocking(mRobot.mIntake.ExtendIntake(3));
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mLift.intake_position();
        sleep(100);
        Actions.runBlocking(mRobot.mIntake.RetractIntake());
    }
}
