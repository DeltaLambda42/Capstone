package CAPSTONE.Beta_ver1;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Created by brandon on 11/10/2016.
 */
public class Menu extends BasicGameState {

    private Animation main, load;
    private int x, y;
    private int[] duration = {500, 500};
    private int[] duration1 = {300, 300, 300, 300, 100, 100, 100, 100, 100, 100, 100, 200, 400, 400, 1000, 200};
    private boolean start = false;
    private float time = 0;
    private Sound monkey;

    Menu(int state){

    }

    @Override

    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Image[] mainMenu = new Image[2];
        mainMenu[0] = new Image("CAPSTONE/Beta_ver1/res/menuBackGround.png");
        mainMenu[1] = new Image("CAPSTONE/Beta_ver1/res/menuBackGround1.png");

        monkey = new Sound("CAPSTONE/Beta_ver1/res/Sound/MonkeyLaugh.wav");

        Image[] loading = new Image[16];
        for(int i = 1; i <= 16; i++){
            loading[i - 1] = new Image("CAPSTONE/Beta_ver1/res/Loading/Loading" + i + ".png");
        }

        load = new Animation(loading, duration1, true);
        main = new Animation(mainMenu, duration, true);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        if(start) main.draw(0, 0);
        else {
            load.draw(0, 0);
            if(time >= 4100) start = true;
        }
        //graphics.drawString("x : " + time, 100, 300);
        //graphics.drawString("x : " + x + " and y: " + y, 100, 300);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        time += i;

        x = Mouse.getX();
        y = Mouse.getY();

        if((x > 182 && x < 356) && (y < 355 && y > 314)){
            if(Mouse.isButtonDown(0)){
                monkey.play();
                stateBasedGame.enterState(2, new FadeOutTransition(), new FadeInTransition());
            }
        }
        if((x > 11 && x < 219) && (y < 220 && y > 173)){
            if(Mouse.isButtonDown(0)){
                stateBasedGame.enterState(4, new FadeOutTransition(), new FadeInTransition());
            }
        }
        if((x > 231 && x < 404) && (y < 80 && y > 40)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
}
