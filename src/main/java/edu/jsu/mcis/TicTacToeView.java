package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        if (isXTurn){

            System.out.println("Player 1 (X) Move: ");
        }

        else{

            System.out.println("Player 2 (O) Move: ");
        }

        System.out.print("Enter the row and column numbers, separated by a space: ");
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = scanner.nextLine().split(" ");
        int row = Integer.parseInt(coordinates[0]);
        int col = Integer.parseInt(coordinates[1]);
        TicTacToeMove move = new TicTacToeMove(row, col);

        return move;

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
