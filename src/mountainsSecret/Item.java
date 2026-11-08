package mountainsSecret;

import java.io.Serializable;

public class Item implements Serializable {
	
	private String name;
	private boolean heavy;
	
	public Item(String na) {
		this(na, false);
	}
	
	public Item (String na, boolean h) {
		name = na;
		heavy = h;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public void setName(String na) {
		name = na;
	}
	
//	public void setHeavy() {
//		heavy = true;
//	}
	
	public void use() {
		Game.print("You can't use the " + name + ".");
	}
	
	public void open() {
		Game.print("There's nothing to open on the " + name + "!");
	}
	
	public void close() {
		Game.print("There's nothing to close on the " + name + "!");
	}
	
	public void read() {
		Game.print("The " + name + " has nothing worth reading.");
	}
	
	public void light() {
		Game.print("You can't light the " + name + "!");
	}
	
	public void extinguish() {
		Game.print("There's nothing to extinguish on the " + name + "!");
	}
	
	public boolean isLit() {
		return false;
	}
	
	public String toString() {
		return name;
	}

}
