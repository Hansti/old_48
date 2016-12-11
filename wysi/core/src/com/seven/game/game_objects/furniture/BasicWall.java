package com.seven.game.game_objects.furniture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.utils.AssetLoader;

import java.util.List;

public class BasicWall implements IGameObject{
    private float x;
    private float y;
    private float rotation;
    private float width;
    private float height;

    public BasicWall(float x, float y, float width, float height, float rotation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
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
    public IGameObject checkCollision(String direction, List<IGameObject> gameObjectList) {
        return null;
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.disableBlending();
        spriteBatch.draw(AssetLoader.wall, x, y, width, height);
        spriteBatch.enableBlending();
        spriteBatch.end();
    }
}
