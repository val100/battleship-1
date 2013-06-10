/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;

import battleship.domain.Logic;
import battleship.domain.PlayerComp;
import battleship.domain.PlayerUser;
import battleship.enums.Ship;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author larg
 */
public class ClickListener implements MouseListener {
    private PlayerUser user;
    private PlayerComp comp;
    private BoardCanvas target;
    private BoardCanvas userBoard;
    private Logic logic;

    public ClickListener(PlayerUser user, PlayerComp comp, BoardCanvas userBoard, BoardCanvas target, Logic logic) {
        this.user = user;
        this.comp = comp;        
        this.userBoard = userBoard;
        this.target = target;
        this.logic = logic;
        //placeUserShips();
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //while (!logic.gameEnded()) {
            int x = (e.getX() / target.getCellSize());
            int y = (e.getY() / target.getCellSize()-1);

            //System.out.println("klikattiin solua: " + x + ", " + y);
            try {
                user.shoot(x, y);
            } catch (Exception ex) {
                
            }    
            comp.shoot();
            target.repaint();
            userBoard.repaint();
        //}
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private void placeUserShips() {
       for (Ship s : Ship.values()) {
            DialogBox shipPlacement = new DialogBox();
            shipPlacement.askShipPlacement(s, user, logic.getUserBoard().getHeight());
        }
    }
    
}
