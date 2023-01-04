//package com.mygdx.game.States;
//
//import Sprite.Ground;
//import Sprite.Tank;
//import Utils.GameData;
//import Utils.TiledObjectUtill;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Animation;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.badlogic.gdx.maps.tiled.TmxMapLoader;
//import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;
//import com.badlogic.gdx.physics.box2d.*;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.mygdx.game.GameMain;
//
//import java.awt.*;
//
//public class P2PplayState extends State {
//    private Texture t;
//    private Texture bg;
//    private Ground ground;
//    private Tank tank;
//    private Texture health_bar1;
//    private Texture health_bar2;
//    private Rectangle r1;
//    private ShapeRenderer sr;
//    private OrthogonalTiledMapRenderer tmr;
//    private TmxMapLoader mapLoader;
//    private FitViewport viewport;
//    private TiledMap map;
//    private OrthographicCamera gamecam;
//    private World world;
//    private Box2DDebugRenderer b2dr;
//    private Body tanks1;
//    private Body tanks2;
//    private Body bullet;
//    private GameData curr;
//    Body b1;
//    Music music;
//    Texture img;
//    TextureRegion[] animationFrames;
//    Animation<TextureRegion> animation;
//    float elapsedTime;
//
//    public P2PplayState(GameStateManager gam, GameData g) {
//        super(gam);
//        curr=g;
//        sr=new ShapeRenderer();
//        music = Gdx.audio.newMusic(Gdx.files.internal("nfs.mp3"));
//
//        // Set the volume and looping behavior of the music
//        music.setVolume(0.5f);
//        music.setLooping(true);
//
//
//
//        // Start playing the music
//        music.play();
//
//        img = new Texture("anime.png");
//
//        TextureRegion[][] tmpFrames = TextureRegion.split(img,50,28);
//
//        animationFrames = new TextureRegion[4];
//        int index = 0;
//
//        for (int i = 0; i < 2; i++){
//            for(int j = 0; j < 2; j++) {
//                animationFrames[index++] = tmpFrames[j][i];
//            }
//        }
//
//        animation = new Animation(1f/4f,animationFrames);
//
//
//
//
//        bg = new Texture("backG5.jpg");
//        health_bar1 = new Texture("healthleft.png");
//        health_bar2 = new Texture("healthright.png");
//        ground = new Ground(50, 50);
//        tank = new Tank(50, 50);
//        sr = new ShapeRenderer();
//        r1 = new Rectangle(40, 30, 40, 40);
//            gamecam = new OrthographicCamera();
//            gamecam.setToOrtho(false, 1150, 337);
//
//            world = new World(new Vector2(0, -20f), false);
//            b2dr = new Box2DDebugRenderer();
//
//            BodyDef bdef = new BodyDef();
//            PolygonShape shape = new PolygonShape();
//            FixtureDef fdef = new FixtureDef();
//
//            map = new TmxMapLoader().load("groundNew2.tmx");
//            tmr = new OrthogonalTiledMapRenderer(map);
//            TiledObjectUtill.parseTiledObjectLayer(world, map.getLayers().get("ground").getObjects());
//
//
////            tanks1 = createTank(100, 240);
////            tanks2 = createTank(1000, 240);
//            tanks1 = createTank((int)curr.t.position1.x, (int)curr.t.position1.y);
//            tanks2 = createTank((int)curr.t.position2.x, (int)curr.t.position2.y);
////            bullet=createBullet(200,320);
//
//            gamecam.position.set(575, 300, 0);
//            tmr.setView(gamecam);
//
//
//    }
//
//    public Body createTank(int x,int y) {
//        Body tbody;
//        BodyDef def = new BodyDef();
//        def.type = BodyDef.BodyType.DynamicBody;
//        def.position.set(x, y);
//        def.fixedRotation = true;
//
//        tbody = world.createBody(def);
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(30, 10);
//        tbody.createFixture(shape, 1.0f);
//        tbody.applyAngularImpulse(1,true);
//        shape.dispose();
//
//        return tbody;
//    }
//    public Body createBullet(int x,int y) {
//        Body tbody;
//        BodyDef def = new BodyDef();
//        def.type = BodyDef.BodyType.KinematicBody;
//        def.position.set(x, y);
//        def.fixedRotation = true;
//
//        tbody = world.createBody(def);
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(15, 7);
//        tbody.createFixture(shape, 1.0f);
//        tbody.applyAngularImpulse(1,true);
//        shape.dispose();
//
//        return tbody;
//    }
//
//    @Override
//    protected void handleInput() {
//        int hforce = 0;
//
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
//            hforce -= 1;
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
//            hforce += 1;
////        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
////            curr.turn = !curr.turn;
////        }
//        if (Gdx.input.isTouched()) {
//            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
//                gam.set(new ResumeState(gam, curr));
//                dispose();
//            }
//        }
//        if (curr.turn) {
////            tanks1.setLinearVelocity(hforce * 100,Math.abs(hforce)*-70);
//            tanks1.setLinearVelocity(hforce * 100, Math.abs(tanks1.getLinearVelocity().y) * -1);
//
//
//        } else {
//            tanks2.setLinearVelocity(hforce * 100, Math.abs(tanks2.getLinearVelocity().y) * -1);
//
//        }
//////        tanks1.setLinearVelocity(hforce * 70, 0);
//
//        curr.t.position1.x= tanks1.getPosition().x;
//        curr.t.position1.y= tanks1.getPosition().y;
//        curr.t.position2.x= tanks2.getPosition().x;
//        curr.t.position2.y= tanks2.getPosition().y;
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            double cdx, cdy;
////            cdx = Gdx.input.getX();
////            cdy = Gdx.input.getY();
////            cdx = 600;
////            cdy = 600;
////
//            int t;
//
//            if (curr.turn == true)
//                t = 1;
//            else
//                t = 0;
////
//            curr.turn = !curr.turn;
////            if (Gdx.input.isKeyPressed(Input.Keys.F)) {
////                double t1dx, t1dy;
//            int f=0;
//            if(f==0){
//                b1 = createBullet((int) tanks1.getPosition().x+40, (int) tanks1.getPosition().y);
//                f=1;
//            }
//
////                if (t == 1) {
////                    t1dx = tanks1.getPosition().x;
////                    t1dy = tanks1.getPosition().y;
////                } else {
////                    t1dx = tanks2.getPosition().x;
////                    t1dy = tanks2.getPosition().y;
////                }
////
////                double theta = (cdx - t1dx) / (cdy - t1dy);
//            //theta = Math.abs(Math.atan(theta));
//
//            double theta = 0;
//            b1.setLinearVelocity((float) (50000 * Math.cos(theta)), (float) (50000* Math.sin(theta)));
//
//
//        }
//    }
////    }
//
//
//
//    @Override
//    public void update(float dt) {
//        tmr.setView(gamecam);
//
//        world.step(1 / 60f, 6, 2);
//        gamecam.update();
//        handleInput();
//    }
//
//    public void cameraUpdate(float dt) {
//        Vector3 position = gamecam.position;
//        position.x = tanks1.getPosition().x;
//        position.y = tanks1.getPosition().y;
//        gamecam.position.set(position);
//
//    }
//    int r=4;
//    @Override
//    public void render(SpriteBatch b) {
//        elapsedTime += Gdx.graphics.getDeltaTime();
//
//        b.begin();
//        b.draw(bg, 0, 0, GameMain.WIDTH, GameMain.HEIGHT);
//
////        b.draw(ground.getGround(),0,-250);
//        b.draw(new Texture("vs.png"), 580, 600);
//        b.draw(new Texture("backBtn.png"), -30, 590, 180, 100);
//        b.draw(health_bar1, 250, 550);
//        b.draw(health_bar2, 650, 600);
//        b.draw(curr.t.getTank1(), tanks1.getPosition().x - curr.t.getTank1().getWidth() / 2, tanks1.getPosition().y-20- curr.t.getTank2().getHeight() / 2);
//        b.draw(curr.t.getTank2(),tanks2.getPosition().x , tanks2.getPosition().y-20 - curr.t.getTank2().getHeight() / 2);
//        if(b1!=null){
//            b.draw(new Texture("bullet.png"),b1.getPosition().x,b1.getPosition().y);
//            elapsedTime=0;
//        }
////        if(elapsedTime<=r && b1!=null){
////            b.draw(animation.getKeyFrame(elapsedTime,false),40,200);
////        }
//        b.end();
//        tmr.render();
//        b2dr.render(world, gamecam.combined);
//        sr.begin(ShapeRenderer.ShapeType.Filled);
//        sr.setColor(Color.YELLOW);
////        sr.rect(330,615, 80/100.0f*230,35);
//        sr.rect(330,615, curr.health1/100.0f*230,35);
//        sr.rect(670+(100-curr.health2)/100.0f*240,615, curr.health2/100.0f*240,35);
////        sr.rect(670+(100-100)/100.0f*230,615, 100/100.0f*240,35);
//        sr.end();
//
//    }
//
//    @Override
//    public void dispose() {
//
//        health_bar1.dispose();
//        health_bar2.dispose();
//        b2dr.dispose();
//        world.dispose();
//        tmr.dispose();
//        music.dispose();
//
//    }
//}
package com.mygdx.game.States;

import Sprite.Ground;
import Sprite.Tank;
import Utils.GameData;
import Utils.TiledObjectUtill;
import Utils.WorldContactListner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.GameMain;

import java.awt.*;

public class P2PplayState extends State {
    private Texture t;
    private Texture bg;
    private Ground ground;
    private Tank tank;
    private Texture health_bar1;
    private Texture health_bar2;
    private Rectangle r1;
    private ShapeRenderer sr;
    private OrthogonalTiledMapRenderer tmr;
    private TmxMapLoader mapLoader;
    private FitViewport viewport;
    private TiledMap map;
    private OrthographicCamera gamecam;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Body tanks1;

    private Body tanks2;
    private Body bullet;
    private GameData curr;
    Body b1;
    Music music;
    Texture img;
    TextureRegion[] animationFrames;
    Animation<TextureRegion> animation;
    BitmapFont font;
    float elapsedTime;

    public P2PplayState(GameStateManager gam, GameData g) {
        super(gam);
        curr=g;
        sr=new ShapeRenderer();
        music = Gdx.audio.newMusic(Gdx.files.internal("nfs.mp3"));

        // Set the volume and looping behavior of the music
        music.setVolume(0.5f);
        music.setLooping(true);



        // Start playing the music
        music.play();
        font = new BitmapFont();
        font.getData().setScale(4);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.setColor(Color.WHITE);
        img = new Texture("anime.png");

        TextureRegion[][] tmpFrames = TextureRegion.split(img,50,28);

        animationFrames = new TextureRegion[4];
        int index = 0;

        for (int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++) {
                animationFrames[index++] = tmpFrames[j][i];
            }
        }

        animation = new Animation(1f/4f,animationFrames);




        bg = new Texture("backG5.jpg");
        health_bar1 = new Texture("healthleft.png");
        health_bar2 = new Texture("healthright.png");
//        ground = new Ground(50, 50);
        tank = new Tank(0, 0);
        sr = new ShapeRenderer();
        r1 = new Rectangle(40, 30, 40, 40);
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, 1150.0f/GameMain.PPM, 337.0f/GameMain.PPM);

        world = new World(new Vector2(0, -10f), false);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();

        map = new TmxMapLoader().load("groundNew2.tmx");
        tmr = new OrthogonalTiledMapRenderer(map,1.0f/GameMain.PPM);
        TiledObjectUtill.parseTiledObjectLayer(world, map.getLayers().get("ground").getObjects());


//            tanks1 = createTank(100, 240);
//            tanks2 = createTank(1000, 240);
        System.out.println(g.t.position1.x);
        tanks1 = createTank(g.t.position1.x, g.t.position1.y);
        tanks2 = createTank((int)curr.t.position2.x, (int)curr.t.position2.y);
//            bullet=createBullet(200,320);

        gamecam.position.set(575.0f/GameMain.PPM, 300.f/GameMain.PPM, 0);
        tmr.setView(gamecam);
        world.setContactListener(new WorldContactListner());

    }

    public Body createTank(float x,float y) {
        Body tbody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x/GameMain.PPM, y/GameMain.PPM+1);
        def.fixedRotation = true;

        tbody = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(30.0f/GameMain.PPM, 10.0f/GameMain.PPM);
//        tbody.createFixture(shape, 1.0f);
        FixtureDef f=new FixtureDef();
//        f.filter.categoryBits=2;
        f.density=1.0f;
        f.shape=shape;
        tbody.createFixture(f).setUserData(this);
        tbody.applyAngularImpulse(1,true);
        shape.dispose();

        return tbody;
    }
    public void dpB(){
        try {
            if (b1 != null) {
//                            b1=null;
//                world.destroyBody(b1);
            }
            if (curr.turn)
                curr.health1 -= 10;
            else {
                curr.health2 -= 10;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public Body createBullet(float x,float y) {
        Body tbody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x/GameMain.PPM, y/GameMain.PPM);
        def.fixedRotation = true;

        tbody = world.createBody(def);
        FixtureDef f=new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(15/GameMain.PPM, 7/GameMain.PPM);
//        f.filter.categoryBits=1;
//        f.filter.maskBits=2;
        f.shape=shape;
        tbody.createFixture(f).setUserData("Bullet");
        f.isSensor=true;

//        tbody.createFixture(shape, 1.0f);

        tbody.applyAngularImpulse(1,true);
        shape.dispose();
        return tbody;
    }
    int power=1;
    float angle=(float)Math.PI/4;
    @Override
    protected void handleInput() {
        try{
        int hforce = 0;
//        System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            hforce = -2;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            hforce = 2;
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            curr.turn = !curr.turn;
//        }
        if (Gdx.input.isTouched()) {
            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new ResumeState(gam, curr));
                dispose();
            }
        }
        if (curr.turn && Math.abs(tanks1.getLinearVelocity().x)<=2) {
//            tanks1.setLinearVelocity(hforce * 100,Math.abs(hforce)*-70);
//            tanks1.setLinearVelocity(hforce, Math.abs(tanks1.getLinearVelocity().y) * -1);
            tanks1.applyLinearImpulse(new Vector2(hforce/50.0f,0),tanks1.getWorldCenter(),true);


        } else if(!curr.turn &&Math.abs(tanks2.getLinearVelocity().x)<=2) {
            tanks2.setLinearVelocity(hforce, Math.abs(tanks2.getLinearVelocity().y) * -1);

        }
////        tanks1.setLinearVelocity(hforce * 70, 0);

        curr.t.position1.x= tanks1.getPosition().x*100;
        curr.t.position1.y= tanks1.getPosition().y*100;
        curr.t.position2.x= tanks2.getPosition().x*100;
        curr.t.position2.y= tanks2.getPosition().y*100;

        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1))
            power=1;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_2))
            power=2;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_3))
            power=3;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_4))
            power=4;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_5))
            power=5;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_6))
            power=6;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_7))
            power=7;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_8))
            power=8;
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_9))
            power=9;
        if(Gdx.input.isKeyPressed(Input.Keys.Q))
            angle=(float) Math.PI/(2*1);
        if(Gdx.input.isKeyPressed(Input.Keys.W))
            angle=(float) Math.PI/(2*2);
        if(Gdx.input.isKeyPressed(Input.Keys.E))
            angle=(float) Math.PI/(2*3);
        if(Gdx.input.isKeyPressed(Input.Keys.R))
            angle=(float) Math.PI/(2*4);
        if(Gdx.input.isKeyPressed(Input.Keys.T))
            angle=(float) Math.PI/(2*5);
        if(Gdx.input.isKeyPressed(Input.Keys.Y))
            angle=(float) Math.PI/(2*6);
        if(Gdx.input.isKeyPressed(Input.Keys.U))
            angle=(float) Math.PI/(2*7);
        if(Gdx.input.isKeyPressed(Input.Keys.I))
            angle=(float) Math.PI/(2*8);
        if(Gdx.input.isKeyPressed(Input.Keys.O))
            angle=(float) Math.PI/(2*9);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {


            if (curr.turn) {
                b1 = createBullet(tanks1.getPosition().x * 100 + 65, tanks1.getPosition().y * 100 + 40);
                double theta = Math.PI / 4.0f;
                b1.setLinearVelocity((float) (power * Math.cos(theta)), (float) (power * Math.sin(theta)));
            } else {
                b1 = createBullet(tanks2.getPosition().x * 100 - 65, tanks2.getPosition().y * 100 + 40);
//                double theta = Math.PI / 4.0f;
                b1.setLinearVelocity((float) (-1*power * Math.cos(angle)), (float) (1*power * Math.sin(angle)));
            }
            curr.turn = !curr.turn;
//            if (Gdx.input.isKeyPressed(Input.Keys.F)) {
//                double t1dx, t1dy;


//                if (t == 1) {
//                    t1dx = tanks1.getPosition().x;
//                    t1dy = tanks1.getPosition().y;
//                } else {
//                    t1dx = tanks2.getPosition().x;
//                    t1dy = tanks2.getPosition().y;
//                }
//
//                double theta = (cdx - t1dx) / (cdy - t1dy);
            //theta = Math.abs(Math.atan(theta));
        }}
        catch(Exception e){
            e.printStackTrace();



        }
    }
//    }



    @Override
    public void update(float dt) {
        tmr.setView(gamecam);

        world.step(1 / 60f, 6, 2);
        gamecam.update();
        handleInput();
    }

    public void cameraUpdate(float dt) {
        Vector3 position = gamecam.position;
        position.x = tanks1.getPosition().x;
        position.y = tanks1.getPosition().y;
        gamecam.position.set(position);

    }
    int r=4;
    @Override
    public void render(SpriteBatch b) {
        elapsedTime += Gdx.graphics.getDeltaTime();
//        b.setProjectionMatrix(cam.combined);
        b.begin();
        b.draw(bg, 0, 0, GameMain.WIDTH, GameMain.HEIGHT);
        if(curr.health1<=0){
            font.draw(b,"GAME OVER",400,400);
            font.draw(b,"Player 2 wins",400,320);
        }
        else if(curr.health2<=0){
            font.draw(b,"GAME OVER",400,400);
            font.draw(b,"Player 1 wins",400,320);
        }
//        b.draw(ground.getGround(),0,-250);
        b.draw(new Texture("vs.png"), 580, 600);
        b.draw(new Texture("backBtn.png"), -30, 590, 180, 100);
        b.draw(health_bar1, 250, 550);
        b.draw(health_bar2, 650, 600);
//        b.draw(curr.t.getTank1(), tanks1.getPosition().x*100, tanks1.getPosition().y*100);
////        b.draw(curr.t.getTank2(),tanks2.getPosition().x , tanks2.getPosition().y-20 - curr.t.getTank2().getHeight() / 2);
        b.draw(curr.t.getTank1(), (tanks1.getPosition().x*100 - curr.t.getTank1().getWidth() / 2.0f), (tanks1.getPosition().y*195-245- curr.t.getTank2().getHeight()/2.0f));
        b.draw(curr.t.getTank2(),tanks2.getPosition().x*100 , (tanks2.getPosition().y*195-245- curr.t.getTank2().getHeight()/2.0f));
        try{
        if(b1!=null){
            b.draw(new Texture("bullet.png"),b1.getPosition().x*100,b1.getPosition().y*100);
            elapsedTime=0;
        }}
        catch (Exception e){
            e.printStackTrace();
        }
//        if(elapsedTime<=r && b1!=null){
//            b.draw(animation.getKeyFrame(elapsedTime,false),40,200);
//        }
        b.end();
        tmr.render();
        b2dr.render(world, gamecam.combined);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.YELLOW);
//        sr.rect(330,615, 80/100.0f*230,35);
        sr.rect(330,615, curr.health1/100.0f*230,35);
        sr.rect(670+(100-curr.health2)/100.0f*240,615, curr.health2/100.0f*240,35);
//        sr.rect(670+(100-100)/100.0f*230,615, 100/100.0f*240,35);
        sr.end();

    }

    @Override
    public void dispose() {
        sr.dispose();
        font.dispose();
        curr.t.tank1.dispose();
        curr.t.tank2.dispose();
        health_bar1.dispose();
        health_bar2.dispose();
        b2dr.dispose();
        world.dispose();
        tmr.dispose();
        music.dispose();

    }
}