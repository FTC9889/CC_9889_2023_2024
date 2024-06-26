/* Copyright (c) 2023 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.team9889.ftc2023.camera;

import static org.firstinspires.ftc.teamcode.DriveAuto.drawRobot;

import com.acmerobotics.dashboard.canvas.Canvas;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.team9889.lib.Transform3d;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Quaternion;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.ArrayList;
import java.util.List;

/*
 * This OpMode illustrates the basics of AprilTag recognition and pose estimation, using
 * the easy way.
 *
 * For an introduction to AprilTags, see the FTC-DOCS link below:
 * https://ftc-docs.firstinspires.org/en/latest/apriltag/vision_portal/apriltag_intro/apriltag-intro.html
 *
 * In this sample, any visible tag ID will be detected and displayed, but only tags that are included in the default
 * "TagLibrary" will have their position and orientation information displayed.  This default TagLibrary contains
 * the current Season's AprilTags and a small set of "test Tags" in the high number range.
 *
 * When an AprilTag in the TagLibrary is detected, the SDK provides location and orientation of the tag, relative to the camera.
 * This information is provided in the "ftcPose" member of the returned "detection", and is explained in the ftc-docs page linked below.
 * https://ftc-docs.firstinspires.org/apriltag-detection-values
 *
 * To experiment with using AprilTags to navigate, try out these two driving samples:
 * RobotAutoDriveToAprilTagOmni and RobotAutoDriveToAprilTagTank
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list.
 */

//@Disabled
public class AprilTagBackdrop {

    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    /**
     * The variable to store our instance of the AprilTag processor.
     */
    public AprilTagProcessor aprilTag;

    /**
     * The variable to store our instance of the vision portal.
     */
    public  VisionPortal visionPortal;

    /**
     * Initialize the AprilTag processor.
     */
    public void initAprilTag(HardwareMap hardwareMap) {

        // Create the AprilTag processor the easy way.
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        // Create the vision portal the easy way.
        if (USE_WEBCAM) {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "Webcam 2"), aprilTag);
        } else {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                BuiltinCameraDirection.BACK, aprilTag);
        }

    }   // end method initAprilTag()

    /**
     * Add telemetry about AprilTag detections.
     */

    int lastDetection = 6;
    public int detect_backdrop_center() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();

        for (AprilTagDetection detection : currentDetections) {

            if (detection.id == 5 || detection.id == 2) {
                int error = -(int) (280 - detection.center.x);
                lastDetection = error;
            } else {
                if (detection.id == 4 || detection.id == 1) lastDetection = 200;
                else if (detection.id == 6 || detection.id == 3) lastDetection = -200;
                else lastDetection = 201;
            }
        }

        return lastDetection;
    }
    public int detect_backdrop_left() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();

        for (AprilTagDetection detection : currentDetections) {

            if (detection.id == 4 || detection.id == 1) {
                int error = -(int) (280 - detection.center.x);
                lastDetection = error;
            } else {
                if (detection.id == 5 || detection.id == 2
                        || detection.id == 6 || detection.id == 3) lastDetection = -200;
                else lastDetection = 201;
            }
        }

        return lastDetection;
    }
    public int detect_backdrop_right() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();

        for (AprilTagDetection detection : currentDetections) {

            if (detection.id == 6 || detection.id == 3) {
                int error = -(int) (240 - detection.center.x);
                lastDetection = error;
            } else {
                if (detection.id == 5 || detection.id == 2
                        || detection.id == 4 || detection.id == 1) lastDetection = 200;
                else lastDetection = 201;
            }
        }

        return lastDetection;
    }
    public ArrayList<Pose2d> getAprilTagPoses() {
        ArrayList<AprilTagDetection> tags = new ArrayList<>();

        if (visionPortal.getProcessorEnabled(aprilTag)) {
            tags = aprilTag.getDetections();
        }

        ArrayList<Pose2d> poses = new ArrayList<>();

        for (AprilTagDetection tag: tags) {
            if (tag.metadata != null) {

                // Get the tag absolute position on the field
                Transform3d tagPose = new Transform3d(
                        tag.metadata.fieldPosition,
                        tag.metadata.fieldOrientation
                );

                // Get the relative location of the tag from the camera
                Transform3d cameraToTagTransform = new Transform3d(
                        new VectorF(
                                (float) tag.rawPose.x,
                                (float) tag.rawPose.y,
                                (float) tag.rawPose.z

                        ),
                        Transform3d.MatrixToQuaternion(tag.rawPose.R)
                );
                // Inverse the previous transform to get the location of the camera from the tag
                Transform3d tagToCameraTransform = cameraToTagTransform.unaryMinusInverse();

                // Add the tag position and the relative position of the camera to the tag
                Transform3d cameraPose = tagPose.plus(tagToCameraTransform);

                // The the relative location of the camera to the robot
                //TODO: You have to tune this value for your camera
                Transform3d robotToCameraTransform = new Transform3d(
                        new VectorF(
                                7f,
                                0f,
                                4.65f
                        ),
                        new Quaternion(0f,0,1f,0, System.nanoTime())
                );

                // Inverse the previous transform again to get the location of the robot from the camera
                Transform3d cameraToRobotTransform = robotToCameraTransform.unaryMinusInverse();

                // Add the relative location of the robot to location of the Camera
                Transform3d robotPose = cameraPose.plus(cameraToRobotTransform);

                // Convert from a 3D transform to a 2D pose
                poses.add(cameraPose.toPose2d());
            }
        }

        return poses;
    }



}