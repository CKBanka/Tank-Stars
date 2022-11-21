package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameMain;

public class Menu extends State{
    private Texture background;
    private Texture playBtn;
    private Texture ResumeBtn;
    private Texture Exit;


    public Menu(GameStateManager gam) {
        super(gam);
        background=new Texture("tankStar1.png");
        playBtn=new Texture("newGameBtn.png");
        ResumeBtn=new Texture("loadGame.png");
        Exit=new Texture("exit.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new chooseTankStateFP(gam));
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
        b.draw(playBtn,GameMain.WIDTH/2-playBtn.getWidth()/2,GameMain.HEIGHT/2);
        b.draw(ResumeBtn,GameMain.WIDTH/2-ResumeBtn.getWidth()/2,GameMain.HEIGHT/2-80);
        b.draw(Exit,GameMain.WIDTH/2-ResumeBtn.getWidth()/2,GameMain.HEIGHT/2-183);
        b.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        ResumeBtn.dispose();
    }

}
