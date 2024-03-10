package com.team9889.ftc2023.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Actions;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
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

import java.util.Objects;

public class Robot {

    public DriveAuto aDrive;

    public Drive mDrive = new Drive();

    public Intake mIntake = new Intake();

    public ScoringLift mLift = new ScoringLift();
    public Hanger mHanger = new Hanger();
    public Drone mDrone = new Drone();

    public Camera mCamera = new Camera();

    public DriverFeedback mLED = new DriverFeedback();

    private final Pose2d zero = new Pose2d(0,0,0);
    public void init (HardwareMap hardwareMap){
        init(hardwareMap, zero);
    }

    public void init (HardwareMap hardwareMap, Pose2d initialPose){
        if (Objects.equals(initialPose, zero)){
            mDrive.init(hardwareMap);
        }
        else{
            aDrive = new DriveAuto(hardwareMap, initialPose);
            mCamera.init(hardwareMap);
        }

        mIntake.init(hardwareMap);
        mLift.init(hardwareMap);
        mHanger.init(hardwareMap);
        mDrone.init(hardwareMap);
        mLED.init(hardwareMap);
    }

    @Deprecated
    public void encoder(double distance, LinearOpMode opMode){
        while (Math.abs(mDrive.front_encoder()) < distance && opMode.opModeIsActive()) opMode.sleep(10);
        mDrive.brake();
        mDrive.reset_encoder();

    }

    @Deprecated
    public double ticks_per_inch = 1.0 / ((((96.0/25.4) * Math.PI) * ((((double) 18) / ((double) 15)))) / 537.7);

    public enum BackDrop {
        LEFT, RIGHT, CENTER;

        @NonNull
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


