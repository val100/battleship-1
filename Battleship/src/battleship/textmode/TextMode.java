/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.textmode;

import battleship.domain.Logic;
import battleship.enums.BoardSize;
import battleship.enums.Ship;
import java.util.Scanner;

/**
 * This class handles the text mode for a game of Battleship.
 *
 * @author larg
 */
public class TextMode {

    private Scanner input;
    private Logic logic;

    public TextMode() {
        BoardSize size = startMenu();
        this.logic = new Logic(size);

    }

    /**
     * Draw the start menu for selecting the board size.
     *
     * @return selected BoardSize
     */
    private BoardSize startMenu() {
        this.input = new Scanner(System.in);
        BoardSize size;
        while (true) {
            System.out.println("Select board size:");
            System.out.println("1 - 8 x 8");
            System.out.println("2 - 10 x 10");
            System.out.println("3 - 15 x 15");
            System.out.print("selection: ");
            try {
                int selection = Integer.parseInt(input.nextLine());
                if (selection == 1) {
                    size = BoardSize.EASY;
                    break;
                } else if (selection == 2) {
                    size = BoardSize.NORMAL;
                    break;
                } else if (selection == 3) {
                    size = BoardSize.HARD;
                    break;
                }
                System.out.println("invalid selection!\n");
            } catch (Exception e) {
                System.out.println("invalid selection!\n");
            }
        }
        return size;
    }

    /**
     * Basic game loop in text mode.
     */
    public void startGame() {
        logic.getComp().placeShips();
        userPlaceShips();
        while (true) {
            if (logic.gameEnded()) {
                break;
            }
            System.out.println("");
            System.out.println("Your board:");
            logic.getUserBoard().drawBoard();
            System.out.println("Enemy board:");
            logic.getCompBoard().drawBoard();
            System.out.println("Your turn to shoot!");
            int x = getXCoord();
            int y = getYCoord();
            logic.getPlayer().shoot(x, y);
            logic.getComp().shoot();
        }
        afterGame();
    }

    /**
     * this method handles the user input for placing the user's ship on the
     * board.
     */
    public void userPlaceShips() {
        System.out.println("Place your ships!");

        for (Ship s : Ship.values()) {
            while (true) {
                logic.getUserBoard().drawBoard();
                System.out.println("Give starting coordinates for ship " + s.name() + "(length: " + s.getLength() + ")");
                int x = getXCoord();
                int y = getYCoord();
                System.out.print("Give orientation (0 - horizontal, 1 - vertical): ");
                int orientation = getIntInput();
                if (orientation < 0 || orientation > 1) {
                    System.out.println("Invalid orientation! try again!");
                    continue;
                }
                if (!logic.getUserBoard().placeShip(x, y, orientation, s.getLength())) {
                    System.out.println("invalid selection! try again");
                    continue;
                }
                break;
            }
        }
        System.out.println("\nDone. Let the game begin!\n");

    }

    /**
     * Get X-coordinate from user.
     *
     * @return valid x-coordinate
     */
    public int getXCoord() {
        int coord = 0;
        while (true) {
            System.out.print("Give X coordinate: ");
            coord = getIntInput();
            if (coord < 0 || coord > logic.getCompBoard().getWidth() - 1) {
                System.out.println("invalid coordinate! try again");
                continue;
            }
            break;
        }
        return coord;
    }

    /**
     * Get Y-coordinate from user.
     *
     * @return valid y-coordinate
     */
    public int getYCoord() {
        int coord = 0;
        while (true) {
            System.out.print("Give Y coordinate: ");
            coord = getIntInput();
            if (coord < 0 || coord > logic.getCompBoard().getWidth() - 1) {
                System.out.println("invalid coordinate! try again");
                continue;
            }

            break;
        }
        return coord;
    }

    /**
     * Get/check integer input from user.
     *
     * @return valid integer
     */
    public int getIntInput() {
        int number = -1;
        while (true) {
            try {
                number = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! try again ...");
                continue;
            }
            break;
        }
        return number;
    }

    /**
     * This method handles events after the game has ended.
     */
    private void afterGame() {
        if (logic.gameWon()) {
            System.out.println("YOU WIN");
            System.out.println("Your score was: " + logic.getPlayer().getScore());
            System.out.print("Give your name: ");
            String name = input.nextLine();
            logic.saveScore(name);
        } else {
            System.out.println("YOU LOSE");
        }
        System.out.println(logic.getScoreString());
    }
}
