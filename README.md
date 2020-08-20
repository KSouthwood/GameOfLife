# GameOfLife
John Conway's Game of Life in Java for the JetBrains Academy Java course.

## About
Get firsthand experience of creating a small inhabited universe and observe the many patterns in which this “life” can evolve. Generation by generation, watch the cells come and go, reacting to their environment, perishing from loneliness or finding comfort in company. In this project, you will write a simple “Game of Life”, a classic toy for programmers to entertain and educate themselves. Careful: might be hypnotizing!

The program will make use of Java Swing for a GUI, basic multi-threading, the Random class, and be programmed using MVC pattern.

#### Stage 1: Let there be light
We’ll begin with the console version of the application and add GUI later.

The first program should output a square matrix NxN: there must be N lines with N characters in each line. If there is an alive cell, place the letter `O`, otherwise, whitespace.

Input data is two numbers in one line. First is N (N>0): the size of the universe. The second is S: a number that you should use as the seed for your Random object. Notice, that you should set the seed only once.
