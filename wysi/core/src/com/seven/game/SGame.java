package com.seven.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.AssetLoader;

public class SGame extends Game{
    @Override
    public void create() {
        //AssetLoader.load();
        Gdx.app.log("SGame", "created");
        setScreen(new SScreen());
    }

    @Override
    public void dispose(){
        super.dispose();
        //AssetLoader.dispose();
    }
}
