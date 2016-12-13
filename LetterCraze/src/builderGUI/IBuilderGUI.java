package builderGUI;

//This interface ensures that each gui object created has
//	 the default behavior of being able to open, close, and
//	hide from view.
public interface IBuilderGUI {

	//Shows this gui object
	public void openWindow();
	//Closes/disposes of this gui object
	public void closeWindow();
	//Hides but DOES NOT dispose of this gui object
	public void hideWindow();
	//Refreshes display
	public void refresh(Object o);
}
