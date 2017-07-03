
package game;
import entity.Player;
import java.util.ArrayList;
import java.util.Random;
import javax.vecmath.Vector2f;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import util.Camera;
import util.GameStates;

public class Start  extends BasicGameState {
    int state;
 long totalTime;
 
 boolean quit;
 
 
 //entity
 Player player;
 
 
 //mapa
 TiledMap map; 

 //camara
 Camera camera;
 
 public Start (int state) {
        this.state = state;
    }
 
    @Override
    public int getID() {
       return this.state;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        totalTime = 0;
        quit = false;
        map = new TiledMap("res/TileMap.tmx");
        player = new Player();
        player.init(gc, sbg);
        camera = new Camera(gc, map);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       //camera.centerOn(layer.position.x,player.position.y);
       
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
