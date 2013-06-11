/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;

import battleship.domain.Board;
import java.awt.Color;
import java.awt.Graphics;

/**
 * This class extends BoardCanvas to draw the enemy board, i.e. not showing ships
 * 
 * @author larg
 */
public class TargetCanvas extends BoardCanvas {
    private Board board;
    private int height;
    private int width;
    private int cellSize;
    
    public TargetCanvas(Board board) {
        super(board);
        this.board = board;
        this.height = board.getHeight();
        this.width = board.getWidth();
        this.cellSize = super.getCellSize();
    }

    @Override
    protected void drawCells(Graphics g) {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
 
                int cell = board.cellInfo(j, i);
                if (cell == 0) {
                    g.setColor(Color.white);
                    g.fillRect((cellSize * j)+1, (cellSize * i)+1, cellSize-1, cellSize-1); 
                }
                if (cell == 1) {
                    g.setColor(Color.white);
                    g.fillRect((cellSize * j)+1, (cellSize * i)+1, cellSize-1, cellSize-1);
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
