package com.team9889.ftc2023.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.team9889.ftc2023.camera.TeamPropDetector;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class testsomeeteampropdetector extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        TeamPropDetector teamPropDetector = new TeamPropDetector(true);

        teamPropDetector.initTfod(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            teamPropDetector.telemetryTfod(telemetry);
            telemetry.update();
        }


    }
}
