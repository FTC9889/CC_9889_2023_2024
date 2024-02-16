package com.team9889.ftc2023.camera;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.team9889.ftc2023.subsystems.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;
@Config
public class TeamPropDetector {

    /*
     * This OpMode illustrates the basics of TensorFlow Object Detection,
     * including Java Builder structures for specifying Vision parameters.
     *
     * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
     * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list.
     */

    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    // TFOD_MODEL_ASSET points to a model file stored in the project Asset location,
    // this is only used for Android Studio when using models in Assets.

    private static final String TFOD_MODEL_ASSET = "2nd_model.tflite";
    // TFOD_MODEL_FILE points to a model file stored onboard the Robot Controller's storage,
    // this is used when uploading models directly to the RC using the model upload interface.
    private static final String TFOD_MODEL_FILE = "/sdcard/FIRST/tflitemodels/myCustomModel.tflite";
    // Define the labels recognized in the model for TFOD (must be in training order!)
    private static final String[] LABELS = {
            "BTP", "RTP",
    };
    public Robot.BackDrop side = Robot.BackDrop.CENTER;

    public static double RC_X = 50;
    public static double RC_Y = 50;
    public static double RL_X = 50;
    public static double RL_Y = 50;
    public static double BC_X = 50;
    public static double BC_Y = 50;
    public static double BL_X = 50;
    public static double BL_Y = 50;

    /**
     * The variable to store our instance of the TensorFlow Object Detection processor.
     */
    private TfodProcessor tfod;

    /**
     * The variable to store our instance of the vision portal.
     */
    public VisionPortal visionPortal;
    Telemetry telemetry;
    boolean red;

    public TeamPropDetector(boolean red) {
        this.red = red;
    }


    /**
     * Initialize the TensorFlow Object Detection processor.
     */
    public void initTfod(HardwareMap hardwareMap) {

        // Create the TensorFlow processor by using a builder.
        tfod = new TfodProcessor.Builder()

                // With the following lines commented out, the default TfodProcessor Builder
                // will load the default model for the season. To define a custom model to load,
                // choose one of the following:
                //   Use setModelAssetName() if the custom TF Model is built in as an asset (AS only).
                //   Use setModelFileName() if you have downloaded a custom team model to the Robot Controller.
                .setModelAssetName(TFOD_MODEL_ASSET)
                //.setModelFileName(TFOD_MODEL_FILE)

                // The following default settings are available to un-comment and edit as needed to
                // set parameters for custom models.
                .setModelLabels(LABELS)
                //.setIsModelTensorFlow2(true)
                //.setIsModelQuantized(true)
                .setModelInputSize(320)
                //.setModelAspectRatio(16.0 / 9.0)

                .build();

        // Create the vision portal by using a builder.
        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }

        // Choose a camera resolution. Not all cameras support all resolutions.

        // builder.setCameraResolution(new Size(320, 320));

        // Enable the RC preview (LiveView).  Set "false" to omit camera monitoring.
        //builder.enableLiveView(true);

        // Set the stream format; MJPEG uses less bandwidth than default YUY2.
        //builder.setStreamFormat(VisionPortal.StreamFormat.YUY2);

        // Choose whether or not LiveView stops if no processors are enabled.
        // If set "true", monitor shows solid orange screen if no processors enabled.
        // If set "false", monitor shows camera view without annotations.
        //builder.setAutoStopLiveView(false);

        // Set and enable the processor.
        builder.addProcessor(tfod);

        // Build the Vision Portal, using the above settings.
        visionPortal = builder.build();

        // Set confidence threshold for TFOD recognitions, at any time.
        tfod.setMinResultConfidence(0.5f);

        // Disable or re-enable the TFOD processor at any time.
        //visionPortal.setProcessorEnabled(tfod, true);

    }   // end method initTfod()

    /**
     * Add telemetry about TensorFlow Object Detection (TFOD) recognitions.
     */

    public void telemetryTfod(Telemetry telemetry) {

        List<Recognition> currentRecognitions = tfod.getRecognitions();
        telemetry.addData("# Objects Detected", currentRecognitions.size());

        Recognition highestConfidence = null;

        // Step through the list of recognitions and display info for each one.
        for (Recognition recognition : currentRecognitions) {


            if (red && recognition.getLabel() == "RTP"){
                if (highestConfidence == null) {
                    highestConfidence = recognition;
                }else if (highestConfidence.getConfidence()< recognition.getConfidence()) {
                   highestConfidence = recognition;
                }
            } else if(recognition.getLabel() == "BTP")  {
                if (highestConfidence == null) {
                    highestConfidence = recognition;
                }else if (highestConfidence.getConfidence()< recognition.getConfidence()) {
                    highestConfidence = recognition;
                }
            }

            telemetry.addData("", " ");
            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100);
        }   // end for() loop

        double x = 0, y = 0;
        if (highestConfidence != null){
            x = (highestConfidence.getLeft() + highestConfidence.getRight()) / 2;
            y = (highestConfidence.getTop() + highestConfidence.getBottom()) / 2;
        }


        if (red) {
            if (highestConfidence == null){
                // Off Screen
                side = Robot.BackDrop.LEFT;
            } else if (Math.hypot(x - RC_X, y- RC_Y) > Math.hypot(x- RL_X, y- RL_Y)){
                // Left
                side = Robot.BackDrop.RIGHT;
            } else {
                //center
                side = Robot.BackDrop.CENTER;
            }
        } else {
            if (highestConfidence == null){
                // Off Screen
                side = Robot.BackDrop.RIGHT;
            } else if (Math.hypot(x - BC_X, y- BC_Y) > Math.hypot(x- BL_X, y- BL_Y)){
                // Left
                side = Robot.BackDrop.LEFT;
            } else {
                side = Robot.BackDrop.CENTER;
            }
        }



    }
}