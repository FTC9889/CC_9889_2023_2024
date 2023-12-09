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
//            if (gamepad1.a && intakeToggle){
//                mRobot.mIntake.on();
//                intakeOn=! intakeOn;
//                intakeToggle=false;
//            } else if (! gamepad1.a){
//                intakeToggle=true;
//            }
//
//            if (intakeOn) mRobot.mIntake.on();
//            else mRobot.mIntake.off();

            if (gamepad1.left_bumper) mRobot.mLift.set_Grabber_Open(true, true);
            else if (gamepad2.dpad_left)  mRobot.mLift.set_Grabber_Open(true,false);
            else if (gamepad2.dpad_right) mRobot.mLift.set_Grabber_Open(false,true);


            if (gamepad2.right_trigger > 0.1)  mRobot.mIntake.startIntake();
            else if (gamepad2.left_trigger > 0.1) mRobot.mIntake.stopIntake();
            else if (gamepad2.dpad_up) mRobot.mIntake.out();

            mRobot.mIntake.setPower(-gamepad2.right_stick_y);

            if (gamepad2.right_bumper) mRobot.mLift.score_position();
            else if (gamepad2.left_bumper) mRobot.mLift.intake_position();
            else if (gamepad2.y){
                mRobot.mIntake.transfer();
                mRobot.mLift.set_Grabber_Open(true,true);
            } else if (gamepad2.b) {
                mRobot.mIntake.slowOn(); mRobot.mLift.set_Grabber_Open(false, false);
            }

            mRobot.mLift.setPower(-gamepad2.left_stick_y);

            sleep(10);

            telemetry.addData("", mRobot.mIntake.intake.getCurrentPosition());
            telemetry.addData("-", mRobot.mIntake.digitalTouch.getState());
            telemetry.update();


        }
    }
}

