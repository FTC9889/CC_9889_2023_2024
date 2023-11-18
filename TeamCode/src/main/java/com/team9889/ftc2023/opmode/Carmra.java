package com.team9889.ftc2023.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


         import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
 import com.qualcomm.robotcore.eventloop.opmode.OpMode;
 import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
 import org.firstinspires.ftc.vision.VisionPortal;
 import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
 import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

         import java.util.List;

         @Autonomous()
 public class SimpleAprilTags extends OpMode {
 private AprilTagProcessor aprilTagProcessor;
 private VisionPortal visionPortal;

         @Override
 public void init() {
         WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
         aprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
         visionPortal = VisionPortal.easyCreateWithDefaults(webcamName,
aprilTagProcessor);}

         @Override
 public void init_loop() {
         List<AprilTagDetection> currentDetections = aprilTagProcessor.getDetections(),
             ;
         StringBuilder idsFound = new StringBuilder();


         for (AprilTagDetection detection : currentDetections) {
             idsFound.append(detection.id);
             idsFound.append(’ ’);
             }
         telemetry.addData("April Tags", idsFound);
         }

         @Override
 public void start() {
         visionPortal.stopStreaming();
         }

         @Override
 public void loop() {
         }
 }




