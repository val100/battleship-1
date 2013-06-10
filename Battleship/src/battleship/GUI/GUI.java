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
import battleship.domain.Logic;
import battleship.domain.PlayerComp;
import battleship.domain.PlayerUser;
import battleship.domain.TargetBoard;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

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
    private Logic logic;
    
    public GUI() {
        DialogBox askSize = new DialogBox();
        this.logic = new Logic(askSize.askBoardSize());
        this.userBoard = logic.getUserBoard();
        this.compBoard = logic.getCompBoard();
        this.comp = logic.getComp();
        this.user = logic.getPlayer();
        this.comp.placeShips();
        
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
        container.setLayout(new GridLayout(1, 0, 50, 0));
        BoardCanvas target = new BoardCanvas(compBoard);
        BoardCanvas userCanvas = new BoardCanvas(userBoard);
        //TargetCanvas targetCanvas = new TargetCanvas(user, comp, userCanvas, logic, compBoard);
        container.add(target);
        container.add(userCanvas);
        frame.addMouseListener(new ClickListener(user, comp, userCanvas, target, logic));
    }
    
    public JFrame getFrame() {
        return this.frame;
    }
}
