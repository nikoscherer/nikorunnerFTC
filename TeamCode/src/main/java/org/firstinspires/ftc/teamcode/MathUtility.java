package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.NikoRunner.src.Pose2d;

public class MathUtility {

    public static boolean isInPose2dRange(Pose2d targetPose, Pose2d currentPose, Pose2d error) {
        Pose2d poseError = new Pose2d(
                targetPose.getX() - currentPose.getX(),
                targetPose.getY() - currentPose.getY(),
                targetPose.getRotation() - currentPose.getRotation());

        boolean[] inError =  {poseError.getX() <= error.getX(), poseError.getY() <= error.getY(), poseError.getRotation() <= error.getRotation()};

        return inError[0] && inError[1] && inError[2];
    }

    public static Vector2d rotateByAngle(Vector2d vector, double radians) {
        double xValue = vector.getX() * Math.cos(radians) - vector.getY() * Math.sin(radians);
        double yValue = vector.getX() * Math.sin(radians) + vector.getY() * Math.cos(radians);

        return new Vector2d(xValue, yValue);
    }

    // NEEDS TESTING
    public static boolean pointInRadius(Vector2d point, Circle2d circle) {

        if(Math.abs(circle.getX() + radius) >= point) {
            if(Math.abs(circle.getY() + radius) >= point) {
                return true;
            }
        }

        return false;
    }

    // Will not work need to edit later
    public static Vector2d farthestPointInRadius(Vector2d[] points, Circle2d circle) {
        Vector2d farthestPoint;

        for(int i = 0; i < points.length; i++) {
            if(pointInRadius(point[i], circle)) {
                farthestPoint = point[i];
            }
        }
    }

    public double normalizeSpeeds(double current) {
        if(current > 1) {
            current = 1;
        } else if (current < -1) {
            current = -1;
        }

        return current;
    }
}
