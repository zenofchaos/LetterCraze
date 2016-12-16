package playerFiles;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerModel.
 */
public class PlayerModel {

	/** The menu. */
	PlayerMenu menu;
	
	/**
	 * Instantiates a new player model.
	 */
	//Constructor for a model object
	public PlayerModel(){
		this.menu = new PlayerMenu();
	}
	
	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	//Get method for menu
	public PlayerMenu getMenu(){
		return this.menu;
	}
	
	/**
	 * Sets the menu.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for menu
	public boolean setMenu(PlayerMenu toSet){
		this.menu = toSet;
		return true;
	}
}
