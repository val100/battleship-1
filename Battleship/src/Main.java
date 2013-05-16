
import battleship.domain.Board;
import battleship.domain.TargetBoard;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author larg
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Battleship\n");
        Board board = new Board(5,5);
        TargetBoard target = new TargetBoard(5,5);
        board.initBoard();
        target.initBoard();
        board.drawBoard();
        target.drawBoard();
        board.placeShip(1, 1, 1, 2);
        target.placeShip(1, 1, 1, 2);
        board.drawBoard();
        target.drawBoard();
        //board.placeShip(3, 2, 0, 2);
        board.shoot(2, 2);
        board.shoot(1,1);
        target.shoot(3, 0);
        target.shoot(1,1);
        board.drawBoard();
        target.drawBoard();
        int[][] lauta = board.getBoard();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(lauta[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
