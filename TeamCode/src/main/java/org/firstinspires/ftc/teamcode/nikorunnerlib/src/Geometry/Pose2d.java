package Geometry;

public class Pose2d {
    double x;
    double y;

    double heading;


    public Pose2d(double x, double y, double heading) {
        this.x = x;
        this.y = y;

        this.heading = heading;
    }

    public Pose2d(Point2d point, double heading) {
        this.x = point.getX();
        this.y = point.getY();
        this.heading = heading;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeading() {
        return heading;
    }

    public Point2d getPoint() {
        return new Point2d(x, y);
    }

    public Vector2d getVector2d() {
        return new Vector2d(new Point2d(x, y));
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    public void setPose(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }
    

}
