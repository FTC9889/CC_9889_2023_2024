package com.team9889.ftc2023.opmode.blue;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Intake;
import com.team9889.ftc2023.subsystems.Robot;
import com.team9889.ftc2023.subsystems.ScoringLift;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.DriveAuto;

@Autonomous(group = "Blue", name = "⬆️ Blue Backdrop Side 🟦", preselectTeleOp = "TeleOp")
public final class BlueFrontRR extends LinearOpMode {
    Robot mRobot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
//******//DON'T CHANGE THIS YOU WILL REGRET IT//**********************************************************************************************************//////////////////////////////////********************
        Pose2d beginPose = new Pose2d(11, 63.5, Math.toRadians(-90));
//********************************************************************************************
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
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .strafeToLinearHeading(new Vector2d(48, 60), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(58, 60), Math.toRadians(-180))
                            .build());
        } else if (side == Robot.BackDrop.LEFT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(-90))
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(26, 48), Math.toRadians(-90))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .afterDisp(5, mRobot.mLift.Deploy())
                            .splineToLinearHeading(new Pose2d(51, 38, Math.toRadians(-180)), 0)
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mLift.Retract())
                            .strafeToLinearHeading(new Vector2d(48, 61), Math.toRadians(-180))
                            .strafeToLinearHeading(new Vector2d(58, 61), Math.toRadians(-180))
                            .build());
        } else if (side == Robot.BackDrop.RIGHT){
            Actions.runBlocking(
                    mRobot.aDrive.actionBuilder(beginPose)
                            .setTangent(Math.toRadians(-90))
                            .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                            .strafeToLinearHeading(new Vector2d(17, 50), Math.toRadians(-120))
                            .stopAndAdd(mRobot.mIntake.ExtendIntake(8))
                            .stopAndAdd(mRobot.mIntake.Outtake())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mIntake.Off())
                            .stopAndAdd(mRobot.mIntake.RetractIntake())
                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
                            .stopAndAdd( mRobot.mLift.Deploy())
                            .turnTo(Math.toRadians(180))
                            .strafeToLinearHeading(new Vector2d(50, 26), Math.toRadians(-180))
                            .stopAndAdd(mRobot.mLift.Score())
                            .waitSeconds(1)
                            .stopAndAdd(mRobot.mLift.Retract())
                            .strafeToLinearHeading(new Vector2d(50, 60), Math.toRadians(180))
                            .strafeToLinearHeading(new Vector2d(58, 60), Math.toRadians(180))
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
