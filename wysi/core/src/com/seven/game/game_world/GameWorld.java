package com.seven.game.game_world;

import com.seven.game.game_objects.furniture.BasicWall;
import com.seven.game.game_objects.furniture.Stove;
import com.seven.game.game_objects.game_object_state.StoveState;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.utils.Settings;

public class GameWorld {
    private BasicSpider gameObject = new BasicSpider(10, null, 100, 100, 0, 30, 30);

    public GameWorld() {

        Keeper.INSTANCE.addObject(new BasicWall(0, 0, Settings.widthDisplay, 30, 0));
        Keeper.INSTANCE.addObject(new BasicWall(0, 0, 30, Settings.heightDisplay, 0));
        Keeper.INSTANCE.addObject(new BasicWall(Settings.widthDisplay - 30, 0, Settings.widthDisplay + 30, Settings.heightDisplay, 0));
        Keeper.INSTANCE.addObject(new BasicWall(0, Settings.heightDisplay - 30, Settings.widthDisplay, Settings.heightDisplay, 0));

        Keeper.INSTANCE.addObject(new Stove(500,300, 50,50, 0,new StoveState()));
        Keeper.INSTANCE.addObject(gameObject);
    }

    public void update(float delta) {
    //Тут был руслан, и будем переключать состояния
    }

    public BasicSpider getGameObject() {
        return gameObject;
    }

    public void setGameObject(BasicSpider gameObject) {
        this.gameObject = gameObject;
    }
}
