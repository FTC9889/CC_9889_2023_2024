package com.team9889.ftc2023.test;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class TestROADRUNNERCode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // specify coefficients/gains
        PIDCoefficients coeffs = new PIDCoefficients(10, 0, 2.5);
// create the controller
        PIDFController controller = new PIDFController(coeffs);

// specify the setpoint
        double setpoint = 100;
        controller.setTargetPosition(setpoint);

// in each iteration of the control loop
// measure the position or output variable
// apply the correction to the input variable
        double correction = controller.update(measuredPosition);
    }
}
