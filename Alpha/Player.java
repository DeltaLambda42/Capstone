package CAPSTONE.Alpha;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

/**
 * Created by brandon on 11/10/2016.
 */
public class Player extends Character{

    private int lives;
    private boolean isAlive;

    Player(int width, int height){
        super(width, height, new Coordinates(20, 20), 0, 0.1f, new Circle(20, 20, width));
        lives = 3;
        isAlive = true;
    }

    public void takeDamage(){
        if(lives == 1){
            isAlive = false;
        }
        lives--;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void move() {
        if (getX() + getXspeed() > 0 && getX() + getXspeed() < Game.getLoc().getX() - getWidth())
            setX(getX() + getXspeed());
    }

    public int getLives() {
        return lives;
    }
}
