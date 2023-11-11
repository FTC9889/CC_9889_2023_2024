package com.team9889.ftc2023.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class Testing_something extends LinearOpMode{
    NormalizedColorSensor colorSensor;
    TouchSensor touchSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        touchSensor = hardwareMap.get(TouchSensor.class, "sensor_touch");
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "sensor_color");
        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("color red", colorSensor.getNormalizedColors().red);
            telemetry.addData("color blue", colorSensor.getNormalizedColors().blue);
            telemetry.addData("color green", colorSensor.getNormalizedColors().green);
            if (touchSensor.isPressed()) {
                telemetry.addData("Touch Sensor", "Is Pressed");
            } else {
                telemetry.addData("Touch Sensor", "Is Not Pressed");
            };
            telemetry.update();


        }
    }
}
