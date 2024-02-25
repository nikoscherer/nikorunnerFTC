package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.NikoRunner.src.Pose2d;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Trajectory;
import org.firstinspires.ftc.teamcode.NikoRunner.src.Vector2d;

public class MecanumDrive {

    DcMotorEx fl, fr, bl, br;

    boolean FOD;

    public MecanumDrive(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotorEx.class, "FrontLeft");
        fr = hardwareMap.get(DcMotorEx.class, "FrontRight");
        bl = hardwareMap.get(DcMotorEx.class, "BackLeft");
        br = hardwareMap.get(DcMotorEx.class, "BackRight");
    }

    public void update(boolean FOD) {
        this.FOD = FOD;
    }

    public void updateDrive(double LY, double LX, double RX, double currentHeading) {
        Vector2d driveVector = new Vector2d(LY, LX);

        if(FOD) {
            driveVector.rotateVector(currentHeading);
        }

        drive(driveVector, RX);
    }

    public void drive(Vector2d driveVector, double yaw) {
        fl.setPower(driveVector.getX() + driveVector.getY() + yaw);
        fr.setPower(driveVector.getX() - driveVector.getY() - yaw);
        bl.setPower(driveVector.getX() - driveVector.getY() + yaw);
        br.setPower(driveVector.getX() + driveVector.getY() - yaw);
    }


    // AUTONOMOUS

    Pose2d allowedError = new Pose2d(.5, .5, 5);
//    double timeError = 1000; for when we will calculate estimated time to target pose


    public void followTrajectory(Trajectory trajectory) {

    }
}


// WOLFPACK EQUATION
/*
    r = ((x'2 + y'2) ^ 3/2 ) / (x' * y'' - y' * x'')

    X = x(t)
    Y = y(t)

    X' = dx(t)/dt
    Y' = dy(t)/dt

 */
