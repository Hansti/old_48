package com.seven.game.game_objects.furniture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.interactions.IClimb;
import com.seven.game.game_objects.interactions.IHide;
import com.seven.game.utils.AssetLoader;

public class Tv implements IGameObject, IHide, IClimb {
    private float x;
    private float y;
    private float rotation;
    private float width;
    private float height;

    public Tv(float x, float y, float width, float height, float rotation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
    }

    @Override
    public Boolean possibleToHide() {
        return true;
    }

    @Override
    public Boolean possibleToClimb() {
        return true;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.disableBlending();
        spriteBatch.draw(AssetLoader.tv, x, y, width, height);
        spriteBatch.enableBlending();
        spriteBatch.end();
    }
}
