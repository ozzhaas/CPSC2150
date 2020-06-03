package cpsc2150.extendedTicTacToe;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;

import java.util.Objects;

public class GameBoard implements IGameBoard{
	private String[][] ticTacBoard;
	private static final int MAX_LEN = 8;
	private int count = 0;


	/**
	 * @pre [the user wants to play Extended Tic Tac Toe]
	 * @post [a game board is created and is empty and ready for the users to play]
	 */
	public GameBoard() {
		//Create the game board//
		ticTacBoard = new String [MAX_LEN][MAX_LEN];

		//Initialize all positions on the board to blank space//
		for (int i = 0; i < MAX_LEN; i++) {
			for (int j = 0; j < MAX_LEN; j++) {
				ticTacBoard[i][j] = " ";
			}
		}
	}

	/**
	 * @param pos [the position the user chose] and [must have both a Row and a Column value]
	 * @pre [The user chose a position that is an integer between 0 and 7]
	 * @return (True [if pos is empty and in the bounds of the board]) and
	 *         (False [if pos is out of bounds or already taken])
	 * @post [The position pos is a valid choice]
	 */
	public boolean checkSpace(BoardPosition pos) {
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
	public void placeMarker(BoardPosition marker, String player) {
		//places the character in marker on the position specified by marker,
		//and should not be called if the space is not available.
		ticTacBoard[marker.getRow()][marker.getColumn()] = marker.getPlayer();
		count++;

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
	public boolean checkForWinner(BoardPosition lastPos) {
		//this function will check to see if the lastPos placed resulted in
		//a winner. If so it will return true, otherwise false.
		if (((checkHorizontalWin(lastPos, lastPos.getPlayer()))) || (checkDiagonalWin(lastPos, lastPos.getPlayer())) || (checkVerticalWin(lastPos, lastPos.getPlayer()))) {
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
	public boolean checkForDraw(BoardPosition lastPos) {
		//this function will check to see if the game has resulted in a tie.
		//A game is tied if there are no free board positions remaining.
		//It will return true if the game is tied, and false otherwise.
		if (!checkForWinner(lastPos)) {
			for (int i = 0; i < lastPos.getRow(); i++) {
				for (int j = 0; j < lastPos.getColumn(); j++) {
					if (!ticTacBoard[lastPos.getRow()][lastPos.getColumn()].equals(" ")) {
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
	public boolean checkHorizontalWin(BoardPosition lastPos, String player) {
		//checks to see if the last marker placed resulted in 5 in a row horizontally
		//by checking if it matches the other 4 players in a sequence next to it
		//Returns true if it does, otherwise false
		int currentRow = lastPos.getRow();
		int numOfHSpots = 0;

		//Loop through all of the columns holding the row (in which the marker was
		//just placed) constant.
		int i = 0;
		while (i < MAX_LEN && numOfHSpots < 6) {
			if (ticTacBoard[currentRow][i].equals(player)) {
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
	public boolean checkVerticalWin(BoardPosition lastPos, String player) {
		//checks to see if the last marker placed resulted in 5 in a row vertically.
		//Returns true if it does, otherwise false
		int currentColumn = lastPos.getColumn();
		int numOfVSpots = 0;

		//Loop through all of the columns holding the row (in which the marker was
		//just placed) constant.
		int i = 0;
		while (i < MAX_LEN && numOfVSpots < 6) {
			if (ticTacBoard[i][currentColumn].equals(player)) {
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
	public boolean checkDiagonalWin(BoardPosition lastPos, String player) {
		//checks to see if the last marker placed resulted in 5 in a row diagonally.
		// Returns true if it does, otherwise false



		return false;
	}

}