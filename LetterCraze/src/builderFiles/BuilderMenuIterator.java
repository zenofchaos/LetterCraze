package builderFiles;

import java.util.List;

public class BuilderMenuIterator {

	List<BuilderLevel> puzzleList;
	List<BuilderLevel> lightningList;
	List<BuilderLevel> themeList;
	int puzzleIndex;
	int lightningIndex;
	int themeIndex;

	public BuilderMenuIterator(List<List<BuilderLevel>> givenMenuList){
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
			try{
				this.puzzleList.get(puzzleIndex);
				return true;
			}
			catch (Exception e){
				return false;
			}
		case "Lightning":
			try{
				this.lightningList.get(lightningIndex);
				return true;
			}
			catch (Exception e){
				return false;
			}
		case "Theme":
			try{
				this.themeList.get(themeIndex);
				return true;
			}
			catch (Exception e){
				return false;
			}
		default:
			System.out.println("MenuIterator.hasNext: Level Type unknown.");
			return false;
		}
	}

	//Returns the next level of the given type in the menu
	public BuilderLevel next(String levelType){
		BuilderLevel levelToReturn;
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
