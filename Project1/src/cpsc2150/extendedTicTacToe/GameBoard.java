package cpsc2150.extendedTicTacToe;

public class GameBoard {
    public boolean checkSpace(BoardPosition pos) {
        //returns true if the position specified in pos is available,
        //false otherwise. If a space is not in bounds, then it is not available

        return false;
    }
    public void placeMarker(BoardPosition marker, char player)
    {
//places the character in marker on the position specified by marker, and should not be called if the space is not available.
    }
    public boolean checkForWinner(BoardPosition lastPos) {
        //this function will check to see if the lastPos placed resulted in
        //a winner. It so it will return true, otherwise false.
        //Passing in the last position will help limit the possible places
        //to check for a win condition, since you can assume that any win
        //condition that did not include the most recent play made would have
        //been caught earlier.
        //You may call other methods to complete this method
        return false;
    }

    public boolean checkForDraw()
    {
        //this function will check to see if the game has resulted in a tie. A game is tied if there are no free board positions remaining. You do not need to check for any potential wins, because we can assume that the players were checking for win conditions as they played the game.
        //It will return true if the game is tied, and false otherwise.
        return false;
    }

    public boolean checkHorizontalWin(BoardPosition lastPos, char player) {
        //checks to see if the last marker placed resulted in 5 in a row horizontally.
        //Returns true if it does, otherwise false
        return false;
    }


    public boolean checkVerticalWin(BoardPosition lastPos, char player)
    {
        //checks to see if the last marker placed resulted in 5 in a row vertically.
        //Returns true if it does, otherwise false
        return false;
    }

    public boolean checkDiagonalWin(BoardPosition lastPos, char player) {
        //checks to see if the last marker placed resulted in 5 in a row diagonally.
        // Returns true if it does, otherwise false
        return false;
    }






}