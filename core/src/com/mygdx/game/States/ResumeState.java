package com.mygdx.game.States;

import Utils.GameData;
import Utils.SaveGame;
import Utils.saveData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameMain;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import java.awt.*;

public class ResumeState extends State{
    private Texture background;
    private Texture background2;
    private Texture saveBtn;
    private Texture resumeBtn;
    private Texture quitBtn;


    private Skin ms;
    private Stage stage;
    Rectangle r2;
    Rectangle r1;
    Rectangle r3;
    ShapeRenderer sr;
    GameData curr;
    Calendar now;
    SimpleDateFormat formatter;

    public ResumeState(GameStateManager gam,GameData g) {
        super(gam);
        now = Calendar.getInstance();
        formatter = new SimpleDateFormat("      yyyy-MM-dd              HH:mm:ss");

        curr=g;
        background=new Texture("tankStar4.jpg");
//        background2=new Texture("pauseScreen2.png");
        saveBtn=new Texture("save.png");
        resumeBtn=new Texture("RE.png");
        quitBtn=new Texture("quit.png");
        r1=new Rectangle(520,220,150,40);
        r2=new Rectangle(520,290,150,40);
        r3=new Rectangle(520,345,150,40);
        sr = new ShapeRenderer();

    }
    public  saveData getInstance(){
        saveData s=new saveData(curr.t.t1val,curr.t.t2val,curr.health1,curr.health2,1,(int)(curr.t.position1.x),(int)(curr.t.position1.y),(int)(curr.t.position2.x),(int)(curr.t.position2.y));
        System.out.println(curr.t.position1.x);
        return s;
    }
    @Override
    protected void handleInput() {
//        if(Gdx.input.justTouched()){
//            gam.set(new savedState(gam));
//            dispose();
//        }
        if (Gdx.input.isTouched()) {
            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new P2PplayState(gam,curr));
                dispose();
            }
            else if (r2.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new Menu2(gam));
                dispose();
            }
            else if (r3.contains(Gdx.input.getX(), Gdx.input.getY())) {
                SaveGame.s=getInstance();
                SaveGame.serialize();
                GameMain.num++;
                String dateTimeString = formatter.format(now.getTime());
                GameMain.dt.add(dateTimeString);
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
//        b.draw(background2,300,180, GameMain.WIDTH/2,GameMain.HEIGHT/2);
        b.draw(resumeBtn,GameMain.WIDTH/2-75,GameMain.HEIGHT/2+30,150,120);
//        b.draw(resumeBtn,GameMain.WIDTH/2-resumeBtn.getWidth()/2,GameMain.HEIGHT/2);
        b.draw(quitBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-60,300,180);
        b.draw(saveBtn,GameMain.WIDTH/2-150,GameMain.HEIGHT/2-120,300,180);
        b.end();
//        sr.begin(ShapeRenderer.ShapeType.Filled);
//        sr.rect(520,100,150,40);
//        sr.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        resumeBtn.dispose();
        quitBtn.dispose();
        saveBtn.dispose();
    }
}
