package mountainsSecret;

public class Torch extends Item {
	
	private boolean lit;
	private String direction;
	
	public Torch(String dir) {
		super(dir + " torch", true);
		lit = false;
		direction = dir;
	}
	
	@Override
	public boolean isLit() {
		return lit;
	}
	
	@Override
	public void light() {
		if (!lit) {
			Game.print("You use a match to light the " + direction + " torch.");
			lit = true;
		}
		else
			Game.print("The " + direction + " torch is already lit.");
	}
	
	@Override
	public void extinguish() {
		if (lit) {
			Game.print("You extinguish the " + direction + " torch.");
			lit = false;
		}
		else
			Game.print("The " + direction + " torch is already unlit.");
		
	}

}
