@Override
public void talk() {
	switch (dialogState) {
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
	}
}

public void conversation1() {
	say("Hello! This is conversation 1. Where do you want to go?");
	String[] responses = { "Conversation 2", "Conversation 5", "Conversation 8", };
	int choice = getResponse(responses);
	switch (choice) {
	case 1:
		say("You're off to conversation 2!");
		dialogState = 2;
		break;
	case 2:
		say("You're off to conversation 5!");
		dialogState = 5;
		break;
	case 3:
		say("You're off to conversation 8!");
		dialogState = 8;
		break;
	default:
		say("Your speech baffles me.");
	}
}

public void conversation2() {
	say("This is conversation 2. Where to?");
	String[] responses = { "Conversation 3", "Conversation 4", };
	int choice = getResponse(responses);
	switch (choice) {
	case 1:
		say("You're off to conversation 3!");
		dialogState = 3;
		break;
	case 2:
		say("You're off to conversation 4!");
		dialogState = 4;
		break;
	default:
		say("Your speech baffles me.");
	}
}

public void conversation3() {
	say("This is conversation 3. The end!");
}

public void conversation4() {
	say("This is conversation 4. The end!");
}

public void conversation5() {
	say("This is conversation 5. Where to?");
	String[] responses = { "Conversation 6", "Conversation 7", };
	int choice = getResponse(responses);
	switch (choice) {
	case 1:
		say("You're off to conversation 6!");
		dialogState = 6;
		break;
	case 2:
		say("You're off to conversation 7!");
		dialogState = 7;
		break;
	default:
		say("Your speech baffles me.");
	}
}

public void conversation6() {
	say("This is conversation 6. The end!");
}

public void conversation7() {
	say("This is conversation 7. The end!");
}

public void conversation8() {
	say("This is conversation 8. Where to?");
	String[] responses = { "Conversation 9", "Conversation 10", };
	int choice = getResponse(responses);
	switch (choice) {
	case 1:
		say("You're off to conversation 9!");
		dialogState = 9;
		break;
	case 2:
		say("You're off to conversation 10!");
		dialogState = 10;
		break;
	default:
		say("Your speech baffles me.");
	}
}

public void conversation9() {
	say("This is conversation 9. The end!");
}

public void conversation10() {
	say("This is conversation 10. The end!");
}
