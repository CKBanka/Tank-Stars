package com.mygdx.game;

import Utils.GameData;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.Menu;

import java.util.ArrayList;

public class GameMain extends Game {
	public static final int WIDTH=1200;
	public static final int HEIGHT=675;
	public static final String title="Tank Stars";
	public static ArrayList<GameData> Games=new ArrayList<>();
	SpriteBatch batch;
	Texture img;
	private Stage stage;
	private GameStateManager gsm;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm=new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new Menu(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
