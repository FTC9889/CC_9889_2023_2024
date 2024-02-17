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
//                  new Pose2d(-38, -63.5, Math.toRadians(90)))
//                  .setTangent(Math.toRadians(-90))
//                  .strafeToLinearHeading(new Vector2d(-39, -57), Math.toRadians(55))
//                  .waitSeconds(1)
//                        .turnTo(Math.toRadians(90))
//                  .strafeToLinearHeading(new Vector2d(-38, -9), Math.toRadians(90))
//                        .turnTo(Math.toRadians(-180))
//                  .waitSeconds(0.75)
//                  .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
//                  .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(180))
//                  .strafeToLinearHeading(new Vector2d(47.5, -37), Math.toRadians(180))
//                  .waitSeconds(1)
//                  .build());

//        RoadRunnerBotEntity RPlagerismLBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeRedDark())
//                .build();
//
//        RPlagerismLBot.runAction(RPlagerismLBot.getDrive().actionBuilder(
//                        new Pose2d(-38, -63.5, Math.toRadians(90)))
//                .setTangent(Math.toRadians(-90))
//                .strafeToLinearHeading(new Vector2d(-39, -57), Math.toRadians(115))
//                .waitSeconds(1)
//                .turnTo(Math.toRadians(90))
//                .splineTo(new Vector2d(-34, -20), Math.toRadians(90))
//                .splineTo(new Vector2d(-38, -9), Math.toRadians(120))
//                .turnTo(Math.toRadians(-180))
//                .waitSeconds(0.75)
//                .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(180))
//                .strafeToLinearHeading(new Vector2d(47.5, -30), Math.toRadians(180))
//                .waitSeconds(1)
//                .build());

        RoadRunnerBotEntity RPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedDark())
                .build();

        RPlagerismCBot.runAction(RPlagerismCBot.getDrive().actionBuilder(
                        new Pose2d(-38, -63.5, Math.toRadians(90)))
                .setTangent(Math.toRadians(-90))
                .strafeToLinearHeading(new Vector2d(-39, -57), Math.toRadians(75))
                .waitSeconds(1)
                .splineTo(new Vector2d(-38, -9), Math.toRadians(-90))
                .waitSeconds(0.75)
                .strafeToLinearHeading(new Vector2d(38, -8), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, -34), Math.toRadians(180))
                .strafeToLinearHeading(new Vector2d(47.5, -34), Math.toRadians(180))
                .waitSeconds(1)
                .build());
//
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
//                .strafeToLinearHeading(new Vector2d(-38, 9), Math.toRadians(-90))
//                .turnTo(Math.toRadians(-180))
//                .waitSeconds(0.75)
//                .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(-180))
//                .strafeToLinearHeading(new Vector2d(47.5, 39), Math.toRadians(-180))
//                .waitSeconds(1)
//                .build());
//
//        RoadRunnerBotEntity BPlagerismLBot = new DefaultBotBuilder(meepMeep)
//                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
//                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
//                .setColorScheme(new ColorSchemeRedDark())
//                .build();
//
//        BPlagerismLBot.runAction(BPlagerismLBot.getDrive().actionBuilder(
//                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
//                .strafeToLinearHeading(new Vector2d(-39, 57), Math.toRadians(-115))
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
        RoadRunnerBotEntity BPlagerismCBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 12.688)
                .setColorScheme(new ColorSchemeRedLight())
                .build();

        BPlagerismCBot.runAction(BPlagerismCBot.getDrive().actionBuilder(
                        new Pose2d(-38, 63.5, Math.toRadians(-90)))
                .setTangent(Math.toRadians(-90))
                .strafeToLinearHeading(new Vector2d(-39, 57), Math.toRadians(-77.5))
                .waitSeconds(1)
                .splineTo(new Vector2d(-38, 9), Math.toRadians(-90))
                .waitSeconds(0.75)
                .strafeToLinearHeading(new Vector2d(38, 8), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(38, 34), Math.toRadians(-180))
                .strafeToLinearHeading(new Vector2d(47.5, 34), Math.toRadians(-180))
                .waitSeconds(1)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
//                .addEntity(myBot)
//                .addEntity(mySecondBot)
//                .addEntity(RPlagerismRBot)
//                .addEntity(RPlagerismLBot)
                .addEntity(RPlagerismCBot)
//                .addEntity(BPlagerismRBot)
//                .addEntity(BPlagerismLBot)
                .addEntity(BPlagerismCBot)
                .start();

    }
}


// Ivan will beat Elijah in arm wresleing in 3 years this is offical**************************************************************************