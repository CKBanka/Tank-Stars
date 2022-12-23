package Utils;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.States.P2PplayState;
import jdk.jfr.Percentage;

import java.awt.event.ContainerEvent;

public class WorldContactListner implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA=contact.getFixtureA();
        Fixture fixB=contact.getFixtureB();
        if((fixA.getUserData()  instanceof P2PplayState) && fixB.getUserData()=="Bullet"){
            System.out.println("Yups");
            ((P2PplayState) fixA.getUserData()).dpB();
        }
        else if((fixB.getUserData() instanceof P2PplayState) && fixA.getUserData()=="Bullet"){
            System.out.println("Yuos");
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
