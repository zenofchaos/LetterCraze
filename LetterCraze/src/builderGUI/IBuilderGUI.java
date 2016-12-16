package builderGUI;

// TODO: Auto-generated Javadoc
//This interface ensures that each gui object created has
//	 the default behavior of being able to open, close, and
/**
 * The Interface IBuilderGUI.
 */
//	hide from view.
public interface IBuilderGUI {

	/**
	 * Open window.
	 */
	//Shows this gui object
	public void openWindow();
	
	/**
	 * Close window.
	 */
	//Closes/disposes of this gui object
	public void closeWindow();
	
	/**
	 * Hide window.
	 */
	//Hides but DOES NOT dispose of this gui object
	public void hideWindow();
	
	/**
	 * Refresh.
	 *
	 * @param o the o
	 */
	//Refreshes display
	public void refresh(Object o);
}
