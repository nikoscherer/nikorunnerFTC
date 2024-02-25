package org.firstinspires.ftc.teamcode.NikoRunner.src;

public class Example {
    public static void main(String[] args) {
        
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));

        Trajectory traj1 = new Trajectory.TrajectoryBuilder(startPose)
            .splineToProfiledHeading(new Pose2d(5, 0, 0), new Rotation2d(Math.toRadians(-90)), 1)
            .splineToProfiledHeading(new Pose2d(15, 10, 0), new Rotation2d(Math.toRadians(-90)), 8)
            .splineToProfiledHeading(new Pose2d(20, 10, 0), new Rotation2d(Math.toRadians(-90)), 1)
            .lineToProfiledHeading(new Pose2d(20, 20, 0))
            .build();
    }
}
