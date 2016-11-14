package CAPSTONE.Alpha;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.geom.Shape;

import java.util.Vector;

/**
 * Created by brandon on 11/10/2016.
 */
public class Play extends BasicGameState {
    private Platform p;
    //private Character player;
    private int x, y, gameWidth, gameHeight;
    private float time, blockyspeed, playeryspeed;
    private Player player;
    private Vector<Block> blocks;
    private boolean pause;
    private boolean top;
    private Block block;
    private Image bl;
    private Image pl;

    Play(int state){

    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        p = new Platform();
        pause = false;
        top = false;
        blocks = new Vector<>();
        time = 0;
        blockyspeed = 0.15f;
        playeryspeed = 0.3f;
        gameWidth = gameContainer.getWidth();
        gameHeight = gameContainer.getHeight();
        bl = new Image("CAPSTONE/Alpha/res/block.png");
        pl = new Image("CAPSTONE/Alpha/res/player.png");
        player = new Player(pl.getWidth(), pl.getHeight());
        //block = new Block(bl, 1, p.randInt(), gameHeight - p.getHeight());
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        pl.draw(player.getX(), player.getY(), pl.getWidth(), pl.getHeight());
        graphics.drawString("Time : " + time, 50, 50);
        for(Block b : blocks){
            b.getBlock().draw(b.getX(), b.getY());
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int elapsedTime) throws SlickException {
        Input in = gameContainer.getInput();

        time += elapsedTime;
        x = p.randInt();

        if(player.isAlive()){
            if(!pause){
                if (in.isKeyDown(Input.KEY_LEFT)) {
                    player.setXspeed(-0.2f);
                    player.move();
                } else if (in.isKeyDown(Input.KEY_RIGHT)) {
                    player.setXspeed(0.2f);
                    player.move();
                }
                if(time >= 2000){
                    time = 0;
                }if(time == 100){
                    blocks.add( new Block (bl, p.randInt(1,2), p.randInt(), gameHeight - p.getHeight()));
                }

                //if(player.getY() < gameHeight - pl.getHeight()) player.setY(player.getY() + player.getYspeed());
                player.getShape().setLocation(player.getX(), player.getY());
                for(Block b : blocks){
                    b.setY(b.getY() - blockyspeed);
                    b.getShape().setLocation(b.getX(), b.getY());
                    if(player.getShape().intersects(b.getShape()) /*&& !top */){
                        top = true;
                        hit(player.getShape(), b.getShape());
                    }
                    /*if(player.getShape().intersects(b.getShape())){
                        System.out.println("true");
                        player.setY(player.getY() - blockyspeed);
                        player.getShape().setLocation(player.getX(), player.getY());
                    }else{
                        if(player.getY() < gameHeight - pl.getHeight()) player.setY(player.getY() + player.getYspeed());
                    }*/
                }
                if(!top){
                    //if(player.getY() < gameHeight - pl.getHeight())
                        player.setY(player.getY() + player.getYspeed());
                }
                check();
            }
        }
    }

    private void check(){
        int ctr = 0;
        for(; ctr < blocks.size(); ctr++){
            Block b = blocks.get(ctr);
            if(b.getY() <= b.getBlock().getHeight()){
                blocks.remove(ctr);
            }
        }
    }

    private void hit(Shape one, Shape two){
        player.setY(player.getY() - blockyspeed);
        two.setLocation(two.getX(), two.getY());
        player.getShape().setLocation(player.getX(), player.getY());
        if(!one.intersects(two)){

            top = false;
            System.out.println("nisulod ko diri");
        }
    }
}
