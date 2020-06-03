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

        //Get Player X's first turn for the first game
        BoardPosition mainPos = new BoardPosition(1,1);


        //Loop for if checkSpace is false and the space is invalid
        while (mainBoard.checkSpace(mainPos)) {
            System.out.println(mainBoard);
            System.out.println("\nPlayer X, Please enter your ROW:");
            String mainRow = scan.nextLine();
            System.out.println("\nPlayer X, Please enter your COLUMN:");
            String mainColumn = scan.nextLine();
            mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                    Integer.parseInt(String.valueOf(mainColumn)));
            mainPos = move(scan, mainPos, 'X', mainBoard);

            mainBoard.placeMarker(mainPos, 'X');
            System.out.println("\nPlayer O, Please enter your ROW:");
            mainRow = scan.nextLine();
            System.out.println("\nPlayer O, Please enter your COLUMN:");
            mainColumn = scan.nextLine();
            mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                    Integer.parseInt(String.valueOf(mainColumn)));
            mainPos = move(scan, mainPos, 'O', mainBoard);

            mainBoard.placeMarker(mainPos, 'O');

            //Check for a win or a draw after the first two turns
            if (mainBoard.checkForWinner(mainPos) || mainBoard.checkForDraw(mainPos)) {
                System.out.println("Congratulations Player " + mainPos.getPlayer() + "! You won!\n");

                //Ask if the user wants to play again
                System.out.println("Would you like to play again? (Y for yes or N for no)\n");
                String in = scan.nextLine();

                //PLAY AGAIN: New Game
                while (in.equals("y") || in.equals("Y")) {
                    //Create new blank GameBoard
                    GameBoard nextBoard = new GameBoard();

                    //Print the new GameBoard
                    System.out.println(nextBoard);

                    //Get Player X's first turn of next game
                    System.out.println("\nPlayer X, Please enter your ROW:");
                    mainRow = scan.nextLine();
                    System.out.println("\nPlayer X, Please enter your COLUMN:");
                    mainColumn = scan.nextLine();
                    mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                            Integer.parseInt(String.valueOf(mainColumn)));
                    mainBoard.placeMarker(mainPos, 'X');

                    //Loop for if checkSpace is false and the space is invalid
                    while (mainBoard.checkSpace(mainPos)) {
                        mainBoard.placeMarker(mainPos, 'X');
                        System.out.println("\nPlayer O, Please enter your ROW:");
                        mainRow = scan.nextLine();
                        System.out.println("\nPlayer O, Please enter your COLUMN:");
                        mainColumn = scan.nextLine();
                        mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                Integer.parseInt(String.valueOf(mainColumn)));

                        mainBoard.placeMarker(mainPos, 'O');


                    }
                }
            }
        }
    }


    public static BoardPosition move(Scanner scan, BoardPosition playersMove, char player, GameBoard moveBoard) {
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
            }
            else {
                return pos;
            }
        }
        return playersMove;
    }

}



