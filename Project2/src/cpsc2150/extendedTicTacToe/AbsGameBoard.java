package cpsc2150.extendedTicTacToe;

public abstract class AbsGameBoard implements IGameBoard {

    /**
     * @pre [The game board is empty at the start of the game] and [The game board has
     *      valid positions on it if the game has started or finished]
     *      [Implementer must be sure to set the size of the rows in this function prior
     *      to calling it]
     * @return [The String array of the Row and Column positions making the game board]
     *         [printed during the game]
     * @post [The string is formatted to return to GameScreen and print to the terminal]
     */
    @Override
    public String toString() {
        String gameBoardStr = " ";
        int strRow = 7;
        int strCol = 7;

        //Label the column indexes
        for (int i = 0; i <= strCol; i++) {
            if (i == 0) {
                gameBoardStr = gameBoardStr + "\t    " + i + " " + '|';
            } else {
                gameBoardStr = gameBoardStr + " " + i + " " + '|';
            }
        }

        gameBoardStr = gameBoardStr + "\n";

        //Create the rows
        for (int i = 0; i <= strRow; i++) {
            //Label the row indexes
            gameBoardStr = gameBoardStr + "\t" + i + " " + '|' + " ";
            for (int c = 0; c <= strCol; c++) {
                BoardPosition stringPos = new BoardPosition(i, c);
                gameBoardStr = gameBoardStr + whatsAtPos(stringPos) + " " + '|' + " ";
            }
            gameBoardStr = gameBoardStr + "\n";
        }

        return gameBoardStr;
    }

}
