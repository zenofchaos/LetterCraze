package playerFiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerMenu {

	List<List<PlayerLevel>> levels;
	
	//Constructor for a PlayerMenu object
	public PlayerMenu(){
		this.levels = new ArrayList<List<PlayerLevel>>();
		for (int i = 0; i < 3; i++){
			this.levels.add(new ArrayList<PlayerLevel>());
		}
	}
	
	//Get method for levels
	public List<List<PlayerLevel>> getLevels(){
		return this.levels;
	}

	//Set method for levels
	public boolean setLevels(List<List<PlayerLevel>> toSet){
		this.levels = toSet;
		return true;
	}
	
	//Returns the level corresponding to the given identifier
	//Identifier should be in one of the following forms:
	//		T#	L#	P#
	//Where the first character indicates the type of level,
	//and number indicates the index in the list of levels.
	//Returns null if the given letter is not T,L, or P,
	//	or if the given number is out of bounds of the arrayList
	public PlayerLevel getLevel(String identifier){
		char type = identifier.charAt(0);
		int index = (int) identifier.charAt(1);
		List<PlayerLevel> desiredLevels;
		
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
	
	//Adds the given level to this menu. If the given level is
	//	false, or is not a puzzle, theme, or lightning level,
	//	returns false.
	public boolean addLevel(PlayerLevel toAdd){
		if (toAdd == null){
			return false;
		}
		else{
			if (toAdd instanceof PlayerPuzzleLevel){
				List<PlayerLevel> puzzleList = this.levels.get(0);
				puzzleList.add(toAdd);
				return true;
			}
			else if (toAdd instanceof PlayerLightningLevel){
				List<PlayerLevel> lightningList = this.levels.get(1);
				lightningList.add(toAdd);
				return true;
			}
			else if (toAdd instanceof PlayerThemeLevel){
				List<PlayerLevel> themeList = this.levels.get(2);
				themeList.add(toAdd);
				return true;
			}
			else{	
				return false;
			}
		}
	}
	
	//Removes the level with the given title from this menu. Returns true
	//	if successful. Returns false if the given title does not match any level.
	boolean removeLevel(String toRemove){
		//Iterate through the array
		Iterator<List<PlayerLevel>> arrayIterator = this.levels.iterator();
		while (arrayIterator.hasNext()){
			//Iterate through the list
			List<PlayerLevel> currentList = arrayIterator.next();
			Iterator<PlayerLevel> listIterator = currentList.iterator();
			
			int listIndex = 0;
			
			while (listIterator.hasNext()){
				PlayerLevel toCheck = listIterator.next();
				if (toCheck.getTitle() == toRemove){
					currentList.remove(listIndex);
					return true;
				}
			}
		}
		//Executes only if the title does not match any levels
		return false;
	}
}
