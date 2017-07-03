package entity;

import javax.vecmath.Vector2f;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
/**
 *
 * @author profesor-205
 */
public class Player {
    
    Animation character, movUp, movDw,
            movLf, movRt;
    Vector2f position = new Vector2f();
    SpriteSheet charSprite;
    
    public void init(GameContainer gc, 
            StateBasedGame sbg) 
            throws SlickException {
        charSprite = new SpriteSheet
        ("res/link.png", 30, 30);
        
        movDw = new Animation();
        movDw.setAutoUpdate(false);
        movDw.addFrame(
           charSprite.getSprite(0, 0).
                        getScaledCopy(2.0f), 
                250);
        movDw.addFrame(
           charSprite.getSprite(0, 1).
                        getScaledCopy(2.0f), 
                250);
        
        movUp = new Animation();
        movUp.setAutoUpdate(false);
        movUp.addFrame(
           charSprite.getSprite(2, 0).
                        getScaledCopy(2.0f), 
                250);
        movUp.addFrame(
           charSprite.getSprite(2, 1).
                        getScaledCopy(2.0f), 
                250);
        
        movLf = new Animation();
        movLf.setAutoUpdate(false);
        movLf.addFrame(
           charSprite.getSprite(1, 0).
                        getScaledCopy(2.0f), 
                250);
        movLf.addFrame(
           charSprite.getSprite(1, 1).
                        getScaledCopy(2.0f), 
                250);
        
        movRt = new Animation();
        movRt.setAutoUpdate(false);
        movRt.addFrame(
           charSprite.getSprite(3, 0).
                        getScaledCopy(2.0f), 
                250);
        movRt.addFrame(
           charSprite.getSprite(3, 1).
                        getScaledCopy(2.0f), 
                250);
        
        
        character = movDw;
        this.position.x = 100;
        this.position.y = 100;
    }
    
    public void render(GameContainer gc, 
            StateBasedGame sbg, Graphics grphcs) 
            throws SlickException {
        character.draw(this.position.x, 
                this.position.y);
    }
    
    public void update(GameContainer gc, 
            StateBasedGame sbg, int delta)
            throws SlickException {
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_DOWN)){
            movDw.update(delta);
            character = movDw;
            this.position.y += 1.00;
        }
         if(input.isKeyDown(Input.KEY_UP)){
            movUp.update(delta);
            character = movUp;
            this.position.y -= 1.00;
        }
         
         if(input.isKeyDown(Input.KEY_LEFT)){
            movLf.update(delta);
            character = movLf;
            this.position.x -= 1.00;
        }
         
         if(input.isKeyDown(Input.KEY_RIGHT)){
            movRt.update(delta);
            character = movRt;
            this.position.x += 1.00;
        }
    }
}