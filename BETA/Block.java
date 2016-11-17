package CAPSTONE.BETA;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;

/**
 * Created by brandon on 11/16/2016.
 */
public class Block extends Character{
    private int type;
    private boolean spawnLife, havePowerUp;
    private int pUP;
    private Powerup p;
    private Random r = new Random();

    public Powerup getP(){
        return p;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isSpawnLife() {
        return spawnLife;
    }

    public void setSpawnLife(boolean spawnLife) {
        this.spawnLife = spawnLife;
    }

    public void placeTop(int x){
        if(spawnLife){
            p.setX(x);
            p.setY(getY() - p.getHeight());
            //System.out.println("TAEEEE " + p.getX() + " : " + p.getY());
            //System.out.println("TAEEEE " + p.getWidth() + " : " + p.getHeight());
        }
        p.updateRect();
    }

    public boolean isHavePowerUp() {
        if(spawnLife) return true;
        return false;
    }

    Block(Powerup p, Image image, float x , float y){
        super(image, x, y, 0.05f);
        this.p = p;
        type = 0;
        spawnLife = false;
        pUP = 0;
        havePowerUp = false;
    }
}
