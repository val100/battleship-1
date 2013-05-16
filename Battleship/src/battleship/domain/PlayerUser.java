/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;

/**
 *
 * @author larg
 */
public class PlayerUser {
    
    private Board myBoard;
    private TargetBoard compBoard;
    private int numShots;

    public PlayerUser(Board myBoard, TargetBoard compBoard) {
        this.myBoard = myBoard;
        this.compBoard = compBoard;
        this.numShots = 0;
    }
    
    public void shoot() {
        this.numShots++;
    }
    
    public int getNumShots() {
        return this.numShots;
    }
}
