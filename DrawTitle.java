/*
 * DrawBoard.java
 * Hague, Brian
 * COP 3252
 * Project 1
 * 02/28/13
 * 
 * Note: some code retrieved from the Java How to Program book
 * and http://www.javalobby.org/java/forums/t19183.html (for setting color)
 * 
 * DrawTitle draws the title bar and title text
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawTitle extends JPanel
{
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        
        Color seminoleRed = new Color(0xB0171F);
        g.setColor(seminoleRed);
        g.fillRect(0, 0, getWidth(), 70);
        
        g.setColor(Color.YELLOW);
        Font titleFont = new Font("Benton Sans", Font.BOLD, 30);
        g.setFont(titleFont);
        String title = "Tic-Tac-NOLE";
        
        g.drawString(title, 15, 45);
    }
}
