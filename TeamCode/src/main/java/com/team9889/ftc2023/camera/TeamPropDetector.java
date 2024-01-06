package com.team9889.ftc2023.camera;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
public class TeamPropDetector extends OpenCvPipeline {
    Telemetry telemetry;

    public TeamPropDetector(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public static int x1 = 600;
    public static int x2 = 650;
    public static int y1 = 500;
    public static int y2 = 450;

    /*
     * These are our variables that will be
     * modifiable from the variable tuner.
     *
     * Scalars in OpenCV are generally used to
     * represent color. So our values in the
     * lower and upper Scalars here represent
     * the Y, Cr and Cb values respectively.
     *
     * YCbCr, like most color spaces, range
     * from 0-255, so we default to those
     * min and max values here for now, meaning
     * that all pixels will be shown.
     */
    public Scalar lower = new Scalar(0, 0, 0);
    public Scalar upper = new Scalar(255, 255, 255);

    /*
     * A good practice when typing EOCV pipelines is
     * declaring the Mats you will use here at the top
     * of your pipeline, to reuse the same buffers every
     * time. This removes the need to call mat.release()
     * with every Mat you create on the processFrame method,
     * and therefore, reducing the possibility of getting a
     * memory leak and causing the app to crash due to an
     * "Out of Memory" error.
     */
    private Mat ycrcbMat       = new Mat();
    private Mat binaryMat      = new Mat();
    private Mat maskedInputMat = new Mat();

    @Override
    public Mat processFrame(Mat input) {
         Rect LEFT_ROI = new Rect(
                new Point(x1, y1),
                new Point(x2, y2)
        );
         Rect CENTER_ROI = new Rect(
                 new Point(400,50),
                 new Point(800, 100)
         );

        Rect RIGHT_ROI = new Rect(
                new Point(0, 0),
                new Point(100, 100)
        );

        Mat left = input.submat(LEFT_ROI);
        Mat right = input.submat(RIGHT_ROI);
        Mat center = input.submat(CENTER_ROI);
        /*
         * Converts our input mat from RGB to YCrCb.
         * EOCV ALWAYS returns RGB mats, so you'd
         * always convert from RGB to the color
         * space you want to use.
         *
         * Takes our "input" mat as an input, and outputs
         * to a separate Mat buffer "ycrcbMat"
         */
        Imgproc.cvtColor(input, ycrcbMat, Imgproc.COLOR_RGB2HSV);

        /*
         * This is where our thresholding actually happens.
         * Takes our "ycrcbMat" as input and outputs a "binary"
         * Mat to "binaryMat" of the same size as our input.
         * "Discards" all the pixels outside the bounds specified
         * by the scalars above (and modifiable with EOCV-Sim's
         * live variable tuner.)
         *
         * Binary meaning that we have either a 0 or 255 value
         * for every pixel.
         *
         * 0 represents our pixels that were outside the bounds
         * 255 represents our pixels that are inside the bounds
         */
        Core.inRange(ycrcbMat, lower, upper, binaryMat);

        /*
         * Release the reusable Mat so that old data doesn't
         * affect the next step in the current processing
         */
        maskedInputMat.release();

        /*
         * Now, with our binary Mat, we perform a "bitwise and"
         * to our input image, meaning that we will perform a mask
         * which will include the pixels from our input Mat which
         * are "255" in our binary Mat (meaning that they're inside
         * the range) and will discard any other pixel outside the
         * range (RGB 0, 0, 0. All discarded pixels will be black)
         */
        Core.bitwise_and(input, input, maskedInputMat, binaryMat);

        /*
         * The Mat returned from this method is the
         * one displayed on the viewport.
         *
         * To visualize our threshold, we'll return
         * the "masked input mat" which shows the
         * pixel from the input Mat that were inside
         * the threshold range.
         */

        Imgproc.rectangle(input, LEFT_ROI, new Scalar(255, 0, 0));
        Imgproc.rectangle(input, CENTER_ROI, new Scalar(255, 0, 0));
        Imgproc.rectangle(input, RIGHT_ROI, new Scalar(255, 0, 0));

//        double leftvalue = Core.sumElems(left).val[0] / LEFT_BOI.area() / 255;
//        double rightvalue = Core.sumElems(right).val[0] / RIGHT_BOI.area() / 255;
//        left.release();
//        right.release();
        telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]/ LEFT_ROI.area() / 255);
        telemetry.addData("Left raw value1", (int) Core.sumElems(left).val[1]/ LEFT_ROI.area() / 255);
        telemetry.addData("Left raw value2", (int) Core.sumElems(left).val[2]/ LEFT_ROI.area() / 255);
//        telemetry.addData("Left percentage", Math.round(leftvalue * 100) + "%");
        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
//        telemetry.addData("Right percentage", Math.round(rightvalue * 100) + "%");
        telemetry.update();
        telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]/ CENTER_ROI.area() / 255);
        telemetry.addData("Left raw value1", (int) Core.sumElems(left).val[1]/ CENTER_ROI.area() / 255);
        telemetry.addData("Left raw value2", (int) Core.sumElems(left).val[2]/CENTER_ROI.area() / 255);
//        telemetry.addData("Left percentage", Math.round(leftvalue * 100) + "%");
        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
//        telemetry.addData("Right percentage", Math.round(rightvalue * 100) + "%");
        telemetry.update();
        telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]/ RIGHT_ROI.area() / 255);
        telemetry.addData("Left raw value1", (int) Core.sumElems(left).val[1]/ RIGHT_ROI.area() / 255);
        telemetry.addData("Left raw value2", (int) Core.sumElems(left).val[2]/ RIGHT_ROI.area() / 255);
//        telemetry.addData("Left percentage", Math.round(leftvalue * 100) + "%");
        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
//        telemetry.addData("Right percentage", Math.round(rightvalue * 100) + "%");
        telemetry.update();


        return input;
    }
}