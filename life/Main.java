package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        Random rnd = new Random();

        int size = input.nextInt();
        Universe life = new Universe(size, rnd);
        Controller controller = new Controller();
        controller.iterateGenerations(life, 30);
    }
}
