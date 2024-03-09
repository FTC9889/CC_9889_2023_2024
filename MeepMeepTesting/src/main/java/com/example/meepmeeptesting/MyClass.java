package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(900);


//        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .build();
//
//      myBot.runAction(myBot.getDrive().actionBuilder(
//                new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .setTangent(Math.toRadians(-90))
//                .strafeToLinearHeading(new Vector2d(-39, 57), Math.toRadians(-90))
//                .waitSeconds(1)
//                .strafeToLinearHeading(new Vector2d(-52, 35), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(-52, 27.5), Math.toRadians(-180))
//                .waitSeconds(0.75)
//                .strafeToLinearHeading(new Vector2d(-52, 8), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(30, 8), Math.toRadians(-140))
//                .waitSeconds(2)
//                .strafeToLinearHeading(new Vector2d(45, 30), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(47.5, 30), Math.toRadians(-180))
//                .waitSeconds(1)
//                .build());
//
//        RoadRunnerBotEntity mySecondBot = new DefaultBotBuilder(meepMeep)
//                // We set this bot to be red
//                .setColorScheme(new ColorSchemeBlueDark())
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .build();
//        mySecondBot.runAction(mySecondBot.getDrive().actionBuilder(new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .setTangent(Math.toRadians(-90))
//                .splineTo(new Vector2d(-39, 57), Math.toRadians(-90))
//                .waitSeconds(1)
//                .splineTo(new Vector2d(-52, 35), Math.toRadians(-180))
//                .splineTo(new Vector2d(-52, 27.5), Math.toRadians(-180))
//                .waitSeconds(0.75)
//                .splineTo(new Vector2d(-52, 8), Math.toRadians(-180))
//                .splineTo(new Vector2d(30, 8), Math.toRadians(-140))
//                .waitSeconds(2)
//                .splineTo(new Vector2d(45, 30), Math.toRadians(-180))
//                .splineTo(new Vector2d(47.5, 30), Math.toRadians(-180))
//                .waitSeconds(1)
//                .build());
//
//        RoadRunnerBotEntity RPlagerismRBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeBlueDark())
//                .build();
//
//        RPlagerismRBot.runAction(RPlagerismRBot.getDrive().actionBuilder(
//                  new Pose2d(-34, -63.5, Math.toRadians(90)))
//                .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(112))
////                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
//                .waitSeconds(0.5)
////                .stopAndAdd(mRobot.mIntake.Outtake())
//                .waitSeconds(1)
////                .stopAndAdd(mRobot.mIntake.Off())
////                .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
////                .stopAndAdd(mRobot.mLift.IntakePosition())
////                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
////                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .strafeToLinearHeading(new Vector2d(-36, -48), Math.toRadians(160))
//
////                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
////                .stopAndAdd(mRobot.mIntake.On())
////                .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
//                .waitSeconds(1)
////                .stopAndAdd(mRobot.mIntake.BringBackIntake())
////                .stopAndAdd(mRobot.mIntake.RetractIntake())
////                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
////                .stopAndAdd(mRobot.mIntake.RetractIntake())
////                .stopAndAdd(mRobot.mIntake.Transfer())
//                .waitSeconds(1.5)
////                .stopAndAdd(mRobot.mIntake.Off())
////                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
////                .stopAndAdd(mRobot.mIntake.Off())
//                .strafeToLinearHeading(new Vector2d(-36, -59), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(33, -59), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(38, -39), Math.toRadians(-180))
////                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
////                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
////                .stopAndAdd(mRobot.mLift.DeploySecondStage())
////                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .strafeToLinearHeading(new Vector2d(50.5, -28), Math.toRadians(180))
////                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
//                .waitSeconds(0.25)
////                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
//                .strafeToLinearHeading(new Vector2d(50.5, -36), Math.toRadians(180))
////                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .waitSeconds(0.5)
////                .stopAndAdd(mRobot.mLift.Score())
//                .waitSeconds(0.5)
////                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
//                .waitSeconds(0.5)
//                .strafeToLinearHeading(new Vector2d(43, -63), Math.toRadians(-180))
//                .build());











        //BACK AUTOS



        //RED



        RoadRunnerBotEntity RPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        RPlagerismCBot.runAction(RPlagerismCBot.getDrive().actionBuilder(
                        new Pose2d(-34, -63.5, Math.toRadians(90)))
                .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(77.5))
//                .stopAndAdd(() -> mRobot.mIntake.vfb.setPosition(0.09))
                .waitSeconds(0.50)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(0.6)
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(17.5))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                .turnTo(Math.toRadians(109))
                .lineToY(-11)
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
                .turnTo(Math.toRadians(-175))
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                .stopAndAdd(mRobot.mIntake.Off())
                .strafeToLinearHeading(new Vector2d(38, -4), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, -31), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                .strafeToLinearHeading(new Vector2d(43, -38), Math.toRadians(-180))
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.255))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(51.5, -38), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.4)
//                .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                .waitSeconds(0.2)
//                .stopAndAdd(() -> mRobot.mLift.initPosition())
                .waitSeconds(2)
                .build());




        RoadRunnerBotEntity RPlagerismLBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        RPlagerismLBot.runAction(RPlagerismLBot.getDrive().actionBuilder(
                        new Pose2d(-38, -63.5, Math.toRadians(90)))
                .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(110))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
//                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .turnTo(Math.toRadians(90))
                .lineToY(-11)
                .turnTo(Math.toRadians(-175))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(18))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.5, -28), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50.5, -32), Math.toRadians(180))
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .strafeToLinearHeading(new Vector2d(50.5, -36), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(() -> mRobot.mLift.initPosition())
                .waitSeconds(0.5)
                .build());




        RoadRunnerBotEntity RPlagerismRBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        RPlagerismRBot.runAction(RPlagerismRBot.getDrive().actionBuilder(
                        new Pose2d(-38, -63.5, Math.toRadians(90)))
                .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(60))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(10))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                .turnTo(Math.toRadians(95))
                .lineToY(-11.5)
                .turnTo(Math.toRadians(-176))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                .strafeToLinearHeading(new Vector2d(39, -8), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(39, -34), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, -Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.25, -45), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false)).waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50.25, -38.5), Math.toRadians(180))
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50, -28.5), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(() -> mRobot.mLift.initPosition())
                .waitSeconds(0.5)
                .build());








        //BLUE









        RoadRunnerBotEntity BPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        BPlagerismCBot.runAction(BPlagerismCBot.getDrive().actionBuilder(
                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-75))
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(0.6)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                .turnTo(Math.toRadians(-109))
                .lineToY(15)
//                .afterDisp(0.01, mRobot.mIntake.vfb5thpixle())
                .turnTo(Math.toRadians(175))
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(6))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                .stopAndAdd(mRobot.mIntake.Off())
                .strafeToLinearHeading(new Vector2d(38, 4), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, 31), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                .strafeToLinearHeading(new Vector2d(43, 33), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(50.5, 33), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.4)
//                .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                .waitSeconds(0.2)
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                            .splineTo(new Vector2d(25.5, 10), Math.toRadians(-180))
//                            .stopAndAdd(() -> new Thread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mRobot.mCamera.visionPortal.setActiveCamera(mRobot.mCamera.webcam1);
//                                }
//                            }).start())
////                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
//                            .afterDisp(20, mRobot.mIntake.ExtendIntake(21))
////                            .splineTo(new Vector2d(0, 8), Math.toRadians(-175))
////                            .afterDisp(25, mRobot.mIntake.On())
//                            .splineTo(new Vector2d(-36, 11.75), Math.toRadians(-180))
//                            .stopAndAdd(mRobot.WhiteLine())
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(-1))
//                            .waitSeconds(0.1)
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(0))
//                            .stopAndAdd(() -> mRobot.mIntake.vfb4thPixleDown())
//                            .stopAndAdd(mRobot.mIntake.On())
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
//                            .waitSeconds(0.5)
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(-1))
//                            .waitSeconds(0.1)
//                            .stopAndAdd(() -> mRobot.mIntake.vfb3rdPixleDown())
//                            .turnTo(Math.toRadians(175))
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
//                            .waitSeconds(0.5)
//                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                            .stopAndAdd(mRobot.mIntake.RetractIntake())
//                            .stopAndAdd(mRobot.mIntake.Off())
//                            .stopAndAdd(mRobot.mIntake.RetractIntake())
//                            .afterDisp(5, mRobot.mLift.setgrabber(true, true))
//                            .afterDisp(7, mRobot.mIntake.RetractIntake())
//                            .afterDisp(9, mRobot.mIntake.RetractIntake())
//                            .afterDisp(10, mRobot.mIntake.Transfer())
//                            .afterDisp(27.5, mRobot.mIntake.Off())
//                            .afterDisp(30, mRobot.mLift.setgrabber(false, false))
////                            .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
////                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
////                            .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
//                            .setReversed(true)
//                            .splineTo(new Vector2d(20, 7), Math.toRadians(0))
//                            .afterDisp(5, mRobot.mIntake.ExtendIntake(5))
//                            .afterDisp(10, mRobot.mLift.DeploySecondStage())
//                            .splineTo(new Vector2d(50.75, 30), Math.toRadians(0))
//                            .stopAndAdd(mRobot.mLift.Score())
//                            .waitSeconds(0.5)

                .build());

























        //************************************************************//

        //AUTOS

        //***********************************************************//



        RoadRunnerBotEntity BPlagerismLBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        BPlagerismLBot.runAction(BPlagerismLBot.getDrive().actionBuilder(
                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
                .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-60))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
//                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(11))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                .turnTo(Math.toRadians(-95))
                .lineToY(15)
                .turnTo(Math.toRadians(176))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(18))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                .strafeToLinearHeading(new Vector2d(39, 8), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(39, 34), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.5, 41), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50.5, 38.5), Math.toRadians(180))
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50, 28.5), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
                .build());



        RoadRunnerBotEntity BPlagerismRBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        BPlagerismRBot.runAction(BPlagerismRBot.getDrive().actionBuilder(
                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
                .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-112))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .turnTo(Math.toRadians(-90))
                .lineToY(15)
                .turnTo(Math.toRadians(175))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(19.5))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
                .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.5, 28), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.25)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .strafeToLinearHeading(new Vector2d(50.5, 36), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
                .build());


























        //FRONT AUTOS




        //RED



        RoadRunnerBotEntity FRPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        FRPlagerismCBot.runAction(FRPlagerismCBot.getDrive().actionBuilder(
                        new Pose2d(11, -63.5, Math.toRadians(90)))
                .setTangent(Math.toRadians(90))
//                .afterDisp(15, mRobot.mLift.Deploy())
                .splineToLinearHeading(new Pose2d(49, -34, Math.toRadians(180)), 0)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mLift.Retract())
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(48, -24), Math.toRadians(180))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(15))
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
                .strafeToLinearHeading(new Vector2d(48, -60), Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(58, -60), Math.toRadians(180))
                .build());




        RoadRunnerBotEntity FRPlagerismLBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        FRPlagerismLBot.runAction(FRPlagerismLBot.getDrive().actionBuilder(
                        new Pose2d(11, -63.5, Math.toRadians(90)))
                .setTangent(Math.toRadians(90))
//                .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                .strafeToLinearHeading(new Vector2d(11, -43), Math.toRadians(90))
                .turnTo(Math.toRadians(120))
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
                .turnTo(Math.toRadians(-175))
                .strafeToLinearHeading(new Vector2d(50.5, -28), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(() -> mRobot.mLift.initPosition())
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(43, -60), Math.toRadians(180))
                .build());



//
        RoadRunnerBotEntity FRPlagerismRBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        FRPlagerismRBot.runAction(FRPlagerismRBot.getDrive().actionBuilder(
                        new Pose2d(11, -63.5, Math.toRadians(90)))
                .setTangent(Math.toRadians(90))
//                .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                .strafeToLinearHeading(new Vector2d(24, -49), Math.toRadians(90))
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
                .turnTo(Math.toRadians(180))
//                .afterDisp(5, mRobot.mLift.Deploy())
                .strafeToLinearHeading(new Vector2d(50, -40), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mLift.Retract())
                .strafeToLinearHeading(new Vector2d(47, -60), Math.toRadians(180))
                .build());







        //BLUE









        RoadRunnerBotEntity FBPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        FBPlagerismCBot.runAction(FBPlagerismCBot.getDrive().actionBuilder(
                new Pose2d(11, 63.5, Math.toRadians(-90)))
                .setTangent(Math.toRadians(-90))
//                .afterDisp(15,() -> mRobot.mLift.setArmPosition(0.17))
                .splineToLinearHeading(new Pose2d(45, 31, Math.toRadians(-180)), 0)
                .strafeToLinearHeading(new Vector2d(51, 31), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mLift.Retract())
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(48, 25), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(14.5))
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mLift.IntakePosition())
                            .splineTo(new Vector2d(25.5, 10), Math.toRadians(-180))
//                            .stopAndAdd(() -> new Thread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mRobot.mCamera.visionPortal.setActiveCamera(mRobot.mCamera.webcam1);
//                                }
//                            }).start())
//                            .afterDisp(5, () -> mRobot.mIntake.vfb4thPixleDown())
//                            .afterDisp(20, mRobot.mIntake.ExtendIntake(21))
//                            .splineTo(new Vector2d(0, 8), Math.toRadians(-175))
//                            .afterDisp(25, mRobot.mIntake.On())
                            .splineTo(new Vector2d(-36, 11.75), Math.toRadians(-180))
//                            .stopAndAdd(mRobot.WhiteLine())
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(-1))
                            .waitSeconds(0.1)
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(0))
//                            .stopAndAdd(() -> mRobot.mIntake.vfb4thPixleDown())
//                            .stopAndAdd(mRobot.mIntake.On())
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                            .waitSeconds(0.5)
//                            .stopAndAdd(() -> mRobot.mIntake.setPower(-1))
//                            .waitSeconds(0.1)
//                            .stopAndAdd(() -> mRobot.mIntake.vfb3rdPixleDown())
                            .turnTo(Math.toRadians(185))
//                            .stopAndAdd(mRobot.mIntake.ExtendIntake(21))
                .strafeToLinearHeading(new Vector2d(44, 11.75), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(44, 31), Math.toRadians(180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
                .waitSeconds(0.25)
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())

                .strafeToLinearHeading(new Vector2d(50.5, 34), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.25)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .strafeToLinearHeading(new Vector2d(50.5, 31), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
                .build());



//
        RoadRunnerBotEntity FBPlagerismLBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        FBPlagerismLBot.runAction(FBPlagerismLBot.getDrive().actionBuilder(
                    new Pose2d(11, 63.5, Math.toRadians(-90)))
                .setTangent(Math.toRadians(-90))
//                .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                .strafeToLinearHeading(new Vector2d(26, 48), Math.toRadians(-90))
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .afterDisp(5, mRobot.mLift.DeploySecondStage())
                        .turnTo(Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(51, 38), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mLift.Retract())
                .strafeToLinearHeading(new Vector2d(48, 61), Math.toRadians(-180))

                .build());
//
//

        RoadRunnerBotEntity FBPlagerismRBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        FBPlagerismRBot.runAction(FBPlagerismRBot.getDrive().actionBuilder(
                        new Pose2d(11, 63.5, Math.toRadians(-90)))
                .setTangent(Math.toRadians(-90))
//                .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                .strafeToLinearHeading(new Vector2d(17, 50), Math.toRadians(-120))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(8))
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd( mRobot.mLift.DeploySecondStage())
                .turnTo(Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(51, 26), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mLift.Retract())
                .strafeToLinearHeading(new Vector2d(51, 60), Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(58, 60), Math.toRadians(180))
                .build());







        //ALTERNATE



        //RED




        RoadRunnerBotEntity ARPlagerismRBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        ARPlagerismRBot.runAction(ARPlagerismRBot.getDrive().actionBuilder(
                        new Pose2d(-38, -63.5, Math.toRadians(90)))
                .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(60))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(11))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                .strafeToLinearHeading(new Vector2d(-36, -48), Math.toRadians(160))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                .stopAndAdd(mRobot.mIntake.Off())
                .strafeToLinearHeading(new Vector2d(-36, -59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(33, -59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.5, -41), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50.5, -38.5), Math.toRadians(180))
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50, -35.5), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(0.5)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(43, -63), Math.toRadians(-180))
                .build());




        RoadRunnerBotEntity ARPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        ARPlagerismCBot.runAction(ARPlagerismCBot.getDrive().actionBuilder(
                        new Pose2d(-38, -63.5, Math.toRadians(90)))
//                        .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                        .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(77.5))
                        .waitSeconds(0.5)
//                        .stopAndAdd(mRobot.mIntake.Outtake())
                        .waitSeconds(0.6)
//                        .stopAndAdd(mRobot.mIntake.Off())
//                        .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
//                        .stopAndAdd(mRobot.mLift.IntakePosition())
//                        .stopAndAdd(mRobot.mIntake.RetractIntake())
//                        .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                        .strafeToLinearHeading(new Vector2d(-36, -48), Math.toRadians(160))
//                        .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                        .stopAndAdd(mRobot.mIntake.On())
//                        .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
                        .waitSeconds(1)
//                        .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                        .stopAndAdd(mRobot.mIntake.RetractIntake())
//                        .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                        .stopAndAdd(mRobot.mIntake.RetractIntake())
//                        .stopAndAdd(mRobot.mIntake.Transfer())
                        .waitSeconds(1.5)
//                        .stopAndAdd(mRobot.mIntake.Off())
//                        .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                        .stopAndAdd(mRobot.mIntake.Off())
                        .strafeToLinearHeading(new Vector2d(-36, -59), Math.toRadians(-180))
                        .strafeToLinearHeading(new Vector2d(33, -59), Math.toRadians(-180))
                        .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
//                        .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                        .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                        .stopAndAdd(mRobot.mLift.DeploySecondStage())
                        .strafeToLinearHeading(new Vector2d(43, -33), Math.toRadians(-180))
                        .waitSeconds(0.5)
                        .strafeToLinearHeading(new Vector2d(51.5, -36), Math.toRadians(-180))
//                        .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                        .waitSeconds(0.1)
//                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                        .waitSeconds(0.4)
//                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.26))
                        .waitSeconds(0.4)
//                        .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                        .waitSeconds(0.2)
//                        .stopAndAdd(mRobot.mLift.IntakePosition())
                        .waitSeconds(0.5)
                        .strafeToLinearHeading(new Vector2d(43, -63), Math.toRadians(-180))
                        .build());


        RoadRunnerBotEntity ARPlagerismLBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        ARPlagerismLBot.runAction(ARPlagerismLBot.getDrive().actionBuilder(
                        new Pose2d(-38, -63.5, Math.toRadians(90)))
                .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(112))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(-36, -48), Math.toRadians(160))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                .stopAndAdd(mRobot.mIntake.Off())
                .strafeToLinearHeading(new Vector2d(-36, -59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(33, -59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.5, -28), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50.5, -32), Math.toRadians(180))
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .strafeToLinearHeading(new Vector2d(50.5, -36), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(0.5)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(43, -63), Math.toRadians(-180))
                .build());









        //BLUE




        RoadRunnerBotEntity ABPlagerismRBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        ABPlagerismRBot.runAction(ABPlagerismRBot.getDrive().actionBuilder(
                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
                .strafeToLinearHeading(new Vector2d(-38, 57), Math.toRadians(-112))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(9.5))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(-36, 48), Math.toRadians(-170))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                .stopAndAdd(mRobot.mIntake.Off())
                .strafeToLinearHeading(new Vector2d(-36, 59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(33, 59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, 39), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.5, 28), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
//                .waitSeconds(0.25)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .strafeToLinearHeading(new Vector2d(50.5, 36), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(0.5)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(43, 63), Math.toRadians(-180))
                .build());


        RoadRunnerBotEntity ABPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        ABPlagerismCBot.runAction(ABPlagerismCBot.getDrive().actionBuilder(
                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-77.5))
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(0.6)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                .strafeToLinearHeading(new Vector2d(-36, 48), Math.toRadians(-170))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
//                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                .stopAndAdd(mRobot.mIntake.Off())
                .strafeToLinearHeading(new Vector2d(-36, 59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(33, 59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, 39), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .strafeToLinearHeading(new Vector2d(43, 33), Math.toRadians(-180))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(50.5, 33), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.1)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.4)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.26))
//                .waitSeconds(0.4)
//                .stopAndAdd(mRobot.mLift.setgrabber(true, true))
                .waitSeconds(0.2)
//                .stopAndAdd(mRobot.mLift.IntakePosition())
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(43, 63), Math.toRadians(-180))
                .build());



        RoadRunnerBotEntity ABPlagerismLBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        ABPlagerismLBot.runAction(ABPlagerismLBot.getDrive().actionBuilder(
                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
                .strafeToLinearHeading(new Vector2d(-37, 57), Math.toRadians(-60))
//                .stopAndAdd(mRobot.mIntake.Depl0yIntake())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(11))
//                .stopAndAdd(mRobot.mLift.IntakePosition())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(() -> mRobot.mIntake.vfbUp())
                .strafeToLinearHeading(new Vector2d(-36, 48), Math.toRadians(-170))
//                .stopAndAdd(mRobot.mIntake.vfb5thpixle())
//                .stopAndAdd(mRobot.mIntake.On())
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(22))
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, true))
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.Transfer())
                .waitSeconds(1.5)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                .stopAndAdd(mRobot.mIntake.Off())
                .strafeToLinearHeading(new Vector2d(-36, 59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(33, 59), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, 39), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
//                .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
                .strafeToLinearHeading(new Vector2d(50.5, 41), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.setgrabber(true, false))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50.5, 38.5), Math.toRadians(180))
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.25)
                .strafeToLinearHeading(new Vector2d(50, 35.5), Math.toRadians(180))
//                .stopAndAdd(mRobot.mLift.DeploySecondStage())
                .waitSeconds(0.5)
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(0.5)
//                .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
                .waitSeconds(0.5)
                .strafeToLinearHeading(new Vector2d(43, 63), Math.toRadians(-180))
                .build());




        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
//                .addEntity(myBot)
//                .addEntity(mySecondBot)

                //FAR AUTO

                //RED
//                .addEntity(RPlagerismRBot)
//                .addEntity(RPlagerismLBot)
//                .addEntity(RPlagerismCBot)

                //BLUE

//                .addEntity(BPlagerismRBot)
//                .addEntity(BPlageris9mLBot)
//                .addEntity(BPlagerismCBot)

                //FRONT AUTOS

                //RED
//                .addEntity(FRPlagerismRBot)
//                .addEntity(FRPlagerismLBot)
//                .addEntity(FRPlagerismCBot)


                //BLUE
//                .addEntity(FBPlagerismRBot)
//                .addEntity(FBPlagerismLBot)
                .addEntity(FBPlagerismCBot)


                //ALTERNATE AUTOS

                //RED
//                .addEntity(ARPlagerismRBot)
//                .addEntity(ARPlagerismLBot)
//                .addEntity(ARPlagerismCBot)
//
//
//                //BLUE
//                .addEntity(ABPlagerismRBot)
//                .addEntity(ABPlagerismLBot)
//                .addEntity(ABPlagerismCBot)
//                .addEntity(TESTRED)
                .start();

    }
}


// Ivan will beat Elijah in arm wresleing in 3 years this is offical**************************************************************************