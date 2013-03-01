/*
 * TicTacToeTester.java
 * Hague, Brian
 * COP 3252
 * Project 1
 * 02/28/13
 */

import java.util.Scanner;

/*
 * Note that this is a very crude driver for TicTacToe. This is only
 * for testing basic functionality.
 */

public class TicTacToeTester
{
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        
        System.out.println(game);
        
        while (!game.isThereAWinner())
        {
            System.out.print("Player 1, enter the space you want to move: ");
            int move1 = input.nextInt();
            game.makeMove(1, move1);
            
            System.out.println(game);
            
            if (game.isThereAWinner())
            {
                if (game.getWinner() == 1)
                {
                    System.out.println("Player 1 wins!");
                }
                else
                {
                    System.out.println("Player 2 wins!");
                }
            }
            
            if (!game.isThereAWinner())
            {
                System.out.print("Player 2, enter the space you want to move: ");
                int move2 = input.nextInt();
                game.makeMove(2, move2);

                System.out.println(game);
            }
            
            if (game.isThereAWinner())
            {
                if (game.getWinner() == 1)
                {
                    System.out.println("Player 1 wins!");
                }
                else
                {
                    System.out.println("Player 2 wins!");
                }
            }
        }
    }
}