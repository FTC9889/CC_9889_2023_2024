package com.team9889.ftc2023.camera;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
public class EasyOpenCVCamera extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();
    static final Rect LEFT_ROI = new Rect(
        new Point(0, 0),
        new Point(100,100)
    );
    static final Rect RIGHT_ROI = new Rect(
            new Point(0, 0),
            new Point(100,100)
    );
    static double PERCENT_COLLOR_THRESHHOLD = 0.4;


    public EasyOpenCVCamera(Telemetry t ) {telemetry = t; }

    @Override()
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowhsv = new Scalar(0, 0, 0);
        Scalar highhsv = new Scalar(255, 255, 255);

        Core.inRange(mat, lowhsv, highhsv, mat);
        Mat left = mat.submat(LEFT_ROI);
        Mat right = mat.submat(RIGHT_ROI);

        double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255;
        double rightValue = Core.sumElems(left).val[0] / RIGHT_ROI.area() / 255;

        left.release();;
        right.release();

        telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]);
        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
        telemetry.addData("Left percentage", Math.round(leftValue * 100) + "%");
        telemetry.addData("Right percentage", Math.round(rightValue * 100) + "%");

        return null;
    }
}