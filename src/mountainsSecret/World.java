package mountainsSecret;

public class World {

	public static Room buildWorld() {
		Game.loadRoomDescriptions();
		
		Room quarry = new Room("Quarry");
		Room antechamber = new Room("Antechamber");
		Room outerCave = new Room("Outer Cave");
		Room torchRoom = new Room("Torch Room");
		Room reflectingPool = new Room("Reflecting Pool");
		Room submergedVault = new Room("Submerged Vault");
		Room shrine = new Room("Shrine");
		Room treasureRoom = new Room("Treasure Room");
		
		antechamber.setLocked(true);
		treasureRoom.setLocked(true);
		
		Item matches = new Item("matches", false);
		Item mirror = new Item("mirror", false);
		Item whiteRose = new Item("whiterose", false);
		Item emerald = new Item("emerald", false);
		
		quarry.addExit(antechamber, 5);
		antechamber.addExit(shrine, 0);
		antechamber.addExit(outerCave, 1);
		antechamber.addExit(reflectingPool, 2);
		antechamber.addExit(torchRoom, 3);
		antechamber.addExit(quarry, 4);
		outerCave.addExit(antechamber, 0);
		torchRoom.addExit(antechamber, 2);
		reflectingPool.addExit(antechamber, 3);
		reflectingPool.addExit(submergedVault, 5);
		submergedVault.addExit(reflectingPool, 4);
		shrine.addExit(treasureRoom, 0);
		shrine.addExit(antechamber, 1);
		treasureRoom.addExit(shrine, 1);
		antechamber.addItem(matches);
		torchRoom.addItem(mirror);
		submergedVault.addItem(whiteRose);
		treasureRoom.addItem(emerald);
		
		Torch northTorch = new Torch("north");
		Torch eastTorch = new Torch("east");
		Torch southTorch = new Torch("south");
		Torch westTorch = new Torch("west");
		torchRoom.addItem(northTorch);
		torchRoom.addItem(eastTorch);
		torchRoom.addItem(southTorch);
		torchRoom.addItem(westTorch);
		
		return quarry;
	}
	
}
