package com.seven.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.seven.game.utils.AssetLoader;

public class SGame extends Game{
    @Override
    public void create() {
        AssetLoader.load();
        AssetLoader.music.setLooping(true);
        AssetLoader.music.play();

        Gdx.app.log("SGame", "created");
        setScreen(new SScreen());
    }

    @Override
    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
}
