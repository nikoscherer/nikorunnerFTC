package org.firstinspires.ftc.teamcode.NikoRunner.src;

import java.util.ArrayList;

public class Spline2d {
    ArrayList<Vector2d> pointList;
    Rotation2d targetRotation;
    String type;

    public Spline2d(ArrayList<Vector2d> pointList, Rotation2d targetRotation, String type) {
        this.pointList = pointList;
        this.targetRotation = targetRotation;
        this.type = type;
    }

    public Pose2d getEndPose() {
        return new Pose2d(pointList.get(pointList.size()), targetRotation);
    }
    
}