package CAPSTONE.Alpha;

import java.util.Random;

/**
 * Created by brandon on 11/10/2016.
 */
public class Platform {
    private int width = 50;
    private int height = 10;
    private static final int gameWidth = 450;
    private static final int min = 0;
    private Random rand = new Random();

    Platform(){

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public int randInt() {
        return rand.nextInt((gameWidth - width - min) + 1) + min;
    }
}
