package playerGUI;

//This interface ensures that each gui object created has
//	 the default behavior of being able to open, close, and
//	hide from view.
public interface IGUI {

	//Shows this gui object
	public void open();
	//Closes/disposes of this gui object
	public void close();
	//Hides but DOES NOT dispose of this gui object
	public void hide();
}
