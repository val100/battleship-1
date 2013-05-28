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
    DESTROYER_1 (3),
    DESTROYER_2 (3),
    PATROL_BOAT_1 (2),
    PATROL_BOAT_2 (2);
    
    private final int length;
    
    Ship(int length) {
        this.length = length;
    }
    
    public int getLength() {
        return this.length;
    }
}
