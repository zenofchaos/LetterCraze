package playerFiles;

import java.util.List;

public class PlayerMenuIterator {

	List<PlayerLevel> puzzleList;
	List<PlayerLevel> lightningList;
	List<PlayerLevel> themeList;
	int puzzleIndex;
	int lightningIndex;
	int themeIndex;
	
	public PlayerMenuIterator(List<List<PlayerLevel>> givenMenuList){
		this.puzzleList = givenMenuList.get(0);
		this.lightningList = givenMenuList.get(1);
		this.themeList = givenMenuList.get(2);
		
		this.puzzleIndex = 0;
		this.lightningIndex = 0;
		this.themeIndex = 0;
	}
	
	//Returns true if there is another level of the given type in the menu
	public boolean hasNext(String levelType){
		switch(levelType){
		case "Puzzle":
			return !(this.puzzleList.get(puzzleIndex) == null);
		case "Lightning":
			return !(this.lightningList.get(lightningIndex) == null);
		case "Theme":
			return !(this.themeList.get(themeIndex) == null);
		default:
			System.out.println("MenuIterator.hasNext: Level Type unknown.");
			return false;
		}
	}
	
	//Returns the next level of the given type in the menu
	public PlayerLevel next(String levelType){
		PlayerLevel levelToReturn;
		switch(levelType){
		case "Puzzle":
			levelToReturn = puzzleList.get(puzzleIndex);
			puzzleIndex++;
			break;
		case "Lightning":
			levelToReturn = lightningList.get(lightningIndex);
			lightningIndex++;
			break;
		case "Theme":
			levelToReturn = themeList.get(themeIndex);
			themeIndex++;
			break;
		default:
			System.out.println("MenuIterator.hasNext: Level Type unknown.");
			levelToReturn = null;
		}
		return levelToReturn;
	}
}
