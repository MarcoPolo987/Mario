import java.util.ArrayList;

public class scrollChecks {
	public ArrayList<scrollCheck> scrolls= new ArrayList<scrollCheck>();
	
	public scrollChecks( ) {
		 scrolls.add(new scrollCheck(650));
		 scrolls.add(new scrollCheck(1450));
		 scrolls.add(new scrollCheck(2250));
		 scrolls.add(new scrollCheck(3050));
		 
	}
	public boolean check(Mario m) {
		for (int i=0;i < scrolls.size();i++) {
			if (scrolls.get(i).getX()==m.getX()) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<scrollCheck> getScroll() {
		return this.scrolls;
	}
}
