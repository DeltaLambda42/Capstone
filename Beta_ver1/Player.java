package CAPSTONE.Beta_ver1;

import org.newdawn.slick.Image;

/**
 * Created by brandon on 11/16/2016.
 */
public class Player extends Character {

    private int lives, pup;
    private float xspeed;
    private float score;
    private boolean isAlive, hitPUP;

    public void move() {
        if (getX() + getXspeed() > 0 && getX() + getXspeed() < Game.getLoc().getX() - getWidth())
            setX(getX() + getXspeed());
    }

    public boolean isHitPUP() {
        return hitPUP;
    }

    public void setHitPUP(boolean hitPUP) {
        this.hitPUP = hitPUP;
    }

    public void whatPUP(int pup){
        this.pup = pup;
    }

    public int getPUP(){
        return pup;
    }

    public void addScore(float score){
        this.score += score;
    }

    public int getScore(){
        return (int) score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void addLife(){
        if(lives < 5) lives++;
        else score += 300;
    }

    public void minusLife(){
        if(lives == 1) isAlive = false;
        else lives --;
    }

    public int getLives(){
        return lives;
    }

    public void setLives(int lives){
        this.lives = lives;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public float getXspeed() {
        return xspeed;
    }

    public void setXspeed(float xspeed) {
        this.xspeed = xspeed;
    }

    Player(Image image, float x , float y){
        super(image, x, y, 0.08f);
        xspeed = 0;
        score = 0;
        lives = 3;
        isAlive = true;
        hitPUP = false;
    }
}
