package cpsc2150.extendedTicTacToe;

import java.sql.SQLType;
import java.util.*;
import java.util.Map;
import java.util.HashMap;

public class GameBoardMem extends AbsGameBoard implements IGameBoard {
    private int MAX_ROWS;
    private int MAX_COLS;
    private int MAX_LEN;
    private int count;
    private int numToWin;
    private Map<Character, List<BoardPosition>> ticTacMap = new HashMap<>();


    /**
     * @pre [the user wants to play Extended Tic Tac Toe]
     * @post [a game board is created and is empty and ready for the users to play]
     */
    public GameBoardMem(int numRows, int numCols, int win) {
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
    }

    public void placeMarker(BoardPosition marker, char player) {
        //places the character in marker on the position specified by marker,
        //and should not be called if the space is not available.
        if (ticTacMap.containsKey(player)) {
            ticTacMap.get(player).add(marker);
        }
        else {
            List<BoardPosition> tempList = new ArrayList<>();
            tempList.add(marker);
            ticTacMap.put(player, tempList);
        }
        count++;

    }



    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        return pos.getPlayer() == player;
    }


    public char whatsAtPos(BoardPosition pos) {
        for (Map.Entry <Character, List<BoardPosition>> m : ticTacMap.entrySet()) {
                if (m.getValue().contains(pos)) {
                    return m.getKey();
                }
        }
        return ' ';
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