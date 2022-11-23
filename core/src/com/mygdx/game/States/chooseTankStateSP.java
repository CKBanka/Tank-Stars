package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameMain;

public class chooseTankStateSP extends State {
    private Texture background;
    private Texture HBtn;
    private Texture t;
    private Texture selB;
    int now;

    public chooseTankStateSP(GameStateManager gam,int st) {
        super(gam);
        background=new Texture("rainScene.jpg");
        HBtn=new Texture("selectTank1.png");
        if(st==1){
            t=new Texture("25.jpg");
            now=1;
        }
        else if(st==2){
            t=new Texture("26.jpg");
            now=2;
        }
        else if(st==3){
            t=new Texture("27.jpg");
            now=3;
        }
        else if(st==4){
            t=new Texture("28.jpg");
            now=4;
        }
        else if(st==5){
            t=new Texture("29.jpg");
            now=5;
        }
        selB=new Texture("select.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            if(now==1) {
                gam.set(new chooseTankStateSP(gam, 2));
                dispose();
            }
            else if(now==2){
                gam.set(new chooseTankStateSP(gam,3));
                dispose();
            }
            else if(now==3){
                gam.set(new chooseTankStateSP(gam,4));
                dispose();
            }
            else if(now==4){
                gam.set(new chooseTankStateSP(gam,5));
                dispose();
            }
            else if(now==5){
                gam.set(new P2PplayState(gam));
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
//        b.draw(background,0,0, GameMain.WIDTH,GameMain.HEIGHT);
//        b.draw(HBtn,GameMain.WIDTH/2-HBtn.getWidth()/2,580);
        b.draw(t,0,0,1200,680);
        b.end();
    }

    @Override
    public void dispose() {

    }
}
