/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;

/**
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
    
    public void initBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                board[i][j] = BOARD_BLANK;
            }
        }
    }
    
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
    
    public boolean placeShip(int startX, int startY, int orientation, int size) {
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
        
        //check other ship       
        
        
        
        // place ship
        for (int i = 0; i < size; i++) {
            //check other ship -- bad solution
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
}
