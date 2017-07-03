
package game;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import util.GameStates;

/**
 *
 * @author rober
 */
public class Instrucciones extends BasicGameState {
    
    int state;
    long totalTime;
    private int playerChoise = 0;
    
    private static final int SALIR = 0;
    private static final int NINGUNA = 1;
    private String[] playerOptions = 
            new String[NINGUNA];
    private TrueTypeFont optionsTTF, menuTitle;
    private Color notChosen = new Color(0,0,153);
    //RECUERSOS
    Image introBG;
    Music introMusic;
    
    //FUENTE
    private java.awt.Font font;
    private TrueTypeFont tituloTTF;
    private Color tituloColor = 
            new Color(0,0,153);
    
    

    public Instrucciones(int state) {
        this.state = state;
    }
    
    @Override
    public int getID() {
        return this.state;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        totalTime = 0;
        introMusic = new Music("res/intro.wav");    
        introBG = new Image("res/fondo_intro.png");
        font = new java.awt.Font(
                "Verdana", 
                java.awt.Font.BOLD,
                40);
       optionsTTF = new TrueTypeFont(font, true);
        menuTitle = new TrueTypeFont(font, true);
        
        tituloTTF = new TrueTypeFont(font, true);
        
        playerOptions[0] = "Salir";
    }

    @Override
    public void render(GameContainer gc, 
            StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(introBG, 0, 0);
        g.drawString("Time: "+totalTime/1000, 
                10, 25);
        tituloTTF.drawString(270,
                50, "Instrucciones", 
                tituloColor);
       renderOptions();
    }
    
     private void renderOptions(){
        for (int i = 0; i < NINGUNA; i++) {
            if ( playerChoise == i){
                optionsTTF.
                    drawString(100, i*50 + 500, 
                        playerOptions[i]);
            } else{
                optionsTTF.
                    drawString(1000, i*50 + 2000, 
                        playerOptions[i],
                        notChosen);
            }
        }
    }

    @Override
    public void update(GameContainer gc, 
            StateBasedGame sbg, int delta) throws SlickException {
        
        int time = (int) (totalTime);
        if(time == 0){
            introMusic.loop(1.0f, 0.5f);
        }
        
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_DOWN)){
            if(playerChoise == (NINGUNA - 1)){
                playerChoise = 0;
            } else{
                playerChoise++;
            }
        }
         if(input.isKeyPressed(Input.KEY_UP)){
            if(playerChoise == 0){
                playerChoise = (NINGUNA - 1);
            } else{
                playerChoise--;
            }
        }

       if(input.isKeyPressed(Input.KEY_ENTER)){
            introMusic.stop();
            switch (playerChoise){
            case SALIR:
                      introMusic.stop();
                    sbg.getState(GameStates.menu).
                            init(gc, sbg);
                    sbg.enterState(GameStates.menu);
                    break;
            }
           // sbg.getState(GameStates.play).
                           // init(gc, sbg);
                   // sbg.enterState(GameStates.play);
        }
        
        totalTime += delta;
    }
    
}
