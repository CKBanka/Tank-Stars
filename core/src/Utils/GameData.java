package Utils;

import Sprite.Tank;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameMain;

public class GameData {
    public Tank t;
    int health1;
    int health2;
    public GameData(){
        health1=100;
        health2=100;
        t=new Tank(0,0);
    }
    public void newTank1(int i){
        if(i==1){
            t.tank1=new Texture("pumpkin1.png");
        }
        else if(i==2){
            t.tank1=new Texture("toxic1.png");
        }
        else if(i==3){
            t.tank1=new Texture("goldenS1.png");
        }
        else if(i==4){
            t.tank1=new Texture("golden1.png");
        }
        else if(i==5){
            t.tank1=new Texture("Buratino1.png");
        }
    }
    public void newTank2(int i){
        if(i==1){
            t.tank2=new Texture("pumpkin2.png");
        }
        else if(i==2){
            t.tank2=new Texture("toxic2.png");
        }
        else if(i==3){
            t.tank2=new Texture("goldenS2.png");
        }
        else if(i==4){
            t.tank2=new Texture("golden2.png");
        }
        else if(i==5){
            t.tank2=new Texture("Buratino2.png");
        }
    }
}
