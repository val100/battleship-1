/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;
//import java.util.Scanner;

/**
 *
 * @author larg
 */
public class PlayerUser {
    
    private Board myBoard;
    private TargetBoard compBoard;
    private int numShots;
    private int numHits;
    //private Scanner input;

    public PlayerUser(Board myBoard, TargetBoard compBoard) {
        this.myBoard = myBoard;
        this.compBoard = compBoard;
        this.numShots = 0;
        this.numHits = 0;
    }
    
    public boolean placeShip(int startX, int startY, int direction, int size) {
        return this.myBoard.placeShip(startX, startY, direction, size);
    }
    
    public boolean shoot(int x, int y) {
        //this.input = new Scanner(System.in);
        
        boolean success = this.compBoard.shoot(x, y);
        this.numShots++;
        return success;
    }
    
    public int getNumShots() {
        return this.numShots;
    }
    
    //public int getNumHits() {
    //    return this.numHits;
    //}
    
    // score == shots / hits
    public int getScore() {
        return this.numShots / (this.myBoard.getHeight() * this.myBoard.getWidth());
    }
}
