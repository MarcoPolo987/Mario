import java.util.ArrayList;

public class Grounds {
	private ArrayList<Ground> grounds = new ArrayList<Ground>();
	public Grounds() {
		grounds.add(new Ground(0, 500));
		grounds.add(new Ground(50, 500));
		grounds.add(new Ground(100, 500));
		grounds.add(new Ground(150, 500));
		grounds.add(new Ground(200, 500));
		grounds.add(new Ground(250, 500));
		grounds.add(new Ground(300, 500));
		grounds.add(new Ground(350, 500));
		grounds.add(new Ground(400, 500));
		grounds.add(new Ground(450, 500));
		grounds.add(new Ground(500, 500));
		grounds.add(new Ground(550, 500));
		grounds.add(new Ground(600, 500));
		grounds.add(new Ground(650, 500));
		grounds.add(new Ground(700, 500));
		grounds.add(new Ground(750, 500));
		grounds.add(new Ground(800, 500));

	}
	public ArrayList<Ground> getGround(){
		return grounds;	
	}
}