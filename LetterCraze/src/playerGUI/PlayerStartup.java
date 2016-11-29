package playerGUI;

import java.io.Console;

public class PlayerStartup { // a main method featuring a placeholder timed splash screen
	
	Console splashText;

	public static void main(String[] args) {
		PlayerStartup startup = new PlayerStartup();
		startup.splash();
	}
	
	public boolean splash() {
		splashText.println("Linda Baker");
		splashText.println("Craig Bursey");
		splashText.println("Karen Orton");
		splashText.println("Kevin Ouellette");
		splashText.println("Charlie Sinkler");
		goToMenu();
		return true;
	}
	
	public boolean goToMenu() {
		return true;
		//TODO: Add code to redirect to main menu
	}

}
