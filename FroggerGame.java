import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class FroggerGame {
	
	// what are the things you see in the game?
	List<GameObject> gos = new ArrayList<>();
	
	// list of autos should come from loadLevel
	List<GameObject> autos = new ArrayList<>();
	
	// list of logs
	List<GameObject> logs = new ArrayList<>();
	
	
	MoveableObject log;
	Frog frog;
	int level=5;
	public FroggerGame()  {
		
		frog = new Frog(40, 80, 100, 100,  null);
		
		Image Log = null;
		try {
			Log = ImageIO.read(new File("log.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		log = new MoveableObject(40,200,100,100,Log,1,1);
		gos.add(frog);
		gos.add(log);
		logs.add(log);
		level++;
		
		//loadLevel();
	}
	
	
	
	private void loadLevel() {
		// this is just an idea.  Maybe store the different levels as text files
		List<List<GameObject>> levelObjects = LevelReader.readInLevel(level);
		gos.clear();
		if(levelObjects != null) {
			for(List<GameObject> list: levelObjects) {
				if(list != null) {
					for(GameObject go: list) {
//						if(go instanceof Log)
//							logs.add(go);
//						if(go instanceof Auto)
//							autos.add(go);
						gos.add(go);
					}
				}
			}
		}
		gos.add(frog);
		gos.add(log);
	}



	// What do you want to do when a key is hit?
	public void keyHit(String s) {
		System.out.println("In frogger game (keyHit): "+s);
		if(s.equals("down")) {
			frog.movedoown();
		}
		if(s.equals("up")) {
			frog.moveup();
		}
		if(s.equals("left")) {
			frog.moveleft();
		}
		if(s.equals("right")) {
		frog.moveright();
		
	}
		//log.moveright();
	}
	public  void moveStuff() {
		for(GameObject l:logs) {
			l.moveright();
		}
		
	}
	public void draw(Graphics g) {
		for(GameObject go:gos) {
			go.draw(g);
		}
		
	}
	

	
	
	
	
	
	
	
	
}
