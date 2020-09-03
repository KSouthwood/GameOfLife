# GameOfLife
John Conway's Game of Life in Java for the JetBrains Academy Java course.

## About
Get firsthand experience of creating a small inhabited universe and observe the many patterns in which this “life” can
evolve. Generation by generation, watch the cells come and go, reacting to their environment, perishing from loneliness
or finding comfort in company. In this project, you will write a simple “Game of Life”, a classic toy for programmers to
entertain and educate themselves. Careful: might be hypnotizing!

The program will make use of Java Swing for a GUI, basic multi-threading, the Random class, and be programmed using MVC
pattern.

#### Stage 1: Let there be light
We’ll begin with the console version of the application and add GUI later.

The first program should output a square matrix NxN: there must be N lines with N characters in each line. If there is
an alive cell, place the letter `O`, otherwise, whitespace.

Input data is two numbers in one line. First is N (N>0): the size of the universe. The second is S: a number that you
should use as the seed for your Random object. Notice, that you should set the seed only once.

#### Stage 2: Generations
The progress of the game is evolution: one generation changes another. Each generation will be fully determined by the
previous generation. The new state of each cell will be determined by its neighbors (the eight adjacent cells). Any cell
on a border will have as its neighbors cells on the opposite side of the board. (i.e. A cell on the top border will have
neighbors on the bottom border.)

Evolution of a cell is controlled by two rules:
- An alive cell survives if it has two or three alive neighbors; otherwise, it dies of boredom (<2 neighbors) or
overpopulation (>3).
- A dead cell is re-born if it has exactly three alive neighbors.

Apply these rules to each cell to compute the next generation.

Input data is now three numbers: `N` `S` `M`. `N` (which will be >0) is the size of the universe. `S` (a long) will be
the seed for the Random object. `M` (which will be ≥0) is the number of generations to generate before outputting
the last generation.

#### Stage 3: Life goes by
Since the universe and its laws work properly now, it's time to visualize evolution.

Display the universe after each generation. We'll need to pause for a bit after each generation - use methods from
`java.lang.Thread` - so we can see the results. Either output each generation one after the other, or clear the console
before printing each generation.

The only input is now a number for the size of the universe. The seed should now be random which means the initial board
will be different each time we run the program.

#### Stage 4: Looking good!
Replace the console output with a window that displays the game field, the generation number, and the number of cells
alive on the board. Use Java Swing components to create the window and associated components.
