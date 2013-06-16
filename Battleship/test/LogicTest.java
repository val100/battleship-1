/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import battleship.domain.Logic;
import battleship.enums.BoardSize;
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
public class LogicTest {
    
    Logic logic;
    
    public LogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        logic = new Logic(BoardSize.EASY);
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
    public void gameEndedWhenNoShipsOnBoard() {
        assertTrue(logic.gameEnded());                
    }
    
    @Test 
    public void gameNotEndedWhenShipsOnBoards() {
        logic.getComp().placeShips();
        logic.getPlayer().placeShip(0, 0, 1, 4);
        assertFalse(logic.gameEnded());
    }
    
    @Test
    public void gameWonWhenNoShipsOnCompBoard() {
        logic.gameEnded();
        assertTrue(logic.gameWon());
    }
    
    @Test 
    public void gameNotWonWhenCompHasShips() {
        logic.getComp().placeShips();
        logic.gameEnded();
        assertFalse(logic.gameWon());
    }
}