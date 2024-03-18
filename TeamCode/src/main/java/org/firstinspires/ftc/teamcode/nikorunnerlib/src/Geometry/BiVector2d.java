package Geometry;

import Other.Util;

public class BiVector2d {
    Vector2d vector1;
    Vector2d vector2;

    double direction;

    public BiVector2d(double mag1, double direction, double mag2) {
        this.direction = direction;
        this.vector1 = new Vector2d(mag1, direction);
        this.vector2 = new Vector2d(mag2, Util.getOppositeAngle(direction));
    }

    public Vector2d getVector1() {
        return vector1;
    }

    public Vector2d getVector2() {
        return vector2;
    }
}
