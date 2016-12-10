package com.seven.game.game_objects.spider;

import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.game_object_state.IGameObjectState;
import com.seven.game.game_objects.interactions.*;

public class BasicSpider implements IGameObject, IAttack, IClimb, IHide, IMove, IEat {
    private float velocity;
    private IGameObjectState state;
    private float x;
    private float y;
    private float width;
    private float height;

    public BasicSpider(float velocity, IGameObjectState state, float x, float y, float width, float height) {
        this.velocity = velocity;
        this.state = state;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public void setX(float x) {

    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public void setY(float y) {

    }

    @Override
    public float getWidth() {
        return 0;
    }

    @Override
    public void setWidth(float width) {

    }

    @Override
    public float getHeight() {
        return 0;
    }

    @Override
    public void setHeight(float height) {

    }

    @Override
    public float getRotation() {
        return 0;
    }

    @Override
    public void setRotation(float rotation) {

    }

    @Override
    public IGameObject checkCollision(String direction) {
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
