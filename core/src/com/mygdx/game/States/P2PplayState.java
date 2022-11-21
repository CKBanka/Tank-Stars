package com.mygdx.game.States;

import Sprite.Ground;
import Sprite.Tank;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameMain;

import java.util.ArrayList;

public class P2PplayState extends State {
    private Texture t;
    private Texture bg;
    private Ground ground;
    private Tank tank;
    private Texture health_bar1;
    private Texture health_bar2;


    public P2PplayState(GameStateManager gam) {
        super(gam);
        bg=new Texture("rainScene.jpg");
        health_bar1=new Texture("healthleft.png");
        health_bar2=new Texture("healthright.png");
        ground=new Ground(50,50);
        tank=new Tank(50,50);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new ResumeState(gam));
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
        b.draw(bg,0,0, GameMain.WIDTH,GameMain.HEIGHT);
        b.draw(ground.getGround(),0,-250);
        b.draw(new Texture("vs.png"), 580, 600);
        b.draw(new Texture("backB.png"), 10, 610);
        b.draw(health_bar1,250,550);
        b.draw(health_bar2,650,600);
        b.draw(tank.getTank1(),97,290);
        b.draw(tank.getTank2(),910,247);
        b.end();
    }

    @Override
    public void dispose() {
        health_bar1.dispose();
        health_bar2.dispose();
    }
}
