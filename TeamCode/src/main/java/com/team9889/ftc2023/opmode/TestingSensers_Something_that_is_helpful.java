package com.team9889.ftc2023.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class TestingSensers_Something_that_is_helpful extends LinearOpMode{
    NormalizedColorSensor colorSensor;
    TouchSensor touchSensor;

    @Override
    public void runOpMode() throws InterruptedException {colorSensor = hardwareMap.get(NormalizedColorSensor.class, "sensor_color");
        touchSensor = hardwareMap.get(TouchSensor)
       waitForStart();
       while(opModeIsActive()){
           telemetry.addData("color,red", colorSensor.getNormalizedColors().red);
           telemetry.addData("color,blue", colorSensor.getNormalizedColors().blue);
           telemetry.addData("color,green", colorSensor.getNormalizedColors().green);
           if (touchSensor.isPressed )
       telemetry.update();
       }
    }
}



























































































