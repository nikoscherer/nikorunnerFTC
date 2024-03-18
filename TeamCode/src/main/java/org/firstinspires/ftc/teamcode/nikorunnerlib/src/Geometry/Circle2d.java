package Pathing;

public class Circle2d {

    double x;
    double y;
    double radius;

    public Circle2d(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Point2d getLocation() {
        return new Point2d(x, y);
    }
}
