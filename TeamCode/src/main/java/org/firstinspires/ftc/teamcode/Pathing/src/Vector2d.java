public class Vector2d {
    
    double x, y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDirection() {
        return Math.atan2(x, y);
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
