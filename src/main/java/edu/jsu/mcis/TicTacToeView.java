package edu.jsu.mcis;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class TicTacToeView extends JPanel {

    private final TicTacToeController controller;

    public final JButton[][] board;
    private final JPanel squaresPanel;
    private final JLabel resultLabel;

    public TicTacToeView (int width, TicTacToeController controller){

        this.controller = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        board = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();

        resultLabel.setName("ResultLabel");

        for (int row = 0; row < width; row++){

            for (int col = 0; col < width; col++){

                board [row][col] = new JButton();
                board [row][col].addActionListener(controller);
                board [row][col].setName("Square" + row + col);
                board [row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(board [row][col]);
            }
        }

        this.add(squaresPanel);
        this.add(resultLabel);

        resultLabel.setText("Welcome to Tic-Tac-Toe!");
    }

    public void updateSquares(){

        for (int i = 0; i < board.length; i++ ){

            for (int j = 0; j < board[i].length; j++){

                String k = controller.getMarkAsString(i, j);
                
                if (k.equals("X") || k.equals("O")){

                    board [i][j].setText(k);
                    board [i][j].setEnabled(false);
                }
            }
        }
    }

    public void disableSquares(){

        for (JButton[] i : board){

            for (JButton j : i){

                j.setEnabled(false);
            }
        }
    }

    public void showResult(String message){
        
        resultLabel.setText(message);
    }

    public void clearResult(){

        resultLabel.setText(" ");
    }
    
    

    
}
