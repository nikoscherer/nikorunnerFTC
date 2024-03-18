package Pathing;

import java.util.ArrayList;

import Geometry.*;

public class PathSegment {
    
    Pose2d pose;
    BiVector2d tangent;

    public PathSegment(Pose2d pose, BiVector2d tangent) {
        this.pose = pose;
        this.tangent = tangent;
    }

    public BiVector2d getTangents() {
        return tangent;
    }

    public Pose2d getEndPose() {
        return pose;
    }
}
