package Sprite;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class bullet
{
    public static final int SPEED = 500;
    public static final int DEFAULT_Y = 40;
    public static final int WIDTH = 3;
    public static final int HEIGHT = 12;

    private static Texture texture ;
    public int damage = 10 ;

    public bullet() {
        if (texture == null)
            texture = new Texture("bullet.png");
    }
}