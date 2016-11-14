package CAPSTONE.Alpha;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

/**
 * Created by brandon on 11/14/2016.
 */
public abstract class Character {
    private int width, height;
    private float xspeed, yspeed;
    private Coordinates coor;
    private Shape shape;

    Character(int width, int height, Coordinates coor, float xspeed, float yspeed, Shape shape){
        this.coor = coor;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.width = width;
        this.height = height;
        this.shape = shape;
    }

    public float getX() {return coor.getX();}

    public float getY() {
        return coor.getY();
    }

    public void setX(float x) {
        coor.setX(x);
    }

    public void setY(float y) {
        coor.setY(y);
    }

    public Shape getShape(){return shape;}

    public int getWidth(){
        return width;
    }

    public int getHeight(){return height;}

    public float getXspeed() {
        return xspeed;
    }

    public float getYspeed() {
        return yspeed;
    }

    public void setXspeed(float xspeed) {
        this.xspeed = xspeed;
    }

    public void setYspeed(float yspeed) {
        this.yspeed = yspeed;
    }
}
