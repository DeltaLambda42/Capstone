package CAPSTONE.Alpha;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Created by brandon on 11/12/2016.
 */
public class Block extends Character{
    private Image block;
    private int type;

    public Image getBlock() {
        return block;
    }

    public void setBlock(Image block) {
        this.block = block;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    Block(Image block, int type, float x, float y){
        super(block.getWidth(), block.getHeight(), new Coordinates(x, y), 0, 0.15f, new Rectangle(x, y, block.getWidth(), block.getHeight()));
        this.type = type;
        this.block = block;
    }


}
