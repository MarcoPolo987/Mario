
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.Rectangle;
	import java.io.IOException;
	import java.util.ArrayList;

	import javax.imageio.ImageIO;

	public class Blocks{
	public ArrayList<Block> blocks= new ArrayList<Block>();

		public Blocks(int width, int height) {
			blocks.add(new Block(100,height-200));
			blocks.add(new Block(200,height-200));
			blocks.add(new Block(300,height-200));
		}
		public ArrayList<Block> getBlocks() {
			return this.blocks;
		}
		
	}

