/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;

import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class handles the dialog for placing the user's ship on the board at the
 * start of the game.
 *
 * @author larg
 */
public class PlaceShipDialog extends JDialog {

    JLabel labelX = new JLabel("Start X");
    JLabel labelY = new JLabel("Start Y");
    JLabel labelO = new JLabel("Orientation");
    JTextField xCoordField = new JTextField();
    JTextField yCoordField = new JTextField();
    JTextField orientationField = new JTextField();
    int[] ship = {-1, -1, -1};

    public PlaceShipDialog(Frame owner, boolean modal) {
        super(owner, modal);
        init();
    }

    /**
     * Initialize dialog box.
     */
    private void init() {
        this.setTitle("Place your ship");
        this.setLayout(new GridLayout(3, 2));
        this.add(labelX);
        this.add(xCoordField);
        this.add(labelY);
        this.add(yCoordField);
        this.add(labelO);
        this.add(orientationField);
    }

    /**
     * Extract user inputted fields for ship placement from dialog box.
     *
     * @return int[] of the field; values are (in order): int[0] - starting X
     * coordinate for ship int[1] - starting Y coordinate for ship int[2] - ship
     * orientation
     */
    public int[] getShip() {
        try {
            ship[0] = Integer.parseInt(xCoordField.getText());

            ship[1] = Integer.parseInt(yCoordField.getText());
            ship[2] = Integer.parseInt(orientationField.getText());

        } catch (Exception e) {
        }
        return ship;
    }
}
