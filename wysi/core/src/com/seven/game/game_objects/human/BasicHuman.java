package com.seven.game.game_objects.human;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.IGameObjectState;
import com.seven.game.game_objects.interactions.*;
import com.seven.game.game_world.IKepper;

import java.util.List;

public class BasicHuman implements IGameObject, IAttack, IClimb, IHide, IMove, IScared {
    private float velocity;
    private IGameObjectState state;
    private float x;
    private float y;
    private float rotation;
    private float width;
    private float height;
    private float elapsedTime = 0;
    private Boolean isMoved;
    private Boolean isHide;
    private Boolean isClimb;
    private int life = 100;

    public BasicHuman(float velocity, IGameObjectState state, float x, float y, float rotation, float width, float height, float elapsedTime, Boolean isMoved, Boolean isHide, Boolean isClimb, int life) {
        this.velocity = velocity;
        this.state = state;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
        this.elapsedTime = elapsedTime;
        this.isMoved = isMoved;
        this.isHide = isHide;
        this.isClimb = isClimb;
        this.life = life;
    }

    @Override
    public void getScared() {

    }

    @Override
    public Boolean possibleToHide() {
        return false;
    }

    @Override
    public Boolean possibleToClimb() {
        return false;
    }

    @Override
    public void attack(IDamage gameObject) {

    }

    public void setMoved(Boolean moved) {
        isMoved = moved;
    }

    @Override
    public void update(float delta) {
        if (life <= 0){
            Gdx.app.exit();
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
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void moveUp(String direction, IKepper kepper) {
        isMoved = true;
        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            y -= 2;
            isClimb = false;
            isHide = false;
        }
    }

    @Override
    public void moveDown(String direction, IKepper kepper) {
        isMoved = true;

        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            y += 2;
            isClimb = false;
            isHide = false;
        }
    }

    @Override
    public void moveLeft(String direction, IKepper kepper) {
        isMoved = true;

        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            x -= 2;
            isClimb = false;
            isHide = false;
        }
    }

    @Override
    public void moveRight(String direction, IKepper kepper) {
        isMoved = true;

        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            x += 2;
            isClimb = false;
            isHide = false;
        }
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
}
