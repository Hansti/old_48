package com.seven.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    public static Texture carpet;
    public static Texture spider;
    public static Texture texture;
    public static Animation birdAnimation;

    public static void load() {
        carpet = new Texture("kover.jpg");
        spider = new Texture("temp_spider.png");
        texture = new Texture("texture.png");
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        //Testtttttttttttttttttttttttttttttttttttttttttttttttttttt
        TextureRegion birdDown = new TextureRegion(texture, 136, 0, 17, 12);
        birdDown.flip(false, true);
        TextureRegion bird = new TextureRegion(texture, 153, 0, 17, 12);
        bird.flip(false, true);
        TextureRegion birdUp = new TextureRegion(texture, 170, 0, 17, 12);
        birdUp.flip(false, true);
        TextureRegion[] birds = {birdDown, bird, birdUp};
        birdAnimation = new Animation(1/15f, birds);
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public static void dispose() {
        carpet.dispose();
    }
}
