package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Universe board = null;
        int gens = Integer.MAX_VALUE;

        final Scanner input = new Scanner(System.in);
        String[] params = input.nextLine().split(" ");

        if (params.length > 0) {
            int size = Integer.parseInt(params[0]);
            switch (params.length) {
                case 1:
                    board = new Universe(size);
                    break;
                case 2:
                    board = new Universe(size, Long.parseLong(params[1]));
                    break;
                case 3:
                    board = new Universe(size, Long.parseLong(params[1]));
                    gens = Integer.parseInt(params[2]);
                    break;
                default:
                    System.out.println("Error: Too many parameters!");
                    break;
            }
        } else {
            System.out.println("Error: No input given!");
        }

        if (board != null) {
            Controller controller = new Controller();
            controller.iterateGenerations(board, gens);
        }
    }
}
