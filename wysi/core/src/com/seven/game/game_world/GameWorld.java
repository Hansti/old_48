package com.seven.game.game_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.seven.game.game_objects.furniture.BasicWall;
import com.seven.game.game_objects.furniture.Stove;
import com.seven.game.game_objects.game_object_state.StoveState;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.utils.Settings;

public class GameWorld {
    private BasicSpider spider1 = new BasicSpider(10, null, 100, 100, 0, 30, 30);

    public GameWorld() {

        //Walls
        Keeper.INSTANCE.addObject(new BasicWall(0, 0, Settings.widthDisplay, 10, 0));
        Keeper.INSTANCE.addObject(new BasicWall(0, 0, 10, Settings.heightDisplay, 0));
        Keeper.INSTANCE.addObject(new BasicWall(Settings.widthDisplay - 10, 0, Settings.widthDisplay + 10, Settings.heightDisplay, 0));
        Keeper.INSTANCE.addObject(new BasicWall(0, Settings.heightDisplay - 10, Settings.widthDisplay, Settings.heightDisplay, 0));
        ///////

        Keeper.INSTANCE.addObject(new Stove(500,10, 50,50, 0,new StoveState()));
        Keeper.INSTANCE.addObject(spider1);
    }

    public void update(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            spider1.moveUp("UP", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            spider1.moveDown("DOWN", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            spider1.moveLeft("LEFT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spider1.moveRight("RIGHT", Keeper.INSTANCE);
        }
    }

}
