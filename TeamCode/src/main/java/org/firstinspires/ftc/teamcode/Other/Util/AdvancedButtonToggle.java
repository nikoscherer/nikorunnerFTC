package org.firstinspires.ftc.teamcode.Other.Util;

public class AdvancedButtonToggle {

    public static class Type {
        public static final int DEFAULT = 0;
        public static final int CYCLE = 1;
    }


    public enum State {
        X_STATE, // 0
        Y_STATE, // 1
        Z_STATE // 2
    }


    public State currentState;

    boolean[] lastStates;

    int type;

    public AdvancedButtonToggle(int type) {
        this.type = type;

        currentState = State.X_STATE;

        lastStates[0] = false;
        lastStates[1] = false;
        lastStates[2] = false;
    }

    public void update(boolean Z_STATE, boolean Y_STATE, boolean X_STATE) {

        if(!(type == Type.CYCLE)) {

        } else {
            return;
        }

        lastStates[0] = Z_STATE;
        lastStates[1] = X_STATE;
        lastStates[2] = Y_STATE;
    }

//    public void updateCycle(boolean Z_STATE, boolean X_STATE) {
//
//        if(type == Type.CYCLE) {
//            if(Z_STATE && X_STATE) {
//                return;
//            } else if(Z_STATE && !lastStates[0]) {
//                currentState = State.Z_STATE;
//            } else if (X_STATE)
//        } else {
//            return;
//        }
//
//        lastStates[0] = Z_STATE;
//        lastStates[1] = X_STATE;
//        lastStates[2] = false;
//    }

    public void setState() {

    }

    public void getState() {

    }
}
