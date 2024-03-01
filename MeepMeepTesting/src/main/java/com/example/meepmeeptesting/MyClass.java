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
        RoadRunnerBotEntity RPlagerismRBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeBlueDark())
                .build();

        RPlagerismRBot.runAction(RPlagerismRBot.getDrive().actionBuilder(
                  new Pose2d(11, 63.5, Math.toRadians(-90)))
                .setTangent(Math.toRadians(-90))
//                .afterDisp(5, mRobot.mIntake.Depl0yIntake())
                .strafeToLinearHeading(new Vector2d(17, 50), Math.toRadians(-120))
//                .stopAndAdd(mRobot.mIntake.Outtake())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mIntake.Off())
//                .stopAndAdd(mRobot.mIntake.RetractIntake())
//                .stopAndAdd(mRobot.mIntake.BringBackIntake())
//                .stopAndAdd( mRobot.mLift.Deploy())
                .turnTo(Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(51, 31), Math.toRadians(-180))
//                .stopAndAdd(mRobot.mLift.Score())
                .waitSeconds(1)
//                .stopAndAdd(mRobot.mLift.Retract())
                .strafeToLinearHeading(new Vector2d(51, 60), Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(58, 60), Math.toRadians(180))
                .build());
//
//        RoadRunnerBotEntity RPlagerismLBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeRedDark())
//                .build();
//
//        RPlagerismLBot.runAction(RPlagerismLBot.getDrive().actionBuilder(
//                        new Pose2d(-38, -63.5, Math.toRadians(90)))
//                .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(60))
////                            .stopAndAdd(mRobot.mIntake.Depl0yIntake())
//                            .waitSeconds(0.5)
////                            .stopAndAdd(mRobot.mIntake.Outtake())
//                            .waitSeconds(1)
////                            .stopAndAdd(mRobot.mIntake.Off())
////                            .stopAndAdd(mRobot.mIntake.ExtendIntake(11))
////                            .stopAndAdd(mRobot.mLift.IntakePosition())
////                            .stopAndAdd(mRobot.mIntake.RetractIntake())
////                            .stopAndAdd(() -> mRobot.mIntake.vfbUp())
//                            .turnTo(Math.toRadians(95))
//                            .lineToY(-11)
//                            .turnTo(Math.toRadians(-176))
////                            .stopAndAdd(mRobot.mIntake.vfb5thpixle())
////                            .stopAndAdd(mRobot.mIntake.On())
//                            .waitSeconds(0.25)
////                            .stopAndAdd(mRobot.mIntake.ExtendIntake(18))
////                            .waitSeconds(1)
////                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
////                            .stopAndAdd(mRobot.mIntake.RetractIntake())
////                            .stopAndAdd(mRobot.mIntake.Off())
////                            .stopAndAdd(mRobot.mIntake.BringBackIntake())
////                            .stopAndAdd(mRobot.mIntake.RetractIntake())
////                            .stopAndAdd(mRobot.mLift.setgrabber(true, true))
////                            .stopAndAdd(mRobot.mIntake.RetractIntake())
////                            .stopAndAdd(mRobot.mIntake.Transfer())
//                            .waitSeconds(1.5)
////                            .stopAndAdd(mRobot.mIntake.Off())
////                            .stopAndAdd(mRobot.mLift.setgrabber(false, false))
//                            .strafeToLinearHeading(new Vector2d(39, -8), Math.toRadians(-180))
////                            .stopAndAdd(mRobot.mIntake.RetractIntake())
//                            .strafeToLinearHeading(new Vector2d(39, -34), Math.toRadians(-180))
////                            .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
////                            .stopAndAdd(mRobot.mIntake.ExtendIntake(3))
//                            .waitSeconds(0.25)
////                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
////                            .stopAndAdd(mRobot.mIntake.RetractIntake())
//                            .strafeToLinearHeading(new Vector2d(50.5, -41), Math.toRadians(180))
////                            .stopAndAdd(mRobot.mLift.setgrabber(true, false))
//                            .waitSeconds(0.25)
//                            .strafeToLinearHeading(new Vector2d(50.5, -38.5), Math.toRadians(180))
////                            .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
//                            .waitSeconds(0.25)
//                            .strafeToLinearHeading(new Vector2d(50, -28.5), Math.toRadians(180))
////                            .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                            .waitSeconds(0.5)
////                            .stopAndAdd(mRobot.mLift.Score())
//                            .waitSeconds(1)
//                            .build());
////
//        RoadRunnerBotEntity RPlagerismCBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeRedDark())
//                .build();
//
//        RPlagerismCBot.runAction(RPlagerismCBot.getDrive().actionBuilder(
//                        new Pose2d(-38, -63.5, Math.toRadians(90)))
//                .setTangent(Math.toRadians(-90))
//                .strafeToLinearHeading(new Vector2d(-39, -57), Math.toRadians(75))
//                .waitSeconds(1)
//                .splineTo(new Vector2d(-38, -9), Math.toRadians(-90))
//                .waitSeconds(0.75)
//                .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(180))
//                .strafeToLinearHeading(new Vector2d(47.5, -34), Math.toRadians(180))
//                .waitSeconds(1)
//                .build());
//

//
//
//
//        RoadRunnerBotEntity BPlagerismRBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeBlueDark())
//                .build();
//
//        BPlagerismRBot.runAction(BPlagerismRBot.getDrive().actionBuilder(
//                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .strafeToLinearHeading(new Vector2d(-39, 57), Math.toRadians(-105))
//                .waitSeconds(1)
//                .turnTo(Math.toRadians(-90))
//                .strafeToLinearHeading(new Vector2d(-38, 13), Math.toRadians(-90))
//                .turnTo(Math.toRadians(-180))
//                .waitSeconds(0.75)
//                .strafeToLinearHeading(new Vector2d(38, 13), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(47.5, 39), Math.toRadians(-180))
//                .waitSeconds(1)
//                .build());

//        RoadRunnerBotEntity BPlagerismLBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeRedDark())
//                .build();
//
//        BPlagerismLBot.runAction(BPlagerismLBot.getDrive().actionBuilder(
//                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .strafeToLinearHeading(new Vector2d(-39, 57), Math.toRadians(-60))
//                .waitSeconds(1)
//                .turnTo(Math.toRadians(-90))
//                .splineTo(new Vector2d(-34, 20), Math.toRadians(-90))
//                .splineTo(new Vector2d(-38, 9), Math.toRadians(-120))
//                .turnTo(Math.toRadians(-180))
//                .waitSeconds(0.75)
//                .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(180))
//                .strafeToLinearHeading(new Vector2d(47.5, 30), Math.toRadians(180))
//                .waitSeconds(1)
//                .build());
//
//        RoadRunnerBotEntity BPlagerismCBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeRedLight())
//                .build();
//
//        BPlagerismCBot.runAction(BPlagerismCBot.getDrive().actionBuilder(
//                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .setTangent(Math.toRadians(-90))
//                .strafeToLinearHeading(new Vector2d(-39, 57), Math.toRadians(-77.5))
//                .turnTo(Math.toRadians(-100))
//                .waitSeconds(1)
//                .lineToY(15)
//                .turnTo(Math.toRadians(-180))
//                .waitSeconds(0.75)
//                .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(47.5, 34), Math.toRadians(-180))
//                .waitSeconds(1)
//                .build());
//
//        RoadRunnerBotEntity TESTRED = new DefaultBotBuilder(meepMeep)
//                 //Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeRedLight())
//                .build();
//
//        TESTRED.runAction(TESTRED.getDrive().actionBuilder(
//                        new Pose2d(-38, -63.5, Math.toRadians(90)))
//                        .strafeToLinearHeading(new Vector2d(-37, -57), Math.toRadians(77.5))
////                        .stopAndAdd(mRobot.mIntake.Outtake())
//                        .waitSeconds(0.6)
////                        .stopAndAdd(mRobot.mIntake.Off())
////                        .stopAndAdd(mRobot.mIntake.ExtendIntake(17))
////                        .stopAndAdd(mRobot.mLift.IntakePosition())
////                        .stopAndAdd(mRobot.mIntake.RetractIntake())
////                        .stopAndAdd(() -> mRobot.mIntake.vfbUp())
//                        .turnTo(Math.toRadians(109))
//                        .lineToY(-15)
////                        .afterDisp(0.01, mRobot.mIntake.vfb5thpixle())
//                        .turnTo(Math.toRadians(-175))
////                        .stopAndAdd(mRobot.mIntake.On())
////                        .stopAndAdd(mRobot.mIntake.ExtendIntake(6))
////                        .waitSeconds(1)
////                        .stopAndAdd(mRobot.mIntake.BringBackIntake())
////                        .stopAndAdd(mRobot.mIntake.RetractIntake())
////                        .stopAndAdd(mRobot.mLift.setgrabber(true, true))
////                        .stopAndAdd(mRobot.mIntake.RetractIntake())
////                        .stopAndAdd(mRobot.mIntake.Transfer())
////                        .waitSeconds(1.5)
////                        .stopAndAdd(mRobot.mIntake.Off())
////                        .stopAndAdd(mRobot.mLift.setgrabber(false, false))
////                        .stopAndAdd(mRobot.mIntake.Off())
//                        .strafeToLinearHeading(new Vector2d(38, -4), Math.toRadians(-180))
//                        .strafeToLinearHeading(new Vector2d(38, -31), Math.toRadians(-180))
////                        .stopAndAdd(mRobot.mCamera.resetPose(mRobot, Math.PI / 2))
////                        .stopAndAdd(mRobot.mIntake.ExtendIntake(5))
//                        .strafeToLinearHeading(new Vector2d(43, -33), Math.toRadians(-180))
////                        .stopAndAdd(mRobot.mLift.DeploySecondStage())
//                        .waitSeconds(0.5)
//                        .strafeToLinearHeading(new Vector2d(50.5, -33), Math.toRadians(-180))
////                        .stopAndAdd(mRobot.mLift.setgrabber(true, false))
//                        .waitSeconds(0.1)
////                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.35))
//                        .waitSeconds(0.4)
////                        .stopAndAdd(() -> mRobot.mLift.setArmPosition(0.26))
////                        .waitSeconds(0.4)
////                        .stopAndAdd(mRobot.mLift.setgrabber(true, true))
////                        .waitSeconds(0.2)
////                        .stopAndAdd(mRobot.mLift.IntakePosition())
//        .build());
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
//                .addEntity(myBot)
//                .addEntity(mySecondBot)
                .addEntity(RPlagerismRBot)
//                .addEntity(RPlagerismLBot)
//                .addEntity(RPlagerismCBot)
//                .addEntity(BPlagerismRBot)
//                .addEntity(BPlagerismLBot)
//                .addEntity(BPlagerismCBot)
//                .addEntity(TESTRED)
                .start();

    }
}


// Ivan will beat Elijah in arm wresleing in 3 years this is offical**************************************************************************