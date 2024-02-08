package com.team9889.ftc2023.subsystems;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Actions;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.team9889.ftc2023.camera.AprilTagBackdrop;
import com.team9889.ftc2023.camera.TeamPropDetector;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.DriveAuto;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

public class Robot {

    public DriveAuto aDrive;
    public AprilTagBackdrop mBackdrop = new AprilTagBackdrop();

    public Drive mDrive = new Drive();

    public Intake mIntake = new Intake();

    public ScoringLift mLift = new ScoringLift();
    public Hanger mHanger = new Hanger();
    public Drone mDrone = new Drone();

    OpenCvWebcam webcam1;
    public TeamPropDetector teamPropDetector;

    public void init (HardwareMap hardwareMap){
        init(hardwareMap, new Pose2d(0,0,0));
    }

    public void init (HardwareMap hardwareMap, Pose2d initialPose){
        if (initialPose == new Pose2d(0,0,0)){
            mDrive.init(hardwareMap);
        }
        else{
            aDrive = new DriveAuto(hardwareMap, initialPose);
        }

        mIntake.init(hardwareMap);
        mLift.init(hardwareMap);
        mHanger.init(hardwareMap);
        mDrone.init(hardwareMap);
    }



    public void init_camera(HardwareMap hardwareMap, Telemetry telemetry, boolean red) {
            int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
            webcam1 = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

            teamPropDetector = (new TeamPropDetector(red));
    }
    public void stop_team_prop_scanner(){
        webcam1.stopStreaming();
        webcam1.closeCameraDevice();
    }

    public void encoder(double distance, LinearOpMode opMode){
        while (Math.abs(mDrive.front_encoder()) < distance && opMode.opModeIsActive()) opMode.sleep(10);
        mDrive.brake();
        mDrive.reset_encoder();

    }
    public double ticks_per_inch = 1.0 / ((((96.0/25.4) * Math.PI) * ((((double) 18) / ((double) 15)))) / 537.7);

    public enum BackDrop {
        LEFT, RIGHT, CENTER;

        public String toString(){
            switch (this) {
                case LEFT:
                    return "LEFT";
                case RIGHT:
                    return "RIGHT";
                case CENTER:
                    return "CENTER";
                default:
                    return "";
            }
        }
    }
}


