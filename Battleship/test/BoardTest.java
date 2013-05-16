/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import battleship.domain.Board;
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
public class BoardTest {
    
    Board board;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new Board(5,5);
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
    public void constructorSetsCorrectHeight() {
        assertEquals(5, board.getHeight());
    }
    
    @Test
    public void constructorSetsCorrectWidth() {
        assertEquals(5, board.getWidth());
    }
    
    @Test 
    public void boardCellInitializedCorrectly() {
        assertEquals(0, board.cellInfo(4, 4));
    }
    
    @Test
    public void horizontalShipPlacedCorrectly() {
        board.placeShip(1, 1, 0, 2);
        int[][] expected = {{0,0,0,0,0}, {0,1,1,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}  };
        assertArrayEquals(expected, board.getBoard());
    }
    
    @Test 
    public void verticalShipPlacedCorrectly() {
        board.placeShip(1, 1, 1, 2);
        int[][] expected = {{0,0,0,0,0}, {0,1,0,0,0}, {0,1,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}  };
        assertArrayEquals(expected, board.getBoard());
    }
    
    @Test
    public void twoShipsPlacedCorrectly() {
        board.placeShip(1, 1, 1, 2);
        board.placeShip(3, 2, 0, 2);
        int[][] expected = {{0,0,0,0,0}, {0,1,0,0,0}, {0,1,0,1,1}, {0,0,0,0,0}, {0,0,0,0,0}  };
        assertArrayEquals(expected, board.getBoard());
    }
    
    @Test
    public void shootMissPlacedCorrectly() {
        int[][] expected = {{0,0,0,0,0}, {0,0,0,0,0}, {0,3,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}  };
        board.shoot(1, 2);
        assertArrayEquals(expected, board.getBoard());
    }
    
    @Test
    public void shootHitPlacedCorrectly() {
        board.placeShip(1, 1, 1, 2);
        int[][] expected = {{0,0,0,0,0}, {0,1,0,0,0}, {0,2,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}  };
        board.shoot(1, 2);
        assertArrayEquals(expected, board.getBoard());
    }
}