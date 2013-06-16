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
        
        if (args == null || args.length == 0) {
            GUI gui = new GUI();
            SwingUtilities.invokeLater(gui);
        } else if (args[0].equalsIgnoreCase("-t")) {
            TextMode text = new TextMode();
            text.startGame();
        } else {
            System.out.println("Argument '-t': textmode\nNo argument: graphics");
            System.exit(0);
        }
//        if (!args[0].isEmpty() && args[0].equalsIgnoreCase("-t")) {
//            TextMode text = new TextMode();
//            text.startGame();
//        } else {
//            GUI gui = new GUI();
//            SwingUtilities.invokeLater(gui);
//        }
        //TextMode text = new TextMode();
        //text.startGame();
       
        
        //GUI gui = new GUI();
        
        

    }
}
