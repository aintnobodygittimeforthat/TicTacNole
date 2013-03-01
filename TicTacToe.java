/*
 * TicTacToe.java
 * Hague, Brian
 * COP 3252
 * Project 1
 * 02/24/13
 * 
 * TicTacToe represents the underlying representation of a Tic-Tac-Toe
 * game. A board can be created and cleared. Moves are made by entering
 * the player number (either 1 or 2) and the space number 0-8. Space
 * numbers are stored in an array and can hold a SpaceStatus (either EMPTY,
 * PLAYER1, or PLAYER2). Space guide:
 *  _ _ _
 * |0|1|2|
 *  - - -
 * |3|4|5|
 *  - - -
 * |6|7|8|
 *  - - -
 * 
 * Winner is found via the getWinner() method.
 * If there is a winner, isThereAWinner() returns true; false otherwise
 * If there is a tie, isTie() returns true; false otherwise
 */

public class TicTacToe
{
    private SpaceStatus[] gameBoard;
    private enum SpaceStatus {EMPTY, PLAYER1, PLAYER2};
    
    public TicTacToe()
    {
        SpaceStatus[] theGameBoard = new SpaceStatus[9];
        for (int i = 0; i < 9; ++i)
        {
            theGameBoard[i] = SpaceStatus.EMPTY;
        }
        
        gameBoard = theGameBoard;
    }
    
    public void clearBoard()
    {
        for (int i = 0; i < 9; ++i)
        {
            gameBoard[i] = SpaceStatus.EMPTY;
        }
    }
    
    /*
     * adds a move to the gameBoard
     * Assumptions: player is either 1 or 2; 0 <= space < 9
     */
    public boolean makeMove(int player, int space)
    {
        //double-checks assumptions
        if (space >= 9 || space < 0 || player < 1 || player > 2) 
        {
            return false;
        }
        
        if (gameBoard[space] == SpaceStatus.EMPTY)
        {
            if (player == 1)
            {
                gameBoard[space] = SpaceStatus.PLAYER1;
            }
            else
            {
                gameBoard[space] = SpaceStatus.PLAYER2;
            }
            
            return true;
        }
        
        return false;
    }
    
    //returns 1 if Player 1 has won, 2 if Player 2 has won, or 0 if there is no winner
    public int getWinner()
    {
        for (int i = 1; i < 3; ++i)
        {
            //assigns SpaceStatus variable to compare against
            SpaceStatus player;
            if (i == 1)
            {
                player = SpaceStatus.PLAYER1;
            }
            else
            {
                player = SpaceStatus.PLAYER2;
            }
            
            //checks rows for winners
            for (int j = 0; j < 7; j += 3)
            {
                if (gameBoard[j] == player)
                {
                    if (gameBoard[j + 1] == player)
                    {
                        if (gameBoard[j + 2] == player)
                        {
                            return i;
                        }
                    }
                }
            }
            
            //checks cols for winners
            for (int k = 0; k < 3; ++k)
            {
                if (gameBoard[k] == player)
                {
                    if (gameBoard[k + 3] == player)
                    {
                        if (gameBoard[k + 6] == player)
                        {
                            return i;
                        }
                    }
                }
            }
            
            //checks diagonals for winners
            if (gameBoard[0] == player)
            {
                if (gameBoard[4] == player)
                {
                    if (gameBoard[8] == player)
                    {
                        return i;
                    }
                }
            }
            if (gameBoard[2] == player)
            {
                if (gameBoard[4] == player)
                {
                    if (gameBoard[6] == player)
                    {
                        return i;
                    }
                }
            }
        }
        
        return 0;
    }
    
    //returns if there has been a winner
    public boolean isThereAWinner()
    {
        if (getWinner() == 0) 
        {
            return false;
        }
        return true;
    }
    
    //returns if there has been a tie (all spaces filled and no winner)
    public boolean isTie()
    {
        if (isThereAWinner())
        {
            return false;
        }
        
        boolean tie = true;
        for (int i = 0; i < gameBoard.length; ++i)
        {
            if (gameBoard[i] == SpaceStatus.EMPTY)
            {
                tie = false;
            }
        }
        
        return tie;
    }
    
    /*
     * outputs the board in a very simple form with Xs and Ox 
     * Used primarily for debugging
     */
    @Override
    public String toString()
    {
        String ticTacToeBoard = "";
        
        for (int i = 0; i < gameBoard.length; ++i)
        {
            if (gameBoard[i] == SpaceStatus.PLAYER1)
            {
                ticTacToeBoard += "X" + " ";
            }
            else if (gameBoard[i] == SpaceStatus.PLAYER2)
            {
                ticTacToeBoard += "O" + " ";
            }
            else
            {
                ticTacToeBoard += "_" + " ";
            }
            
            if (i % 3 == 2)
            {
                ticTacToeBoard += "\n";
            }
        }
        
        return ticTacToeBoard;
    }
}
