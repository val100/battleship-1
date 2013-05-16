/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import battleship.domain.Board;
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
public class PlayerUserTest {
    
    PlayerUser pelaaja;
    Board myBoard;
    TargetBoard target;
    
    public PlayerUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myBoard = new Board(5,5);
        target = new TargetBoard(5,5);
        pelaaja = new PlayerUser(myBoard, target);
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
        pelaaja.shoot();
        pelaaja.shoot();
        assertEquals(2, pelaaja.getNumShots());
    }
}