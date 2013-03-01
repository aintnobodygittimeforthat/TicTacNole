/*
 * GameBoard.java
 * Hague, Brian
 * COP 3252
 * Project 1
 * 02/28/13
 * 
 * Note: some code retrieved from the Java How to Program book
 * and http://stackoverflow.com/questions/8065571/change-state-of-toggle-button-from-another-button
 * (for the idea of the AbstractButton)
 * 
 * http://www.coderanch.com/t/345317/GUI/java/clear-JPanel-repainting
 * (for how to implement reset by clearing the Panel)
 * 
 * Other code ideas came from the online Java API document:
 * http://docs.oracle.com/javase/6/docs/api/
 * 
 * GameBoard serves as the "meat" behind TicTacNOLE's visual interface. The class
 * creates the buttons, text, and variables necessary to "wrap" a TicTacToe object
 * and make playing TicTacNOLE user-friendly.
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel
{
    //array of JButtons that represent board spaces
    private JButton[] buttonList;
    //clears the board
    private JButton resetButton;
    //displays the winner, whose turn it is, and if a tie has been reached
    private String status;
    private JLabel statusLabel;
    private JPanel statusPanel;
    //"switch" that represents the player
    private int player;
    //underlying TicTacToe object
    private TicTacToe game;
    
    //initializes the starting player, status/status bar, TicTacToe game, and buttons
    public GameBoard ()
    {
        player = 1;
        game = new TicTacToe();
        
        status = "Welcome to Tic-Tac-Nole. Player 1 (FSU) goes first.";
        statusLabel = new JLabel(status);
        statusPanel = new JPanel();
        statusPanel.add(statusLabel);
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        initButtons();
        add(statusPanel);
    }
    
    //initializes the buttons, including the reset button, and puts them in a JPanel
    private void initButtons ()
    {
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new GridLayout(3, 3));
        
        buttonList = new JButton[9];
        GameBoard.ButtonHandler handler = new GameBoard.ButtonHandler();
        Icon blank = new ImageIcon(getClass().getResource("blank.gif"));
        
        /*
         * initializes each button, setting the icon, ActionListener, and
         * ActionCommand (the ActionCommand is used by actionPerformed in
         * order to know which button is pressed
         */
        for (int i = 0; i < 9; ++i)
        {
            buttonList[i] = new JButton();
            buttonList[i].setIcon(blank);
            buttonList[i].setActionCommand(Integer.toString(i));
            buttonList[i].addActionListener(handler);
            bPanel.add(buttonList[i]);
        }
        
        //adds the panel with all the buttons (excluding the reset button)
        add(bPanel);
        
        //initializes and sets up the reset button
        resetButton = new JButton();
        resetButton.setText("RESET");
        ResetHandler rHandler = new ResetHandler();
        resetButton.addActionListener(rHandler);
        JPanel resetPanel = new JPanel();
        resetPanel.add(resetButton);
        add(resetPanel);
    }
    
    //updates the status
    private void updateStatus()
    {
        statusLabel.setText(status);
        updateUI();
    }
    
    //when the reset button is pressed, this class clears and resets everything
    private class ResetHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            removeAll();
            updateUI();
            
            player = 1;
            game.clearBoard();
            status = "Player 1 (FSU) goes first.";
            initButtons();
            updateStatus();
            add(statusPanel);
        }
    }
    
    /*
     * when a board space is pressed, this class determines which icon to change
     * the button to, that is, if the button can be pressed at all. It also
     * updates the TicTacToe object and uses it to update the status bar, among
     * other things.
     */
    private class ButtonHandler implements ActionListener
    {
        //when a board space is pressed
        @Override
        public void actionPerformed(ActionEvent event)
        {
            //get that board space
            AbstractButton buttonPressed = (AbstractButton) event.getSource();
            boolean moveMade = false;
            
            //if player 1 pressed the space
            if (player == 1 && !game.isThereAWinner())
            {
                //determine which space it was
                for (int j = 0; j < 9; ++j)
                {
                    if (buttonPressed.getActionCommand().equals(buttonList[j].getActionCommand()))
                    {
                        //attempt to make a move (if makeMove returns false, nothing happens later)
                        moveMade = game.makeMove(player, j);
                    }
                }
                //if the move was successful, change the icon, player, and status
                if (moveMade)
                {
                    Icon nole = new ImageIcon(getClass().getResource("nole100.gif"));
                    buttonPressed.setIcon(nole);
                    player = 2;
                    
                    status = "Player 2 (UF) turn.";
                    updateStatus();
                }
                //if this move is a winning move
                if (game.isThereAWinner())
                {
                    status = "Player 1 (FSU) wins! Click reset to play again.";
                    updateStatus();
                }
                //if this move results in a tie
                if (game.isTie())
                {
                    status = "Darn, a tie! Click reset to play again";
                    updateStatus();
                }
            }
            /*
             * if player 2 pressed the space (pretty much does the same thing as player 1,
             * other than text differences
             */
            else if (player == 2 && !game.isThereAWinner())
            {
                for (int j = 0; j < 9; ++j)
                {
                    if (buttonPressed.getActionCommand().equals(buttonList[j].getActionCommand()))
                    {
                        moveMade = game.makeMove(player, j);
                    }
                }
                if (moveMade)
                {
                    Icon gator = new ImageIcon(getClass().getResource("gator100.gif"));
                    buttonPressed.setIcon(gator);
                    player = 1;
                    
                    status = "Player 1 (FSU) turn.";
                    updateStatus();
                }
                if (game.isThereAWinner())
                {
                    status = "Player 2 (UF) wins. Noooo :(. Click reset to play again.";
                    updateStatus();
                }
                if (game.isTie())
                {
                    status = "Darn, a tie! Click reset to play again";
                    updateStatus();
                }
            }
        }
    }
    
    private void setPlayer(int newPlayer)
    {
        if (newPlayer == 1 || newPlayer == 2)
        {
            player = newPlayer;
        }
    }
}
