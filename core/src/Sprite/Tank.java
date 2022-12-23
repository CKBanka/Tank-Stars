package Sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Tank {
    private static final int movement=100;
    public Vector3 position1;
    public Vector3 position2;
    public Texture tank1;
    public int t1val;
    public int t2val;
    public Texture tank2;
    public Tank(int x,int y){
        position1=new Vector3(100,180,0);
        position2=new Vector3(1000,180,0);
        tank1=new Texture("toxic1.png");
        tank2=new Texture("pumpkin.png");
        t1val=1;
        t2val=1;
    }
    public void update(float dt){

    }
    public Vector3 getPosition() {
        return position1;
    }
    public Texture getTank1() {
        return tank1;
    }
    public Texture getTank2() {
        return tank2;
    }
}
