package com.seven.game.game_objects.human;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.BasicHumanState;
import com.seven.game.game_objects.interactions.*;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.game_world.IKepper;
import com.seven.game.game_world.Keeper;
import com.seven.game.utils.AssetLoader;
import com.seven.game.utils.Settings;

import java.util.List;
import java.util.Random;

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
    private int life = 60;
    private Boolean lose = false;
    private int getScaredCounter = 60*5;
    private int flipOutCounter = 7 - 3;
    private BasicSpider targetSpider;
    private int moveToCounter = 150;
    private boolean nextMove = true;
    private int randomX = 1;
    private int randomY = 1;
    private int timeAngry = 60*30;
    private int getAngryCounter = 120;

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
        Rectangle currentObjectRectangle = new Rectangle(x - width / 2 , y - height /2, width+width, height+height);
        Rectangle speederObjectRectangle = new Rectangle(targetSpider.getX(), targetSpider.getY(), targetSpider.getWidth(), targetSpider.getHeight());
        Gdx.app.log("life boss", "Life Boss On = " + String.valueOf(life));
        Gdx.app.log("life boss", "Life Boss Main = " + String.valueOf(flipOutCounter));

        if (Intersector.overlaps(currentObjectRectangle, speederObjectRectangle) && !targetSpider.getHide()) {
            if (getAngryCounter < 1) {
                if (state.getCalm()) {
                    state.transitionToNewState("angry");
                }
                getAngryCounter = 120;
            } else {
                getAngryCounter--;
            }
            if (state.getAngry()) {
                this.targetSpider.takeDamage(1);
            } else {
                this.life--;
            }
        }


        Random random = new Random();
        if (life <= 0) {
            flipOutCounter--;
            life = 60;
        }

        if (flipOutCounter <= 0) {
            lose = true;
        }

        if (timeAngry > 0) {
            timeAngry--;
        } else {
            timeAngry = 60*60;
            state.transitionToNewState("calm");
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
        } else if (state.getCalm() == true) {

            if (nextMove) {
                randomX = random.nextInt(Settings.widthDisplay / 2) + 1;
                randomY = random.nextInt(Settings.heightDisplay / 2) + 1;
            }



            moveTo(randomX, randomY);
        }
    }

    public void moveTo(float targetX, float targetY) {
        if (moveToCounter > 0) {
            if (x < targetX) {
                moveRight("RIGHT", Keeper.INSTANCE);
            } else if (x > targetX) {
                moveLeft("LEFT", Keeper.INSTANCE);
            }

            if (y < targetY) {
                moveDown("DOWN", Keeper.INSTANCE);
            } else if (y > targetY) {
                moveUp("UP", Keeper.INSTANCE);
            }
            --moveToCounter;
            nextMove = false;
        } else {
            nextMove = true;
            moveToCounter = 150;
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

        spriteBatch.draw(AssetLoader.human, x, y, width, height);

        if (state.getCalm()){
            spriteBatch.draw(AssetLoader.circulView, x - width / 2, y - height /2, width+width, height+height);
        }
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
