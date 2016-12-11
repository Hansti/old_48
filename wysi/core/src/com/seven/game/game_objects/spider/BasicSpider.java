package com.seven.game.game_objects.spider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.IGameObjectState;
import com.seven.game.game_objects.interactions.*;
import com.seven.game.game_world.GameRender;
import com.seven.game.game_world.IKepper;
import com.seven.game.utils.AssetLoader;
import com.seven.game.utils.Settings;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class BasicSpider implements IGameObject, IAttack, IClimb, IHide, IMove, IEat {
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

    public BasicSpider(float velocity, IGameObjectState state, float x, float y, float rotation, float width, float height) {
        this.velocity = velocity;
        this.state = state;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
        isMoved = false;
        isHide = false;
        isClimb = false;
    }

    public void climbUp(String direction, IKepper kepper) {
        isMoved = true;
        IClimb collidedObject = (IClimb) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToClimb()) {
            y -= 2;
            isClimb = true;
        }
    }

    public void climbDown(String direction, IKepper kepper) {
        isMoved = true;
        IClimb collidedObject = (IClimb) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToClimb()) {
            y += 2;
            isClimb = true;
        }
    }

    public void climbLeft(String direction, IKepper kepper) {
        isMoved = true;
        IClimb collidedObject = (IClimb) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToClimb()) {
            x -= 2;
            isClimb = true;
        }
    }

    public void climbRight(String direction, IKepper kepper) {
        isMoved = true;
        IClimb collidedObject = (IClimb) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToClimb()) {
            x += 2;
            isClimb = true;
        }
    }

    public void hideUp(String direction, IKepper kepper) {
        isMoved = true;
        IHide collidedObject = (IHide) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToHide()) {
            y -= 2;
            isHide = true;
        }
    }

    public void hideDown(String direction, IKepper kepper) {
        isMoved = true;
        IHide collidedObject = (IHide) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToHide()) {
            y += 2;
            isHide = true;
        }
    }

    public void hideLeft(String direction, IKepper kepper) {
        isMoved = true;
        IHide collidedObject = (IHide) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToHide()) {
            x -= 2;
            isHide = true;
        }
    }

    public void hideRight(String direction, IKepper kepper) {
        isMoved = true;
        IHide collidedObject = (IHide) checkCollision(direction, kepper.getAllObjects());

        if (collidedObject != null && collidedObject.possibleToHide()) {
            x += 2;
            isHide = true;
        }
    }

    public void setHide(Boolean hide) {
        isHide = hide;
    }

    public Boolean getHide() {
        return isHide;
    }

    public void setMoved(Boolean moved) {
        isMoved = moved;
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
    public void render(SpriteBatch spriteBatch) {
        if (isHide){
            spriteBatch.begin();
            elapsedTime += Gdx.graphics.getDeltaTime();
            spriteBatch.disableBlending();
            spriteBatch.draw(AssetLoader.spiderAnimation.getKeyFrame(elapsedTime, true), x, y, width, height);
            spriteBatch.end();
        } else if (isMoved) {
            spriteBatch.begin();
            elapsedTime += Gdx.graphics.getDeltaTime();
            spriteBatch.draw(AssetLoader.spiderAnimation.getKeyFrame(elapsedTime, true), x, y, width, height);
            spriteBatch.end();
        } else {
            spriteBatch.begin();
            spriteBatch.draw(AssetLoader.staticSpider, x, y, width, height);
            spriteBatch.end();
        }
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
    public Boolean possibleToHide() {
        return false;
    }

    @Override
    public Boolean possibleToClimb() {
        return false;
    }

    @Override
    public void eat(IGameObject gameObject) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicSpider)) return false;

        BasicSpider that = (BasicSpider) o;

        if (Float.compare(that.velocity, velocity) != 0) return false;
        if (Float.compare(that.getX(), getX()) != 0) return false;
        if (Float.compare(that.getY(), getY()) != 0) return false;
        if (Float.compare(that.getRotation(), getRotation()) != 0) return false;
        if (Float.compare(that.getWidth(), getWidth()) != 0) return false;
        if (Float.compare(that.getHeight(), getHeight()) != 0) return false;
        return state != null ? state.equals(that.state) : that.state == null;

    }

    @Override
    public int hashCode() {
        int result = (velocity != +0.0f ? Float.floatToIntBits(velocity) : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (getX() != +0.0f ? Float.floatToIntBits(getX()) : 0);
        result = 31 * result + (getY() != +0.0f ? Float.floatToIntBits(getY()) : 0);
        result = 31 * result + (getRotation() != +0.0f ? Float.floatToIntBits(getRotation()) : 0);
        result = 31 * result + (getWidth() != +0.0f ? Float.floatToIntBits(getWidth()) : 0);
        result = 31 * result + (getHeight() != +0.0f ? Float.floatToIntBits(getHeight()) : 0);
        return result;
    }

    @Override
    public void attack(IDamage gameObject) {

    }
}
