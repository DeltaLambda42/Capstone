package CAPSTONE.Beta_ver1;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by brandon on 11/18/2016.
 */
public class GameOver extends BasicGameState {

    private Image gameover;
    private int x, y;
    private boolean flag = true;
    private Sound gover;

    @Override
    public int getID() {
        return 5;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        gameover = new Image("CAPSTONE/Beta_ver1/res/gameover.png");
        gover = new Sound("CAPSTONE/Beta_ver1/res/Sound/GameOver.wav");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        gameover.draw(0, 0);
        if(flag){
            gover.play();
            flag = false;
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        x = Mouse.getX();
        y = Mouse.getY();

        if((x > 182 && x < 356) && (y < 312 && y > 270)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(2);
            }
        }
        if((x > 30 && x < 205) && (y < 130 && y > 88)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }

    GameOver(int state){}
}
