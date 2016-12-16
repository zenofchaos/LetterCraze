Welcome to Yttrium's LetterCraze! The application is 100% guaranteed functional on Windows, and should work on Linux. It has never been tested on a Mac.

To run either application:
	Run the "BuilderSplashGUI" or "PlayerSplashGUI" as a java application in order to start the
	game with the splash screen included. Optionally, you can start faster by bypassing the splash
	screen if you run "BuilderMainMenuGUI" or "PlayerMainMenuGUI".

On the Main menu:
	We arrange all of our 15 levels in groups, with our Puzzles on the top row, followed by Lightning
	levels, followed by theme levels. The first of each level starts out unlocked, and earning one
	star in an unlocked level will unlock the next level in the same group. In the builder, creation
	of each type of level is as simple as clicking the '+' sign at the end of the group. Once a new
	level is saved, it can be seen appended to the end of its respective group of levels.

-Inside Player Level-
Controls:
	Click and drag across square to select a word. If you select a square you didn't want to,
	backtrack (while still dragging) to go back one letter. When a word is selected, hit right
	click to submit.

How gravity works:
	Our gravity has a unique implementation, approved by Professor Heineman. Instead of
	blocking rising letters, our inactive squares allow letters to pass through. The catch is,
	the letters inside inactive squares cannot be selected.

Theme level:
	In our theme level, we decided to show the theme words to the side, to make the game more fair.
	each word is then removed from the list on the lefthand side when it is removed from the board.

-Inside Builder Level-
Controls:
	Most fields are labeled and/or in the same location as they would be in the player application.
	Click on a field and type to enter its info. Be warned that you must hit enter to save your
	input or else it will be cleared out. These fields check for proper input (for example,
	entering "hi" or "[!" into one of the score thresholds will not be accepted, and will revert to
	its last legal value. Entering a single alphabetical character into each board square changes
	its letter. To enter the 'QU' letter, just enter a 'Q' into the desired square. Any squares left
	without a letter when saved and played in the player application, a random letter will be added
	in its place.
	Click (and optionally drag) the gray square behind each text field on the board to toggle whether
	the square is active or inactive. When editing a theme level, to add words type each word into
	the text field on the left, then press enter to add it to the list. To remove a word, right click
	on it in the list. Click save to save the level to the disk. 
	