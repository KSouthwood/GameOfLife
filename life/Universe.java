package life;

import java.util.Random;

public class Universe {
    private static int size;
    private static Random rnd;

    private boolean[][] board;
    private int numberAlive;

    Universe(int boardSize) {
        size = boardSize;
        rnd = new Random();
        this.board = new boolean[boardSize][boardSize];
        initialize();
    }

    Universe(int boardSize, long seed) {
        size = boardSize;
        rnd = new Random(seed);
        this.board = new boolean[boardSize][boardSize];
        initialize();
    }

    Universe() {
        if (size > 0) {
            board = new boolean[size][size];
        } else {
            System.out.println("Size is undefined!");
        }
    }

    private void initialize() {
        numberAlive = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                boolean state = rnd.nextBoolean();
                board[row][col] = state;
                numberAlive += state ? 1 : 0;
            }
        }
    }

    public Universe nextGeneration() {
        Universe nextGen = new Universe();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                nextGen.setCell(row, col, deadOrAlive(board[row][col], getNeighbors(row, col)));
                nextGen.numberAlive += nextGen.isAlive(row, col) ? 1 : 0;
            }
        }

        return nextGen;
    }

    private boolean deadOrAlive(boolean cell, int neighbors) {
        if (cell) {
            // if currently alive, stay alive if there are two or three neighbors
            return neighbors == 2 || neighbors == 3;
        } else {
            // if currently dead, be re-born if there are three neighbors
            return neighbors == 3;
        }
    }

    public void setCell(int row, int col, boolean alive) {
        board[row][col] = alive;
    }

    public boolean isAlive(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

    private int getNeighbors(int cellRow, int cellCol) {
        int neighbors = 0;

        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }
                neighbors += this.board[checkLimit(cellRow + row)][checkLimit(cellCol + col)] ? 1 : 0;
            }
        }

        return neighbors;
    }

    private int checkLimit(int pos) {
        if (pos < 0) {
            return size - 1;
        }

        if (pos == size) {
            return 0;
        }

        return pos;
    }

    public int getNumberAlive() {
        return numberAlive;
    }
}
