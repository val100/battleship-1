/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;

import battleship.domain.Board;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author larg
 */
public class BoardCanvas extends JPanel {
    private Board board;
    private int height;
    private int width;
    private int cellSize;
    
    public BoardCanvas(Board userBoard) {
        this.board = userBoard;
        this.height = board.getHeight();
        this.width = board.getWidth();
        this.cellSize = 20;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.red);
        for (int i = 0; i <= this.height; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, this.height * cellSize);
        }
        
        for (int i = 0; i <= this.width; i++) {
            g.drawLine(0, i * cellSize, this.width * cellSize, i * cellSize);
        }
    }
    
    
    
    
    
}
