package cpsc2150.extendedTicTacToe;

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

        GameBoard mainBoard = new GameBoard();

/***********************************************************************************
 * Create the BoardPosition object and initialize it with a row and column of one
 ***********************************************************************************/
        BoardPosition mainPos = new BoardPosition(1, 1);

        boolean playAgain = true;

/***********************************************************************************
 * Loop through the first game as long as playAgain is true
 ************************************************************************************/
        //Loop for if checkSpace is true and the space is valid
        while (playAgain) {
            System.out.println(mainBoard);
            System.out.println("\nPlayer X, Please enter your ROW:");
            String mainRow = scan.nextLine();
            System.out.println("\nPlayer X, Please enter your COLUMN:");
            String mainColumn = scan.nextLine();
            mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                    Integer.parseInt(String.valueOf(mainColumn)));
            mainPos = move(scan, mainPos, 'X', mainBoard);
            mainBoard.placeMarker(mainPos, 'X');

            if (mainBoard.checkForWinner(mainPos)) {
                System.out.println("Congratulations Player " + mainPos.getPlayer() + "! You won!\n");

                //Ask if the user wants to play again
                System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                String in = scan.nextLine();
                if (in.equals("N") || in.equals("n")) {
                    playAgain = false;
                } else if (in.equals("y") || in.equals("Y")) {
                    playAgain = true;
                } else {
                    System.out.println("That is not a valid choice please try again (Y or y for Yes, or N or n for no)\n");
                    System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                    in = scan.nextLine();
                }
            }

            //Player O's first turn
            System.out.println(mainBoard);
            System.out.println("\nPlayer O, Please enter your ROW:");
            mainRow = scan.nextLine();
            System.out.println("\nPlayer O, Please enter your COLUMN:");
            mainColumn = scan.nextLine();
            mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                    Integer.parseInt(String.valueOf(mainColumn)));
            mainPos = move(scan, mainPos, 'O', mainBoard);
            mainBoard.placeMarker(mainPos, 'O');
            if (mainBoard.checkForWinner(mainPos)) {
                System.out.println("Checking for Winner in main...\n");
                System.out.println("Congratulations Player " + mainPos.getPlayer() + "! You won!\n");

                //Ask if the user wants to play again
                System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                String in = scan.nextLine();
                if (in.equals("N") || in.equals("n")) {
                    playAgain = false;
                }
                else if (in.equals("y") || in.equals("Y")) {
                    playAgain = true;
                }
                else {
                    System.out.println("That is not a valid choice please try again (Y or y for Yes, or N or n for no)\n");
                    System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                    in = scan.nextLine();
                }
            }
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



