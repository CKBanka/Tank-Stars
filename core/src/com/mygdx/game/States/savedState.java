package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.GameMain;

import java.awt.*;

public class savedState extends State{
    private Texture background;
    private Texture loadBar;
    private Texture exitBtn;
    private Texture gameImg;
    Rectangle r1;
    ShapeRenderer sr;
    public savedState(GameStateManager gam) {
        super(gam);
        background=new Texture("loadGameScreen.png");
        loadBar=new Texture("loadGameBar.png");
        exitBtn=new Texture("exit.png");
        gameImg=new Texture("noSavedGame.png");
        sr=new ShapeRenderer();
        r1=new Rectangle(40,30,60,60);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new Menu2(gam));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch b) {
        b.begin();
        b.draw(background,0,0, GameMain.WIDTH,GameMain.HEIGHT);
//        b.draw(loadBar,30,GameMain.HEIGHT/2+200);
//        b.draw(loadBar,30,GameMain.HEIGHT/2+200);
//        b.draw(exitBtn,GameMain.WIDTH-300,GameMain.HEIGHT/2-200);
        b.draw(gameImg,300,180,600,400);
        b.end();
//        sr.begin(ShapeRenderer.ShapeType.Filled);
//        sr.rect(40,30,60,60);
//        sr.end();
    }

    @Override
    public void dispose() {

    }
}
