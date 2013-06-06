/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;

import battleship.domain.Board;
import battleship.domain.TargetBoard;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author larg
 */
public class BoardCanvas extends JPanel {
    private Board board;
//    private TargetBoard target;
    private int height;
    private int width;
    private int cellSize;
    
    public BoardCanvas(Board userBoard) {
        this.board = userBoard;
//        this.target = target;
        this.height = board.getHeight();
        this.width = board.getWidth();
        this.cellSize = 20;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        drawGrid(g);
        drawCells(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i <= this.height; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, this.height * cellSize);
        }
        
        for (int i = 0; i <= this.width; i++) {
            g.drawLine(0, i * cellSize, this.width * cellSize, i * cellSize);
        }
    }

    private void drawCells(Graphics g) {
        
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
 
                int cell = board.cellInfo(j, i);
                if (cell == 0) {
                    g.setColor(Color.white);
                    g.fillRect((cellSize * j)+1, (cellSize * i)+1, cellSize-1, cellSize-1); 
                }
                if (cell == 1) {
                    g.setColor(Color.black);
                    g.fillRect((cellSize * j)+1, (cellSize * i)+1, cellSize, cellSize);
                }
                if (cell == 2) {
                    g.setColor(Color.red);
                    g.fillRect((cellSize * j)+1, (cellSize * i)+1, cellSize-1, cellSize-1);
                }
                
                if (cell == 3) {
                    g.setColor(Color.blue);
                    g.fillRect((cellSize * j)+1, (cellSize * i)+1, cellSize-1, cellSize-1);
                }
                
            }
        }
    }
    
    
    
    
    
}
