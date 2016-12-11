package com.seven.game.game_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.game_objects.spider.BasicSpider;
import com.seven.game.utils.AssetLoader;
import com.seven.game.utils.Settings;

public class GameRender {
    private OrthographicCamera camera;
    private SpriteBatch batcher;

    public GameRender(GameWorld gameWorld) {
        camera = new OrthographicCamera();
        camera.setToOrtho(true, Settings.widthDisplay/2, Settings.heightDisplay/2);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
    }

    public void render(float runTime, GameWorld world) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if (world.getGameOver()) {
            batcher.begin();
            batcher.draw(AssetLoader.gameOver, 0, 0, Settings.widthDisplay/2, Settings.heightDisplay/2);
            batcher.end();
        } else {
            batcher.begin();
            batcher.disableBlending();
            batcher.draw(AssetLoader.floor, 0, 0, Settings.widthDisplay / 2, Settings.heightDisplay / 2);
            batcher.draw(AssetLoader.carpet, 150, 130);
            batcher.enableBlending();
            batcher.end();

            for (IGameObject object : Keeper.INSTANCE.getAllObjects()) {
                object.render(batcher);
            }
        }
    }
}
