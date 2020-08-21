package life;

public class Controller {
    public Universe iterateGenerations(Universe board, int generations) {
        Universe finalGen = board;
        for (int i = 0; i < generations; i++) {
            finalGen = newGeneration(finalGen);
        }

        return finalGen;
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
