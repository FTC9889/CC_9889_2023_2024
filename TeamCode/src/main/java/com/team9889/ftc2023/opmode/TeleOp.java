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
        while(opModeIsActive()){
            mRobot.mDrive.setPower(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
           // if (gamepad1.a && intakeToggle){
//                mRobot.mIntake.on();
//                intakeOn=! intakeOn;
//                intakeToggle=false;}
//            else if (! gamepad1.a){
//                intakeToggle=true;}
//            if (intakeOn) mRobot.mIntake.on();
//            else mRobot.mIntake.off();
            //if (gamepad1.b)
           // {mRobot.mIntake.out();}
            if(gamepad1.right_trigger > 0.1){
                mRobot.mHopper.intake_position();}
            else if(gamepad1.left_trigger > 0.1){
                mRobot.mHopper.score_position();}
//           // if (gamepad1.right_bumper){
//              //  mRobot.mHanger.up();}
//            else if(gamepad1.left_bumper){
//                mRobot.mHanger.down();}
//            else{
//                mRobot.mHanger.off();}
//            if(gamepad1.right_trigger > 0.1){
//                else if
 }}}

