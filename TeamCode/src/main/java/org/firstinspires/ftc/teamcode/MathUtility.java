package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.NikoRunner.src.Pose2d;

public class MathUtility {



    public boolean isInPose2dRange(Pose2d targetPose, Pose2d currentPose, Pose2d error) {
        Pose2d poseError = new Pose2d(
                currentPose.getX() - targetPose.getX(),
                currentPose.getY() - targetPose.getY(),
                currentPose.getRotation() - targetPose.getRotation());

        boolean[] inError =  {poseError.getX() <= error.getX(), poseError.getY() <= error.getY(), poseError.getRotation() <= error.getRotation()};

        return inError[0] && inError[1] && inError[2];
    }
}
