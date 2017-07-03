package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import util.GameStates;

/**
 *
 * @author rober
 */
public class Menu extends BasicGameState{
    int state;
    private int playerChoise = 0;
    
    //OPCIONES
    private static final int START = 0;
    private static final int INSTRUCCIONES = 1;
    private static final int CREDITOS = 2;
    private static final int SALIR = 3;
    private static final int NINGUNA = 4;
    private String[] playerOptions = 
            new String[NINGUNA];
    
    private boolean exit = false;
    private java.awt.Font font;
    
    private TrueTypeFont optionsTTF, menuTitle;
    private Color notChosen = new Color(0,0,153);
    private Color title = new Color(0,0,153);

    //RECUERSOS
    Image background;
    Music opening;
    
    public Menu(int state) {
        this.state = state;
    }
    
    @Override
    public int getID() {
        return this.state;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        font = new java.awt.Font(
                "Verdana", 
                java.awt.Font.BOLD,
                40);
        optionsTTF = new TrueTypeFont(font, true);
        
        menuTitle = new TrueTypeFont(font, true);
        
         playerOptions[0] = "Iniciar Partida";
        playerOptions[1] = "Instrucciomes";
        playerOptions[2] = "Credotos";
        playerOptions[3] = "Salir";
        
        //FONDO
        background = new Image("res/background.png");
        //MUSICA DE FONDO
        opening = new Music("res/background.wav");
        //REPRODUCE Y GENERA EL BUCLE 
        // PRIMER VALOR VELOCIDAD - SEGUND VOLUMEN
       opening.loop(1.0f, 0.3f);
    }

    @Override
    public void render(GameContainer gc, 
            StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.drawImage(background, 0, 0);
        menuTitle.
        drawString(100, 50, "Pantalla de Acceso",
                title);
        grphcs.drawString("Vienvenido", 100, 100);
        
        renderOptions();
    }
    
    private void renderOptions(){
        for (int i = 0; i < NINGUNA; i++) {
            if ( playerChoise == i){
                optionsTTF.
                    drawString(100, i*50 + 200, 
                        playerOptions[i]);
            } else{
                optionsTTF.
                    drawString(100, i*50 + 200, 
                        playerOptions[i],
                        notChosen);
            }
        }
    }

    @Override
    public void update(GameContainer gc, 
            StateBasedGame sbg, int delta) throws SlickException {
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
            switch (playerChoise){
                
                case SALIR:
                    gc.exit();
                    break;
                    
                  case START:
                      opening.stop();
                    sbg.getState(GameStates.start).
                            init(gc, sbg);
                    sbg.enterState(GameStates.start);
                    break;
                    
                 case INSTRUCCIONES:
                      opening.stop();
                    sbg.getState(GameStates.instrucciones).
                            init(gc, sbg);
                    sbg.enterState(GameStates.instrucciones);
                    break;
                    
                 case CREDITOS:
                      opening.stop();
                    sbg.getState(GameStates.creditos).
                            init(gc, sbg);
                    sbg.enterState(GameStates.creditos);
                    break;
            }
        }
    }
    
}
