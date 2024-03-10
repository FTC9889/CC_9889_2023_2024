package com.team9889.ftc2023.subsystems;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriverFeedback {

    RevBlinkinLedDriver blinkinLedDriver;

    public void init(HardwareMap hardwareMap) {
        blinkinLedDriver = hardwareMap.get(RevBlinkinLedDriver.class, "blinkin");
        this.whiteHeartbeat();
    }

    public void setPattern(RevBlinkinLedDriver.BlinkinPattern pattern) {
        this.blinkinLedDriver.setPattern(pattern);
    }

    public void whiteHeartbeat() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.HEARTBEAT_WHITE);
    }

    public void scoringLiftOut() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
    }

    public void nothingInIntake() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
    }

    public void twoInIntake() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
    }

    public void stuckInIntake() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
    }

    public void restingNoFeedback() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.LIME);
    }

    public void transferIntake() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_FOREST_PALETTE);
    }

    public void droneLaunched() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.CONFETTI);
    }

    public void off() {
        setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);
    }
}
