package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SwerveDrive {

    public DcMotorEx frontLeft, frontRight, backLeft, backRight;


    public SwerveDrive (HardwareMap hardwareMap) {

        frontLeft = hardwareMap.get(DcMotorEx.class, "FrontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "FrontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "BackLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "BackRight");

    }

    public void drive(double LY, double LX, double RX) {

        setHeading(LY, LX, RX);
    }

    public void setHeading(double x, double y, double yaw) {

    }
}
