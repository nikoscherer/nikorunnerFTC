package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Other.RobotBase;
import org.firstinspires.ftc.teamcode.Other.Util.AdvancedButtonToggle;

public class TeleOp extends LinearOpMode {

    RobotBase robot;

    AdvancedButtonToggle state;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new RobotBase(hardwareMap);

        


        waitForStart();


    }

}
