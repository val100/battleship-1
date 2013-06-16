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
import battleship.enums.BoardSize;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author larg
 */
public class GUI implements Runnable {
    private BoardSize boardsize;
    private JFrame frame;
    private Board userBoard;
    private TargetBoard compBoard;
    private PlayerComp comp;
    private PlayerUser user;
    private Logic logic;
    private ClickListener clicker;
    
    public GUI() {
        DialogBox askSize = new DialogBox();
        this.boardsize = askSize.askBoardSize();
        this.logic = new Logic(this.boardsize);
        this.userBoard = logic.getUserBoard();
        this.compBoard = logic.getCompBoard();
        this.comp = logic.getComp();
        this.user = logic.getPlayer();
        this.comp.placeShips();
        
    }

    @Override
    public void run() {
        frame = new JFrame("Battleship");
//        if (this.boardsize == BoardSize.HARD) {
//            frame.setPreferredSize(new Dimension(700, 380));
//        }
        setWindowSize();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        clicker.placeUserShips();
    }

    private void createComponents(Container container) {
        container.add(createUpperPanel(), BorderLayout.NORTH);
        BoardCanvas target = new TargetCanvas(compBoard);
        BoardCanvas userCanvas = new BoardCanvas(userBoard);
        JPanel panel = createBoardPanel(target, userCanvas);
        container.add(panel);
        
        this.clicker = new ClickListener(frame, panel, user, comp, userCanvas, target, logic);
        frame.addMouseListener(clicker);
    }
    
    private JPanel createUpperPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("ENEMY BOARD"));
        panel.add(new JLabel("YOUR BOARD"));
        return panel;
    }
    
    private JPanel createBoardPanel(BoardCanvas target, BoardCanvas userCanvas) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(target);
        panel.add(userCanvas);
        return panel;
        
    }
    
    public void setWindowSize() {
        if (this.boardsize == BoardSize.HARD) {
            frame.setPreferredSize(new Dimension(700, 380));
        } else if (this.boardsize == BoardSize.NORMAL) {
            frame.setPreferredSize(new Dimension(500, 300));
        } else if (this.boardsize == BoardSize.EASY) {
            frame.setPreferredSize(new Dimension(420, 230));
        } else {
            frame.setPreferredSize(new Dimension(700, 380));
        }
    }
    
    public JFrame getFrame() {
        return this.frame;
    }
}
