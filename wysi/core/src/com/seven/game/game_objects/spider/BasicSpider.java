package com.seven.game.game_objects.spider;

import com.badlogic.gdx.math.Rectangle;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.IGameObjectState;
import com.seven.game.game_objects.interactions.*;

import java.util.List;

public class BasicSpider implements IGameObject, IAttack, IClimb, IHide, IMove, IEat {
    private float velocity;
    private IGameObjectState state;
    private float x;
    private float y;
    private float rotation;
    private float width;
    private float height;

    public BasicSpider(float velocity, IGameObjectState state, float x, float y, float rotation, float width, float height) {
        this.velocity = velocity;
        this.state = state;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
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
        float xTranslation = 0;
        float yTranslation = 0;

        if (direction.equals("UP")) {
            yTranslation = y - height;
        } else if (direction.equals("DOWN")) {
            yTranslation = y + height;
        } else if (direction.equals("LEFT")) {
            xTranslation = x - width;
        } else if (direction.equals("RIGHT")) {
            xTranslation = x + width;
        }

        for (IGameObject gameObject : gameObjectList) {
            Rectangle spiderRectangle = new Rectangle(xTranslation, yTranslation, width, height);
            Rectangle gameObjectRectangle = new Rectangle(gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight());

            if (spiderRectangle.overlaps(gameObjectRectangle)) {
                return gameObject;
            }
        }

        return null;
    }

    @Override
    public void moveUp() {
    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public Boolean possibleToHide() {
        return null;
    }

    @Override
    public Boolean possibleToClimb() {
        return null;
    }

    @Override
    public void eat(IGameObject gameObject) {

    }

    @Override
    public void attack(IGameObject gameObject) {

    }
}
