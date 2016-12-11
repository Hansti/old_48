package com.seven.game.game_world;

import com.seven.game.game_objects.IGameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Keeper implements IKepper {
    public static final Keeper INSTANCE = new Keeper();

    private List<IGameObject> objects;

    public Keeper() {
        objects = new CopyOnWriteArrayList<IGameObject>();
    }

    @Override
    public List<IGameObject> getAllObjects() {
        return objects;
    }

    @Override
    public void addObject(IGameObject object) {
        objects.add(object);
    }
}
