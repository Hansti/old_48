package com.seven.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
    public static Texture carpet;

    public static void load() {
        carpet = new Texture("kover.jpg");
    }

    public static void dispose() {
        carpet.dispose();
    }
}
