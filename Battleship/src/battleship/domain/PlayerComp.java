/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;
import java.util.Random;

/**
 *
 * @author larg
 */
public class PlayerComp {
    private Board userBoard;
    private TargetBoard compBoard;
    private Random random;
    private int numShots;

    public PlayerComp(Board userBoard, TargetBoard compBoard) {
        this.userBoard = userBoard;
        this.compBoard = compBoard;
        this.random = new Random();
        this.numShots = 0;
    }
    
    public boolean shoot() {
        int x = random.nextInt(userBoard.getWidth());
        int y = random.nextInt(userBoard.getHeight());
        numShots++;
        return this.userBoard.shoot(x, y);
        
    }
    
    public void placeShips() {
        for (Ship s : Ship.values()) {
            while (true) {
                int orientation = random.nextInt(2);
                int startX = random.nextInt(compBoard.getWidth());
                int startY = random.nextInt(compBoard.getHeight());
                if (compBoard.placeShip(startX, startY, orientation, s.getLength())) {
                    break;
                }
            }
        }
    }
    
    public int getNumShots() {
        return this.numShots;
    }
    
}
