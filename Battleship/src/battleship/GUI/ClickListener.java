/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;

import battleship.domain.Logic;
import battleship.domain.PlayerComp;
import battleship.domain.PlayerUser;
import battleship.enums.Ship;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author larg
 */
public class ClickListener implements MouseListener {
    private Frame frame;
    private PlayerUser user;
    private PlayerComp comp;
    private BoardCanvas target;
    private BoardCanvas userBoard;
    private Logic logic;

    public ClickListener(Frame frame, PlayerUser user, PlayerComp comp, BoardCanvas userBoard, BoardCanvas target, Logic logic) {
        this.frame = frame;
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
            if (logic.gameEnded()) {
                endGame();
            }
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

    public void placeUserShips() {
       for (Ship s : Ship.values()) {
           while (true) {
                PlaceShipDialog dialog = new PlaceShipDialog(frame, true);
                dialog.setSize(250, 120);
                dialog.setVisible(true);
                int[] shipCoords = dialog.getShip();
                if (user.placeShip(shipCoords[0], shipCoords[1], shipCoords[2], s.getLength())) {
                    userBoard.repaint();
                    break;
                }
                

        }
    }
    
}

    private void endGame() {
        if (logic.gameWon()) {
            DialogBox askName = new DialogBox();
            String name = askName.askName();
            logic.saveScore(name);
            
        }
    }
}