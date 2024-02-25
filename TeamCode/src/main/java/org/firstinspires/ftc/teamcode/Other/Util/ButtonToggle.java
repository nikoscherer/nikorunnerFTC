package org.firstinspires.ftc.teamcode.Other.Util;

public class ButtonToggle {

    private boolean currentState;
    private boolean lastPressed;

    public ButtonToggle() {
        currentState = false;
        lastPressed = false;
    }

    public void update(boolean pressed) {
        if(pressed && !lastPressed) {
            currentState = !currentState;
        }

        lastPressed = true;
    }

    public boolean getState() {
        return currentState;
    }
}
