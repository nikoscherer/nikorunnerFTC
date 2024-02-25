package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.Other.SwerveDrive;

public class RobotBase {

    public MecanumDrive drive;

    public RobotBase(HardwareMap hardwareMap) {
        drive = new MecanumDrive(hardwareMap);



        for (LynxModule module : hardwareMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
    }
}
