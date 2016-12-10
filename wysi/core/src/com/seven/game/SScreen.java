package com.seven.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.game_world.GameRender;
import com.seven.game.game_world.GameWorld;

public class SScreen implements Screen {
    GameRender render;
    GameWorld gameWorld;

    public SScreen() {
        gameWorld = new GameWorld();
        render = new GameRender(gameWorld);
        //Gdx.input.setInputProcessor(new InputHandler((BasicSpider) gameWorld.getGameObject()));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Gdx.app.log("GameScreen FPS", (1/delta) + "");
        render.render(delta);
        gameWorld.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
