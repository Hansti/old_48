package com.seven.game.game_objects.game_object_state;

public class BasicHumanState implements IGameObjectState {
    public Boolean getScared() {
        return isScared;
    }

    public Boolean getAngry() {
        return isAngry;
    }

    public Boolean getCalm() {
        return isCalm;
    }

    private Boolean isScared = false;
    private Boolean isAngry = false;
    private Boolean isCalm = true;

    @Override
    public void transitionToNewState(String string) {
        if (string.equals("angry")) {
            isAngry = true;
            isScared = false;
            isCalm = false;
        } else if (string.equals("scared")) {
            isAngry = false;
            isScared = true;
            isCalm = false;
        } else  if (string.equals("calm")) {
            isAngry = false;
            isScared = false;
            isCalm = true;
        }
    }
}
