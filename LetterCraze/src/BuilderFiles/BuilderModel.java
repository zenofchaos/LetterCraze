package BuilderFiles;

public class BuilderModel {

	BuilderMenu menu;
	
	//Constructor for a model object
	public BuilderModel(){
		this.menu = new BuilderMenu();
	}
	
	//Get method for menu
	public BuilderMenu getMenu(){
		return this.menu;
	}
	
	//Set method for menu
	public boolean setMenu(BuilderMenu toSet){
		this.menu = toSet;
		return true;
	}
}
