package cpsc2150.extendedTicTacToe;

import java.util.Objects;

public interface IGameBoard {

        public static final int MAX_LEN = 90;
        public char[][] ticTacBoard = new char[MAX_LEN][MAX_LEN];


        /**
         * @param pos [the position the user chose] and [must have both a Row and a Column value]
         * @pre [The user chose a position that is an integer between 0 and 7]
         * @return (True [if pos is empty and in the bounds of the board]) and
         *         (False [if pos is out of bounds or already taken])
         * @post [The position pos is a valid choice]
         */
        public default boolean checkSpace(BoardPosition pos) {
            //returns true if the position specified in pos is available,
            //false otherwise. If a space is not in bounds, then it is not available
            if ((pos.getRow() >= 0) && (pos.getRow() < MAX_LEN) && (pos.getColumn() >= 0) && (pos.getColumn() < MAX_LEN)) {
                return true;
            }
            else {
                return false;
            }
        }

        /**
         * @param marker = [position to place the character player on the game board]
         * @pre [The position passed in as marker must be valid and if it is not, then this
         *      function shouldn't be called]
         * @return void
         * @post [Makes sure to place a marker in a position that is not already taken or is invalid]
         */
        public default void placeMarker(BoardPosition marker, char player) {
            //places the character in marker on the position specified by marker,
            //and should not be called if the space is not available.
            ticTacBoard[marker.getRow()][marker.getColumn()] = marker.getPlayer();

        }

        /**
         * @param lastPos = [the last position placed on the game board]
         * @pre [The position passed in must be valid and in bounds before it can
         *      be checked for a potential winner]
         * @return (True [if lastPos won the game]) or (False [if lastPos didn't win the game])
         * @post [Will determine if there is a winner from only the specific position. Since
         *       it will be called every time a game piece is placed, you can assume it would've
         *       caught a previous win if there was one.]
         */
        public default boolean checkForWinner(BoardPosition lastPos) {
            //this function will check to see if the lastPos placed resulted in
            //a winner. If so it will return true, otherwise false.
            if (((checkHorizontalWin(lastPos, lastPos.getPlayer()))) ||
                    (checkDiagonalWin(lastPos, lastPos.getPlayer())) ||
                    (checkVerticalWin(lastPos, lastPos.getPlayer()))) {
                return true;
            }
            return false;
        }


        /**
         * @param lastPos
         * @pre [Assumes that all positions are placed in a valid fashion]
         * @return (True [if the game is a tie]) or (False [if the game is not a tie]
         * @post [If true, there is a tie]
         */
        public default boolean checkForDraw(BoardPosition lastPos) {
            //this function will check to see if the game has resulted in a tie.
            //A game is tied if there are no free board positions remaining.
            //It will return true if the game is tied, and false otherwise.
            if (!checkForWinner(lastPos)) {
                for (int i = 0; i < lastPos.getRow(); i++) {
                    for (int j = 0; j < lastPos.getColumn(); j++) {
                        if (!Objects.equals(ticTacBoard[lastPos.getRow()][lastPos.getColumn()], " ")) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        /**
         * @param lastPos = [last position placed on the board]
         * @param player
         * @pre [The last marker that was placed is valid and was passed properly to this function]
         * @return (True [if the move lastPos won the game horizontally]) or
         *         (False [if the move lastPos did not win the game horizontally])
         * @post [The specified Row of the board is checked for a win]
         */
        public default boolean checkHorizontalWin(BoardPosition lastPos, char player) {
            //checks to see if the last marker placed resulted in 5 in a row horizontally
            //by checking if it matches the other 4 players in a sequence next to it
            //Returns true if it does, otherwise false
            int currentRow = lastPos.getRow();
            int numOfHSpots = 0;

            //Loop through all of the columns holding the row (in which the marker was
            //just placed) constant.
            int i = 0;
            while (i < MAX_LEN && numOfHSpots < 6) {
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
        public default boolean checkVerticalWin(BoardPosition lastPos, char player) {
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

            return numOfVSpots == 5;
        }


        /**
         * @param lastPos = [last position placed on the board]
         * @pre [The last marker that was placed is valid and was passed properly to this function]
         * @return (True [if the move lastPos won the game diagonally]) or
         *         (False [if the move lastPos did not win the game diagonally])
         * @post [The specified diagonal of the board is checked for a win]
         */
        public default boolean checkDiagonalWin(BoardPosition lastPos, char player) {
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


    public default char whatsAtPos(BoardPosition pos) {
        return ticTacBoard[pos.getRow()][pos.getColumn()];
    }

    public default boolean isPlayerAtPos(BoardPosition pos, char player) {
        if (ticTacBoard[pos.getRow()][pos.getColumn()] == player) {
            return true;
        }
        else {
            return false;
        }
    }

    }

