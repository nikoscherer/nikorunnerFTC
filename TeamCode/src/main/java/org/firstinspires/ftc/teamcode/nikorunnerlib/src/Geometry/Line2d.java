package Geometry;
import java.util.ArrayList;

public class Line2d {
    ArrayList<Point2d> pointList;
    double targetRotation;
    String type;

    public Line2d(ArrayList<Point2d> pointList, double targetRotation, String type) {
        this.pointList = pointList;
        this.targetRotation = targetRotation;
        this.type = type;
    }

    public Pose2d getEndPose() {
        return new Pose2d(pointList.get(pointList.size()), targetRotation);
    }

    public double getTargetRotation2d() {
        return targetRotation;
    }

    public String getType() {
        return type;
    }
}
