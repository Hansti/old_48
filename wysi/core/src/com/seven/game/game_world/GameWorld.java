package com.seven.game.game_world;

import com.seven.game.game_objects.furniture.Stove;
import com.seven.game.game_objects.game_object_state.StoveState;
import com.seven.game.game_objects.spider.BasicSpider;

public class GameWorld {
    private BasicSpider gameObject = new BasicSpider(10, null, 0, 0, 0, 30, 30);

    public GameWorld() {


        //Keeper.INSTANCE.addObject(new Stove(10,10, 50,50, 0,new StoveState()));
        Keeper.INSTANCE.addObject(new Stove(500,300, 50,50, 0,new StoveState()));
        Keeper.INSTANCE.addObject(gameObject);
    }

    public void update(float delta) {

    }

    public BasicSpider getGameObject() {
        return gameObject;
    }

    public void setGameObject(BasicSpider gameObject) {
        this.gameObject = gameObject;
    }
}
