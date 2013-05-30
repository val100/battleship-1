/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import battleship.domain.Board;
import battleship.domain.PlayerComp;
import battleship.domain.PlayerUser;
import battleship.domain.TargetBoard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author larg
 */
public class PlayerCompTest {
    
    PlayerComp comp;
    Board myBoard;
    TargetBoard target;
    
    public PlayerCompTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myBoard = new Board(8,8);
        target = new TargetBoard(8,8);
        comp = new PlayerComp(myBoard, target);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void numShotsIncreases() {
        comp.shoot();
        comp.shoot();
        assertEquals(2, comp.getNumShots());
    }
    
    
    
    @Test
    public void correctAmountOfShipsPlacedOnBoard() {
        int numShipSquares = 0;
        int cell = 0;
        comp.placeShips();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cell = target.cellInfo(i, j);
                if (cell == 1) {
                    numShipSquares++;
                }
            }
        }
        assertEquals(19, numShipSquares);
    }
    
}