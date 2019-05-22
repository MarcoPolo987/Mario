import java.util.ArrayList;

public class Grounds {
	private ArrayList<Ground> grounds = new ArrayList<Ground>();
	public Grounds(int width, int height) {
		System.out.println(width/50);
		for(int i=0; i< (width/50)+30; i++) {
			grounds.add(new Ground(i*50, height-50));
			
		}
//		grounds.add(new Ground(50, height-50));
//		grounds.add(new Ground(100, height-50));
//		grounds.add(new Ground(150, height-50));
//		grounds.add(new Ground(200, height-50));
//		grounds.add(new Ground(250, height-50));
//		grounds.add(new Ground(300, height-50));
//		grounds.add(new Ground(350, height-50));
//		grounds.add(new Ground(400, height-50));
//		grounds.add(new Ground(450, height-50));
//		grounds.add(new Ground(500, height-50));
//		grounds.add(new Ground(550, height-50));
//		grounds.add(new Ground(600, height-50));
//		grounds.add(new Ground(650, height-50));
//		grounds.add(new Ground(700, height-50));
//		grounds.add(new Ground(750, height-50));
//		grounds.add(new Ground(800, height-50));
//		grounds.add(new Ground(850, height-50));
//		grounds.add(new Ground(900, height-50));
//		grounds.add(new Ground(950, height-50));
//		grounds.add(new Ground(1000, height-50));
//		grounds.add(new Ground(1050, height-50));
//		grounds.add(new Ground(1100, height-50));
//		grounds.add(new Ground(1150, height-50));
//		grounds.add(new Ground(1200, height-50));
//		grounds.add(new Ground(1250, height-50));
//		grounds.add(new Ground(1300, height-50));
//		grounds.add(new Ground(1350, height-50));
//		grounds.add(new Ground(1400, height-50));
//		

	}
	public ArrayList<Ground> getGround(){
		return grounds;	
	}
}