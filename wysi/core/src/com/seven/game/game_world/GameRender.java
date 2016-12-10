package com.seven.game.game_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.seven.game.game_objects.IGameObject;
import com.seven.game.utils.AssetLoader;
import com.seven.game.utils.Settings;

public class GameRender {
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private GameWorld myWorld;

    public GameRender(GameWorld gameWorld) {
        myWorld = gameWorld;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, Settings.widthDisplay, Settings.heightDisplay);

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
        batcher.draw(AssetLoader.carpet, 0, 0, Settings.widthDisplay, Settings.heightDisplay);
        batcher.enableBlending();
        batcher.end();


        for (IGameObject object: Keeper.INSTANCE.getAllObjects()) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(1, 1, 1, 1);
            shapeRenderer.rect(object.getX(), object.getY(), object.getWidth(), object.getHeight());
            shapeRenderer.end();
        }
    }
}
