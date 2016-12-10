package com.seven.game.game_world;

import com.seven.game.game_objects.IGameObject;

import java.util.List;

/**
 * Created by hanst on 10.12.16.
 */
public interface IKepper {
    List<IGameObject> getAllObjects();
    void addObject(IGameObject object);
}
