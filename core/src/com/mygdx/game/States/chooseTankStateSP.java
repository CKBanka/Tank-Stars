package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameMain;

public class chooseTankStateSP extends State {
    private Texture background;
    private Texture HBtn;
    private Texture t1;
    private Texture t2;
    private Texture t3;
    private Texture t4;
    private Texture selB;

    public chooseTankStateSP(GameStateManager gam) {
        super(gam);
        background=new Texture("rainScene.jpg");
        HBtn=new Texture("selectTank2.png");
        t1=new Texture("pumpkin.png");
        t2=new Texture("pumpkin.png");
        t3=new Texture("pumpkin.png");
        t4=new Texture("toxic1.png");
        selB=new Texture("select.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new P2PplayState(gam));
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
        b.draw(HBtn,GameMain.WIDTH/2-HBtn.getWidth()/2+7,568);
        b.draw(t1,150,370);
        b.draw(selB,100,250);
        b.draw(t2,550,370);
        b.draw(selB,500,250);
        b.draw(t2,950,370);
        b.draw(selB,900,250);
        b.end();
    }

    @Override
    public void dispose() {

    }
}
