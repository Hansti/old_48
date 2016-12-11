package com.seven.game.game_objects.furniture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.StoveState;
import com.seven.game.game_objects.interactions.IAttack;
import com.seven.game.game_objects.interactions.IClimb;
import com.seven.game.game_objects.interactions.IDamage;
import com.seven.game.game_objects.interactions.IHide;
import com.seven.game.utils.AssetLoader;

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
        if (Gdx.input.isKeyPressed(Input.Keys.F12)) {
            if (state.getState()) {
                state.transitionToNewState("unactiv");

            } else {
                state.transitionToNewState("active");
            }
        }

        if (state.getState()) {
            spriteBatch.begin();
            spriteBatch.disableBlending();
            spriteBatch.draw(AssetLoader.stoveOn, x, y, width, height);
            spriteBatch.enableBlending();
            spriteBatch.end();
        } else {
            spriteBatch.begin();
            spriteBatch.disableBlending();
            spriteBatch.draw(AssetLoader.stoveOff, x, y, width, height);
            spriteBatch.enableBlending();
            spriteBatch.end();
        }
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
    public void attack(IDamage gameObject) {
        gameObject.takeDamage(10);
    }
}
