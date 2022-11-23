package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameMain;

public class ResumeState extends State{
    private Texture background;
    private Texture background2;
    private Texture saveBtn;
    private Texture resumeBtn;
    private Texture quitBtn;


    private Skin ms;
    private Stage stage;

    public ResumeState(GameStateManager gam) {
        super(gam);
        background=new Texture("tankStar4.jpg");
//        background2=new Texture("pauseScreen2.png");
        saveBtn=new Texture("save.png");
        resumeBtn=new Texture("RE.png");
        quitBtn=new Texture("quit.png");
//        ms=new Skin(Gdx.files.internal("skin/cloud-form-ui.json"));
//        stage=new Stage();
//        Label gt=new Label()

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new savedState(gam));
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
//        b.draw(background2,300,180, GameMain.WIDTH/2,GameMain.HEIGHT/2);
        b.draw(resumeBtn,GameMain.WIDTH/2-75,GameMain.HEIGHT/2+30,150,120);
//        b.draw(resumeBtn,GameMain.WIDTH/2-resumeBtn.getWidth()/2,GameMain.HEIGHT/2);
        b.draw(quitBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-60,300,180);
        b.draw(saveBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-120,300,180);
        b.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        resumeBtn.dispose();
        quitBtn.dispose();
        saveBtn.dispose();
    }
}
