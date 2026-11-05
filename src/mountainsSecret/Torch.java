package mountainsSecret;

public class Torch extends Item {
	
	private boolean lit;
	private String direction;
	
	public Torch(String dir) {
		super(dir + " torch", true);
		lit = false;
		direction = dir;
	}
	
	public boolean isLit() {
		return lit;
	}
	
	@Override
	public void light() {
		if (!lit)
			Game.print("You light the " + direction + " torch.");
		else
			Game.print("The " + direction + " torch is already lit.");
	}

}
