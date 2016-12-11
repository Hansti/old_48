package com.seven.game.game_objects.human;

import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.BasicHumanState;
import com.seven.game.game_objects.interactions.*;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.game_world.IKepper;
import com.seven.game.game_world.Keeper;
import com.seven.game.utils.AssetLoader;

import java.util.List;
import java.util.jar.Pack200;

public class BasicHuman implements IGameObject, IAttack, IClimb, IHide, IMove, IScared {
    private float velocity;
    private BasicHumanState state;
    private float x;
    private float y;
    private float targetX;
    private float targetY;
    private Boolean gotTarget = false;
    private float rotation;
    private float width;
    private float height;
    private float elapsedTime = 0;
    private Boolean isMoved;
    private Boolean isHide;
    private Boolean isClimb;
    private int life = 300;
    private Boolean lose = false;
    private int getScaredCounter = 60*5;
    private int flipOutCounter = 7 - 4;
    private BasicSpider targetSpider;

    public BasicHuman(BasicSpider targetSpider, float velocity, BasicHumanState state, float x, float y, float rotation, float width, float height) {
        this.velocity = velocity;
        this.state = state;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
        this.targetSpider = targetSpider;
    }

    public Boolean getLose() {
        return lose;
    }

    @Override
    public void getScared() {
        state.transitionToNewState("scared");
        velocity = 3;
    }

    public void getAngry() {
        state.transitionToNewState("angry");
        velocity = 0.5f;
    }

    public void getCalm() {
        state.transitionToNewState("calm");
        velocity = 0;
    }

    public void setTarget(float x, float y) {
        targetX = x;
        targetY = y;
        gotTarget = true;
    }

    @Override
    public Boolean possibleToHide() {
        return false;
    }

    @Override
    public Boolean possibleToClimb() {
        return true;
    }

    @Override
    public void attack(IDamage gameObject) {

    }

    public void setMoved(Boolean moved) {
        isMoved = moved;
    }

    @Override
    public void update(float delta) {
        if (life <= 0) {
            flipOutCounter--;
        }

        if (flipOutCounter <= 0) {
            lose = true;
        }

        if (state.getAngry()) {
            if (x < targetSpider.getX()) {
                moveRight("RIGHT", Keeper.INSTANCE);
            } else if (x > targetSpider.getX()) {
                moveLeft("LEFT", Keeper.INSTANCE);
            }

            if (y < targetSpider.getY()) {
                moveDown("DOWN", Keeper.INSTANCE);
            } else if (y > targetSpider.getY()) {
                moveUp("UP", Keeper.INSTANCE);
            }
        }

        Rectangle currentObjectRectangle = new Rectangle(x - width / 2, y - height /2, width+width, height+height);
        Rectangle speederObjectRectangle = new Rectangle(targetSpider.getX(), targetSpider.getY(), targetSpider.getWidth(), targetSpider.getHeight());


        if (Intersector.overlaps(currentObjectRectangle, speederObjectRectangle) && !targetSpider.getHide()) {
            if (state.getAngry()) {
                this.targetSpider.takeDamage(1);
            } else {
                this.life--;
            }
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
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.circulView, x - width / 2, y - height /2, width+width, height+height);
        spriteBatch.draw(AssetLoader.human, x, y, width, height);
        spriteBatch.end();
    }

    @Override
    public void moveUp(String direction, IKepper kepper) {
        isMoved = true;
        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            y -= 1 + velocity;
            isClimb = false;
            isHide = false;
        }
    }

    @Override
    public void moveDown(String direction, IKepper kepper) {
        isMoved = true;

        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            y += 1 + velocity;
            isClimb = false;
            isHide = false;
        }
    }

    @Override
    public void moveLeft(String direction, IKepper kepper) {
        isMoved = true;

        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            x -= 1 + velocity;
            isClimb = false;
            isHide = false;
        }
    }

    @Override
    public void moveRight(String direction, IKepper kepper) {
        isMoved = true;

        IGameObject collidedObject = checkCollision(direction, kepper.getAllObjects());

        if (collidedObject == null) {
            x += 1 + velocity;
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
