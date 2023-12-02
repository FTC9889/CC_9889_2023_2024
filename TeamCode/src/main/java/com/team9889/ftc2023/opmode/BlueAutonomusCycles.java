package com.team9889.ftc2023.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;

@Autonomous
public class BlueAutonomusCycles extends LinearOpMode {// STOPSHIP: 10/28/2023 }
    Robot mRobot = new Robot();

    public void runOpMode() throws InterruptedException {

        mRobot.init(hardwareMap);


        waitForStart();
        long tile = (2500 / 3);

        mRobot.mDrive.setPower(0, 0.5, 0);

        mRobot.mIntake.on();

        sleep((long) (tile * 2));
        mRobot.mIntake.off();
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(0.5, 0, 0);
        sleep(tile * 2);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(0, 0.1, 0);
        sleep(500);
        mRobot.mDrive.setPower(0, -0.1, 0);
        sleep(150);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep(tile * 2);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(-0.5, -0.5, -0.5, -0.5);
        sleep(5 * tile);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(0, 0, 0.5);
        sleep(230);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mIntake.on();
        mRobot.mDrive.setPower(0.5, 0.5, 0.5, 0.5);
        sleep((long) (tile * 1.5));
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mIntake.off();
        mRobot.mDrive.setPower(0, 0, -0.5);
        sleep(230);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(0.5, 0.5, 0.5, 0.5);
        sleep(tile * 5);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep((long) (3.5 * tile));
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep(tile * 2);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(-0.5, -0.5, -0.5, -0.5);
        sleep(5 * tile);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(0, 0, 0.5);
        sleep(230);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mIntake.on();
        mRobot.mDrive.setPower(0.5, 0.5, 0.5, 0.5);
        sleep((long) (tile * 1.5));
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mIntake.off();
        mRobot.mDrive.setPower(0, 0, -0.5);
        sleep(230);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(0.5, 0.5, 0.5, 0.5);
        sleep(tile * 5);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep((long) (3.5 * tile));
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep(tile * 2);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(-0.5, -0.5, -0.5, -0.5);
        sleep(5 * tile);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(0, 0, 0.5);
        sleep(230);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mIntake.on();
        mRobot.mDrive.setPower(0.5, 0.5, 0.5, 0.5);
        sleep((long) (tile * 1.5));
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mIntake.off();
        mRobot.mDrive.setPower(0, 0, -0.5);
        sleep(230);
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mDrive.setPower(0.5, 0.5, 0.5, 0.5);
        sleep(tile * 5);
        mRobot.mDrive.setPower(0, 0, 0, 0);
        mRobot.mDrive.setPower(-0.5, 0, 0);
        sleep((long) (3.5 * tile));
        mRobot.mDrive.setPower(0, 0, 0);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);
        mRobot.mLift.score_position();
        sleep(2500);
        mRobot.mLift.intake_position();
        sleep(1000);



















    }
}