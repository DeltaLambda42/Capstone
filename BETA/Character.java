package CAPSTONE.BETA;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by brandon on 11/16/2016.
 */
public abstract class Character {

    private Image image;
    private int width, height;
    private float x, y, yspeed;
    private Rectangle rect;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void updateRect() {
        rect.setBounds(x, y, width, height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getYspeed() {
        return yspeed;
    }

    public void setYspeed(float yspeed) {
        this.yspeed = yspeed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    Character(Image image, float x , float y, float yspeed){
        this.image = image;
        this.x = x;
        this.y = y;
        this.yspeed = yspeed;
        width = image.getWidth();
        height = image.getHeight();
        rect = new Rectangle(x, y, width, height);
    }
}
