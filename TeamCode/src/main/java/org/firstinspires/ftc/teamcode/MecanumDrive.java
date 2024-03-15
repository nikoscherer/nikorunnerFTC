package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.NikoRunner.src.Pose2d;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Spline2d;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Trajectory;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Vector2d;

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
//    double timeError = 1000; for when we will calculate estimated time to target pose

    public void setRobotPose(Pose2d poseUpdate) {
        robotPose = poseUpdate;
    }


    public void followTrajectory(Trajectory trajectory) {

        int currentSpline = 0;

        // While trajectory is not completed, will need an actual way to do this instead of a while loop, this probably will not even work correctly and just crash.
        while(MathUtility.isInPose2dRange(trajectory.end(), robotPose, allowedError)) {

            // FULL TRAJECTORY
            ArrayList<Spline2d> splines = trajectory.getSplineList();


            Vector2d closestPoint;


            /*
             * CURRENT WAY, NEED A BETTER WAY (LIKE PURE PURSUIT) TO FOLLOW THE SPLINES,
             * ONCE FOLLOWING SOMEWHAT WORKS, SWITCH TO A NEW WAY.
             * 
             * GET LINE SEGMENT
             * MAKE CIRCLE
             * FIND FARTHEST PATH IN CIRCLE
             * SET DIRECION TO THAT POINT
             * SET MOTOR SPEEDS USING TRAPEZOIDAL PID CONTROLLER
             */

            
            // Test for individual splines
            double radius = 3; // FOLLOW RADIUS, in Inches
            Circle2d circle = new Circle2d(robotPose.getX(), robotPose.getY(), radius);

            // Check through spline points if it intersects the circle
            Vector2d firstLinePoint = new Vector2d(5, 5);
            Vector2d secondLinePoint = new Vector2d(10, 10);
            
            // Get current splines waypoints
            ArrayList<SplineValues2d> waypoints = splines.get(currentSpline);
            
            for(int i = 1; i < waypoints.size(); i++) {

                Vector2d distance = new Vector2d(
                    waypoints.get(i).getX() - circle.getX(),
                    waypoint.get(i).getY() - cirle.getY()
                );

                if(distance.getFullVector() <= radius) {
                    if(closestPoint == null) {
                        closestPoint = waypoints.get(i);
                    } else if(closestPoint.getFullVector() >= distance.getFullVector()){
                        closestPoint = waypoints.get(i);
                    }
                }
            }


            // REDO THIS
            // If robot pose is in the correct position, switch to new point, spline, or exit trajectory.
            if(MathUtility.isInPose2dRange(splines.get(currentSpline).get(currentPoint), robotPose, allowedError)) {
                if(splines.get(currentSpline).size() <= currentPoint) {
                    if(splines.size() <= currentSpline) {
                        // DONE WITH TRAJECTORY
                        break;
                    } else {
                        // MOVE TO NEXT SPLINE IN TRAJECTORY
                        currentSpline = currentSpline + 1;
                    }
                } else {

                    
                    // MOVE TO NEXT POINT IN SPLINE
                }
            }
        }

        // set to power vector
        drive(new Vector2d(0, 0), 0);


        
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
