package CAPSTONE.Alpha;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by brandon on 11/10/2016.
 */
public class Menu extends BasicGameState {

    private Image bstart, bexit;
    private int x, y;

    Menu(int state){

    }

    @Override

    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bstart = new Image("CAPSTONE/DEMO/res/playNow.png");
        bexit = new Image("CAPSTONE/DEMO/res/exitGame.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("WELCOME to THE GAME", 100, 100);
        bstart.draw(100, 150);
        bexit.draw(100, 200);
        graphics.drawString("x : " + x + " and y: " + y, 100, 300);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        x = Mouse.getX();
        y = Mouse.getY();

        if((x > 100 && x < 311) && (y < 650 && y > 620)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(2);
            }
        }
        if((x > 100 && x < 311) && (y < 600 && y > 570)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
}
