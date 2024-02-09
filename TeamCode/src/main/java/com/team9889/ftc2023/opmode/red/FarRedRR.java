package com.team9889.ftc2023.opmode.red;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;


@Autonomous
public class FarRedRR extends LinearOpMode {

    Robot mRobot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        //* DON'T CHANGE THIS YOU WILL REGRET IT *************************************************************** LOOK ****************
        Pose2d beginPose = new Pose2d(-34, -63.5, Math.toRadians(90));
        mRobot.init(hardwareMap, beginPose);

        Robot.BackDrop side = Robot.BackDrop.LEFT;

        mRobot.mLift.initPosition();
        mRobot.mLift.set_Grabber_Open(false, false);
        mRobot.mIntake.vfbUp();
        mRobot.mIntake.closeGate();

        waitForStart();

        mRobot.mBackdrop.initAprilTag(hardwareMap);

        if (side == Robot.BackDrop.CENTER) {
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(-90))
                            .strafeToLinearHeading(new Vector2d(-39, -57), Math.toRadians(90))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(400))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(1, mRobot.mIntake.BringBackIntake())
                            .strafeToLinearHeading(new Vector2d(-52, -35), Math.toRadians(180))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(150))
                            .strafeToLinearHeading(new Vector2d(-52, -27.5), Math.toRadians(180))
                            .waitSeconds(0.75)
                            .stopAndAdd( mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .afterDisp(3,mRobot.mIntake.RetractIntake())
                            .afterDisp(20, mRobot.mIntake.Transfer())
                            .strafeToLinearHeading(new Vector2d(-52, -8), Math.toRadians(180))
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .strafeToLinearHeading(new Vector2d(34, -8), Math.toRadians(180))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(50))
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(2)
                            .strafeToLinearHeading(new Vector2d(50, -28), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)

                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(-90))
                            .strafeToLinearHeading(new Vector2d(-41, -55), Math.toRadians(50))
                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(275))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .stopAndAdd(mRobot.mLift.IntakePosition())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .afterDisp(1, mRobot.mIntake.BringBackIntake())
                            .strafeToLinearHeading(new Vector2d(-52, -35), Math.toRadians(180))
                            .stopAndAdd(mRobot.mIntake.On())
                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                            .afterDisp(10, mRobot.mIntake.ExtendIntake(150))
                            .strafeToLinearHeading(new Vector2d(-52, -26), Math.toRadians(180))
                            .waitSeconds(0.75)
                            .stopAndAdd( mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                            .afterDisp(3,mRobot.mIntake.RetractIntake())
                            .afterDisp(20, mRobot.mIntake.Transfer())
                            .strafeToLinearHeading(new Vector2d(-52, -8), Math.toRadians(180))
                            .stopAndAdd(mRobot.mIntake.Off())
                            .strafeToLinearHeading(new Vector2d(34, -8), Math.toRadians(180))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(50))
                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                            .waitSeconds(0.5)
                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
                            .waitSeconds(1)
                            .strafeToLinearHeading(new Vector2d(50, -34), Math.toRadians(180))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){

        }
    }
}
