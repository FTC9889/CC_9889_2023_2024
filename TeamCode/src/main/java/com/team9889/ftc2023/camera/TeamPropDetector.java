package com.team9889.ftc2023.camera;
import com.team9889.ftc2023.subsystems.Robot;

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

    boolean red;

    public TeamPropDetector(Telemetry telemetry, boolean red) {
        this.telemetry = telemetry;
        this.red = red;
    }

    public static int x1;
    public static int x2;
    public static int y1;
    public static int y2;
    public Robot.BackDrop side = Robot.BackDrop.RIGHT;
    @Override
    public Mat processFrame(Mat input) {
        Rect LEFT_ROI, RIGHT_ROI;
        Rect RED_FAR_RIGHT = new Rect(
                new Point(1210, 320),
                new Point(1280, 240));
        if(red){
             //red
             //change numbers later...
             LEFT_ROI = new Rect(
                     new Point(110, 360),
                     new Point(40, 290));

             RIGHT_ROI = new Rect(
                     new Point(710, 260),
                     new Point(640, 190)
             );

             //blue
         }else{
             LEFT_ROI = new Rect(
                     new Point(370, 260),
                     new Point(530, 190));

             RIGHT_ROI = new Rect(
                     new Point(1000, 300),
                     new Point(1100, 220)
             );
         }

        Mat left = input.submat(LEFT_ROI);
        Mat right = input.submat(RIGHT_ROI);
        Mat red_right = input.submat(RED_FAR_RIGHT);

        Imgproc.rectangle(input, LEFT_ROI, new Scalar(255, 0, 0));
        Imgproc.rectangle(input, RIGHT_ROI, new Scalar(255, 0, 0));
        Imgproc.rectangle(input, RED_FAR_RIGHT, new Scalar(255, 0, 0));

        double leftred = (Core.sumElems(left).val[0]/ LEFT_ROI.area() / 255);
        double leftgreen = (Core.sumElems(left).val[1]/ LEFT_ROI.area() / 255);
        double leftblue = (Core.sumElems(left).val[2]/ LEFT_ROI.area() / 255);
        double rightred = (Core.sumElems(right).val[0]/ RIGHT_ROI.area() / 255);
        double rightgreen = (Core.sumElems(right).val[1]/ RIGHT_ROI.area() / 255);
        double rightblue = (Core.sumElems(right).val[2]/ RIGHT_ROI.area() / 255);


        double farrightred = (Core.sumElems(red_right).val[0]/ RED_FAR_RIGHT.area() / 255);
        double farrightgreen = (Core.sumElems(red_right).val[1]/ RED_FAR_RIGHT.area() / 255);
        double farrightblue = (Core.sumElems(red_right).val[2]/ RED_FAR_RIGHT.area() / 255);


        double avarage_right = (rightgreen + rightblue + rightred) / 3.0;
        double avarage_left = (leftgreen + leftblue + leftred) / 3.0;
        double avg_far = (farrightblue + farrightgreen + farrightred) / 3.0;


        if (red){ // RED SIDE
            if(rightred > leftred && rightred > farrightred){
                side = Robot.BackDrop.CENTER;
            } else if(leftred > rightred && leftred > farrightred){
                side = Robot.BackDrop.LEFT;
            } else if(farrightred > rightred && farrightred > leftred){
                side = Robot.BackDrop.RIGHT;
            }
        }else{ // BLUE SIDE
            double diff = Math.abs(leftblue - rightblue);
            if (diff < 0.05){
                side = Robot.BackDrop.LEFT;
            } else if(leftblue < rightblue) {
                side = Robot.BackDrop.RIGHT;

            }

            else{
                side = Robot.BackDrop.CENTER;
            }
        }

        telemetry.addData("Left blue value", leftblue);
        telemetry.addData("Right blue value", rightblue);
        telemetry.addData("Blue Diff", Math.abs(leftblue - rightblue));

        telemetry.addData("Left red value", leftred);
        telemetry.addData("Right red value", rightred);
        telemetry.addData("Red Diff", Math.abs(leftred - rightred));

        telemetry.addData("Red FAR_", farrightred);
        telemetry.addData("Red FAR", avg_far);

        telemetry.addData("avg.right", avarage_right);
        telemetry.addData("avg.left", avarage_left);
        telemetry.addData("side", side.toString());
        telemetry.update();



        return input;
    }


    public Robot.BackDrop getside(){
        return side;}
}