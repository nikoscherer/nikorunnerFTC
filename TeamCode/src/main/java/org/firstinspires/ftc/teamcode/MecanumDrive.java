package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.NikoRunner.src.Pose2d;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Spline2d;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Trajectory;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Vector2d;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MecanumDrive {

    DcMotorEx fl, fr, bl, br;

    double robotHeading;

    public MecanumDrive(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotorEx.class, "FrontLeft");
        fr = hardwareMap.get(DcMotorEx.class, "FrontRight");
        bl = hardwareMap.get(DcMotorEx.class, "BackLeft");
        br = hardwareMap.get(DcMotorEx.class, "BackRight");
    }

    public void update(double heading) {
        this.heading = robotHeading;
    }

    public void updateDrive(double LY, double LX, double RX, boolean FOD) {
        Vector2d driveVector = new Vector2d(LY, LX);

        if(FOD) {
            driveVector.rotateVector(heading);
        }

        drive(driveVector, RX);
    }

    public void drive(Vector2d driveVector, double yaw) {
        fl.setPower(driveVector.getX() + driveVector.getY() + yaw);
        fr.setPower(driveVector.getX() - driveVector.getY() - yaw);
        bl.setPower(driveVector.getX() - driveVector.getY() + yaw);
        br.setPower(driveVector.getX() + driveVector.getY() - yaw);
    }


    // AUTONOMOUS
    Pose2d robotPose;

    Pose2d allowedError = new Pose2d(.5, .5, 5);

    double followRadius = 4; // in
//    double timeError = 1000; for when we will calculate estimated time to target pose

    public void setRobotPose(Pose2d poseUpdate) {
        robotPose = poseUpdate;
    }

    public void followTrajectory(Path path) {

        ArrayList<Spline2d> splinePaths = path.getSplineList();

            
        Circle2d circle = new Circle2d(robotPose.getX(), robotPose.getY(), followRadius);

        ArrayList<Point2D> waypoints = new ArrayList<>();

        for(int i = 0; i < spinePaths.size(); i++) {
            for(int j = 0; j < waypoints.size(); j++) {
                waypoints.add(splinePaths.get(i).get(j));
            }
        }


        Vector2d targetPoint;

        for(int i = 0; i < waypoints.size(); i++) {
            Vector2d distance = waypoints.get(i).toVector2d().minus(circle.getLocation().toVector2d());

            if(distance.getMagnitude() <= followRadius) {
                targetPoint = waypoints.get(i);
            }
        }


        if(targetPoint != null) {
            // Follow to point

            Vector2d driveVector = new Vector2d(
                0.25, //Speed (will input profiled pid later)
                Math.atan2(distance.getY(), distance.getX()) // Might be reverse.
            );
        }
        




    }
}

// WOLFPACK EQUATION
/*
    r = ((x'2 + y'2) ^ 3/2 ) / (x' * y'' - y' * x'')

    X = x(t)
    Y = y(t)

    X' = dx(t)/dt
    Y' = dy(t)/dt

 */
