package com.mygdx.game.States;

import Sprite.Ground;
import Sprite.Tank;
import Utils.TiledObjectUtill;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.GameMain;

import java.awt.*;
import java.util.ArrayList;

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
    private OrthographicCamera camera;
    private World world;
    private Box2DDebugRenderer b2dr;


    public P2PplayState(GameStateManager gam) {
        super(gam);
        world=new World(new Vector2(0,0),false);
        b2dr=new Box2DDebugRenderer();
        bg=new Texture("rainScene.jpg");
        health_bar1=new Texture("healthleft.png");
        health_bar2=new Texture("healthright.png");
        ground=new Ground(50,50);
        tank=new Tank(50,50);
        sr=new ShapeRenderer();
        r1=new Rectangle(40,30,40,40);
        map=new TmxMapLoader().load("GroundNew.tmx");
        tmr=new OrthogonalTiledMapRenderer(map);
//        tmr = new OrthogonalTiledMapRenderer(map,1200/(map.getProperties().get("width",Integer.class)*5f));
        camera=new OrthographicCamera();
        camera.setToOrtho(false,1150,337);
        BodyDef bdef=new BodyDef();
        PolygonShape shape=new PolygonShape();
        FixtureDef fdef=new FixtureDef();
        TiledObjectUtill.parseTiledObjectLayer(world,map.getLayers().get("ground").getObjects());

        Body body;
        int width = 800; // Can change to other
        int height = 480;
//        viewport = new FitViewport(width, height, new OrthographicCamera(width, height));
//
//        viewport.getCamera().position.set(768, 0, 0);

        mapLoader = new TmxMapLoader() ;
        tmr = new OrthogonalTiledMapRenderer(map) ;

        camera.position.set(580,300,0);


    }
//    public void resize(int w, int h) {
//        cam.setToOrtho(false, w, h);
//    }
    public Body createTank(){
        Body tbody;
        BodyDef def=new BodyDef();
        def.type=BodyDef.BodyType.DynamicBody;
        def.position.set(0,0);
        def.fixedRotation=true;
        tbody=world.createBody(def);
        PolygonShape shape=new PolygonShape();
        shape.setAsBox(32,32);
        tbody.createFixture(shape,1.0f);
        shape.dispose();
        return tbody;
    }
    @Override
    protected void handleInput() {
//        if(Gdx.input.justTouched()){
//            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
//                gam.set(new ResumeState(gam));
//                dispose();
//            }
//        }
        if(Gdx.input.justTouched()){
            if (r1.contains(Gdx.input.getX(), Gdx.input.getY())) {
                gam.set(new ResumeState(gam));
                dispose();
            }
        }
        camera.update();
        tmr.setView(camera);
//        world.step(1/60f,6,2);

    }



    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch b) {
        update(Gdx.graphics.getDeltaTime());
//        b.setProjectionMatrix(camera.combined);
        b.begin();
        b.draw(bg,0,0, GameMain.WIDTH,GameMain.HEIGHT);
//        b.draw(ground.getGround(),0,-250);
        b.draw(new Texture("vs.png"), 580, 600);
        b.draw(new Texture("backBtn.png"), -30, 590,180,100);
        b.draw(health_bar1,250,550);
        b.draw(health_bar2,650,600);
        b.draw(tank.getTank1(),97,290);
        b.draw(tank.getTank2(),910,247);
        b.end();
        tmr.render();
        b2dr.render(world,camera.combined);
//        sr.begin(ShapeRenderer.ShapeType.Filled);
//        sr.rect(40,30,40,40);
//        sr.end();
    }

    @Override
    public void dispose() {

        health_bar1.dispose();
        health_bar2.dispose();
        b2dr.dispose();
        world.dispose();
        tmr.dispose();

    }
}
