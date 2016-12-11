package com.seven.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    public static Texture carpet;
    public static Texture badlogic;
    public static Texture texture;
    public static TextureRegion wall;
    public static TextureRegion stoveOff;
    public static TextureRegion stoveOn;
    public static TextureRegion floor;
    public static Animation spiderAnimation;
    public static TextureRegion staticSpider;
    public static TextureRegion tv;
    public static TextureRegion gameOver;
    public static TextureRegion human;
    public static TextureRegion circulView;

    public static Animation shadowSpider;

    public static void load() {
        carpet = new Texture("kover.jpg");
        badlogic = new Texture("badlogic.jpg");
        texture = new Texture("texture.png");
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);


        Texture gameOverTexture = new Texture("GameOver.png");
        gameOver = new TextureRegion(gameOverTexture, 400, 257);
        gameOver.flip(false, true);

        human = new TextureRegion(texture, 221, 23, 14, 7);
        circulView = new TextureRegion(texture, 221, 32, 16, 16);

        wall = new TextureRegion(texture, 0, 33, 136, 8);
        tv = new TextureRegion(texture, 195, 21, 14, 13);
        stoveOff = new TextureRegion(texture, 195, 0, 14, 14);
        stoveOff.flip(false, true);

        stoveOn = new TextureRegion(texture, 214, 0, 14, 14);
        stoveOn.flip(false, true);

        floor = new TextureRegion(texture, 137, 16, 17, 3);

        TextureRegion spiderDown = new TextureRegion(texture, 136, 0, 17, 12);
        spiderDown.flip(false, true);
        TextureRegion spider = new TextureRegion(texture, 153, 0, 17, 12);
        spider.flip(false, true);
        TextureRegion spiderUp = new TextureRegion(texture, 170, 0, 17, 12);
        spiderUp.flip(false, true);

        staticSpider = spiderDown;

        TextureRegion shadowSpiderFirst = new TextureRegion(texture, 138, 25, 17, 12);
        shadowSpiderFirst.flip(false, true);
        TextureRegion shadowSpiderSecond = new TextureRegion(texture, 156, 25, 17, 12);
        shadowSpiderSecond.flip(false, true);
        TextureRegion shadowSpiderThird = new TextureRegion(texture, 173, 25, 17, 12);
        shadowSpiderThird.flip(false, true);

        TextureRegion[] spiders = {spiderDown, spider, spiderUp};
        TextureRegion[] shadowSpiders = {shadowSpiderFirst, shadowSpiderSecond, shadowSpiderThird};

        spiderAnimation = new Animation(1/15f, spiders);
        shadowSpider = new Animation(1/15f, shadowSpiders);
        spiderAnimation.setPlayMode(Animation.PlayMode.LOOP);
        shadowSpider.setPlayMode(Animation.PlayMode.LOOP);
    }

    public static void dispose() {
        carpet.dispose();
    }
}
