/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import battleship.filehandler.FileHandler;
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
public class FileHandlerTest {
    
    FileHandler fh;
    
    public FileHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fh = new FileHandler();
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
    public void readingScoreSuccesful() {
        assertTrue(fh.readScore());
    }
    
    @Test
    public void writingScoreSuccesful() {
        assertTrue(fh.writeScore("puppe", 45));
    }
}