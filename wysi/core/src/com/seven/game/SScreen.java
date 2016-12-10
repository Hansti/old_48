package com.seven.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class SScreen implements Screen {
    float gameWidth = 600;
    float gameHeight = 400;

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.app.log("GameScreen FPS", (1/delta) + "");

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
