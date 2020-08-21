package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        long seed = input.nextLong();
        int gens = input.nextInt();
        Universe life = new Universe(size, seed);
        Controller controller = new Controller();
        life = controller.iterateGenerations(life, gens);
        life.print();
    }
}
