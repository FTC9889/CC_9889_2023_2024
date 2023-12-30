package com.team9889.ftc2023.camera;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Test_Open_CV_Camera extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();
    static final Rect LEFT_BOI = new Rect(
        new Point(0, 0),
        new Point(100, 100)
        );

    static final Rect RIGHT_BOI = new Rect(
            new Point(0, 0),
            new Point(100, 100)
            );
    static double PERCENT_COLOR_THRESHOLD = 0.4;
    public Test_Open_CV_Camera(Telemetry t ) {telemetry = t;}
    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowsv = new Scalar(0, 0, 0);
        Scalar highsv = new Scalar(255, 255, 255);

        Core.inRange(mat, lowsv, highsv, mat);

        Mat left = mat.submat(LEFT_BOI);
        Mat right = mat.submat(RIGHT_BOI);

        double leftvalue = Core.sumElems(left).val[0] / LEFT_BOI.area() / 255;
        double rightvalue = Core.sumElems(right).val[0] / RIGHT_BOI.area() / 255;
        left.release();
        right.release();

        telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]);
        telemetry.addData("Left percentage", Math.round(leftvalue * 100) + "%");
        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
        telemetry.addData("Right percentage", Math.round(rightvalue * 100) + "%");

        boolean stoneLeft = leftvalue > PERCENT_COLOR_THRESHOLD;
        boolean stoneRight = rightvalue > PERCENT_COLOR_THRESHOLD;



        return left;
    }
}
