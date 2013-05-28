/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;

/**
 *
 * @author larg
 */
public enum Ship {
    CARRIER (5),
    CRUISER (4),
    DESTROYER (3),
    PATROL_BOAT (2);
    
    private final int length;
    
    Ship(int length) {
        this.length = length;
    }
    
    public int getLength() {
        return this.length;
    }
}
