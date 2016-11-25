package CAPSTONE.Beta_ver1;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by brandon on 11/16/2016.
 */
public class Powerup {

    private float x, y;
    private Rectangle rect;
    private Image[] powerUP;
    private int width, height, type;

    public void setType(int type){
        this.type = type;
    }
        
    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Image[] getPowerUP() {
        return powerUP;
    }

    public void setPowerUP(Image[] powerUP) {
        this.powerUP = powerUP;
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

    public void updateRect() {
        this.rect.setBounds(x, y, width, height);
    }

    Powerup(Image[] powerUP){
        this.powerUP = powerUP;
        width = powerUP[0].getWidth();
        height = powerUP[0].getHeight();
        x = 0;
        y = 0;
        rect = new Rectangle(x, y, width, height);
    }

    public int getType() {
        return type;
    }
}
