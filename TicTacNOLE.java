/*
 * TicTacNOLE.java
 * Hague, Brian
 * COP 3252
 * Project 1
 * 02/28/13
 * 
 * Note: some code retrieved from the Java How to Program book
 * 
 * This is the driver class. Creates a title, board, and footer.
 * Places these three into a JPanel with a BoxLayout, then adds
 * to a JFrame.
 */

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
        
public class TicTacNOLE
{
    
    public static void main(String[] args)
    {
        DrawTitle board = new DrawTitle();
        GameBoard buttons = new GameBoard();
        DrawFooter footer = new DrawFooter();
        JFrame applicationWindow = new JFrame();
        JPanel wholeApp = new JPanel();
        wholeApp.setLayout(new BoxLayout(wholeApp, BoxLayout.Y_AXIS));
        wholeApp.add(board);
        wholeApp.add(buttons);
        wholeApp.add(footer);
        
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.add(wholeApp);
        applicationWindow.setSize(500, 760);
        applicationWindow.setVisible(true);
        
    }
}
