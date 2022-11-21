package Sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Ground {
    private Texture ground;
    private Vector3 position;
    public Ground(int x,int y){
        position=new Vector3(x,y,0);
        ground=new Texture("ground.png");

    }
    public void update(float dt){

    }

    public Texture getGround() {
        return ground;
    }
}
