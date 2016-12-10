package com.seven.game.game_objects.furniture;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.StoveState;
import com.seven.game.game_objects.interactions.IAttack;
import com.seven.game.game_objects.interactions.IClimb;
import com.seven.game.game_objects.interactions.IHide;

import java.util.List;

public class Stove implements IGameObject, IHide, IClimb, IAttack {
    private float x;
    private float y;
    private float rotation;
    private float width;
    private float height;
    private StoveState state;

    private Boolean possibleToHide = true;
    private Boolean possibleToClime = true;

    public Stove(float x, float y, float width, float height, float rotation, StoveState state) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.state = state;
    }

    @Override
    public void update(float delta) {
        if(state.getState()){

        }
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
        float xTranslation = x;
        float yTranslation = y;

        if (direction.equals("UP")) {
            yTranslation = y - 2;
        } else if (direction.equals("DOWN")) {
            yTranslation = y + 2;
        } else if (direction.equals("LEFT")) {
            xTranslation = x - 2;
        } else if (direction.equals("RIGHT")) {
            xTranslation = x + 2;
        }

        Rectangle currentObjectRectangle = new Rectangle(xTranslation, yTranslation, width, height);

        for (IGameObject gameObject : gameObjectList) {
            if (!this.equals(gameObject)) {
                Rectangle gameObjectRectangle = new Rectangle(gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight());

                if (Intersector.overlaps(currentObjectRectangle, gameObjectRectangle)) {
                    return gameObject;
                }
            }
        }

        return null;
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public Boolean possibleToHide() {
        return possibleToHide;
    }

    @Override
    public Boolean possibleToClimb() {
        return possibleToClime;
    }

    @Override
    public void attack(IGameObject gameObject) {
        gameObject.takeDamage(10);
    }
}
