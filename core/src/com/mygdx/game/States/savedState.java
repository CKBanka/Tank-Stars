package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameMain;

public class savedState extends State{
    private Texture background;
    private Texture loadBar;
    private Texture exitBtn;
    private Texture gameImg;
    public savedState(GameStateManager gam) {
        super(gam);
        background=new Texture("loadGameScreen.png");
        loadBar=new Texture("loadGameBar.png");
        exitBtn=new Texture("exit.png");
        gameImg=new Texture("noSavedGame.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new Menu(gam));
            dispose();
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
    }

    @Override
    public void dispose() {

    }
}
