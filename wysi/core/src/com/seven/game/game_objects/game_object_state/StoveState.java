package com.seven.game.game_objects.game_object_state;

public class StoveState implements IGameObjectState {
    private Boolean isActive = false;

    @Override
    public void transitionToNewState(String state) {
        isActive = state.equals("active");
    }

    public Boolean getState() {
        return isActive;
    }
}
