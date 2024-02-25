package org.firstinspires.ftc.teamcode.Other.Util;

public class MathUtil {

    public double AngleWrap(double angle, double wrapAmount) {
        while (angle > wrapAmount) {
            angle = angle - wrapAmount;
        }

        return angle;
    }
}
