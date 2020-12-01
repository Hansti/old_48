package com.seven.game.game_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.furniture.BasicWall;
import com.seven.game.game_objects.furniture.Stove;
import com.seven.game.game_objects.furniture.Tv;
import com.seven.game.game_objects.game_object_state.BasicHumanState;
import com.seven.game.game_objects.game_object_state.StoveState;
import com.seven.game.game_objects.human.BasicHuman;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.utils.Settings;

public class GameWorld {
    private BasicHuman human1;
    private BasicSpider spider1;
    private Boolean gameOver = false;
    private Boolean gameWin = false;

    public GameWorld() {
        createGame();
    }

    public Boolean getGameWin() {
        return gameWin;
    }

    public void createGame() {
        gameOver = false;
        gameWin = false;
        spider1 = new BasicSpider(10, null, 100, 100, 0, 15, 15);
        human1 = new BasicHuman(spider1, 0, new BasicHumanState(), 300, 300, 0, 30, 30);
        human1.getCalm();

        Keeper.INSTANCE.addObject(new BasicWall(0, 0, (Settings.widthDisplay / 2), 10, 0));
        Keeper.INSTANCE.addObject(new BasicWall(0, 0, 10, (Settings.heightDisplay / 2), 0));
        Keeper.INSTANCE.addObject(new BasicWall(Settings.widthDisplay / 2 - 10, 0, (Settings.widthDisplay / 2) + 10, Settings.heightDisplay /2, 0));
        Keeper.INSTANCE.addObject(new BasicWall(0, Settings.heightDisplay / 2 - 10, (Settings.widthDisplay / 2), Settings.heightDisplay / 2, 0));

        Keeper.INSTANCE.addObject(new Tv(40, 40, 30, 30, 0));
        Keeper.INSTANCE.addObject(new Stove(500,10, 50,50, 0,new StoveState()));
        Keeper.INSTANCE.addObject(spider1);


        Keeper.INSTANCE.addObject(human1);
    }

    public void disposeGame() {
        for(IGameObject object: Keeper.INSTANCE.getAllObjects()) {
            Keeper.INSTANCE.getAllObjects().remove(object);
        }
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public void update(float delta) {
        spider1.setMoved(false);

        if(human1.getLose()) {
            gameWin = true;
            if (Gdx.input.isKeyPressed(Input.Keys.R)) {
                disposeGame();
                createGame();
            }
        }

        if (spider1.getDead()) {
            gameOver = true;
            if (Gdx.input.isKeyPressed(Input.Keys.R)) {
                disposeGame();
                createGame();
            }
        } else {
            //Это блок движения, и да я знаю что я мудак
            if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                spider1.climbUp("UP", Keeper.INSTANCE);
            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                spider1.climbDown("DOWN", Keeper.INSTANCE);
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                spider1.climbLeft("LEFT", Keeper.INSTANCE);
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                spider1.climbRight("RIGHT", Keeper.INSTANCE);
            } else if (Gdx.input.isKeyPressed(Input.Keys.UP) && Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
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

            for (IGameObject object : Keeper.INSTANCE.getAllObjects()) {
                object.update(delta);
            }
        }
    }

}
