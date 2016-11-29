//Same Layout for all levels
High Score, 5 decimal digit int
Highest number of stars, 1 decimal digit int
Title, String
1 Star threshold, int
2 Star threshold, higher int
3 Star threshold, highest int

//Bitmap of 1 and 0 separated by 1, 6 by 6 grid
//1 is active, 2 is inactive (example below)
0 1 1 1 1 1
1 0 1 1 1 1
1 1 0 1 1 1
1 1 1 0 1 1
1 1 1 1 0 1
1 1 1 1 1 0

//Below diverges based on type of level.

//Lightning:

number of seconds, int

//Puzzle:

word limit, int

//Theme:

//Same shape as the bitmap, but one capitalized char in stead of 1 or 0
//Qu is represented by Q
//Shows which squares appear where when the level begins (example below)
J W A T D O
M B I P E P
E N E P M U
L R A K A A
N R A A C V
G O N A N O

Theme, String

Number of Words used in the level, int
//List of words used in the level, in all caps (example below)
PUMPKIN
AVOCADO
BANANA
GRAPE
WATERMELON


**********************

The first two fields need to be 5 digit and 1 digit long respectively, with either leading zeros or spaces preceeding. Everything will break if you do not do that.

As of this writing, we need at least 1 more lightning, 2 more puzzles, and 3 more themes. Feel free to add your own, just follow this layout and use my examples as a reference.