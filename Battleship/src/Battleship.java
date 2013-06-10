import battleship.GUI.GUI;

import battleship.domain.Board;
import battleship.domain.Logic;
import battleship.domain.PlayerComp;
import battleship.domain.TargetBoard;
import battleship.textmode.TextMode;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author larg
 */
public class Battleship {
    public static void main(String[] args) {
        

        //TextMode text = new TextMode();
        //text.startGame();
       
        
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);
        

    }
}
