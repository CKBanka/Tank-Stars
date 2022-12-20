package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.GameMain;

import java.awt.*;

public class Menu2 extends State{
    private Texture background;
    private Texture playBtn;
    private Texture ResumeBtn;
    private Texture Exit;
    Rectangle r2;
    Rectangle r1;
    Rectangle r3;
    ShapeRenderer sr;
    public Menu2(GameStateManager gam) {
        super(gam);
        background=new Texture("tankStar3.png");
//        playBtn=new Texture("newGameBtn.png");
//        ResumeBtn=new Texture("loadGameBtn.png");
//        Exit=new Texture("exit.png");
        r1=new Rectangle(720,170,380,65);
        r2=new Rectangle(720,270,380,65);
        r3=new Rectangle(840,370,150,65);
        sr = new ShapeRenderer();
    }

    @Override
    public void handleInput() {
//        if(Gdx.input.justTouched()){
//            gam.set(new chooseTankStateFP(gam,1));
//            dispose();
//        }
        if (Gdx.input.isTouched()) {
            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new chooseTankStateFP(gam, 1));
                dispose();
            }
            else if (r2.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new savedState(gam));
                dispose();
            }
            else if (r3.contains(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.app.exit();
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
//        b.draw(playBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2,300,160);
//        b.draw(ResumeBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-40,300,160);
//        b.draw(Exit,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-80,300,160);
        b.end();
//        sr.begin(ShapeRenderer.ShapeType.Filled);
//        sr.rect(720,100,380,100);
//        sr.end();
    }

    @Override
    public void dispose() {
        background.dispose();
//        playBtn.dispose();
//        ResumeBtn.dispose();
    }

}
