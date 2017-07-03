package main;


import game.Creditos;
import game.Instrucciones;
import game.Menu;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import util.GameStates;

/**
 *
 * @author rober
 */
public class Game extends StateBasedGame{

    public static final String 
            gameName = "Mi juego";
    
    //RESOLUCION
    public static final int xSize = 800;
    public static final int ySize = 600;
    public static final boolean fullscreen = 
            false;
    
    public Game() {
        super(gameName);
        this.addState(
                new Menu(GameStates.menu));
        this.addState(
               new Instrucciones (GameStates.instrucciones));
        this.addState(
                new Creditos(GameStates.creditos));
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(GameStates.menu).
                init(gc, this);
        this.getState(GameStates.instrucciones).
                init(gc, this);
        this.getState(GameStates.creditos).
                init(gc, this);
        this.enterState(GameStates.menu);
    }
    
    public static void main(String[] args) 
            throws SlickException{
        AppGameContainer app =
                new AppGameContainer
                (new Game());
        app.setDisplayMode(xSize, 
                ySize, fullscreen);
        app.setVSync(true);
        app.start();
    }
    
}
