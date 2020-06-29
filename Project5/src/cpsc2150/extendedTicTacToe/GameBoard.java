package cpsc2150.extendedTicTacToe;

import java.util.Objects;

public class GameBoard extends AbsGameBoard implements IGameBoard {
    private char[][] ticTacBoard;
    private int MAX_ROWS;
    private int MAX_COLS;
    private int MAX_LEN;
    private int count;
    private int numToWin;


    /**
     * @pre [the user wants to play Extended Tic Tac Toe]
     * @post [a game board is created and is empty and ready for the users to play]
     */

    public GameBoard(int numRows, int numCols, int win) {
        //Create the game board//
        this.count = 0;
        this.MAX_ROWS = numRows;
        this.MAX_COLS = numCols;
        this.numToWin = win;
        if (numCols > numRows) {
            this.MAX_LEN = numCols;
        }
        else {
            this.MAX_LEN = numRows;
        }
        ticTacBoard = new char [numRows][numCols];
        //Initialize all positions on the board to blank space//
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                ticTacBoard[i][j] = ' ';
            }
        }
    }



    public void placeMarker(BoardPosition marker, char player) {
        //places the character in marker on the position specified by marker,
        //and should not be called if the space is not available.
        ticTacBoard[marker.getRow()][marker.getColumn()] = player;
        count++;

    }




    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        if (whatsAtPos(pos) == player) {
            return true;
        }
        else {
            return false;
        }
    }

    public char whatsAtPos(BoardPosition pos) {
        return ticTacBoard[pos.getRow()][pos.getColumn()];
    }


    public int getNumRows() {
        return MAX_ROWS;
    }

    public int getNumColumns() {
        return MAX_COLS;
    }

    public int getNumToWin() {
        return numToWin;
    }

}