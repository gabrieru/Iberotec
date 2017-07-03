/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.vecmath.Vector2f;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author profesor-205
 */
public class Misil {
    //Constantes
    public static final int DIR_DERECHA = 1;
    public static final int DIR_IZQUIERDA = 2;
    public static final int DIR_ARRIBA = 3;
    public static final int DIR_ABAJO = 4;
    
    
    Animation misil, misilDerecha, misilIzquierda,
            misilArriba, misilAbajo;
    //Posicion x, y
    Vector2f posicion = new Vector2f();
    SpriteSheet imagenes;
    //Indica la dirección del misil
    int direccion;
    
    public Misil(int x, int y, int direccion){
        this.posicion.x = x;
        this.posicion.y = y;
        this.direccion = direccion;
    }
    
    
    //1: Se ejecuta una sola vez
    public void init(GameContainer gc, 
        StateBasedGame sbg) 
        throws SlickException {
        //1: Obtener todas las imagenes
        imagenes = new SpriteSheet("res/link.png", 30, 30);
        
        //2: Preparar animaciones
        //2.1 Crear animación
        misilDerecha = new Animation();
        //2.2 Eliminan AutoUpdate
        misilDerecha.setAutoUpdate(false);
        //2.3 Agregar frames a la animación
        misilDerecha.addFrame(imagenes.getSprite(3, 7).
                        getScaledCopy(2.0f), 250);
        misilDerecha.addFrame(imagenes.getSprite(3, 8).
                        getScaledCopy(2.0f), 250);
        
        misilIzquierda = new Animation();
        misilIzquierda.setAutoUpdate(false);
        misilIzquierda.addFrame(imagenes.getSprite(1, 7).
                        getScaledCopy(2.0f), 250);
        misilIzquierda.addFrame(imagenes.getSprite(1, 8).
                        getScaledCopy(2.0f), 250);
        
        misilArriba = new Animation();
        misilArriba.setAutoUpdate(false);
        misilArriba.addFrame(imagenes.getSprite(2, 7).
                        getScaledCopy(2.0f), 250);
        misilArriba.addFrame(imagenes.getSprite(2, 8).
                        getScaledCopy(2.0f), 250);

        misilAbajo = new Animation();
        misilAbajo.setAutoUpdate(false);
        misilAbajo.addFrame(imagenes.getSprite(0, 7).
                        getScaledCopy(2.0f), 250);
        misilAbajo.addFrame(imagenes.getSprite(0, 8).
                        getScaledCopy(2.0f), 250);

    }

    //2: Modificaciones -> Lógica principal
    public void update(GameContainer gc, 
            StateBasedGame sbg, int delta)
            throws SlickException {
        if(direccion==DIR_DERECHA){
            posicion.x += 1; 
        } else if(direccion==DIR_IZQUIERDA){
            posicion.x -= 1; 
       } else if(direccion==DIR_ARRIBA){
            posicion.y -= 1; 
        } else if(direccion==DIR_ABAJO){
            posicion.y += 1; 
        }
    }
    
    //3: Pintar personaje en la pantalla
    public void render(GameContainer gc, 
            StateBasedGame sbg, Graphics grphcs) 
            throws SlickException {
        //Dibuja la animación actual del misil en la pantalla
        misil.draw(posicion.x, posicion.y);
    }
    
}
