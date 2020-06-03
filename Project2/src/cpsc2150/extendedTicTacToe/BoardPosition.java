package cpsc2150.extendedTicTacToe;
import java.lang.*;


public class BoardPosition {
    private int Row;
    private int Column;
    private char Player;

    /**
     * BoardPosition Constructor
     * @param r = the row of the position on the game board
     * @param c = the column of the position on the game board
     * @param playerLetter = the character for each player [i.e. X or O]
     * @return [returns a BoardPosition Object]
     * @pre (0 <= r <= 7) and (0 <= c <= 7)
     * @pre (playerLetter == 'X') or (playerLetter == 'O')
     * @post The GameBoard was successfully created and
     *       then used BoardPosition as a parameter for its methods
     *       to mark the various valid positions on the board.
     */
    public BoardPosition(int r, int c, char playerLetter) {
        Row = r;
        Column = c;
        Player = playerLetter;
    }

    /**
     * @return returns the Row position
     */
    public int getRow() {return Row;}


    /**
     * @return returns the Column position
     */
    public int getColumn() {return Column;}

    /**
     * @return the player's associated character
     */
    public char getPlayer() {return Player;}


    /**
     * @pre
     * @param
     * @param
     * @return
     * @post
     */

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BoardPosition) {
            BoardPosition b = (BoardPosition) obj;
            return this.getPlayer()==(b.getPlayer()) && this.getRow() == b.getRow() && this.getColumn() == b.getColumn();
        } else {
            return false;
        }
    }
}

