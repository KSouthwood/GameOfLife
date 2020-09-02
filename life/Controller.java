package life;

import java.io.IOException;

public class Controller {
    public void iterateGenerations(Universe board, int generations) {
        Universe finalGen = board;
        for (int gen = 0; gen < generations; gen++) {
            finalGen = finalGen.nextGeneration();
            consoleOutput(finalGen, gen);
        }
    }

    private void consoleOutput(Universe board, int generation) {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }

        System.out.printf("Generation #%d\n", generation + 1);
        System.out.println("Alive: " + board.getNumberAlive());

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                System.out.print(board.isAlive(row, col) ? "O" : " ");
            }
            System.out.println();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
