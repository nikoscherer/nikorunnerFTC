package Pathing;

import java.util.ArrayList;

import Geometry.*;

public class Path {
    ArrayList<PathSegment> pathSegments;

    static ArrayList<Path2d> path = new ArrayList<>();
    


    public Path(PathBuilder builder) {
        this.pathSegments = builder.segments;
    }

    /**
     * @return returns a trajectories start pose
     */
    public Pose2d start() {
        return path.get(0).getStartPose();
    }

    /** 
     * @return returns a trajectories end pose
     */
    public Pose2d end() {
        return path.get(path.size()).getEndPose();
    }

    public ArrayList<Path2d> getPath() {
        return path;
    }

    public static class PathBuilder {
        ArrayList<PathSegment> segments = new ArrayList<>();

        Pose2d startPose;
        Vector2d startTangent;

        public PathBuilder(Pose2d startPose, Vector2d startTangent) {
            this.startPose = startPose;
            this.startTangent = startTangent;
        }

        public Path build() {

            for (int i = 0; i < segments.size(); i++) {

                Pose2d initialPose;
                Vector2d initialTangent;

                // If first spline in Path, reset initial pose and tangent, otherwise, set to last spline end pose.
                // Also reset continuity to beginning spline.
                if(i == 0) {
                    initialPose = startPose;
                    initialTangent = startTangent;
                } else {
                    initialPose = segments.get(i - 1).getEndPose();
                    initialTangent = segments.get(i - 1).getTangents().getVector2();
                }

                initialTangent = initialPose.getVector2d().plus(initialTangent);

                SplineGenerator spline = new SplineGenerator(
                    initialPose, 
                    initialTangent,
                    segments.get(i).getEndPose().getVector2d().plus(segments.get(i).getTangents().getVector1()),
                    segments.get(i).getEndPose()
                );

                path.add(spline.getSpline());
            }

            return new Path(this);
        }

        // Splines
        /**
         * Create a control point in the spline.
         * If last control point in path, will not use last magnitude.
         * @param pose target robot pose
         * @param controlPoints control point lengths and rotation.
         * @return
         */
        public PathBuilder addControlPoint(Pose2d pose, BiVector2d controlPoints) {
            this.segments.add(new PathSegment(pose, controlPoints));
            return this;
        }
    }
}