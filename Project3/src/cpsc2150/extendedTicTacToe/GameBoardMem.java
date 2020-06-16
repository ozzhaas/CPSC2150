package cpsc2150.extendedTicTacToe;

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
                for (Map.Entry <Character, List<BoardPosition>> m : ticTacMap.entrySet()) {
                    m.getValue().add(marker);
                }
            }
            count++;

        }


        /**
         * @param lastPos
         * @pre [Assumes that all positions are placed in a valid fashion]
         * @return (True [if the game is a tie] or False [if the game is not a tie])
         * @post [If true, there is a tie]
         */

        @Override
        public boolean checkForDraw(BoardPosition lastPos) {
            //this function will check to see if the game has resulted in a tie.
            //A game is tied if there are no free board positions remaining.
            //It will return true if the game is tied, and false otherwise.
            if (count == MAX_LEN) {
                return true;
            }
            else {
                return false;
            }
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
            for (Map.Entry <Character, List<BoardPosition>> m : ticTacMap.entrySet()) {
                if (((BoardPosition) m.getValue()).equals(pos)) {
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