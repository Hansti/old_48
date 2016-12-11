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
        spider1.setMoved(false);


        //Это блок движения, и да я знаю что я мудак
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            spider1.climbUp("UP", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            spider1.climbDown("DOWN", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            spider1.climbLeft("LEFT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            spider1.climbRight("RIGHT", Keeper.INSTANCE);
        }else if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            spider1.hideUp("UP", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            spider1.hideDown("DOWN", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            spider1.hideLeft("LEFT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            spider1.hideRight("RIGHT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            spider1.moveUp("UP", Keeper.INSTANCE);
            spider1.moveLeft("LEFT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spider1.moveUp("UP", Keeper.INSTANCE);
            spider1.moveRight("RIGHT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            spider1.moveDown("DOWN", Keeper.INSTANCE);
            spider1.moveLeft("LEFT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spider1.moveDown("DOWN", Keeper.INSTANCE);
            spider1.moveRight("RIGHT", Keeper.INSTANCE);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
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
