package com.team9889.ftc2023.opmode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.team9889.ftc2023.subsystems.Robot;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

  Robot mRobot=new Robot();

  boolean intakeOn=false;
  boolean intakeToggle=true;

    @Override
    public void runOpMode() throws InterruptedException {
        mRobot.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()) {

            // Drive Code
            mRobot.mDrive.setPower(-gamepad1.left_stick_x, gamepad1.left_stick_y, -gamepad1.right_stick_x * 0.85);

            // Toggle Intake On
            if (gamepad1.a && intakeToggle){
                mRobot.mIntake.on();
                intakeOn=! intakeOn;
                intakeToggle=false;
            } else if (! gamepad1.a){
                intakeToggle=true;
            }

            if (intakeOn) mRobot.mIntake.on();
            else mRobot.mIntake.off();

            if (gamepad1.b) {
                mRobot.mIntake.out();
                intakeOn = false;
            }

            // Hopper Code
            if(gamepad1.right_trigger > 0.1){
                mRobot.mHopper.intake_position();}
            else if(gamepad1.left_trigger > 0.1){
                mRobot.mHopper.score_position();}

            // Hanger Code
            if (gamepad2.a){
                mRobot.mHanger.down();
            } else if (gamepad2.b){
                mRobot.mHanger.up();
            } else{
                mRobot.mHanger.off();
            }
        }
    }
}

