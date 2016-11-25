package CAPSTONE.Beta_ver1;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by brandon on 11/10/2016.
 */
public class Game extends StateBasedGame {

    private static final String gameTitle = "CAERY'S DESCENT";
    private static final int menu = 0;
    private static final int help = 1;
    private static final int play = 2;
    private static final int pause = 3;
    private static final int options = 4;
    private static final int gameover = 5;
    private static final int reset = 6;

    public Game(String gameTitle){
        super(gameTitle);
        this.addState(new Menu(menu));
        this.addState(new Help(help));
        this.addState(new Play(play));
       // this.addState(new Pause(pause));
        this.addState(new Options(options));
        this.addState(new GameOver(gameover));
        this.addState(new Reset(reset));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(menu).init(gameContainer, this);
        this.getState(help).init(gameContainer, this);
        this.getState(play).init(gameContainer, this);
        //this.getState(pause).init(gameContainer, this);
        this.getState(options).init(gameContainer, this);
        this.getState(gameover).init(gameContainer, this);
        this.getState(reset).init(gameContainer, this);
        this.enterState(menu);
    }

    public static Coordinates getLoc(){
        return new Coordinates(450, 800);
    }

    public static void main(String[] args) {
        AppGameContainer mainGame;
        try{
            mainGame = new AppGameContainer(new Game(gameTitle));
            mainGame.setDisplayMode(450, 525, false);
            mainGame.start();
        }catch (SlickException e){
            e.printStackTrace();
        }
    }
}
