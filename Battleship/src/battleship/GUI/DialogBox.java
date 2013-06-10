/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;

import battleship.domain.PlayerUser;
import battleship.enums.BoardSize;
import battleship.enums.Ship;
import javax.swing.JOptionPane;

/**
 *
 * @author larg
 */
public class DialogBox {
    private JOptionPane questionBox;
   
    
    public DialogBox() {
        this.questionBox = new JOptionPane();
    }
    
    public BoardSize askBoardSize() {
        String input;
        int selection;
        while (true) {
            try {
                input = questionBox.showInputDialog("Select board size:\n1 - 8 x 8\n2 - 10 x 10\n3 - 15 x 15");
                selection = Integer.parseInt(input);
                if (selection == 1 ) { 
                    return BoardSize.EASY;
                } else if (selection == 2) {
                    return BoardSize.NORMAL;
                } else if (selection == 3) {
                    return BoardSize.HARD;
                }
                continue;
            } catch (Exception e) {
                continue;
            }    
        }
    }

    public void askShipPlacement(Ship s, PlayerUser u, int size) {
        int[] Xpossibilities = new int[size];
        int[] Ypossibilities = new int[size];
        for (int i = 0; i < size; i++) {
            Xpossibilities[i] = i;
            Ypossibilities[i] = i;
        }  
        String input;
        while (true) {    
                
                input = questionBox.showInputDialog("Give starting coordinates for ship " + s.name() + "(length: " + s.getLength() + ")");                
              
       }                                       
        
    }
}
