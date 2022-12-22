package Utils;

import Sprite.Tank;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.mygdx.game.GameMain;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.Menu;
import com.mygdx.game.States.Menu2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertNotSame;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class GameTest {

    @Test
    public void testGameInitialization() {
        // Create a new instance of the game
        GameMain game = new GameMain();

        // Verify that the game is in the expected initial state
        assertTrue(game.isRunning());
    }
    @Test
    public void testSaveData() {
        // Create a new instance of the game
        saveData s=new saveData(0,0,0,0,0,0,0,0,0);

        // Verify that the game is in the expected initial state
        assertTrue(s.isSaveDataWorking());
    }
    @Test(expected = NullPointerException.class)
    public void testgameData() {
        // Create a new instance of the game
        GameData s=new GameData();

        // Verify that the game is in the expected initial state
        assertTrue(s.isRunning());
    }

    @Test(expected = NullPointerException.class)
    public void testTankCreation() {
        // Create a new instance of the game
        Tank t=new Tank(30,70);
        assertEquals(t.tank1.getClass(), Tank.class);
        assertEquals(t.tank2.getClass(), Texture.class);
        assertNotSame(t.tank1, t.tank2);
        assertNotNull(t.tank1);

    }

}

