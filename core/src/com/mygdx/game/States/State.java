package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gam;
    public State(GameStateManager gam){
        this.gam=gam;
        cam=new OrthographicCamera();
        mouse=new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public void resize(int w, int h) {
        cam.setToOrtho(false, w, h);
    }
    public abstract void render(SpriteBatch b);
    public abstract void dispose();
}
