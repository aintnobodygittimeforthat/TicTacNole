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
 * DrawFooter draws the footer, which includes credits.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawFooter extends JPanel
{
    @Override
    public void paintComponent (Graphics g)
    {
        
        super.paintComponent(g);
        
        Color seminoleRed = new Color(0xB0171F);
        g.setColor(seminoleRed);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.YELLOW);
        Font titleFont = new Font("Benton Sans", Font.BOLD, 12);
        g.setFont(titleFont);
        g.drawString("(Needless to say, Seminoles go first!)", 15, 20);
        g.drawString("\u00A9 2013 Brian Hague. Pictures from http://content.sportslogos.net/", 15, 40);
        g.drawString("COP 3252 Java -- Spring 2013 -- Instructor: Rick Hurst", 15, 60);
    }
}
