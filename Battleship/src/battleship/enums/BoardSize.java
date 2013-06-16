/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.enums;

/**
 * Enum class for the different board sizes available.
 *
 * @author larg
 */
public enum BoardSize {

    EASY(8),
    NORMAL(10),
    HARD(15);
    private final int size;

    private BoardSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
