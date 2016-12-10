package com.seven.game.game_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.seven.game.utils.AssetLoader;

public class GameRender {
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private GameWorld myWorld;

    public GameRender(GameWorld gameWorld) {
        myWorld = gameWorld;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, 800, 600);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batcher.begin();
        batcher.disableBlending();
        batcher.draw(AssetLoader.carpet, 0, 0, 800, 600);
        batcher.enableBlending();
        batcher.end();
    }
}
