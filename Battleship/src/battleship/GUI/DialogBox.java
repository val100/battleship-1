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
 * A Class that makes the different SIMPLE dialogs for the GUI.
 * 
 * @author larg
 */
public class DialogBox {
    private JOptionPane questionBox;
   
    
    public DialogBox() {
        this.questionBox = new JOptionPane();
    }
    
    /**
     * This method is used to ask the board size at the start of the game.
     * 
     * @return board size
     */
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
    
    /**
     * This method is used to ask the user's name to put on the scoreboard
     * at the end of the game.
     * 
     * @return user name
     */
    public String askName() {
        String input;
        input = questionBox.showInputDialog("YOU WON!\nEnter your name:");
        return input;
    }
    
    public void showScore(String scoreString) {
        questionBox.showMessageDialog(questionBox, scoreString);
    }
}
