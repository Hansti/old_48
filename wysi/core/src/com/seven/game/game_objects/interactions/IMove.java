package com.seven.game.game_objects.interactions;

import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_world.IKepper;

import java.util.List;

public interface IMove {
    void moveUp(String direction, IKepper kepper);
    void moveDown(String direction, IKepper kepper);
    void moveLeft(String direction, IKepper kepper);
    void moveRight(String direction, IKepper kepper);

    IGameObject checkCollision(String direction, List<IGameObject> gameObjectList);
}
