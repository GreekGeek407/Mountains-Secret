package mountainsSecret;

public class Golem extends NPC {
	
	private int dialogState;
	
	public Golem() {
		super("golem");
		dialogState = 0;
	}
	
	@Override
	public void talk() {
		switch(dialogState) {
			case 0:
				conversation0();
				break;
			case 1:
				conversation1();
				break;
			case 2:
				conversation2();
				break;
			case 3:
				conversation3();
				break;
			case 4:
				conversation4();
				break;
			case 5:
				conversation5();
				break;
			case 6:
				conversation6();
				break;
			case 7:
				conversation7();
				break;
			case 8:
				conversation8();
				break;
			case 9:
				conversation9();
				break;
			case 10:
				conversation10();
				break;
			default:
				say("Something has gone very wrong. You are a strange one to be able to hear me say this.");
		}
	}
	
	public void conversation0() {
		say("What business brings you to this sacred place?");
		String[] responses = {
				"I seek the treasure!",
				"Who are you?",
				"Nothing, I was just leaving."
		};
		int choice = getResponse(responses);
		switch(choice) {
			case 1:
				say("I have guarded this door for centuries. Only once you have proven your character may you pass through.");
				dialogState = 1;
				break;
			case 2:
				say("My creators did not burden me with a name, only a purpose: to prevent their most precious relic from "
						+ "falling into the wrong hands.");
				dialogState = 2;
				break;
			case 3:
				say("Very well. I, of course, will remain here.");
				dialogState = 3;
				break;
			default:
				say("Your speech baffles me.");
			
		}
	}
	
	public void conversation1() {
		say("You wish to know how to prove yourself?");
		String[] responses = {
				"Yes, tell me what to do!",
				"No, I can figure it out myself.",
				"Why do I need to prove myself?"
		};
		int choice = getResponse(responses);
		switch(choice) {
			case 1:
				say("Somewhere within this temple is preserved a thing of beauty, a relic of my creators' lost home. Bring this thing to me.");
				dialogState = 4;
				break;
			case 2:
				say("Very well. Best of luck, then. ");
				dialogState = 5;
				break;
			case 3:
				say("The ones who built this sanctuary wished to leave behind a place of reverence for the elements."
						+ " I can tell you more, if you wish.");
				dialogState = 6;
				break;
			default:
				say("Your speech baffles me.");
			
		}
	}
	
	public void conversation2() {
		say("What more do you have to say?");
		String[] responses = {
				"What exactly is the treasure?",
				"Would you ever want a name?",
				"Nothing, I guess."
		};
		int choice = getResponse(responses);
		switch(choice) {
			case 1:
				say("Though I have not seen it, the treasure is said to be a beautiful gem, the pinnacle of natural beauty.");
				dialogState = 7;
				break;
			case 2:
				say("I was not made to 'want.' That said, if you must prescribe me a title, you may call me Terra from now on.");
				setName("terra");
				dialogState = 8;
				break;
			case 3:
				say("Then leave me to my duty.");
				dialogState = 9;
				break;
			default:
				say("Your speech baffles me.");
			
		}
	}
	
	public void conversation3() {
		say("Have you changed your mind?");
		String[] responses = {
				"Actually, I do seek the treasure!",
				"Actually, I do want to know more about this place.",
				"Actually, I do want to know more about you."
		};
		int choice = getResponse(responses);
		switch(choice) {
			case 1:
				say("I have guarded this door for centuries. Only once you have proven your character may you pass through.");
				dialogState = 1;
				break;
			case 2:
				say("The ones who built this sanctuary wished to leave behind a place of reverence for the elements."
						+ " I can tell you more, if you wish.");
				dialogState = 6;
				break;
			case 3:
				say("Then once again, leave me to my duty.");
				dialogState = 9;
				break;
			default:
				say("Your speech baffles me.");
			
		}
	}
	
	public void conversation4() {
		say("Bring me the preserved beauty, and perhaps I will step aside.");
	}
	
	public void conversation5() {
		say("Have you discovered a need for assistance?");
		String[] responses = {
				"Yes, tell me what to do!",
				"Nope, I'm still good on my own."
		};
		int choice = getResponse(responses);
		switch(choice) {
			case 1:
				say("Somewhere within this temple is preserved a thing of beauty, a relic of my creators' lost home. Bring this thing to me.");
				dialogState = 4;
				break;
			case 2:
				say("If you insist. Best of luck!");
				break;
			default:
				say("Your speech baffles me.");
		}
	}
	
	public void conversation6() {
		say("You desire more information about this place?");
		String[] responses = {
				"Yes, please tell me!",
				"Not right now."
		};
		int choice = getResponse(responses);
		switch(choice) {
			case 1:
				say("The people known as the Druids built this temple when their home, a grotto full of roses, was destroyed by "
						+ "human greed. They wished to carve out a space where the beauty of nature would forever be remembered.");
				dialogState = 10;
				break;
			case 2:
				say("Should you wish to learn more, I will remain.");
				break;
			default:
				say("Your speech baffles me.");
			
		}
	}
	
	public void conversation7() {
		say("Should you find this gem, I hope it instills in you the same respect of nature held by my creators.");
	}
	
	public void conversation8() {
		say("I must admit, this name suits me. Thank you for the pleasure of your conversation.");
	}
	
	public void conversation9() {
		say("You have voiced your contentedness with this conversation.");
	}
	
	public void conversation10() {
		say("My creators' tale is a sad one, but all the more worth telling because of it. One preserved rose from their grotto is"
				+ "said to rest in this temple somewhere. I would very much like to see it.");
	}
}
