public class Circle2d {

    Vector2d point;
    double radius;


    public Circle2d(Vector2d point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    public Circle2d(double x, double y, double radius) {
        this.point = new Vector2d(x, y);
        this.radius = radius;
    }

    public Vector2d getPoint() {
        return point;
    }

    public double getRadius() {
        return radius;
    }
}