package com.mygdx.game.States;

import Utils.GameData;
import Utils.SaveGame;
import Utils.saveData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.*;
//import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameMain;

import java.awt.*;
import java.util.ArrayList;

public class savedState extends State{
    private Texture background;
    private Texture loadBar;
    private Texture exitBtn;
    private Texture gameImg;
    Rectangle r1;
    ShapeRenderer sr;
    BitmapFont font;
    Rectangle r2 = new Rectangle(900, 350, 120, 50);
    Rectangle r3;
    Rectangle r4;
    Rectangle r5;
    ShapeRenderer shapeRenderer;
    public savedState(GameStateManager gam) {
        super(gam);
        shapeRenderer=new ShapeRenderer();
        font = new BitmapFont();
        font.getData().setScale(2);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.setColor(Color.WHITE);
        background=new Texture("loadGameScreen.png");
        loadBar=new Texture("loadGameBar.png");
        exitBtn=new Texture("exit.png");
        gameImg=new Texture("noSavedGame.png");
        sr=new ShapeRenderer();
        r1=new Rectangle(40,30,60,60);
        r3=new Rectangle(900, 280, 120, 50);
        r4=new Rectangle(900, 370, 120, 50);
        r5=new Rectangle(900, 460, 120, 50);
    }

    @Override
    protected void handleInput() {

        if(Gdx.input.justTouched()){
            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new Menu2(gam));
                dispose();
            }
            else if (r3.contains(Gdx.input.getX(), Gdx.input.getY()) && GameMain.num>0) {
                saveData sd=SaveGame.deserialize(1,false);
                GameData d=new GameData();
                d.newTank1(sd.t1);
                System.out.println(sd.t1);
                d.newTank2(sd.t2);
                d.health1=sd.h1;
                d.health2=sd.h2;
                GameMain.num--;
                GameMain.dt.remove(GameMain.num);
                gam.set(new P2PplayState(gam,d));
                dispose();
            }
            else if (r4.contains(Gdx.input.getX(), Gdx.input.getY()) && GameMain.num>1) {
                saveData sd=SaveGame.deserialize(2,false);
                GameData d=new GameData();
                d.newTank1(sd.t1);
                System.out.println(sd.t1);
                d.newTank2(sd.t2);
                d.health1=sd.h1;
                d.health2=sd.h2;
                d.t.position1.x=sd.t1x;
                d.t.position1.y=sd.t1y;
                GameMain.num--;
                GameMain.dt.remove(GameMain.num);
                gam.set(new P2PplayState(gam,d));
                dispose();
            }
            else if (r5.contains(Gdx.input.getX(), Gdx.input.getY()) && GameMain.num>2) {
                saveData sd=SaveGame.deserialize(3,false);
                GameData d=new GameData();
                d.newTank1(sd.t1);
                System.out.println(sd.t1);
                d.newTank2(sd.t2);
                d.health1=sd.h1;
                d.health2=sd.h2;
                GameMain.num--;
                GameMain.dt.remove(GameMain.num);
                gam.set(new P2PplayState(gam,d));
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
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GRAY);
        b.begin();
        b.draw(background,0,0, GameMain.WIDTH,GameMain.HEIGHT);
        if(GameMain.num>0) {
            for (int i = 0; i < GameMain.num; i++) {
                font.draw(b, "Saved Game "+(i+1) +"" + GameMain.dt.get(i), 100, (400-i*100));
                shapeRenderer.rect(r2.x, r2.y-i*90, r2.width, r2.height);
            }
        }
        else{
            b.draw(gameImg,300,180,600,400);
        }

//        b.draw(loadBar,30,GameMain.HEIGHT/2+200);
//        b.draw(loadBar,30,GameMain.HEIGHT/2+200);
//        b.draw(exitBtn,GameMain.WIDTH-300,GameMain.HEIGHT/2-200);

        b.end();

        shapeRenderer.end();
//        sr.begin(ShapeRenderer.ShapeType.Filled);
//        sr.rect(40,30,60,60);
//        sr.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        font.dispose();
        sr.dispose();
        background.dispose();

    }
}
