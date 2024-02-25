package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hanger {
    public DcMotor Hang;

    public void init(HardwareMap hardwaremap) {
        Hang = hardwaremap.dcMotor.get("hang");
        Hang.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Hang.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hang.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    // lift up
    // go down
    // turn off
    public void up() {
        Hang.setPower(1);
    }

    public void off() {
        Hang.setPower(0);
    }

    public void down() {
        Hang.setPower(-1);
    }

    public void setPower(double power) {
        if (power < 0) {
            if (Hang.getCurrentPosition() > 0) {
                Hang.setPower(power);
            } else {
                Hang.setPower(0);
            }
        } else {
            if (Hang.getCurrentPosition() < 3500) {
                Hang.setPower(power);
            } else {
                Hang.setPower(0);
            }
        }
    }
}