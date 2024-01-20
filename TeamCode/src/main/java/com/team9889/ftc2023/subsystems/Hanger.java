package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hanger {
    DcMotor Hang;

    public void init(HardwareMap hardwaremap) {
        Hang = hardwaremap.dcMotor.get("hang");
        Hang.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    // lift up
    // go down
    // turn off
    public void up() {
        Hang.setPower(0.4);
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