package builderFiles;

/**
 * The Class BuilderModel to hold all entity information for the builder.
 */
public class BuilderModel {

	/** The menu. */
	BuilderMenu menu;
	
	/**
	 * Instantiates a new builder model.
	 */
	public BuilderModel(){
		this.menu = new BuilderMenu();
	}
	
	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	public BuilderMenu getMenu(){
		return this.menu;
	}
	
	/**
	 * Sets the menu.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	public boolean setMenu(BuilderMenu toSet){
		this.menu = toSet;
		return true;
	}
}
