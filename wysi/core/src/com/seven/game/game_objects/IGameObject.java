package com.seven.game.game_objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.List;

public interface IGameObject {
    void update(final float delta);

    float getX();

    void setX(final float x);

    float getY();

    void setY(final float y);

    float getWidth();

    void setWidth(final float width);

    float getHeight();

    void setHeight(final float height);

    float getRotation();

    void setRotation(final float rotation);

    IGameObject checkCollision(String direction, List<IGameObject> gameObjectList);

    void takeDamage(int damage);

    void render(SpriteBatch spriteBatch);
}
