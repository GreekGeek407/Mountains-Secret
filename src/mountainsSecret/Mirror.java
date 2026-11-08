package mountainsSecret;

public class Mirror extends Item {
	
	private boolean used;
	
	public Mirror() {
		super("mirror");
		used = false;
	}
	
	@Override
	public void use() {
		if (Game.getCurrentRoom().getName().equals("Outer Cave")) {
			if (!used) {
				Game.print("You carefully angle the mirror and focus a beam of light on "
						+ "the gem in the wall. Suddenly, water comes pouring out of the "
						+ "rock face from the direction of the reflecting pool.");
				// at some point I would like to figure out how to
				// update the room description for the reflecting pool
				// without having to copy/paste the whole paragraph into here
				used = true;
				Game.rooms.get("Submerged Vault").setLocked(false);
				Game.rooms.get("Reflecting Pool").setDescription("The pool has been drained. [TEMPORARY DESCRIPTION]");
			}
			else
				Game.print("You manipulate the beam of light once again, but nothing new happens.");
		}
		else
			Game.print("You admire your reflection, but you don't think "
					+ "the mirror will be very useful here.");
	}

}
