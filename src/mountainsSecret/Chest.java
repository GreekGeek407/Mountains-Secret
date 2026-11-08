package mountainsSecret;

public class Chest extends Item {
	
	private boolean open;
	private boolean hasOpened;
	// private boolean locked // the player might eventually need to solve a riddle
	
	public Chest() {
		super("chest", true);
		open = false;
		hasOpened = false;
	}

	@Override
	public void open() {
		if (!open) {
			if (!hasOpened) {
				Game.print("You lift the lid and open the chest! Inside, you "
						+ "see a beautiful emerald in the shape of a flower.");
				Game.getCurrentRoom().addItem(new Emerald());
				hasOpened = true;
			}
			else
				Game.print("You open the chest again, but nothing else has appeared inside.");
			open = true;
		}
		else
			Game.print("The chest is already open!");
	}
	
	@Override
	public void close() {
		if (open) {
			Game.print("You close the chest with a thud.");
			open = false;
		}
		else
			Game.print("The chest is already closed!");
	}

}
