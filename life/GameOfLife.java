package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private final JLabel generations = new JLabel();
    private final JLabel numberAlive = new JLabel();
    private final JPanel boardGrid   = new JPanel();

    public GameOfLife() {
        setTitle("Game of Life");
        setLocation(100, 100);
        setSize(510, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        generations.setName("GenerationLabel");
        generations.setBounds(5, 5, 290, 20);
        generations.setText("Generation #0");
        add(generations);

        numberAlive.setName("AliveLabel");
        numberAlive.setBounds(5, 30, 290, 20);
        numberAlive.setText("Alive: 0");
        add(numberAlive);

        boardGrid.setBounds(4, 55, 500, 500);
        boardGrid.setBackground(Color.LIGHT_GRAY);
        add(boardGrid);
    }

    public void draw(int gen, Universe board) {
        int size = board.getSize();
        generations.setText("Generation #" + gen);
        numberAlive.setText("Alive: " + board.getNumberAlive());

        int rectSize = 500 / size;
        Graphics2D panelGraphics = (Graphics2D) boardGrid.getGraphics();
        panelGraphics.setColor(Color.LIGHT_GRAY);
        panelGraphics.fillRect(0, 0, 500, 500);
        panelGraphics.setColor(Color.BLUE);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.isAlive(row, col)) {
                    panelGraphics.fillRect(row * rectSize, col * rectSize, rectSize, rectSize);
                } else {
                    panelGraphics.drawRect(row * rectSize, col * rectSize, rectSize - 1, rectSize - 1);
                }
            }
        }
    }
}
