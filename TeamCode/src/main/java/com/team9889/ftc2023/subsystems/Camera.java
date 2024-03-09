package com.team9889.ftc2023.subsystems;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Rotation2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.team9889.ftc2023.camera.AprilTagBackdrop;
import com.team9889.ftc2023.camera.TeamPropDetector;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Consumer;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.function.Continuation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.teamcode.DriveAuto;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Config
public class Camera {

    public AprilTagProcessor aprilTag;
    public TfodProcessor tfod;

    /**
     * The variable to store our instance of the vision portal.
     */
    public  VisionPortal visionPortal;
    public WebcamName webcam1, webcam2;

    private static final String TFOD_MODEL_ASSET = "2nd_model.tflite";
    // TFOD_MODEL_FILE points to a model file stored onboard the Robot Controller's storage,
    // this is used when uploading models directly to the RC using the model upload interface.
    private static final String TFOD_MODEL_FILE = "/sdcard/FIRST/tflitemodels/myCustomModel.tflite";
    // Define the labels recognized in the model for TFOD (must be in training order!)
    private static final String[] LABELS = {
            "BTP", "RTP",
    };

    public boolean red = false;

    public static double RC_X = 172;
    public static double RC_Y = 172;
    public static double RL_X = 543;
    public static double RL_Y = 205;
    public static double BC_X = 216;
    public static double BC_Y = 162;
    public static double BL_X = 584;
    public static double BL_Y = 215;

    public Robot.BackDrop side = Robot.BackDrop.CENTER;

    public static class CameraStreamProcessor implements VisionProcessor, CameraStreamSource {
        private final AtomicReference<Bitmap> lastFrame =
                new AtomicReference<>(Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565));

        @Override
        public void init(int width, int height, CameraCalibration calibration) {
            lastFrame.set(Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565));
        }

        @Override
        public Object processFrame(Mat frame, long captureTimeNanos) {
            Bitmap b = Bitmap.createBitmap(frame.width(), frame.height(), Bitmap.Config.RGB_565);
            Utils.matToBitmap(frame, b);
            lastFrame.set(b);
            return null;
        }

        @Override
        public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight,
                                float scaleBmpPxToCanvasPx, float scaleCanvasDensity,
                                Object userContext) {
            // do nothing
        }

        @Override
        public void getFrameBitmap(Continuation<? extends org.firstinspires.ftc.robotcore.external.function.Consumer<Bitmap>> continuation) {
            continuation.dispatch(bitmapConsumer -> bitmapConsumer.accept(lastFrame.get()));
        }
    }


    public void init(HardwareMap hardwareMap){

        final CameraStreamProcessor processor = new CameraStreamProcessor();

        aprilTag = new AprilTagProcessor.Builder()
                .setDrawAxes(false)
                .setDrawCubeProjection(false)
                .setDrawTagOutline(false)
                .setOutputUnits(DistanceUnit.INCH, AngleUnit.DEGREES)
                .setNumThreads(3)
                .build();

        aprilTag.setDecimation(3);

        tfod = new TfodProcessor.Builder().setModelAssetName(TFOD_MODEL_ASSET)
                .setModelLabels(LABELS)
                .setModelInputSize(320)
                .setNumExecutorThreads(1)
                .setNumDetectorThreads(1)
                .setMaxNumRecognitions(5)
                .build();
        tfod.setMinResultConfidence(0.3f);

        webcam1 = hardwareMap.get(WebcamName.class, "Webcam 1");
        webcam2 = hardwareMap.get(WebcamName.class, "Webcam 2");
        CameraName switchableCamera = ClassFactory.getInstance()
                .getCameraManager().nameForSwitchableCamera(webcam1, webcam2);

        // Create the vision portal by using a builder.
        visionPortal = new VisionPortal.Builder()
                .setCamera(switchableCamera)
                .addProcessor(processor)
                .addProcessor(aprilTag)
                .addProcessor(tfod)
                .setStreamFormat(VisionPortal.StreamFormat.MJPEG)
                .enableLiveView(true)
                .build();

        FtcDashboard.getInstance().startCameraStream(processor, 15);

        startteampropdetector();
    }

    public void startapriltag(){
        if (visionPortal.getCameraState() == VisionPortal.CameraState.STREAMING || visionPortal.getCameraState() == VisionPortal.CameraState.STARTING_STREAM) {
            visionPortal.setProcessorEnabled(tfod, false);
            visionPortal.setProcessorEnabled(aprilTag, true);

            visionPortal.setActiveCamera(webcam2);
        }
    }

    public void startteampropdetector(){
        if (visionPortal.getCameraState() == VisionPortal.CameraState.STREAMING) {
            visionPortal.setActiveCamera(webcam1);

            visionPortal.setProcessorEnabled(tfod, true);
            visionPortal.setProcessorEnabled(aprilTag, false);
        }
    }

    public void pauseallcamera(){
        visionPortal.setProcessorEnabled(tfod, false);
        visionPortal.setProcessorEnabled(aprilTag, false);
    }

    public void telemetryTfod(Telemetry telemetry) {

        List<Recognition> currentRecognitions = tfod.getRecognitions();
        telemetry.addData("# Objects Detected", currentRecognitions.size());

        Recognition highestConfidence = null;

        // Step through the list of recognitions and display info for each one.
        for (Recognition recognition : currentRecognitions) {
            if (red && recognition.getLabel() == "RTP"){
                if (highestConfidence == null) {
                    highestConfidence = recognition;
                }else if (highestConfidence.getConfidence() < recognition.getConfidence()) {
                    highestConfidence = recognition;
                }
            } else if(recognition.getLabel() == "BTP")  {
                if (highestConfidence == null) {
                    highestConfidence = recognition;
                }else if (highestConfidence.getConfidence()< recognition.getConfidence()) {
                    highestConfidence = recognition;
                }
            }

            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100);
        }   // end for() loop

        double x = 0, y = 0;
        if (highestConfidence != null){
            x = (highestConfidence.getLeft() + highestConfidence.getRight()) / 2;
            y = (highestConfidence.getTop() + highestConfidence.getBottom()) / 2;
            telemetry.addData("-------------------", "");
            telemetry.addData("Conf.", highestConfidence.getConfidence());
            telemetry.addData("Position X", x);
            telemetry.addData("Position Y", y);
        }

        if (red) {
            if (highestConfidence == null){
                // Off Screen
                side = Robot.BackDrop.LEFT;
            } else if (Math.hypot(x - RC_X, y - RC_Y) > Math.hypot(x - RL_X, y - RL_Y)){
                // Left
                side = Robot.BackDrop.RIGHT;
            } else {
                //center
                side = Robot.BackDrop.CENTER;
            }
        } else {
            if (highestConfidence == null){
                // Off Screen
                side = Robot.BackDrop.LEFT;
            } else if (Math.hypot(x - BC_X, y - BC_Y) > Math.hypot(x - BL_X, y - BL_Y)){
                // Left
                side = Robot.BackDrop.RIGHT;
            } else {
                side = Robot.BackDrop.CENTER;
            }
        }

        telemetry.update();

    }

    public Robot.BackDrop side() {
        return side;
    }

    public Pose2d RobotPose(double IMUAngle) {
        ArrayList<AprilTagDetection> list = aprilTag.getDetections();

        double x = 0, y= 0;

        if (!list.isEmpty()) {
            double PoseCount = 0;
            for (AprilTagDetection detection : list) {
                double tagx = detection.metadata.fieldPosition.get(0);
                double tagy = detection.metadata.fieldPosition.get(1);

                double heading = IMUAngle;

                double cx = -(detection.ftcPose.y + 7) * Math.cos(heading) - detection.ftcPose.x * Math.sin(Math.PI - heading);
                double cy = (detection.ftcPose.y + 7) * Math.sin(heading) + detection.ftcPose.x * Math.cos(Math.PI + heading);

                double rx = tagx - cx;
                double ry = tagy + cy;

                x += rx;
                y += ry;
                PoseCount ++;
            }

            return new Pose2d(x / PoseCount, y / PoseCount, IMUAngle);
        }

        else {
            return new Pose2d(0, 0,0 );
        }
    }

    public class resetPose implements Action{
        DriveAuto driveAuto;
        double angle;
        public resetPose(DriveAuto driveAuto, double angle){
            this.driveAuto = driveAuto;
            this.angle = angle;
        }
        ElapsedTime timer = new ElapsedTime();
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            startapriltag();
            Pose2d PoseFromCamera = RobotPose(driveAuto.imu.get().getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS) - angle);
            telemetryPacket.put("APRIL TAG", PoseFromCamera.toString());
            telemetryPacket.put("Difference", driveAuto.pose.minus(PoseFromCamera).toString());
            if (timer.milliseconds() > 0){
                telemetryPacket.put("FPS", 1.0 / timer.seconds());
                timer.reset();
            }
            if (PoseFromCamera.position.x > 15 && Math.abs(PoseFromCamera.position.y) > 0.01){
                if (Math.abs(driveAuto.pose.minus(PoseFromCamera).line.x) < 7 && Math.abs(driveAuto.pose.minus(PoseFromCamera).line.y) < 7){
                    driveAuto.pose = PoseFromCamera;
                }

                pauseallcamera();
                return false;
            }
            return true;
        }
    }

    public Action resetPose(Robot robot, double angle){
        return new resetPose(robot.aDrive, angle);
    }

}
;