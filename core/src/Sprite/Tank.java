package Sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Tank {
    private static final int movement=100;
    private Vector3 position;
    private Vector3 velocity;
    public Texture tank1;
    public Texture tank2;
    public Tank(int x,int y){
        position=new Vector3(0,0,0);
        velocity=new Vector3(0,0,0);
        tank1=new Texture("toxic1.png");
        tank2=new Texture("pumpkin.png");
    }
    public void update(float dt){

    }
    public Vector3 getPosition() {
        return position;
    }
    public Texture getTank1() {
        return tank1;
    }
    public Texture getTank2() {
        return tank2;
    }
}
