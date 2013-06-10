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
    private Scanner input;
    private boolean gameWon;

    public Logic(BoardSize size) {
        //BoardSize size = startMenu();
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
    
//    private BoardSize startMenu() {
//        this.input = new Scanner(System.in);
//        BoardSize size;
//        while (true) {
//            System.out.println("Select board size:");
//            System.out.println("1 - 8 x 8");
//            System.out.println("2 - 10 x 10");
//            System.out.println("3 - 15 x 15");
//            System.out.print("selection: ");
//            try {
//                int selection = Integer.parseInt(input.nextLine());
//                if (selection == 1) {
//                   size = BoardSize.EASY; 
//                   break;
//                } else if (selection == 2) {
//                    size = BoardSize.NORMAL;
//                    break;
//                } else if (selection == 3) {
//                    size = BoardSize.HARD;
//                    break;
//                }
//                System.out.println("invalid selection!\n");
//            } catch (Exception e) {
//                System.out.println("invalid selection!\n");
//            }
//        }
//        return size;
//    }
    
//    public void userPlaceShips() {
//        System.out.println("Place your ships!");
//        
//        for (Ship s : Ship.values()) {
//            while (true) {    
//                userBoard.drawBoard();
//                System.out.println("Give starting coordinates for ship " + s.name() + "(length: " + s.getLength() + ")");                
//                int x = getXCoord();
//                int y = getYCoord();
//                System.out.print("Give orientation (0 - horizontal, 1 - vertical): ");
//                int orientation = getIntInput();
//                if (orientation < 0 || orientation > 1) {
//                    System.out.println("Invalid orientation! try again!");
//                    continue;
//                }
//                if (!userBoard.placeShip(x, y, orientation, s.getLength())) {
//                    System.out.println("invalid selection! try again");
//                    continue;
//                }
//                break; 
//            }                                       
//        }
//        System.out.println("\nDone. Let the game begin!\n");
//        
//    }
    
//    public void startGame() {
//
//        comp.placeShips();
//        userPlaceShips();
//        while (true) {
//            if (gameEnded()) {
//                break;
//            }
//            System.out.println("");
//            System.out.println("Your board:");
//            userBoard.drawBoard();
//            System.out.println("Enemy board:");
//            compBoard.drawBoard();
//            System.out.println("Your turn to shoot!");
//            int x = getXCoord();
//            int y = getYCoord();
//            player.shoot(x, y);
//            comp.shoot();
//        }
//        fileHandler.readScore();
//        fileHandler.printScore();
//    }
   
    public boolean gameEnded() {
        if (compBoard.shipSquaresLeft() == 0) {
            
            
            gameWon = true;
            return true;
        
        } else if (userBoard.shipSquaresLeft() == 0) {
           // System.out.println("YOU LOSE");

            return true;
        }
        return false;
    }
    
    
//    public int getXCoord() {
//        int coord = 0;
//        while (true) {
//            System.out.print("Give X coordinate: ");
//            coord = getIntInput();
//            if (coord < 0 || coord > compBoard.getWidth()-1) {
//                System.out.println("invalid coordinate! try again");
//                continue;
//            }
//            
//            break;
//        }
//        return coord;
//    }
//    
//    public int getYCoord() {
//        int coord = 0;
//        while (true) {
//            System.out.print("Give Y coordinate: ");
//            coord = getIntInput();
//            if (coord < 0 || coord > compBoard.getWidth()-1) {
//                System.out.println("invalid coordinate! try again");
//                continue;
//            }
//            
//            break;
//        }
//        return coord;
//    }
//    
//    public int getIntInput() {
//        int number = 0;
//        while (true) {
//            try {
//                number = Integer.parseInt(input.nextLine());
//            } catch (Exception e) {
//                System.out.println("Invalid input! try again ...");
//                continue;
//            }
//            break;
//        }
//        return number;        
//    }

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
    
}
