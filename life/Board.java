package life;

import java.util.Random;

public class Board {
    int size;
    Random rnd = new Random();
    boolean[][] board;

    Board(int size, long seed) {
        this.size = size;
        rnd.setSeed(seed);
        board = new boolean[size][size];
    }

    public void create() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = rnd.nextBoolean();
            }
        }
    }

    public void print() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] ? "O" : " ");
            }
            System.out.println();
        }
    }
}
