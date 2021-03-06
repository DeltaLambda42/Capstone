package CAPSTONE.BETA;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by brandon on 11/10/2016.
 */
public class Menu extends BasicGameState {

    private Image mainMenu;
    private int x, y;

    Menu(int state){

    }

    @Override

    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        mainMenu = new Image("CAPSTONE/BETA/res/menuBackGround.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        mainMenu.draw(0, 0);
        //graphics.drawString("x : " + x + " and y: " + y, 100, 300);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        x = Mouse.getX();
        y = Mouse.getY();

        if((x > 52 && x < 400) && (y < 334 && y > 236)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(2);
            }
        }
        if((x > 52 && x < 400) && (y < 220 && y > 122)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(4);
            }
        }
        if((x > 52 && x < 400) && (y < 110 && y > 10)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
}
