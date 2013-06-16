/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;

/**
 * This class represents the board on a game of battleship.
 *
 * @author larg
 */
public class Board {

    final static int BOARD_BLANK = 0;
    final static int BOARD_SHIP = 1;
    final static int BOARD_HIT = 2;
    final static int BOARD_MISS = 3;
    final static int DIR_HORIZONTAL = 0;
    final static int DIR_VERTICAL = 1;
    private int height;
    private int width;
    private int[][] board;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.board = new int[height][width];
    }

    /**
     * Initiates all board cells to BLANK.
     */
    public void initBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                board[i][j] = BOARD_BLANK;
            }
        }
    }

    /**
     * Draws the board.
     */
    public void drawBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == BOARD_BLANK) {
                    System.out.print(".");
                } else if (board[i][j] == BOARD_SHIP) {
                    System.out.print("#");
                } else if (board[i][j] == BOARD_HIT) {
                    System.out.print("X");
                } else if (board[i][j] == BOARD_MISS) {
                    System.out.print("O");
                }
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    /**
     * Places a ship on the board.
     *
     * Places a ship on the board by first checking that the coordinates are
     * valid and that there are no other ships in the intended squares.
     *
     * @param startX starting X-coordinate for ship
     * @param startY starting Y-coordinate for ship
     * @param orientation ship orientation
     * @param size ships size in squares
     *
     * @see #checkPlacementCoords(int, int, int, int)
     *
     * @return return true if ship placed successfully, otherwise false
     */
    public boolean placeShip(int startX, int startY, int orientation, int size) {
        if (!checkPlacementCoords(startX, startY, orientation, size)) {
            return false;
        }
        if (!checkOrientation(orientation)) {
            return false;
        }    
        //check for other ships -- maybe needs to be better?
        int checkX = startX;
        int checkY = startY;
        for (int i = 0; i < size; i++) {
            if (board[checkY][checkX] == BOARD_SHIP) {
                return false;
            }
            if (orientation == DIR_HORIZONTAL) {
                checkX++;
            } else {
                checkY++;
            }
        }

        // place ship
        for (int i = 0; i < size; i++) {
            if (board[startY][startX] == BOARD_SHIP) {
                return false;
            }
            board[startY][startX] = BOARD_SHIP;
            if (orientation == DIR_HORIZONTAL) {
                startX++;
            } else {
                startY++;
            }
        }

        return true;
    }

    /**
     * Check that all intended coordinates for ship placement are on the board.
     *
     * @param startX starting X-coordinate for ship placement
     * @param startY starting Y-coordinate for ship placement
     * @param orientation ship orientation
     * @param size ship size in squares
     *
     * @return true if all coordinates valid, otherwise false
     */
    public boolean checkPlacementCoords(int startX, int startY, int orientation, int size) {
        // check starting coordinates
        if (startX < 0 || startX >= this.width || startY < 0 || startY >= this.height) {
            return false;
        }

        // check size
        if (orientation == DIR_HORIZONTAL && startX + size > this.width) {
            return false;
        } else if (orientation == DIR_VERTICAL && startY + size > this.height) {
            return false;
        }
        return true;
    }
    
    public boolean checkOrientation(int orientation) {
        if (orientation < 0 || orientation > 1) {
            return false;
        }
        return true;
    }
        
    

    /**
     * Take a shot at the specified square
     *
     * NOTE: shooting at a square that has already been shot at is considered
     * legal and is not checked.
     *
     * @param x X-coordinate for shot
     * @param y Y-coordinate for shot
     * @return true if shot successful, otherwise false
     */
    public boolean shoot(int x, int y) {
        if (x < 0 || x > width) {
            return false;
        } else if (y < 0 || y > height) {
            return false;
        }
        if (board[y][x] == BOARD_SHIP) {
            board[y][x] = BOARD_HIT;
        } else {
            board[y][x] = BOARD_MISS;
        }
        return true;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public int cellInfo(int x, int y) {
        return board[y][x];
    }

    /**
     * Count how many squares on the board have a ship
     *
     * @return number of squares with ships on the board
     */
    public int shipSquaresLeft() {
        int numShipsLeft = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == BOARD_SHIP) {
                    numShipsLeft++;
                }
            }
        }
        return numShipsLeft;
    }
}
