package com.team9889.ftc2023.opmode;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.INTAKE;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.OUTTAKE;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.RETRACTED;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.SLIGHT_EXTEND;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.TRANSFER_FIRST_POSITION;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.TRANSFER_SECOND_POSITION;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.subsystems.Robot;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

  Robot mRobot=new Robot();

  enum IntakeState {
      INTAKE,
      OUTTAKE,
      RETRACTED,
      NULL,
      SLIGHT_EXTEND,
      TRANSFER_FIRST_POSITION,
      TRANSFER_SECOND_POSITION;

      public String toString() {
          switch (this) {
              case INTAKE:
                  return "INTAKE";
              case OUTTAKE:
                  return "OUTTAKE";
              case RETRACTED:
                  return "RETRACTED";
              case SLIGHT_EXTEND:
                  return "SLIGHT EXTEND";
              case TRANSFER_FIRST_POSITION:
                  return "TRANSFER FIRST POSITION";
              case TRANSFER_SECOND_POSITION:
                  return "TRANSFER SECOND POSITION";
              case NULL:
              default:
                  return "NULL";
          }
      }
  }

  enum LiftState {
      NULL,
      INTAKE_POSITION,
      FIRST_POSITION,
      SECOND_POSITION,
      EXTENDED_POSITION,
      AUTO;

      public String toString() {
          switch (this) {
              case INTAKE_POSITION:
                  return "Intake Position";
              case FIRST_POSITION:
                  return "First Position";
              case SECOND_POSITION:
                  return "Second Position";
              case EXTENDED_POSITION:
                  return "Extended Position";
              case AUTO:
                  return "Auto Position";
              case NULL:
              default:
                  return "NULL";
          }
      }
  }

  enum HangerState {
      RETRACTED,
      DEPLOYED;

      public String toString() {
          switch (this) {
              case RETRACTED:
                  return "Retracted";
              case DEPLOYED:
              default:
                  return "Deployed";
          }
      }
  }
    @Override
    public void runOpMode() throws InterruptedException {
        mRobot.init(hardwareMap);
        waitForStart();

        mRobot.mDrone.do_nothing();

        IntakeState requestedIntakeState = IntakeState.NULL;
        IntakeState currentIntakeState = IntakeState.RETRACTED;

        ElapsedTime extendIntakeTimer = new ElapsedTime();

        ElapsedTime retractIntakeUpTimer = new ElapsedTime();

        ElapsedTime firstPositionTimer = new ElapsedTime();

        ElapsedTime armTimer = new ElapsedTime();

        ElapsedTime transferTimer = new ElapsedTime();

        LiftState requestedLiftState = LiftState.NULL;
        LiftState currentLiftState = LiftState.AUTO;

        boolean allowDriverInputIntakeExtend = true;
        boolean allowDriverInputLiftExtend = true;

        while(opModeIsActive()) {

            // Drive Code
            mRobot.mDrive.setPower(-gamepad1.left_stick_x, gamepad1.left_stick_y, -gamepad1.right_stick_x * 0.85);

            if(gamepad1.left_stick_y > 0.5 && currentIntakeState == RETRACTED && mRobot.mIntake.extend.getCurrentPosition() > 10) {
                currentIntakeState = SLIGHT_EXTEND;
            }

            if (gamepad1.a) {
                if(currentIntakeState == INTAKE) {
                    currentIntakeState = RETRACTED;
                }

                requestedIntakeState = IntakeState.INTAKE;
            }

            if (gamepad1.b) {
                requestedIntakeState = RETRACTED;
            }

            if (gamepad1.y) {
                requestedIntakeState = OUTTAKE;
            }

            if (currentLiftState == LiftState.FIRST_POSITION || currentLiftState == LiftState.SECOND_POSITION || currentLiftState == LiftState.EXTENDED_POSITION) {
                mRobot.mLift.set_Grabber_Open(gamepad1.right_bumper, gamepad1.left_bumper);
            }

            if (gamepad2.x) {
                requestedIntakeState = TRANSFER_SECOND_POSITION;
            }

            if (gamepad2.a) {
                mRobot.mIntake.on();
            } else if (gamepad2.b) {
                mRobot.mIntake.off();
            } else if (gamepad2.y) {
                mRobot.mIntake.out();
            }

            if (gamepad2.right_stick_button && gamepad2.left_stick_button) {
                mRobot.mDrone.shoot();
            }

            if (gamepad2.right_bumper) {
                requestedLiftState = LiftState.FIRST_POSITION;
            } else if (gamepad2.left_bumper) {
                requestedLiftState = LiftState.INTAKE_POSITION;
            }

            if (requestedIntakeState != currentIntakeState) {
                switch (requestedIntakeState) {
                    case INTAKE:
                        switch (currentIntakeState) {
                            case OUTTAKE:
                                mRobot.mIntake.on();
                                currentIntakeState = IntakeState.INTAKE;
                                break;
                            case TRANSFER_FIRST_POSITION:
                            case TRANSFER_SECOND_POSITION:
                            case SLIGHT_EXTEND:
                            case NULL:
                            case RETRACTED:
                                mRobot.mIntake.startIntake();
                                allowDriverInputIntakeExtend = true;
                                currentIntakeState = IntakeState.INTAKE;
                                break;
                            default:
                                break;
                        }
                        break;
                    case OUTTAKE:
                        switch (currentIntakeState) {
                            case INTAKE:
                                mRobot.mIntake.out();
                                currentIntakeState = IntakeState.OUTTAKE;
                                break;
                            case RETRACTED:
                                if (!mRobot.mIntake.digitalTouch.getState()) {
                                    mRobot.mIntake.setPower(1);
                                    allowDriverInputIntakeExtend = false;
                                } else {
                                    mRobot.mIntake.vfbDown();
                                    mRobot.mIntake.out();
                                    allowDriverInputIntakeExtend = true;
                                    currentIntakeState = IntakeState.OUTTAKE;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case RETRACTED:
                        if (currentLiftState != LiftState.INTAKE_POSITION) {
                            mRobot.mIntake.stopIntake();
                            mRobot.mLift.set_Grabber_Open(false, false);
                            requestedLiftState = LiftState.INTAKE_POSITION;
                            allowDriverInputIntakeExtend = false;
                        } else {
                            mRobot.mIntake.stopIntake();
                            allowDriverInputIntakeExtend = false;
                            if (retractIntakeUpTimer.milliseconds() > 600) {
                                retractIntakeUpTimer.reset();
                                telemetry.addData("Line Number", "249");
                            }

                            if (retractIntakeUpTimer.milliseconds() < 400) {
                                mRobot.mLift.set_Grabber_Open(false, false);
                                mRobot.mIntake.setPower(-1);
                            } else if (retractIntakeUpTimer.milliseconds() > 1500 || !mRobot.mIntake.digitalTouch.getState()) {
                                mRobot.mIntake.setPower(0);

                                mRobot.mIntake.brake_on();
                                currentIntakeState = IntakeState.RETRACTED;
                                mRobot.mLift.set_Grabber_Open(true, true);


                                allowDriverInputIntakeExtend = true;
                                retractIntakeUpTimer.reset();
                            }
                        }
                        break;
                    case SLIGHT_EXTEND:
                        switch (currentIntakeState) {
                            case TRANSFER_FIRST_POSITION:
                            case TRANSFER_SECOND_POSITION:
                            case NULL:
                            case RETRACTED:
                                if (extendIntakeTimer.milliseconds() > 500) {
                                    extendIntakeTimer.reset();
                                }


                                if (!mRobot.mIntake.digitalTouch.getState() || mRobot.mIntake.extend.getCurrentPosition() < 70) {
                                    mRobot.mIntake.setPower(1);
                                    allowDriverInputIntakeExtend = false;

                                } else {
                                    mRobot.mIntake.vfbUp();
                                    mRobot.mIntake.off();
                                    mRobot.mIntake.closeGate();
                                    mRobot.mIntake.setPower(0);
                                    allowDriverInputIntakeExtend = true;
                                    currentIntakeState = SLIGHT_EXTEND;
                                }
                                break;
                            case OUTTAKE:
                            case INTAKE:
                                break;
                        }
                        break;
                    case TRANSFER_FIRST_POSITION:
                        if (currentIntakeState != RETRACTED) {
                            requestedIntakeState = RETRACTED;
                        } else {
                            mRobot.mLift.set_Grabber_Open(true, true);
                            mRobot.mIntake.transfer();
                            if (transferTimer.milliseconds() > 1000) {
                                transferTimer.reset();
                            } else if (transferTimer.milliseconds() > 800) {
                                mRobot.mLift.set_Grabber_Open(false, false);
                                mRobot.mIntake.transfer2();
                                currentIntakeState = TRANSFER_FIRST_POSITION;
                            }

                        }
                        break;
                    case TRANSFER_SECOND_POSITION:
                        if (currentIntakeState != TRANSFER_FIRST_POSITION) {
                            requestedIntakeState = TRANSFER_FIRST_POSITION;
                        } else {
                            if (transferTimer.milliseconds() > 1000) {
                                transferTimer.reset();
                                allowDriverInputIntakeExtend = false;
                            } else if (transferTimer.milliseconds() < 100) {
                                mRobot.mIntake.setPower(1);
                            } else if (transferTimer.milliseconds() < 200) {
                                mRobot.mIntake.setPower(0);
                            } else if (transferTimer.milliseconds() < 300) {
                                mRobot.mIntake.closeGate();
                                mRobot.mLift.set_Grabber_Open(true, true);
                            } else if (transferTimer.milliseconds() < 500) {
                                mRobot.mIntake.setPower(-1);
                            } else if (transferTimer.milliseconds() > 700) {
                                mRobot.mIntake.setPower(0);
                                mRobot.mLift.set_Grabber_Open(false, false);
                                currentIntakeState = TRANSFER_FIRST_POSITION;
                                requestedIntakeState = TRANSFER_FIRST_POSITION;
                                allowDriverInputIntakeExtend = true;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }


            // LIFT AND ARM CONTROL
            if (currentLiftState != requestedLiftState) {
                switch (requestedLiftState) {
                    case FIRST_POSITION:
                        switch (currentLiftState) {
                            case INTAKE_POSITION:
                                if(mRobot.mIntake.extend.getCurrentPosition() < 70) {
                                    currentIntakeState = RETRACTED;
                                }

                                if (currentIntakeState != SLIGHT_EXTEND) {
                                    requestedIntakeState = SLIGHT_EXTEND;
                                    allowDriverInputLiftExtend = false;
                                } else {
                                    allowDriverInputLiftExtend = false;
                                    mRobot.mLift.set_Grabber_Open(false, false);
                                    mRobot.mLift.score_position();

                                    if (firstPositionTimer.milliseconds() > 1200) {
                                        firstPositionTimer.reset();
                                    } else if (firstPositionTimer.milliseconds() > 500) {
                                        currentLiftState = LiftState.FIRST_POSITION;
                                        allowDriverInputLiftExtend = true;
                                    }
                                }
                                break;
                            case SECOND_POSITION:
                                mRobot.mLift.score_position();

                                if (firstPositionTimer.milliseconds() > 600) {
                                    firstPositionTimer.reset();
                                } else if (firstPositionTimer.milliseconds() > 500) {
                                    currentLiftState = LiftState.FIRST_POSITION;
                                }
                                break;
                            case AUTO:
                            case NULL:
                                currentLiftState = LiftState.SECOND_POSITION;
                                break;
                        }
                        break;
                    case SECOND_POSITION:
                        switch (currentLiftState) {
                            case INTAKE_POSITION:
                                if (currentIntakeState != SLIGHT_EXTEND) {
                                    requestedIntakeState = SLIGHT_EXTEND;
                                } else {
                                    mRobot.mLift.set_Grabber_Open(false, false);
                                    mRobot.mLift.score_position_second_level();

                                    if (firstPositionTimer.milliseconds() > 800) {
                                        firstPositionTimer.reset();
                                    } else if (firstPositionTimer.milliseconds() > 500) {
                                        currentLiftState = LiftState.SECOND_POSITION;
                                        allowDriverInputLiftExtend = true;
                                    }
                                }
                                break;
                            case FIRST_POSITION:
                                mRobot.mLift.score_position_second_level();

                                if (firstPositionTimer.milliseconds() > 600) {
                                    firstPositionTimer.reset();
                                    allowDriverInputLiftExtend = false;
                                } else if (firstPositionTimer.milliseconds() > 500) {
                                    currentLiftState = LiftState.SECOND_POSITION;
                                    allowDriverInputLiftExtend = true;
                                }
                                break;
                            case AUTO:
                            case NULL:
                                currentLiftState = LiftState.SECOND_POSITION;
                                break;
                        }
                        break;
                    case INTAKE_POSITION:
                        if (currentIntakeState == SLIGHT_EXTEND || currentIntakeState == INTAKE || currentIntakeState == OUTTAKE) {
                            if (currentLiftState == LiftState.EXTENDED_POSITION) {
                                allowDriverInputLiftExtend = false;
                                if (armTimer.milliseconds() > 2000) armTimer.reset();
                                else if (armTimer.milliseconds() < 300) {
                                    mRobot.mLift.setArmPosition(0.45);
                                } else {
                                    mRobot.mLift.setPower(-1);
                                    if(mRobot.mLift.LiftMotor.getCurrentPosition() < 5){
                                        mRobot.mLift.setPower(0);
                                        currentLiftState = LiftState.FIRST_POSITION;
                                        armTimer.reset();
                                    }
                                }
                            }

                            if (currentLiftState == LiftState.FIRST_POSITION || currentLiftState == LiftState.SECOND_POSITION || currentLiftState == LiftState.AUTO) {
                                if (armTimer.milliseconds() > 1500) armTimer.reset();
                                else if (armTimer.milliseconds() < 150) {
                                    mRobot.mLift.intake_position();
                                    mRobot.mLift.set_Grabber_Open(false, false);
                                } else if (armTimer.milliseconds() > 800) {
                                    mRobot.mLift.set_Grabber_Open(true, true);
                                    allowDriverInputLiftExtend = false;
                                    currentLiftState = LiftState.INTAKE_POSITION;
                                }
                            }
                        } else {
                            requestedIntakeState = SLIGHT_EXTEND;
                        }
                        break;
                    case NULL:
                    case AUTO:
                    case EXTENDED_POSITION:
                        break;

                }
            }

            if(allowDriverInputLiftExtend && currentLiftState != LiftState.AUTO && requestedLiftState != LiftState.INTAKE_POSITION) {
                if(gamepad2.left_trigger > 0.1) {
                    mRobot.mLift.setPower(-gamepad2.left_trigger, true);
                    currentLiftState = LiftState.EXTENDED_POSITION;
                } else if (gamepad2.right_trigger > 0.1) {
                    mRobot.mLift.setPower(gamepad2.right_trigger, true);
                    currentLiftState = LiftState.EXTENDED_POSITION;
                } else {
                    mRobot.mLift.setPower(0, true);
                }
            }

            if(allowDriverInputIntakeExtend) {
                if(gamepad1.left_trigger > 0.1) {
                    mRobot.mIntake.setPower(-gamepad1.left_trigger);
                    mRobot.mLift.set_Grabber_Open(false, false);
                    if(currentIntakeState == SLIGHT_EXTEND && mRobot.mIntake.extend.getCurrentPosition() < 70) {
                        currentIntakeState = RETRACTED;
                        requestedIntakeState = RETRACTED;
                    }
                } else if (gamepad1.right_trigger > 0.1) {
                    mRobot.mIntake.setPower(gamepad1.right_trigger);
                    if(currentIntakeState == RETRACTED && mRobot.mIntake.extend.getCurrentPosition() > 70) {
                        currentIntakeState = SLIGHT_EXTEND;
                        requestedIntakeState = SLIGHT_EXTEND;
                    }
                } else {
                    mRobot.mIntake.setPower(0);
                }
            } else {
                if(currentIntakeState == SLIGHT_EXTEND && requestedIntakeState == SLIGHT_EXTEND)
                    allowDriverInputIntakeExtend = true;

                if(mRobot.mIntake.extend.getCurrentPosition() > 570)
                    allowDriverInputIntakeExtend = true;
            }

            if(gamepad1.dpad_up) {
                mRobot.mHanger.up();
            } else if(gamepad1.dpad_down) {
                mRobot.mHanger.down();
            } else {
                mRobot.mHanger.off();
            }

            telemetry.addData("Intake Wanted", requestedIntakeState.toString());
            telemetry.addData("Intake Current", currentIntakeState.toString());
            telemetry.addData("Lift Wanted", requestedLiftState.toString());
            telemetry.addData("Lift Current", currentLiftState.toString());
            telemetry.addData("Intake Magnet", mRobot.mIntake.digitalTouch.getState());
            telemetry.addData("Allow Extension", allowDriverInputIntakeExtend);
            telemetry.addData("Arm Timer (ms)", armTimer.milliseconds());
            telemetry.addData("Intake Extension", mRobot.mIntake.extendPosition());
            telemetry.addData("Lift Position", mRobot.mLift.LiftMotor.getCurrentPosition());
            telemetry.addData("Hanger Position", mRobot.mHanger.Hang.getCurrentPosition());
            telemetry.update();
        }
    }
}

