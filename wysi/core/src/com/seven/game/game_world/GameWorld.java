package com.seven.game.game_world;

import com.seven.game.game_objects.furniture.Stove;
import com.seven.game.game_objects.game_object_state.StoveState;

public class GameWorld {
    public GameWorld() {
        Keeper.INSTANCE.addObject(new Stove(10,10, 50,50, 0,new StoveState()));
        Keeper.INSTANCE.addObject(new Stove(300,300, 50,50, 0,new StoveState()));
    }

    public void update(float delta) {

    }
}
