package life;

import java.io.IOException;

public class Controller {
    public void iterateGenerations(Universe board, int generations) {
        Universe finalGen = board;
        for (int i = 0; i < generations; i++) {
            finalGen = newGeneration(finalGen);
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            }
            catch (IOException | InterruptedException e) {
                System.out.println("Error: " + e);
            }
            System.out.printf("Generation #%d\n", i + 1);
            System.out.println("Alive: " + finalGen.aliveCount());
            finalGen.print();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Error: " + e);
//            }
        }
    }

    private Universe newGeneration(Universe board) {
        Universe newGen = new Universe();
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                newGen.setCell(row, col, deadOrAlive(board.getCell(row, col), board.getNeighbors(row, col)));
            }
        }
        return newGen;
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
}
