package cpsc2150.extendedTicTacToe;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;

import java.util.Objects;

public class GameBoard extends AbsGameBoard implements IGameBoard {
	private char[][] ticTacBoard;
	private static final int MAX_LEN = 8;
	private int count = 0;


	/**
	 * @pre [the user wants to play Extended Tic Tac Toe]
	 * @post [a game board is created and is empty and ready for the users to play]
	 */
	public GameBoard() {
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
		if ((pos.getRow() >= 0) && (pos.getRow() < MAX_LEN) && (pos.getColumn() >= 0) && (pos.getColumn() < MAX_LEN)) {
			return true;
		}
		else {
			return false;
		}
	}


	public void placeMarker(BoardPosition marker, char player) {
		//places the character in marker on the position specified by marker,
		//and should not be called if the space is not available.
		ticTacBoard[marker.getRow()][marker.getColumn()] = marker.getPlayer();
		count++;

	}


	public boolean checkForWinner(BoardPosition lastPos) {
		//this function will check to see if the lastPos placed resulted in
		//a winner. If so it will return true, otherwise false.
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