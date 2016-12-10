package com.seven.game.utils;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.game_world.Keeper;

public class InputHandler implements InputProcessor {

    private BasicSpider spider;

    public InputHandler(BasicSpider spider) {
        this.spider = spider;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.UP) {
            spider.moveUp("UP", Keeper.INSTANCE);
        } else if (keycode == Input.Keys.DOWN) {
            spider.moveDown("DOWN", Keeper.INSTANCE);
        } else if (keycode == Input.Keys.LEFT) {
            spider.moveLeft("LEFT", Keeper.INSTANCE);
        } else if (keycode == Input.Keys.RIGHT) {
            spider.moveRight("RIGHT", Keeper.INSTANCE);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
