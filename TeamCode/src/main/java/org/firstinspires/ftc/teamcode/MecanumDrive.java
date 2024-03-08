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
        int currentPoint = 0;

        // While trajectory is not completed, will need an actual way to do this instead of a while loop, this probably will not even work correctly and just crash.
        while(MathUtility.isInPose2dRange(trajectory.end(), robotPose, allowedError)) {

            ArrayList<Spline2d> splines = trajectory.getSplineList();


            // FOLLOW TRAJECTORY
            
            // TARGET MOTOR POWER (FOR TESTING, NEED TO SWITCH TO PROFILED PID LATER)
            int power = .25;

            Vector2d targetPoint = splines.get(currentSpline).get(currentPoint);
        
            // Might be different, need to test.
            double targetDirection = math.atan2(targetPoint.getX() - robotPose.getX(), 
            targetPoint.getY() - robotPose.getY());

            Vector2d transformedVector = rotateByAngle(targetPoint, targetDirection);

            // Should follow, but will not use heading yet.
            // Should test this when able to.
            drive(transformedVector, power * robotHeading);


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
                    currentPoint = currentPoint + 1;
                }
            }
        }

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
