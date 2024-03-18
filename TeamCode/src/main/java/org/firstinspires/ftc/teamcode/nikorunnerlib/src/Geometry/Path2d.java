package Geometry;

import java.util.ArrayList;

public class Path2d {
    
    ArrayList<Point2d> points;
    double initHeading;
    double endHeading;

    public Path2d(ArrayList<Point2d> points, double initHeading, double endHeading) {
        this.points = points;
        this.endHeading = endHeading;
    }

    public ArrayList<Point2d> getPoints() {
        return points;
    }

    public Pose2d getStartPose() {
        return new Pose2d(points.get(0), initHeading);
    }

    public Pose2d getEndPose() {
        return new Pose2d(points.get(points.size()), endHeading);
    }

    public double getEndHeading() {
        return endHeading;
    }

}
