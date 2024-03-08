package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.util.List;

public class RobotBase {

    HardwareMap hardwareMap;

    List<LynxModule> allHubs;
    BNO055IMU imu;

    public Orientation robotOrientation;
    public AngularVelocity robotAngularVel;

    MecanumDrive drive;

    public RobotBase(HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;

        imu = hardwareMap.get(BNO055IMU.class, "imu");

        imu.initialize(new BNO055IMU.Parameters());

        robotOrientation = imu.getAngularOrientation();
        robotAngularVel = imu.getAngularVelocity();

        drive = new MecanumDrive(hardwareMap);


        allHubs = hardwareMap.getAll(LynxModule.class);

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }

    public void update() {
        

        drive.update(false, )
    }
}
