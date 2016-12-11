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

    public static void load() {
        carpet = new Texture("kover.jpg");
        badlogic = new Texture("badlogic.jpg");
        texture = new Texture("texture.png");
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);


        wall = new TextureRegion(texture, 0, 33, 136, 8);
        stoveOff = new TextureRegion(texture, 195, 0, 14, 14);
        stoveOff.flip(false, true);

        stoveOn = new TextureRegion(texture, 214, 0, 14, 14);
        stoveOn.flip(false, true);

        floor = new TextureRegion(texture, 137, 16, 18, 3);

        TextureRegion spiderDown = new TextureRegion(texture, 136, 0, 17, 12);
        spiderDown.flip(false, true);
        TextureRegion spider = new TextureRegion(texture, 153, 0, 17, 12);
        spider.flip(false, true);
        TextureRegion spiderUp = new TextureRegion(texture, 170, 0, 17, 12);
        spiderUp.flip(false, true);

        TextureRegion[] spiders = {spiderDown, spider, spiderUp};
        spiderAnimation = new Animation(1/15f, spiders);
        spiderAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public static void dispose() {
        carpet.dispose();
    }
}
