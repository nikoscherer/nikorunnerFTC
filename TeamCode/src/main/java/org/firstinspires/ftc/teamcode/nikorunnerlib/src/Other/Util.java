package Other;

public class Util {
    public static double getOppositeAngle(double rad) {
        double opposite = rad - Math.PI;
        if(opposite < -Math.PI) {
            opposite = opposite + (2 * Math.PI);
        } else if (opposite > Math.PI) {
            opposite = opposite - (2 * Math.PI);
        }
        return opposite;
    }
}
