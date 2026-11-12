package mountainsSecret;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {

	// Instance variables
	private String name; // Room name
	private boolean locked;
	private Room[] exits; //array of all possible exit rooms
	private HashMap<String, Item> roomItems; // map of all items in the room
	private NPC roomNPC;
	
	// Constructor method
	public Room(String n) {
		name = n;
		locked = false;
		exits = new Room[6];
		roomItems = new HashMap<>();
		Game.rooms.put(this.getName(), this);
	}
	
	// Get methods
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return Game.roomDescriptions.get(name);
	}
	
	public Room getExit(int i) {
		return exits[i];
	}
	
	public Item getItem(String itemName) {
		return roomItems.get(itemName);
	}
	
	public NPC getNPC() {
		return roomNPC;
	}
	public boolean isLocked() {
		return locked;
	}
	// Set methods
	public void setName(String n) {
		name = n;
	}
	
	public void setLocked(boolean l) {
		locked = l;
	}
	
	public void addExit(Room room, int i) {
		exits[i] = room;
	}
	
	public void setDescription(String d) {
		Game.roomDescriptions.put(name, d);
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName().toLowerCase(), i);
	}
	
	public void removeItem(String itemName) {
		roomItems.remove(itemName);
	}
	
	public void setNPC(NPC npc) {
		roomNPC = npc;
	}
	
	// toString method
	public String toString() {
		String output = name;
		output += "\n\n" + getDescription();
		return output;
	}
}
