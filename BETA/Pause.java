package CAPSTONE.BETA;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by brandon on 11/18/2016.
 */
public class Pause extends BasicGameState {

    private Image pause;
    private int x, y;

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        pause = new Image("CAPSTONE/BETA/res/pause.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        pause.draw(0, 0);
        //graphics.drawString("x : " + x + " and y: " + y, 100, 300);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        x = Mouse.getX();
        y = Mouse.getY();

        if((x > 84 && x < 384) && (y < 320 && y > 250)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(2);
            }
        }
        if((x > 84 && x < 384) && (y < 235 && y > 166)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(6);
            }
        }
        if((x > 84 && x < 384) && (y < 154 && y > 85)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(4);
            }
        }
        if((x > 84 && x < 384) && (y < 76 && y > 8)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }

    Pause(int state){

    }
}
