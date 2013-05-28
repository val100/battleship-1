/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;
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

    public Logic() {
        int size = startMenu();
        this.userBoard = new Board(size, size);
        this.compBoard = new TargetBoard(size, size);
        this.userBoard.initBoard();
        this.compBoard.initBoard();
        this.player = new PlayerUser(userBoard, compBoard);
        this.comp = new PlayerComp(userBoard, compBoard);
        this.fileHandler = new FileHandler();
    }
    
    private int startMenu() {
        this.input = new Scanner(System.in);
        int selection = 0;
        while (true) {
            System.out.println("Select board size:");
            System.out.println("1 - 5 x 5");
            System.out.println("2 - 8 x 8");
            System.out.println("3 - 10 x 10");
            System.out.print("selection: ");
            try {
                selection = Integer.parseInt(input.nextLine());
                if (selection < 1 || selection > 3) {
                    System.out.println("invalid selection!");
                    continue;
                }                             
            } catch (Exception e) {
                System.out.println("invalid selection!");
                continue;
            }
            break;
        }
        return selection;
    }
   
    
}
