package mountainsSecret;

public class Matchbook extends Item {
	// with the way my game is designed, the player doesn't really
	// need to use the matches, only to find and take them.
	// as such, this class is a bit barren, but the player does
	// need to have the matchbook to interact with the torches.
	// I'm considering trying to add the ability to use the matches
	// on one of the torches
	
	public Matchbook() {
		super("matchbook");
	}

}
