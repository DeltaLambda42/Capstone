package CAPSTONE.BETA;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by brandon on 11/10/2016.
 */
public class Game extends StateBasedGame {

    private static final String gameTitle = "Rapid Roll!";
    private static final int menu = 0;
    private static final int help = 1;
    private static final int play = 2;

    public Game(String gameTitle){
        super(gameTitle);
        this.addState(new Menu(menu));
        this.addState(new Help(help));
        this.addState(new Play(play));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(menu).init(gameContainer, this);
        this.getState(help).init(gameContainer, this);
        this.getState(play).init(gameContainer, this);
        this.enterState(play);
    }

    public static Coordinates getLoc(){
        return new Coordinates(450, 800);
    }

    public static void main(String[] args) {
        AppGameContainer mainGame;
        try{
            mainGame = new AppGameContainer(new Game(gameTitle));
            mainGame.setDisplayMode(450, 500, false);
            mainGame.start();
        }catch (SlickException e){
            e.printStackTrace();
        }
    }
}
