package builderFiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import playerFiles.PlayerLevel;
import playerFiles.PlayerMenuIterator;

/**
 * The Class BuilderMenu, menu for the builder application.
 */
public class BuilderMenu {

/** The levels. */
List<List<BuilderLevel>> levels;
	
	/**
	 * Instantiates a new builder menu.
	 */
	public BuilderMenu(){
		this.levels = new ArrayList<List<BuilderLevel>>(3);
		for (int i = 0; i < 3; i++){
			this.levels.add(new ArrayList<BuilderLevel>());
		}
	}
	
	/**
	 * Gets the levels.
	 *
	 * @return the levels
	 */
	public List<List<BuilderLevel>> getLevels(){
		return this.levels;
	}
	
	/**
	 * Sets the levels.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	public boolean setLevels(List<List<BuilderLevel>> toSet){
		this.levels = toSet;
		return true;
	}
	
	/**
	 * Num level.
	 *
	 * @param levelType the level type
	 * @return the number of levels held in this menu of the given level type
	 */
	public int numLevel(String levelType){
		switch(levelType){
		case "Puzzle":
			return this.levels.get(0).size();
		case "Lightning":
			return this.levels.get(1).size();
		case "Theme":
			return this.levels.get(2).size();
		default:
			return -1;
		}
	}
	
	/**
	 * Gets the level corresponding to the given identifier.
	 * Identifier should be in one of the following forms:
	 *T# or	L# or P# , where the first character indicates the type of level,
	 *and number indicates the index in the list of levels.
	 *
	 * @param identifier the identifier
	 * @return the level
	 */
	public BuilderLevel getLevel(String identifier){
		char type = identifier.charAt(0);
		int index = ((int) identifier.charAt(1)) - 48 - 1;
		List<BuilderLevel> desiredLevels;

		//Determine which type of level is desired
		switch (type){
		case 'T':
			desiredLevels = this.levels.get(2);
			break;
		case 'L':
			desiredLevels = this.levels.get(1);
			break;
		case 'P':
			desiredLevels = this.levels.get(0);
			break;
		default:
			return null;
		}

		//returns the desired level, or null if the desired
		//	level does not exist
		try{
			return desiredLevels.get(index);
		}
		catch (Exception e){
			return null;
		}
	}
	

	/**
	 * Adds the given level to this menu, if the given level is valid.
	 *
	 * @param toAdd the to add
	 * @return true, if successful
	 */
	public boolean addLevel(BuilderLevel toAdd){
		if (toAdd == null){
			return false;
		}
		else{
			if (toAdd instanceof BuilderPuzzleLevel){
				List<BuilderLevel> puzzleList = this.levels.get(0);
				puzzleList.add(toAdd);
				return true;
			}
			else if (toAdd instanceof BuilderLightningLevel){
				List<BuilderLevel> lightningList = this.levels.get(1);
				lightningList.add(toAdd);
				return true;
			}
			else if (toAdd instanceof BuilderThemeLevel){
				List<BuilderLevel> themeList = this.levels.get(2);
				themeList.add(toAdd);
				return true;
			}
			else{	
				return false;
			}
		}
	}
	
	/**
	 * Removes the level with the given indicator for the menu.
	 *
	 * @param indicator the indicator
	 * @return true, if successful
	 */
	boolean removeLevel(String indicator){
		char type = indicator.charAt(0);
		int index = ((int) indicator.charAt(1)) - 48 - 1;
		List<BuilderLevel> indicatedLevels;
		
		//Determine which type of level is desired
		switch (type){
			case 'T':
				indicatedLevels = this.levels.get(2);
				break;
			case 'L':
				indicatedLevels = this.levels.get(1);
				break;
			case 'P':
				indicatedLevels = this.levels.get(0);
				break;
			default:
				return false;
		}
		
		//returns the desired level, or null if the desired
		//	level does not exist
		try{
			indicatedLevels.remove(index);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	/**
	 * Iterator.
	 *
	 * @return the builder menu iterator
	 */
	//Returns an iterator for this menu
	public BuilderMenuIterator iterator(){
		return new BuilderMenuIterator(this.levels);
	}
}
