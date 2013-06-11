/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;

import static battleship.domain.Board.BOARD_BLANK;

/**
 * This class extends the Board-class, so that the enemy board
 * does not show it's ships.
 * 
 * @author larg
 */
public class TargetBoard extends Board {
    
    public TargetBoard(int height, int width) {        
        super(height, width);        
    }
    
    @Override
    public void drawBoard() {
        for (int i = 0; i < super.getHeight(); i++) {
            for (int j = 0; j < super.getWidth(); j++) {
                if (super.getBoard()[i][j] == BOARD_BLANK) {
                    System.out.print(".");
                } else if (super.getBoard()[i][j] == BOARD_SHIP) {
                    //debug draw
                    //System.out.print("@");
                    //real draw
                    System.out.print(".");
                } else if (super.getBoard()[i][j] == BOARD_HIT) {
                    System.out.print("X");
                } else if (super.getBoard()[i][j] == BOARD_MISS) {
                    System.out.print("O");
                }
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
}
