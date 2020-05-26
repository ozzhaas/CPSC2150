package cpsc2150.extendedTicTacToe;

public class BoardPosition {
    private int Row;
    private int Column;

    /**
     * @pre
     * @param
     * @param
     * @return
     * @post
     */
    public int getRow() {return Row;}


    /**
     * @pre
     * @param
     * @param
     * @return Column value
     * @post
     */    public int getColumn() {return Column;}

    /**
     * @pre
     * @param
     * @param
     * @return
     * @post
     */
    @Override
    public boolean equals(Object pos) {return true;}

    /**
     * @pre
     * @param r
     * @param c
     * @return String newString (r, c)
     * @post
     */
    @Override
    public String toString(int r, int c) {
        String newString = Row.toString() + ", ";
        newString += Column;
        return newString;
    }

}

