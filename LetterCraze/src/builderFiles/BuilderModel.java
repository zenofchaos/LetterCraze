package builderFiles;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderModel.
 */
public class BuilderModel {

	/** The menu. */
	BuilderMenu menu;
	
	/**
	 * Instantiates a new builder model.
	 */
	//Constructor for a model object
	public BuilderModel(){
		this.menu = new BuilderMenu();
	}
	
	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	//Get method for menu
	public BuilderMenu getMenu(){
		return this.menu;
	}
	
	/**
	 * Sets the menu.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for menu
	public boolean setMenu(BuilderMenu toSet){
		this.menu = toSet;
		return true;
	}
}
