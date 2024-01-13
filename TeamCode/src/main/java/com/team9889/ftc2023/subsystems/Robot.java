package com.team9889.ftc2023.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.team9889.ftc2023.camera.TeamPropDetector;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

public class Robot {

    public Drive mDrive = new Drive();

    public Intake mIntake = new Intake();
    public ScoringLift mLift = new ScoringLift();
    public Hanger mHanger = new Hanger();
    public Drone mdrone = new Drone();

    OpenCvWebcam webcam1;
    public TeamPropDetector teamPropDetector;

    public void init (HardwareMap hardwareMap){
        mDrive.init(hardwareMap);
        mIntake.init(hardwareMap);
        mLift.init(hardwareMap);
        mHanger.init(hardwareMap);
//        mdrone.init(hardwareMap);
    }

    public void init_camera(HardwareMap hardwareMap, Telemetry telemetry, boolean red) {


            int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
            webcam1 = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

            teamPropDetector = (new TeamPropDetector(telemetry, red));
            webcam1.setPipeline(teamPropDetector);
            webcam1.setMillisecondsPermissionTimeout(5000);
            webcam1.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
            {
                @Override
                public void onOpened()
                {
                    webcam1.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
                }

                @Override
                public void onError(int errorCode)
                {
                    /*
                     * This will be called if the camera could not be opened
                     */
                }
            });
    }

    public void encoder(double distance, LinearOpMode opMode){
        while (Math.abs(mDrive.front_encoder()) < distance && opMode.opModeIsActive()) opMode.sleep(10);
        mDrive.brake();
        mDrive.reset_encoder();

    }
    public double ticks_per_inch = 1.0 / ((((96.0/25.4) * Math.PI) * ((((double) 18) / ((double) 15)))) / 537.7);

    public enum BackDrop {
        LEFT, RIGHT, CENTER
    }

}


