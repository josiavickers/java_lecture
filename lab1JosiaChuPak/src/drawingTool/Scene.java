package drawingTool;

import java.awt.Color;
import java.util.ArrayList;

public class Scene {
	
	private ArrayList<LocatedRectangle> sceneObjects = null; // programming to an interface
	
	public Scene() {
		sceneObjects = new ArrayList<LocatedRectangle>();
	}
	
	public void draw() {
		for (LocatedRectangle o : sceneObjects) {
			if (o.getClass() == Monkey.class) {
				((Monkey)o).draw(); // typecasting to Monkey	
			} // else draw say another object e.g. Tree
		}
	}
	
	private void addObject(LocatedRectangle newObject) {
		boolean intersection = false;
		
		for (LocatedRectangle m : sceneObjects) {
			intersection = intersection || m.intersects(newObject);
		}
		if (!intersection) {
			sceneObjects.add(newObject);
		}
	}
	
	public void setBlackMonkey() {
		int x = RandomNumber.between(0, 1200);
		int y = RandomNumber.between(0, 700);
		int k = RandomNumber.between(1, 2);
			
		LocatedRectangle aMonkey = new Monkey(x, y, k);
		addObject(aMonkey);
	}
	
	public void setGreenMonkey() {
		int x = RandomNumber.between(0, 1200);
		int y = RandomNumber.between(0, 700);
		int k = RandomNumber.between(1, 2);
			
		LocatedRectangle aMonkey = new Monkey(x, y, k, Color.GREEN);
		addObject(aMonkey);
	}
	
	public void setPinkMonkey() {
		int x = RandomNumber.between(0, 1200);
		int y = RandomNumber.between(0, 700);
		int k = RandomNumber.between(1, 2);
			
		LocatedRectangle aMonkey = new Monkey(x, y, k, Color.PINK);
		addObject(aMonkey);
	}
	
	public void removeBlackMonkeys() {
		for (int i = 0; i < sceneObjects.size(); i++) {
			if (((Monkey)sceneObjects.get(i)).getColor() == Color.BLACK && sceneObjects.get(i).getClass() == Monkey.class) {
				sceneObjects.remove(i);
				i--;
			}
		}
	}
	
	public void removeGreenMonkeys() {
		for (int i = 0; i < sceneObjects.size(); i++) {
			if (((Monkey)sceneObjects.get(i)).getColor() == Color.GREEN && sceneObjects.get(i).getClass() == Monkey.class) {
				sceneObjects.remove(i);
				i--;
			}
		}
	}
	
	public void removePinkMonkeys() {
		for (int i = 0; i < sceneObjects.size(); i++) {
			if (((Monkey)sceneObjects.get(i)).getColor() == Color.PINK && sceneObjects.get(i).getClass() == Monkey.class) {
				sceneObjects.remove(i);
				i--;
			}
		}
	}
	
	public void removeAllObjects() {
		sceneObjects.removeAll(sceneObjects);
	}
	 
}


