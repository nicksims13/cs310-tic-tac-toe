package edu.jsu.mcis;

import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(width, this);
        
    }

    public String getMarkAsString(int row, int col) { 

        return (model.getMark(row, col).toString());       
    }
   
    public Component getView() { 

        return view;       
    }

    @Override

    public void actionPerformed(ActionEvent e) {

        String name = ((JButton) e.getSource()).getName();

        int row = Integer.parseInt(String.valueOf(name.charAt(6)));
        int col = Integer.parseInt(String.valueOf(name.charAt(7)));

        view.updateSquares();

        if (model.makeMark(row, col) == true){

            view.updateSquares();
        }

        for (int i = 0; i < view.board.length; i++){

            for (int j = 0; j < view.board.length; j++){

                if (model.isGameover() == true){
                    view.showResult(model.getResult().toString());
                    view.board[i][j].setEnabled(false);
                }
            }
        }
    }
}
