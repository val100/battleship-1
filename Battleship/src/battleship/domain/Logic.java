/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;
import battleship.enums.BoardSize;
import battleship.filehandler.FileHandler;
import battleship.enums.Ship;
import java.util.Scanner;

/**
 *
 * @author larg
 */
public class Logic {
    private Board userBoard;
    private TargetBoard compBoard;
    private PlayerUser player;
    private PlayerComp comp;
    private FileHandler fileHandler;
    //private Scanner input;
    private boolean gameWon;

    public Logic(BoardSize size) {
        this.userBoard = new Board(size.getSize(), size.getSize());
        this.compBoard = new TargetBoard(size.getSize(), size.getSize());
        this.userBoard.initBoard();
        this.compBoard.initBoard();
        this.player = new PlayerUser(userBoard, compBoard);
        this.comp = new PlayerComp(userBoard, compBoard);
        this.fileHandler = new FileHandler();
        fileHandler.readScore();
        gameWon = false;
    }    
   
    public boolean gameEnded() {
        if (compBoard.shipSquaresLeft() == 0) {                       
            gameWon = true;
            return true;
        
        } else if (userBoard.shipSquaresLeft() == 0) {
            return true;
        }
        return false;
    }    

    public PlayerComp getComp() {
        return comp;
    }

    public TargetBoard getCompBoard() {
        return compBoard;
    }

    public PlayerUser getPlayer() {
        return player;
    }

    public Board getUserBoard() {
        return userBoard;
    }

    public boolean gameWon() {
        return gameWon;
    }
    
    public void saveScore(String name) {
        fileHandler.writeScore(name, player.getScore());
    }
    
    public void showScore() {
        fileHandler.readScore();
        fileHandler.printScore();
    }
    
    public String getScoreString() {
        String scores = fileHandler.getScores();
        System.out.println(scores);
        return scores;
        
    }
    
}
