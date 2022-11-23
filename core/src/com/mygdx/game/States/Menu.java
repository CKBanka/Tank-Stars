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
        background=new Texture("tankStar1.jpg");
        playBtn=new Texture("newGameBtn.png");
        ResumeBtn=new Texture("loadGameBtn.png");
        Exit=new Texture("exit.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new Menu2(gam));
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
//        b.draw(playBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2,300,160);
//        b.draw(ResumeBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-40,300,160);
//        b.draw(Exit,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-80,300,160);
        b.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        ResumeBtn.dispose();
    }

}
