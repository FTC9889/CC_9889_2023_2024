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
         Rect LEFT_ROI= null;
        Rect RIGHT_ROI = null;
         if(red){

             //change numbers later...
             LEFT_ROI = new Rect(
                     new Point(600, 500),
                     new Point(650, 450));

             RIGHT_ROI = new Rect(
                     new Point(1000, 250),
                     new Point(1050, 200)
             );
         }else{
             LEFT_ROI = new Rect(
                     new Point(600, 500),
                     new Point(650, 450));

             RIGHT_ROI = new Rect(
                     new Point(1000, 250),
                     new Point(1050, 200)
             );
         }

        Mat left = input.submat(LEFT_ROI);
        Mat right = input.submat(RIGHT_ROI);

        Imgproc.rectangle(input, LEFT_ROI, new Scalar(255, 0, 0));
        Imgproc.rectangle(input, RIGHT_ROI, new Scalar(255, 0, 0));

        int leftred = (int) (Core.sumElems(left).val[0]/ LEFT_ROI.area() / 255);
        int leftblue = (int) (Core.sumElems(left).val[2]/ LEFT_ROI.area() / 255);
        int rightred = (int) (Core.sumElems(right).val[0]/ RIGHT_ROI.area() / 255);
        int rightblue = (int) (Core.sumElems(right).val[2]/ RIGHT_ROI.area() / 255);

        telemetry.addData("Left blue value", leftblue);
        telemetry.addData("Left red value1", leftred);
        telemetry.addData("Right blue value", rightblue);
        telemetry.addData("Right red value1", rightred);
        telemetry.update();

        if (red){
            int diff = Math.abs(leftred - rightred);
            if (diff < 5){
                side = Robot.BackDrop.LEFT;
            } else if(leftred < rightred) {
                side = Robot.BackDrop.RIGHT;

            }

            else{
                side = Robot.BackDrop.CENTER;
            }
        }else{
            int diff = Math.abs(leftblue - rightblue);
            if (diff < 5){
                side = Robot.BackDrop.LEFT;
            } else if(leftblue < rightblue) {
                side = Robot.BackDrop.RIGHT;

            }

            else{
                side = Robot.BackDrop.CENTER;
            }
        }



        return input;
    }


    public Robot.BackDrop getside(){
        return side;}
}