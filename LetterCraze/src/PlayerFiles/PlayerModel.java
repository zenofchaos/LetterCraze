package PlayerFiles;

public class PlayerModel {

	PlayerMenu menu;
	
	//Constructor for a model object
	public PlayerModel(){
		this.menu = new PlayerMenu();
	}
	
	//Get method for menu
	public PlayerMenu getMenu(){
		return this.menu;
	}
	
	//Set method for menu
	public boolean setMenu(PlayerMenu toSet){
		this.menu = toSet;
		return true;
	}
}
