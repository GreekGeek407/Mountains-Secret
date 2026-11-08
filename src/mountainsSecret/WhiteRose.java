package mountainsSecret;

public class WhiteRose extends Item {
	
	private boolean gaveRose;
	public WhiteRose() {
		super("whiterose");
		gaveRose = false;
	}
	
	@Override
	public void use() {
		if (Game.getCurrentRoom().getName().equals("Shrine")) {
			if (!gaveRose) {
				Game.print("You present the rose to the golem. The golem's sculpted eyes "
						+ "light up, and it steps away from the door behind it.");
				gaveRose = true;
				Game.rooms.get("Treasure Room").setLocked(false);
			}
			else
				Game.print("The golem once again acknowledges the rose's splendor, but nothing new happens.");
		}
		else
			Game.print("You admire the beauty of the rose, but you can't find a use for it here.");
	}

}
