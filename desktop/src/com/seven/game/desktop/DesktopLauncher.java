package com.seven.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.seven.game.SGame;
import com.seven.game.utils.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Settings.title;
		config.width = Settings.widthDisplay;
		config.height = Settings.heightDisplay;
		new LwjglApplication(new SGame(), config);
	}
}
