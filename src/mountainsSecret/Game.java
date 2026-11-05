package mountainsSecret;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

public class Game {
	
	public static HashMap<String, String> roomDescriptions = new HashMap<>();
	public static ArrayList<Room> rooms = new ArrayList<>();
	private static Room currentRoom = World.buildWorld();
	private static ArrayList<Item> inventory = new ArrayList<>();
	private static UserInterface ui;
	
	public static void main(String[] args) {
		// runGame();
		runGameGUI();
	}
	
	public static void runGameGUI() {
		SwingUtilities.invokeLater(() -> ui = new UserInterface());
	}
	
	public static void saveGame() {
		File saveFile = new File("save.sav");
		try {
			saveFile.createNewFile();
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));
			outStream.writeObject(rooms);
			outStream.writeObject(currentRoom);
			outStream.writeObject(inventory);
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadGame() {
		File saveFile = new File("save.sav");
		try {
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
			rooms = (ArrayList<Room>)inStream.readObject();
			currentRoom = (Room)inStream.readObject();
			inventory = (ArrayList<Item>)inStream.readObject();
			inStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void runGame(String c) {
		//Scanner input = new Scanner(System.in);
		//String command = "";
		String[] fullCommand;
		//while (!command.equals("exit")) {
			//print("Current room: " + currentRoom);
			//print("Enter a command ('exit' to finish)");
			fullCommand = c
					.toLowerCase()
					.replaceAll("\\b(the|to)\\b", "")
					.replaceAll("\\s+", " ")
					.split(" ");
			String command = fullCommand[0];
			String itemName;
			switch (command) {
			case "east", "west", "north", "south", "up", "down":
				move(command);
				break;
			case "go", "move":
				if (fullCommand.length < 2) {
					print("Specify a direction to go (east, west, north, south, up, or down).");
					break;
				}
				move(fullCommand[1]);
				break;
			case "open":
				if (fullCommand.length < 2) {
					print("Specify what you're opening!");
					break;
				}
				itemName = "";
				for (int i = 1; i < fullCommand.length; i++) {
					itemName += fullCommand[i];
				}
				openItem(itemName);
				break;
			case "close":
				if (fullCommand.length < 2) {
					print("Specify what you're closing!");
					break;
				}
				itemName = "";
				for (int i = 1; i < fullCommand.length; i++) {
					itemName += fullCommand[i];
				}
				closeItem(itemName);
				break;
			case "read":
				if (fullCommand.length < 2) {
					print("Specify what you're reading!");
					break;
				}
				itemName = "";
				for (int i = 1; i < fullCommand.length; i++) {
					itemName += fullCommand[i];
				}
				readItem(itemName);
				break;
			case "light":
				if (fullCommand.length < 2) {
					print("Specify what you're lighting!");
					break;
				}
				itemName = "";
				for (int i = 1; i < fullCommand.length; i++) {
					itemName += fullCommand[i];
				}
				readItem(itemName);
				break;
			case "exit":
				print("Come back soon!");
				break;
			case "take":
				if (fullCommand.length < 2) {
					print("Specify an item to take.");
					break;
				}
				itemName = "";
				for (int i = 1; i < fullCommand.length; i++) {
					itemName += fullCommand[i];
					//if (i < fullCommand.length - 1)
					//	itemName += " ";
				}
				takeItem(itemName);
				break;
			case "use":
				if (fullCommand.length < 2) {
					print("Specify an item to use.");
					break;
				}
				itemName = "";
				for (int i = 1; i < fullCommand.length; i++) {
					itemName += fullCommand[i];
					//if (i < fullCommand.length - 1)
					//	itemName += " ";
				}
				useItem(itemName);
				break;
			case "i":
				if (inventory.size() > 0) {
				print("You are carrying: ");
				for (Item i : inventory)
					print(i);
				print("");
				}
				else
					print("You are carrying nothing.");
				break;
			case "save":
				saveGame();
				print("Game saved successfully.");
				break;
			case "load":
				loadGame();
				print("Succesfully loaded previous save.");
				break;
			default:
				print("Error: invalid command");
				break;
			} // end switch (command)
			
		//} // end while loop
		//input.close();
	}
	
	public static void print(Object obj) {
		ui.updateGameText(obj.toString());
	}

	public static void move(String direction) {
		int dir = -1;
		switch (direction) {
		case "east":
			dir = 0;
			break;
		case "west":
			dir = 1;
			break;
		case "north":
			dir = 2;
			break;
		case "south":
			dir = 3;
			break;
		case "up":
			dir = 4;
			break;
		case "down":
			dir = 5;
			break;
		default:
			print("Please enter a valid direction.");
			return;
		} // end switch (direction)
		Room destination = currentRoom.getExit(dir);
		if (destination != null) {
			if (!destination.isLocked()) {
				currentRoom = destination;
				print("You enter the " + currentRoom.getName() + ".");
			}
			else
				print("The " + destination.getName() + " is locked.");
		}
		else 
			print("You cannot go that way.");
	}
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void addInventoryItem(Item i) {
		inventory.add(i);
	}
	
	public static Item getItem(String itemName) {
		for (Item i : inventory) {
			if (i.getName().toLowerCase().equals(itemName.toLowerCase()))
				return i;
		}
		return null;
	}
	
	public static void takeItem(String itemName) {
		Item i = currentRoom.getItem(itemName);
		if (i != null) {
			if (i.isHeavy())
				print("You can't lift the " + itemName + "!");
			else {
				print("You take the " + i + " and add it to your inventory.");
				inventory.add(i);
				currentRoom.removeItem(itemName);
			}
		}
		else
			print("There is no " + itemName + " in this room.");
	}
	
	public static void useItem(String itemName) {
		Item i = getItem(itemName);
		if (i != null) {
			i.use();
		}
		else
			print("You don't have a " + itemName + ".");
	}
	
	public static void openItem(String itemName) {
		Item i = currentRoom.getItem(itemName);
		if (i != null)
			i.open();
		else
			print("There is no " + itemName + " to open.");
	}
	
	public static void closeItem(String itemName) {
		Item i = currentRoom.getItem(itemName);
		if (i != null)
			i.close();
		else
			print("There is no " + itemName + " to close.");
	}
	
	public static void readItem(String itemName) {
		Item i = getItem(itemName);
		if (i != null)
			i.read();
		else
			print("You don't have a " + itemName + " to read.");
	}
	
	public static void lightItem(String itemName) {
		Item i = currentRoom.getItem(itemName);
		if (i != null) {
			if (getItem("matches") != null) {
				i.light();
			}
			else
				print("You have nothing to light a fire.");
		}
			
		else
			print("There is no " + itemName + " to light.");
	}
	
	public static void loadRoomDescriptions() {
		try {
			Scanner fileScan = new Scanner(new File("room_descriptions.txt"));
			while (fileScan.hasNextLine()) {
				String roomName = fileScan.nextLine();
				String roomDescription = "";
				String check = fileScan.nextLine();
				while (!check.equals("#")) {
					roomDescription += check;
					check = fileScan.nextLine();
				}
				roomDescriptions.put(roomName, roomDescription);
			}
			fileScan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
