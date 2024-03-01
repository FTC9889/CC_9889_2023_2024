package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ThreeDeadWheelLocalizer;
@TeleOp
@Disabled
public class TestOdometry extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        double inPerTick = ((35 / 25.4 * Math.PI) * ((((double) 40) / ((double) 24)))) / 1440;
        ThreeDeadWheelLocalizer localizer = new ThreeDeadWheelLocalizer(hardwareMap, inPerTick);

        waitForStart();

        while (opModeIsActive()){
            telemetry.addData("par0", localizer.par0.getPositionAndVelocity().position);
            telemetry.addData("par1", localizer.par1.getPositionAndVelocity().position);
            telemetry.addData("perp", localizer.perp.getPositionAndVelocity().position);
            telemetry.update();
        }

    }
}
