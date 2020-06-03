package cpsc2150.extendedTicTacToe;

public abstract class AbsGameBoard implements IGameBoard {

    /**
     * @pre [The game board is empty at the start of the game] and [The game board has
     *      valid positions on it if the game has started or finished]
     * @return [The String array of the Row and Column positions making the game board]
     *         [printed during the game]
     * @post [The string is formatted to return to GameScreen and print to the terminal]
     */
    @Override
    public String toString() {
        String temp = "";
        temp = "\t    0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n"
                +  "\t0 |   |   |   |   |   |   |   |   |\n"
                +  "\t1 |   |   |   |   |   |   |   |   |\n"
                +  "\t2 |   |   |   |   |   |   |   |   |\n"
                +  "\t3 |   |   |   |   |   |   |   |   |\n"
                +  "\t4 |   |   |   |   |   |   |   |   |\n"
                +  "\t5 |   |   |   |   |   |   |   |   |\n"
                +  "\t6 |   |   |   |   |   |   |   |   |\n"
                +  "\t7 |   |   |   |   |   |   |   |   |\n";

        return temp;
    }

}
