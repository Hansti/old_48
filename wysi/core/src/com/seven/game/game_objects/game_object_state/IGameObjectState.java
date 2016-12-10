package com.seven.game.game_objects.game_object_state;

public interface IGameObjectState {
    void transitionToNewState(IGameObjectState gameObjectState);
}
