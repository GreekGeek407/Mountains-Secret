package mountainsSecret;

import javax.swing.JOptionPane;

public class NPC {
	
	private String name;
	
	public NPC(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void say(String dialog) {
		Game.print(name.toUpperCase() + "\n" + dialog);
	}
	
	public void talk() {
		Game.print("You can't talk to " + name + ".");
	}
	
	public int getResponse(String[] choices) {
		for (int i = 0; i < choices.length; i++) {
			Game.print((i + 1) + ") " + choices[i] + "\n");
		}
		String input = JOptionPane.showInputDialog(null, "Choose an option: ");
		return Integer.parseInt(input);	
	}
	
}
