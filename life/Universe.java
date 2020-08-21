package life;

import java.util.Random;

public class Universe {
    private static int size;
    private boolean[][] board;

    Universe(int boardSize, Random rnd) {
        size = boardSize;
        initialize(rnd);
    }

    Universe() {
        board = new boolean[size][size];
    }

    private void initialize(Random rnd) {
        board = new boolean[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = rnd.nextBoolean();
            }
        }
    }

    public void setCell(int row, int col, boolean isAlive) {
        board[row][col] = isAlive;
    }

    public boolean getCell(int row, int col) {
        return board[row][col];
    }

    public void print() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] ? "O" : " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public int getNeighbors(int cellRow, int cellCol) {
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

    public int aliveCount() {
        int alive = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col]) {
                    alive++;
                }
            }
        }

        return alive;
    }
}
