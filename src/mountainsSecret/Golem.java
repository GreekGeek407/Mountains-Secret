package mountainsSecret;

public class Golem extends NPC {
	
	public Golem() {
		super("golem");
	}
	
	@Override
	public void talk() {
		say("What business brings you to this sacred place?");
		String[] responses = {
				"Nothing, I was just leaving.",
				"I seek the treasure!",
				"I wanna fight you!"
		};
		int choice = getResponse(responses);
		switch(choice) {
			case 1:
				say("Then leave, and allow me my well-earned rest.");
				break;
			case 2:
				say("I have guarded this door for centuries. I will not falter now.");
				break;
			case 3:
				say("I think not. Such an encounter would leave you as dust on the floor.");
				break;
			default:
				say("Your speech baffles me.");
			
		}
	}

}
