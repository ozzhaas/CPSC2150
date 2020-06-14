package cpsc2150.extendedTicTacToe;

import java.lang.instrument.ClassDefinition;
import java.util.Scanner;

public class GameScreen {

    /**
     * @param args
     * @return integer value of 0
     * @pre [Bounds checking for the users input to
     * make sure it is a valid position on the board]
     * @pre Input: 1st get Row then Col [0,0 is the top left
     * corner]
     * @pre Only enter integers between 0 and 7 are valid
     * @post [Checks if either player has one or if not,
     * it checks if all of the positions are taken. If they
     * are all taken, it prints draw. Else, prints the current
     * game board and prompts next player for their turn]
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Extended Tic Tac Toe!\n");
        Scanner scan = new Scanner(System.in);
        char[] playerArray = new char[10];
        boolean playAgain = true;





/***********************************************************************************
 * Loop through the first game as long as playAgain is true
 ************************************************************************************/
        //Loop for if checkSpace is true and the space is valid
        while (playAgain) {

/***********************************************************************************
 * Create the BoardPosition object and initialize it with a row and column of one
 ***********************************************************************************/
            BoardPosition mainPos;


            System.out.println("How many players?\n");
            String numP = scan.nextLine();
            int numOfPlayers = Integer.parseInt(numP);
            while (numOfPlayers > 10 || numOfPlayers < 2) {
                System.out.println("Must be between 2 and 10 players. Try again.\n");
                System.out.println("How many players?\n");
                numP = scan.nextLine();
                numOfPlayers = Integer.parseInt(numP);
            }

            for (int p = 1; p <= numOfPlayers; p++) {
                System.out.println("Enter the character to represent player " + p + "\n");
                String playersChar = scan.nextLine();
                while (playerArray[p - 1] == playersChar.charAt(0)){
                    System.out.println(playersChar + " is already taken by another player. Choose a different character.\n");
                    System.out.println("Enter the character to represent player " + p + "\n");
                    playersChar = scan.nextLine();
                }
                playerArray[p - 1] = playersChar.charAt(0);
            }


            System.out.println("How many rows in your game board?\n");
            String rowsString = scan.nextLine();
            int rows = Integer.parseInt(rowsString);
            while (rows < 3 || rows > 100) {
                System.out.println("Rows must be between 3 and 100. Try again.\n");
                System.out.println("How many rows in your game board?\n");
                rowsString = scan.nextLine();
                rows = Integer.parseInt(rowsString);
            }

            System.out.println("How many columns in your game board?\n");
            String columnsString = scan.nextLine();
            int columns = Integer.parseInt(columnsString);
            while (columns < 3 || columns > 100) {
                System.out.println("Columns must be between 3 and 100. Try again.\n");
                System.out.println("How many columns in your game board?\n");
                columnsString = scan.nextLine();
                columns = Integer.parseInt(columnsString);
            }

            System.out.println("How many characters in a row to win the game?\n");
            String winNumString = scan.nextLine();
            int winNum = Integer.parseInt(winNumString);
            while (winNum >= rows) {
                System.out.println("The number in a row to win must be less than the number of rows or columns.\n");
                System.out.println("How many characters in a row to win the game?\n");
                winNumString = scan.nextLine();
                winNum = Integer.parseInt(winNumString);
            }

            System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?\n");
            String gameType = scan.nextLine();
            while (gameType.charAt(0) != 'F' || gameType.charAt(0) != 'f' || gameType.charAt(0) != 'M' || gameType.charAt(0) != 'm') {
                System.out.println("Please enter F or f for Fast Game, or M or m for Memory Efficient Game.\n");
                gameType = scan.nextLine();
            }

            GameBoard mainBoard = new GameBoard(rows, columns, winNum);

            ///////////////////////////////
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.println(mainBoard);
                System.out.println("\nPlayer " + playerArray[i] + ", please enter your ROW:");
                String mainRow = scan.nextLine();
                System.out.println("\nPlayer " + playerArray[i] + ", please enter your COLUMN:");
                String mainColumn = scan.nextLine();
                mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                        Integer.parseInt(String.valueOf(mainColumn)));
                //Check the position
                mainPos = move(scan, mainPos, playerArray[i], mainBoard);
                mainBoard.placeMarker(mainPos, playerArray[i]);

                if (mainBoard.checkForWinner(mainPos)) {
                    System.out.println("Congratulations Player " + playerArray[i] + "! You won!\n");

                    //Ask if the user wants to play again
                    System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                    String in = scan.nextLine();
                    if (in.equals("N") || in.equals("n")) {
                        playAgain = false;
                    }
                    else if (in.equals("y") || in.equals("Y")) {
                        playAgain = true;
                        mainBoard = new GameBoard();
                        System.out.println(mainBoard);
                        System.out.println("\nPlayer " + playerArray[i] + ", please enter your ROW:");
                        mainRow = scan.nextLine();
                        System.out.println("\nPlayer " + playerArray[i] + ", please enter your COLUMN:");
                        mainColumn = scan.nextLine();
                        mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                Integer.parseInt(String.valueOf(mainColumn)));
                        mainPos = move(scan, mainPos, playerArray[i], mainBoard);
                        mainBoard.placeMarker(mainPos, playerArray[i]);
                    }
                    else {
                        System.out.println("That is not a valid choice please try again (Y or y for Yes, or N or n for no)\n");
                        System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                        in = scan.nextLine();
                    }
                }
            }
//
//            //Player O's first turn
//            System.out.println(mainBoard);
//            System.out.println("\nPlayer " + p2 + ", please enter your ROW:");
//            mainRow = scan.nextLine();
//            System.out.println("\nPlayer " + p2 + ", Please enter your COLUMN:");
//            mainColumn = scan.nextLine();
//            pos2 = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
//                    Integer.parseInt(String.valueOf(mainColumn)));
//            pos2 = move(scan, pos2, p2, mainBoard);
//            mainBoard.placeMarker(pos2, p2);
//            if (mainBoard.checkForWinner(pos2)) {
//                System.out.println("Checking for Winner in main...\n");
//                System.out.println("Congratulations Player " + p2 + "! You won!\n");
//
//                //Ask if the user wants to play again
//                System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
//                String in = scan.nextLine();
//                if (in.equals("N") || in.equals("n")) {
//                    playAgain = false;
//                }
//                else if (in.equals("y") || in.equals("Y")) {
//                    playAgain = true;
//                    mainBoard = new GameBoard();
//                }
//                else {
//                    System.out.println("That is not a valid choice please try again (Y or y for Yes, or N or n for no)\n");
//                    System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
//                    in = scan.nextLine();
//                }
//            }
        }
    }


        public static BoardPosition move (Scanner scan, BoardPosition playersMove,char player, GameBoard moveBoard){
            while (!moveBoard.checkSpace(playersMove)) {
                System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                String row = scan.nextLine();
                System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                String column = scan.nextLine();
                BoardPosition pos = new BoardPosition(Integer.parseInt(String.valueOf(row)),
                        Integer.parseInt(String.valueOf(column)));
                if (!moveBoard.checkSpace(pos)) {
                    System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                    System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                    row = scan.nextLine();
                    System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                    column = scan.nextLine();
                    pos = new BoardPosition(Integer.parseInt(String.valueOf(row)),
                            Integer.parseInt(String.valueOf(column)));
                } else {
                    return pos;
                }
            }
            return playersMove;
        }
    }



