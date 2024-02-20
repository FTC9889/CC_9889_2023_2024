package com.team9889.ftc2023.opmode;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.INTAKE;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.OUTTAKE;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.RETRACTED;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.SLIGHT_EXTEND;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.TRANSFER_FIRST_POSITION;
import static com.team9889.ftc2023.opmode.TeleOp.IntakeState.TRANSFER_SECOND_POSITION;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.opmode.TeleOp.HangerState;
import com.team9889.ftc2023.opmode.TeleOp.IntakeState;
import com.team9889.ftc2023.opmode.TeleOp.LiftState;
import com.team9889.ftc2023.subsystems.Robot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class OneDriverTeleOp extends LinearOpMode {

  Robot mRobot=new Robot();
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

        HangerState hangerState = HangerState.DEPLOYED;

        boolean allowDriverInputIntakeExtend = true;
        boolean allowDriverInputLiftExtend = true;

        while(opModeIsActive()) {

            // Drive Code
            mRobot.mDrive.setPower(-gamepad1.left_stick_x, gamepad1.left_stick_y, -gamepad1.right_stick_x * 0.85);

            if(Math.abs(gamepad1.left_stick_y) > 0.1 && currentIntakeState == RETRACTED && mRobot.mIntake.extend.getCurrentPosition() > 20) {
                currentIntakeState = SLIGHT_EXTEND;
            }

            if (gamepad1.a) {
                if(currentIntakeState == INTAKE) {
                    currentIntakeState = RETRACTED;
                }
                requestedIntakeState = IntakeState.INTAKE;
            }

            if (gamepad1.y) {
                requestedIntakeState = OUTTAKE;
            }

            if (currentLiftState == LiftState.FIRST_POSITION || currentLiftState == LiftState.SECOND_POSITION || currentLiftState == LiftState.EXTENDED_POSITION) {
                mRobot.mLift.set_Grabber_Open(gamepad1.left_bumper, gamepad1.right_bumper);
            }

            if (gamepad1.b) {
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

            if (gamepad1.x) {
                if(currentLiftState == LiftState.FIRST_POSITION)
                    requestedLiftState = LiftState.SECOND_POSITION;
                else
                    requestedLiftState = LiftState.FIRST_POSITION;
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
                            case RETRACTED:
                                mRobot.mIntake.startIntake();
                                allowDriverInputIntakeExtend = true;
                                currentIntakeState = IntakeState.INTAKE;
                                requestedLiftState = LiftState.INTAKE_POSITION;
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
                                telemetry.addData("Line Number", "255");
                            } else if (retractIntakeUpTimer.milliseconds() > 1500 || !mRobot.mIntake.digitalTouch.getState()) {
                                mRobot.mIntake.setPower(0);
                                telemetry.addData("Line Number", "258");


                                if (hangerState != HangerState.RETRACTED) {
                                    currentIntakeState = IntakeState.RETRACTED;
                                    mRobot.mLift.set_Grabber_Open(true, true);
                                    telemetry.addData("Line Number", "264");

                                }


                                allowDriverInputIntakeExtend = true;
                                retractIntakeUpTimer.reset();
                                telemetry.addData("Line Number", "271");

                            }
                        }
                        break;
                    case SLIGHT_EXTEND:
                        switch (currentIntakeState) {
                            case TRANSFER_FIRST_POSITION:
                            case TRANSFER_SECOND_POSITION:
                            case RETRACTED:
                                if (extendIntakeTimer.milliseconds() > 500) {
                                    extendIntakeTimer.reset();
                                    telemetry.addData("Line Number", "283");
                                }


                                if (!mRobot.mIntake.digitalTouch.getState() || mRobot.mIntake.extend.getCurrentPosition() < 100) {
                                    mRobot.mIntake.setPower(1);
                                    allowDriverInputIntakeExtend = false;
                                    telemetry.addData("Line Number", "290");

                                } else {
                                    mRobot.mIntake.vfbUp();
                                    mRobot.mIntake.off();
                                    mRobot.mIntake.closeGate();
                                    allowDriverInputIntakeExtend = true;
                                    currentIntakeState = SLIGHT_EXTEND;
                                    telemetry.addData("Line Number", "298");

                                }
                                break;
                            case NULL:
                            case OUTTAKE:
                            case INTAKE:
                                break;
                        }
                        break;
                    case TRANSFER_FIRST_POSITION:
                        if (currentIntakeState != RETRACTED) {
                            requestedIntakeState = RETRACTED;
                            telemetry.addData("Line Number", "311");
                        } else {
                            mRobot.mLift.set_Grabber_Open(true, true);
                            telemetry.addData("Line Number", "315");
                            mRobot.mIntake.transfer();
                            if (transferTimer.milliseconds() > 1000) {
                                transferTimer.reset();
                                telemetry.addData("Line Number", "319");

                            } else if (transferTimer.milliseconds() > 800) {
                                mRobot.mLift.set_Grabber_Open(false, false);
                                mRobot.mIntake.transfer2();
                                currentIntakeState = TRANSFER_FIRST_POSITION;
                                telemetry.addData("Line Number", "325");

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
                                telemetry.addData("Line Number", "338");

                            } else if (transferTimer.milliseconds() < 100) {
                                mRobot.mIntake.setPower(1);
                                telemetry.addData("Line Number", "342");

                            } else if (transferTimer.milliseconds() < 200) {
                                mRobot.mIntake.setPower(0);
                                telemetry.addData("Line Number", "346");

                            } else if (transferTimer.milliseconds() < 300) {
                                mRobot.mIntake.closeGate();
                                mRobot.mLift.set_Grabber_Open(true, true);
                                telemetry.addData("Line Number", "351");

                            } else if (transferTimer.milliseconds() < 500) {
                                mRobot.mIntake.setPower(-1);
                                telemetry.addData("Line Number", "355");

                            } else if (transferTimer.milliseconds() > 700) {
                                mRobot.mIntake.setPower(0);
                                mRobot.mLift.set_Grabber_Open(false, false);
                                currentIntakeState = TRANSFER_FIRST_POSITION;
                                requestedIntakeState = TRANSFER_FIRST_POSITION;
                                allowDriverInputIntakeExtend = true;
                                telemetry.addData("Line Number", "363");
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
                                if (firstPositionTimer.milliseconds() > 800) {
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
                                if (firstPositionTimer.milliseconds() > 1200) {
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
                                    mRobot.mLift.setArmPosition(0.35);
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

            if(currentLiftState != LiftState.INTAKE_POSITION) {
                if(allowDriverInputLiftExtend) {
                    if(gamepad1.left_trigger > 0.1) {
                        mRobot.mLift.setPower(-gamepad1.left_trigger);
                        currentLiftState = LiftState.EXTENDED_POSITION;
                    } else if (gamepad1.right_trigger > 0.1) {
                        mRobot.mLift.setPower(gamepad1.right_trigger);
                        currentLiftState = LiftState.EXTENDED_POSITION;
                    }
                }

                if(allowDriverInputIntakeExtend)
                    mRobot.mIntake.setPower(0);
            } else {
                if(allowDriverInputIntakeExtend) {
                    if(gamepad1.left_trigger > 0.1) {
                        mRobot.mIntake.setPower(-gamepad1.left_trigger);
                        mRobot.mLift.set_Grabber_Open(false, false);
                        if(currentIntakeState == SLIGHT_EXTEND && mRobot.mIntake.extend.getCurrentPosition() < 20) {
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
                }
            }




            if(gamepad1.dpad_up) {
                mRobot.mHanger.up();
                hangerState = HangerState.DEPLOYED;
            } else if(gamepad1.dpad_down) {
                mRobot.mHanger.down();
                hangerState = HangerState.RETRACTED;
                requestedIntakeState = RETRACTED;
            } else {
                mRobot.mHanger.off();
            }

            telemetry.addData("Intake Wanted", requestedIntakeState.toString());
            telemetry.addData("Intake Current", currentIntakeState.toString());
            telemetry.addData("Lift Wanted", requestedLiftState.toString());
            telemetry.addData("Lift Current", currentLiftState.toString());
            telemetry.addData("Hanger Current", hangerState.toString());
            telemetry.addData("Intake Magnet", mRobot.mIntake.digitalTouch.getState());
            telemetry.addData("Allow Extension", allowDriverInputIntakeExtend);
            telemetry.addData("Arm Timer (ms)", armTimer.milliseconds());
            telemetry.addData("Intake Extension", mRobot.mIntake.extendPosition());
            telemetry.addData("Lift Position", mRobot.mLift.LiftMotor.getCurrentPosition());
            telemetry.addData("Intake Current", mRobot.mIntake.currentDraw());

            telemetry.update();
        }
    }
}
