package com.mygdx.game.States;

import Utils.GameData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameMain;

import java.awt.*;

public class chooseTankStateSP extends State {
    private Texture background;
    private Texture HBtn;
    private Texture t;
    private Texture selB;
    int now;
    Rectangle r2;
    Rectangle r1;
    Rectangle r3;

    GameData curr;

    public chooseTankStateSP(GameStateManager gam,int st,GameData g) {
        super(gam);
        curr=g;
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
        r1=new Rectangle(50,300,90,90);
        r2=new Rectangle(1020,300,90,90);
        r3=new Rectangle(400,350,200,200);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            if(now==1) {
                if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateFP(gam,5,curr));
                    dispose();
                }
                else if (r2.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam, 2,curr));
                    dispose();
                }
                else if (r3.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    curr.newTank2(1);
                    curr.t.t2val=1;
                    gam.set(new P2PplayState(gam,curr));
                    dispose();
                }

            }
            else if(now==2){
                if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam,1,curr));
                    dispose();
                }
                else if (r2.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam, 3,curr));
                    dispose();
                }
                else if (r3.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    curr.newTank2(2);
                    curr.t.t2val=2;
                    gam.set(new P2PplayState(gam,curr));
                    dispose();
                }
            }
            else if(now==3){
                if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam,2,curr));
                    dispose();
                }
                else if (r2.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam, 4,curr));
                    dispose();
                }
                else if (r3.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    curr.newTank2(3);
                    curr.t.t2val=3;
                    gam.set(new P2PplayState(gam,curr));
                    dispose();
                }
            }
            else if(now==4){
                if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam,3,curr));
                    dispose();
                }
                else if (r2.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam, 5,curr));
                    dispose();
                }
                else if (r3.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    curr.newTank2(4);
                    curr.t.t2val=4;
                    gam.set(new P2PplayState(gam,curr));
                    dispose();
                }
            }
            else if(now==5){
                if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    gam.set(new chooseTankStateSP(gam,4,curr));
                    dispose();
                }
                else if (r2.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    curr.newTank2(1);
                    curr.t.t2val=1;
                    gam.set(new P2PplayState(gam,curr));
                    dispose();
                }
                else if (r3.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    curr.newTank2(5);
                    curr.t.t2val=5;
                    gam.set(new P2PplayState(gam,curr));
                    dispose();
                }
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
        t.dispose();
    }
}
