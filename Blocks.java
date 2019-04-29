import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Blocks{
public ArrayList<Block> blocks= new ArrayList<Block>();

	public Blocks() {
		blocks.add(new Block(100,300));
	}
	public ArrayList<Block> getBlocks() {
		return this.blocks;
	}
	
}