import java.util.ArrayList;

public class Grounds {
	private ArrayList<Ground> grounds = new ArrayList<Ground>();
	public Grounds(int width, int height) {
		System.out.println(width/50);
		for(int i=0; i< (width/50)+120; i++) {
			grounds.add(new Ground(i*50, height-50));

		}
		grounds.remove(36);
		grounds.remove(36);
		grounds.remove(36);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(50);
		grounds.remove(64);
		grounds.remove(64);
		grounds.remove(64);
		grounds.remove(64);
		grounds.remove(64);

	}
	public ArrayList<Ground> getGround(){
		return grounds;	
	}
}