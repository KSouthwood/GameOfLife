package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        long seed = input.nextInt();
        Board life = new Board(size, seed);
        life.create();
        life.print();
    }
}
