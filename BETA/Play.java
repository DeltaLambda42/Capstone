package CAPSTONE.BETA;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

/**
 * Created by brandon on 11/16/2016.
 */
public class Play extends BasicGameState {

    private Animation runningLeft, runningRight, idle, steadyLeft, steadyRight;
    private Image player;
    private Image[] powerUp;
    private Player mplayer;
    private Image[] platform;
    private Block[] block;
    private Random rand = new Random();
    private boolean onTop, flag, pupSpawned, hitTop, pupHit, addPUP, updateSpawn, hitSpike, hitPUP;
    private Block temp, tempSpawn, tempPUP;
    private float time;
    private Powerup p;
    private int tempX;
    private Image bg;
    private int level, height, width;
    private boolean PLAY, PAUSE, OPTIONS, QUIT, changeSpeed;

    private int[] duration = {100, 100, 100, 100, 100, 100, 100};
    private int[] duration2 = {100, 100};

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        level = 0;
        PLAY = true;
        PAUSE = false;
        OPTIONS = false;
        QUIT = false;
        height = gameContainer.getHeight();
        width = gameContainer.getWidth();

        Image[] runLeft = new Image[7];                                                             Image[] runRight = new Image[7];
        runLeft[0] = new Image("CAPSTONE/BETA/res/Animation/run_LEFT/run_00 left.png");             runRight[0] = new Image("CAPSTONE/BETA/res/Animation/run_RIGHT/run_00 right.png");
        runLeft[1] = new Image("CAPSTONE/BETA/res/Animation/run_LEFT/run_01 left.png");             runRight[1] = new Image("CAPSTONE/BETA/res/Animation/run_RIGHT/run_01 right.png");
        runLeft[2] = new Image("CAPSTONE/BETA/res/Animation/run_LEFT/run_02 left.png");             runRight[2] = new Image("CAPSTONE/BETA/res/Animation/run_RIGHT/run_02 right.png");
        runLeft[3] = new Image("CAPSTONE/BETA/res/Animation/run_LEFT/run_03 left.png");             runRight[3] = new Image("CAPSTONE/BETA/res/Animation/run_RIGHT/run_03 right.png");
        runLeft[4] = new Image("CAPSTONE/BETA/res/Animation/run_LEFT/run_04 left.png");             runRight[4] = new Image("CAPSTONE/BETA/res/Animation/run_RIGHT/run_04 right.png");
        runLeft[5] = new Image("CAPSTONE/BETA/res/Animation/run_LEFT/run_05 left.png");             runRight[5] = new Image("CAPSTONE/BETA/res/Animation/run_RIGHT/run_05 right.png");
        runLeft[6] = new Image("CAPSTONE/BETA/res/Animation/run_LEFT/run_06 left.png");             runRight[6] = new Image("CAPSTONE/BETA/res/Animation/run_RIGHT/run_06 right.png");

        Image[] Idle = new Image[2];                                                                Image[] Idle2 = new Image[2];
        Idle[0] = new Image("CAPSTONE/BETA/res/Animation/idle_RIGHT/idle_closeEyes_right.png");     Idle2[0] = new Image("CAPSTONE/BETA/res/Animation/idle_LEFT/idle_closeEyes_left.png");
        Idle[1] = new Image("CAPSTONE/BETA/res/Animation/idle_RIGHT/idle_openEyes_right.png");      Idle2[1] = new Image("CAPSTONE/BETA/res/Animation/idle_LEFT/idle_openEyes_left.png");

        changeSpeed = false;
        addPUP = false;
        hitPUP = false;
        hitSpike = false;
        updateSpawn = false;
        onTop = true;
        flag = true;
        hitTop = false;
        pupSpawned = false;
        pupHit = false;
        tempX = 0;
        //spawnLife = false;
        platform = new Image[2];
        powerUp = new Image[4];
        block = new Block[5];
        bg = new Image("CAPSTONE/BETA/res/BackGround.png");
        powerUp[0] = new Image("CAPSTONE/BETA/res/heart.png");
        player = new Image("CAPSTONE/Alpha/res/player.png");
        platform[0] = new Image("CAPSTONE/BETA/res/base.png");
        platform[1] = new Image("CAPSTONE/BETA/res/spikes.png");
        p = new Powerup(powerUp);
        /*int x = randInt(0, gameContainer.getWidth() - platform[0].getWidth());
        block[0] = new Block(p, platform[0], x, 100);
        temp = block[0];
        mplayer = new Player(player, x + platform[0].getWidth()/2, 100 - player.getHeight());
        for(int i = 1, j = 200; i < block.length; i++, j+=100){
            block[i] = new Block(p, platform[0], randInt(0, gameContainer.getWidth() - platform[0].getWidth()), j);
        }*/
        instantiate();

        steadyRight = new Animation(Idle, duration2, true);
        steadyLeft = new Animation(Idle2, duration2, true);
        runningLeft = new Animation(runLeft, duration, true);
        runningRight = new Animation(runRight, duration, true);
        idle = steadyLeft;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        if(mplayer.isAlive()){
            graphics.drawImage(bg, 0, 0);
            idle.draw(mplayer.getX(), mplayer.getY());
            graphics.drawString("Lives : " + mplayer.getLives(), 20, 50);
            graphics.drawString("SCORE: " + mplayer.getScore(), 300, 50);

            for(Block b : block){
                if(b.isHavePowerUp() && !mplayer.isHitPUP()){
                    if(b.isSpawnLife()){
                        b.getP().getPowerUP()[0].draw(b.getP().getX(), b.getP().getY());
                    }
                }
                if(mplayer.isHitPUP()) mplayer.setHitPUP(false);
                b.getImage().draw(b.getX(), b.getY());
            }
        }else{
            stateBasedGame.enterState(5);
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int elapsedTime) throws SlickException {
        Input in = gameContainer.getInput();

        time += elapsedTime;
        //mplayer.setHitPUP(false);
        if (in.isKeyDown(Input.KEY_ESCAPE)){
            stateBasedGame.enterState(3);
        }
      //  if(PLAY){
        if(mplayer.isAlive()){
            if (in.isKeyDown(Input.KEY_LEFT)) {
                idle = runningLeft;
                mplayer.setXspeed(-0.15f);
                mplayer.move();
            } else if (in.isKeyDown(Input.KEY_RIGHT)) {
                idle = runningRight;
                mplayer.setXspeed(0.15f);
                mplayer.move();
            } else{
                if(idle == runningLeft) idle = steadyLeft;
                if(idle == runningRight) idle = steadyRight;
            }
            clearUps();
            if(mplayer.getScore() >= 500 && mplayer.getScore() <= 1500 && !changeSpeed){
                level = 1;
                setAllyspeed(0.1f);
                changeSpeed = true;
            }
            if(mplayer.getScore() > 1500 && mplayer.getScore() <= 2500 && changeSpeed){
                level = 2;
                setAllyspeed(0.15f);
                changeSpeed = false;
            }
            if(mplayer.getScore() > 2500 && mplayer.getScore() <= 4000 && !changeSpeed){
                level = 3;
                setAllyspeed(0.2f);
                changeSpeed = true;
            }
            if(mplayer.getScore() > 4000 && changeSpeed){
                level = 4;
                setAllyspeed(0.25f);
                changeSpeed = false;
            }
            addPowerups();
            moveBlocks();
            if(hitPUP){
                mplayer.addLife();
                hitPUP = false;
            }
            if(addPUP){
                addPUP = false;
                tempSpawn.setSpawnLife(true);
                tempSpawn.placeTop((int)tempSpawn.getX() + tempSpawn.getWidth()/2);
                updateSpawn = true;
            }
            if(hitTop){
                mplayer.minusLife();
                hitTop = false;
            }
            if(pupHit){
                pupSpawned = false;
                tempPUP.setSpawnLife(false);
                pupHit = false;
            }
            if(onTop) {
                mplayer.setY(temp.getY() - mplayer.getHeight());
                time = 0;
            }
            else {
                mplayer.setY(mplayer.getY() + mplayer.getYspeed());
                if(mplayer.getY() >= 800) mplayer.minusLife();
                mplayer.addScore(time/10000);
            }
            mplayer.updateRect();
        }
      //  }

    }

    private void moveBlocks(){
        for(Block b : block){
            if(mplayer.getRect().intersects(b.getRect())){
                check(b);
            }

            if(mplayer.getY() <= 5 || mplayer.getY() >= height){
                hitSpike = true;
            }
            if(b.getY() <= 0) {
                b.setY(height);
                b.setX(randInt(0, width - b.getWidth()));
                if(hitSpike && b.getType() != 1){
                    mplayer.setY(b.getY() - mplayer.getHeight());
                    mplayer.setX(b.getX() + b.getWidth()/2);
                    hitTop = true;
                    hitSpike = false;
                }
            }
            if(b.isHavePowerUp()){
                b.placeTop((int)b.getX() + b.getWidth()/2);
                if(mplayer.getRect().intersects(b.getP().getRect())){
                    pupSpawned = false;
                    b.setSpawnLife(false);
                    mplayer.setHitPUP(true);
                    hitPUP = true;
                }
            }
            b.setY(b.getY() - b.getYspeed());
            b.updateRect();
        }
    }

    private void setAllyspeed(float f){
        for(Block b : block){
            b.setYspeed(f);
        }
    }

    public void check(Block b){
        if(mplayer.getY() + mplayer.getHeight() - 1 <= b.getY() && mplayer.getX() + mplayer.getWidth() >= b.getX() && mplayer.getX() <= b.getX() + b.getWidth()){
            if(b.getType() == 1){
                //mplayer.minusLife();
                onTop = false;
                hitSpike = true;
            }else{
                temp = b;
                onTop = true;
            }
        }else{
            onTop = false;
        }
    }

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    private void clearUps(){
        for(Block b : block){
            if(b.getY() <= 0 && b.isHavePowerUp()){
                pupSpawned = false;
                b.setSpawnLife(false);
                break;
            }
        }
    }

    private void addPowerups(){
        for(Block b : block){
            if(b.getY() <= 0 && !pupSpawned) {
                if(level == 1){
                    int x = randInt(1, 10);
                    if(x == 2 || x == 7){
                        b.setType(1);
                    }else {
                        b.setType(0);
                        if(x == 1 || x == 3 || x == 5 || x == 9){
                            b.setSpawnLife(true);
                            pupSpawned = true;
                        }
                    }
                }
                if(level == 2){
                    int x = randInt(1, 10);
                    if(x == 2 || x == 7 || x == 9){
                        b.setType(1);
                    }else{
                        b.setType(0);
                        if(!pupSpawned && x == 1 || x == 3 || x == 5){
                            pupSpawned = true;
                        }
                    }
                }
                if(level == 3 || level == 4){
                    int x = randInt(1, 10);
                    if(x == 2 || x == 7 || x == 9){
                        b.setType(1);
                    }else{
                        b.setType(0);
                        if(!pupSpawned && x == 3 || x == 6){
                            pupSpawned = true;
                        }
                    }
                }
                b.setImage(platform[b.getType()]);
                break;
            }
        }
    }

    public void reset(){
        mplayer.setLives(3);
        mplayer.setScore(0);
        mplayer.setAlive(true);
        instantiate();
        clearUps();
        setAllyspeed(0.05f);
    }

    public void instantiate(){
        int x = randInt(0, width - platform[0].getWidth());
        block[0] = new Block(p, platform[0], x, 100);
        temp = block[0];
        mplayer = new Player(player, x + platform[0].getWidth()/2, 100 - player.getHeight());
        for(int i = 1, j = 200; i < block.length; i++, j+=100){
            block[i] = new Block(p, platform[0], randInt(0, width - platform[0].getWidth()), j);
        }
    }

    Play(int state){

    }

    @Override
    public int getID() {
        return 2;
    }
}
