package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    Stack<State> states;
    public GameStateManager(){
        states=new Stack<State>();
    }
    public void push(State s){
        states.push(s);
    }
    public void pop(){
        states.pop();
    }
    public void set(State s){
        states.pop();
        states.push(s);
    }
    public void update(float dt){
        states.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
