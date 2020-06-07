package cpsc2150.extendedTicTacToe;


import java.util.Objects;

public class GameBoardMem extends AbsGameBoard {
    private char[][] ticTacBoard;
    private static final int MAX_LEN = 8;
    private int count = 0;
    private int numToWin = 5;

        /**
         * @pre [the user wants to play Extended Tic Tac Toe]
         * @post [a game board is created and is empty and ready for the users to play]
         */
        public GameBoardMem() {
            //Create the game board//
            ticTacBoard = new char [MAX_LEN][MAX_LEN];

            //Initialize all positions on the board to blank space//
            for (int i = 0; i < MAX_LEN; i++) {
                for (int j = 0; j < MAX_LEN; j++) {
                    ticTacBoard[i][j] = ' ';
                }
            }
        }


        public boolean checkSpace(BoardPosition pos) {
            //returns true if the position specified in pos is available,
            //false otherwise. If a space is not in bounds, then it is not available
            System.out.println("Checking space " + pos.getRow() + ", " + pos.getColumn() + "; " + pos.getPlayer() + "\n");
            if ((pos.getRow() >= 0) && (pos.getRow() < MAX_LEN) && (pos.getColumn() >= 0) && (pos.getColumn() < MAX_LEN)) {
                if (ticTacBoard[pos.getRow()][pos.getColumn()] == ' ') {
                    System.out.println("Space is valid continuing...\n");
                    return true;
                } else {
                    System.out.println("Space " + pos.getRow() + ", " + pos.getColumn() + "; " + pos.getPlayer() + " is invalid exiting...\n");
                    return false;
                }
            }
            return false;
        }


        public void placeMarker(BoardPosition marker, char player) {
            //places the character in marker on the position specified by marker,
            //and should not be called if the space is not available.
            ticTacBoard[marker.getRow()][marker.getColumn()] = player;
            count++;

        }


        public boolean checkForWinner(BoardPosition lastPos) {
            //this function will check to see if the lastPos placed resulted in
            //a winner. If so it will return true, otherwise false.
            System.out.println("checkForWinner is being called...\n");
            if (((checkHorizontalWin(lastPos, lastPos.getPlayer())))
                    || (checkDiagonalWin(lastPos, lastPos.getPlayer()))
                    || (checkVerticalWin(lastPos, lastPos.getPlayer()))) {
                return true;
            }
            return false;
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
            if (count == 64) {
                return true;
            }
            else {
                return false;
            }
        }

        /**
         * @param lastPos = [last position placed on the board]
         * @param player
         * @pre [The last marker that was placed is valid and was passed properly to this function]
         * @return (True [if the move lastPos won the game horizontally]) or
         *         (False [if the move lastPos did not win the game horizontally])
         * @post [The specified Row of the board is checked for a win]
         */
        public boolean checkHorizontalWin(BoardPosition lastPos, char player) {
            //checks to see if the last marker placed resulted in 5 in a row horizontally
            //by checking if it matches the other 4 players in a sequence next to it
            //Returns true if it does, otherwise false
            int currentRow = lastPos.getRow();
            int numOfHSpots = 0;

            //Loop through all of the columns holding the row (in which the marker was
            //just placed) constant.
            int i = 0;
            while (i < MAX_LEN && numOfHSpots < numToWin) {
                if (Objects.equals(ticTacBoard[currentRow][i], player)) {
                    numOfHSpots++;
                }
                i++;
            }
            return numOfHSpots == 5;
        }


        /**
         * @param lastPos = [last position placed on the board]
         * @pre [The last marker that was placed is valid and was passed properly to this function]
         * @return (True [if the move lastPos won the game vertically]) or
         *         (False [if the move lastPos did not win the game vertically])
         * @post [The specified Column of the board is checked for a win]
         */
        public boolean checkVerticalWin(BoardPosition lastPos, char player) {
            //checks to see if the last marker placed resulted in 5 in a row vertically.
            //Returns true if it does, otherwise false
            int currentColumn = lastPos.getColumn();
            int numOfVSpots = 0;

            //Loop through all of the columns holding the row (in which the marker was
            //just placed) constant.
            int i = 0;
            while (i < MAX_LEN && numOfVSpots < 6) {
                if (Objects.equals(ticTacBoard[i][currentColumn], player)) {
                    numOfVSpots++;
                }
                i++;
            }

            i = 0;
            while (i >= 0 && i < lastPos.getRow()) {
                if (Objects.equals(ticTacBoard[i][currentColumn], player)) {
                    numOfVSpots++;
                }
                i--;
            }
            if (numOfVSpots == 5) {
                System.out.println("Winner!\n");
            }
            return numOfVSpots == 5;
        }


        /**
         * @param lastPos = [last position placed on the board]
         * @pre [The last marker that was placed is valid and was passed properly to this function]
         * @return (True [if the move lastPos won the game diagonally]) or
         *         (False [if the move lastPos did not win the game diagonally])
         * @post [The specified diagonal of the board is checked for a win]
         */
        public boolean checkDiagonalWin(BoardPosition lastPos, char player) {
            //checks to see if the last marker placed resulted in 5 in a row diagonally.
            // Returns true if it does, otherwise false
            int countInARow = 0;
            int secondCountInARow = 0;
            int row = lastPos.getRow();
            int col = lastPos.getColumn();

            //First scan from top left to bottom right
            while (countInARow < 5 && row >= 0 && col >= 0) {
                if (ticTacBoard[lastPos.getRow()][lastPos.getColumn()] == player) {
                    countInARow++;
                }
                else {
                    break;
                }
                //Decrement to go diagonally down to bottom right
                row--;
                col--;
            }

            //Next scan from top right to bottom left
            while (secondCountInARow < 5 && row >= 0 && col < MAX_LEN) {
                if (countInARow >= 5) {
                    break;
                }
                if (ticTacBoard[lastPos.getRow()][lastPos.getColumn()] == player) {
                    secondCountInARow++;
                }
                else {
                    break;
                }
                //Increment the column and decrement the row to go diagonally down from
                //the top right to the bottom left
                row--;
                col++;
            }

            //Next scan from the bottom right to the top left
            while (row < MAX_LEN && col < MAX_LEN && countInARow < 5) {
                if (ticTacBoard[lastPos.getRow()][lastPos.getColumn()] == player) {
                    countInARow++;
                }
                else {
                    break;
                }
                //Increment the column and the rows to go diagonally up from the bottom
                //right to the top left
                row++;
                col++;
            }


            //Next scan from the bottom left to the top right
            while (row < MAX_LEN && col >= 0 && countInARow < 5) {
                if (secondCountInARow >= 5) {
                    break;
                }
                if (ticTacBoard[lastPos.getRow()][lastPos.getColumn()] == player) {
                    secondCountInARow++;
                }
                else {
                    break;
                }
                //Increment the row and decrement the columns to go diagonally
                //up from the bottom left to the top right
                row++;
                col--;
            }
            return (countInARow == 5 || secondCountInARow == 5);
        }

        public char whatsAtPos(BoardPosition pos) {
            return ticTacBoard[pos.getRow()][pos.getColumn()];
        }

        public boolean isPlayerAtPos(BoardPosition pos, char player) {
            if (ticTacBoard[pos.getRow()][pos.getColumn()] == player) {
                return true;
            }
            else {
                return false;
            }
        }

}

