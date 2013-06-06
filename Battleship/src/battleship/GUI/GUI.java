/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.GUI;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import battleship.domain.Board;
import battleship.domain.PlayerComp;
import battleship.domain.PlayerUser;
import battleship.domain.TargetBoard;
import java.awt.GridLayout;

/**
 *
 * @author larg
 */
public class GUI implements Runnable {
    
    private JFrame frame;
    private Board userBoard;
    private TargetBoard compBoard;
    private PlayerComp comp;
    private PlayerUser user;
    
    public GUI() {
        this.userBoard = new Board(10,10);
        this.compBoard = new TargetBoard(10, 10);
        this.comp = new PlayerComp(userBoard, compBoard);
        this.user = new PlayerUser(userBoard, compBoard);
        this.comp.placeShips();
        this.user.shoot(4, 4);
    }

    @Override
    public void run() {
        frame = new JFrame("Battleship");
        frame.setPreferredSize(new Dimension(800, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(1, 0, 15, 15));
        container.add(new BoardCanvas(userBoard));
        container.add(new BoardCanvas(compBoard));
    }
    
    public JFrame getFrame() {
        return this.frame;
    }
}
