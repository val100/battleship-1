/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;

/**
 * This class represents the User player.
 *
 * @author larg
 */
public class PlayerUser {

    private Board myBoard;
    private TargetBoard compBoard;
    private int numShots;
    private int numHits;

    public PlayerUser(Board myBoard, TargetBoard compBoard) {
        this.myBoard = myBoard;
        this.compBoard = compBoard;
        this.numShots = 0;
        this.numHits = 0;
    }

    public boolean placeShip(int startX, int startY, int direction, int size) {
        return this.myBoard.placeShip(startX, startY, direction, size);
    }

    /**
     * Take a shot at the enemy board.
     *
     * @param x X-coordinate for shot
     * @param y Y-coordinate for shot
     *
     * @see battleship.domain.Board#shoot(int, int)
     *
     * @return true if shot successful, otherwise false
     */
    public boolean shoot(int x, int y) {
        boolean success = this.compBoard.shoot(x, y);
        this.numShots++;
        return success;
    }

    public int getNumShots() {
        return this.numShots;
    }

    public int getScore() {
        return (this.myBoard.getHeight() * this.myBoard.getWidth()) - this.numShots;
    }
}
