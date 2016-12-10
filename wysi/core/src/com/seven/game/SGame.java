package com.seven.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

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
