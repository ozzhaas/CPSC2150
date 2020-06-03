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
        System.out.println("Ready to play? (Y for yes or N for no)\n");
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        if (in.equals("n") || in.equals("N")) {
            System.out.println("See you next time! Exiting program...");
            System.exit(0);
        }
        else {
            GameBoard mainBoard = new GameBoard();
            while (in.equals("y") || in.equals("Y")) {
                System.out.println(mainBoard);
                System.out.println("\nPlayer X, Please enter your ROW:");
                String mainRow = scan.nextLine();
                System.out.println("\nPlayer X, Please enter your COLUMN:");
                String mainColumn = scan.nextLine();
                BoardPosition mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                        Integer.parseInt(String.valueOf(mainColumn)), 'X');
                mainBoard.placeMarker(mainPos, 'X');

                while (!mainBoard.checkSpace(mainPos)) {
                    System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                    System.out.println("\nPlayer X, Please enter your ROW:");
                    mainRow = scan.nextLine();
                    System.out.println("\nPlayer X, Please enter your COLUMN:");
                    mainColumn = scan.nextLine();
                    mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                            Integer.parseInt(String.valueOf(mainColumn)), 'X');
                }
                mainBoard.placeMarker(mainPos, 'X');

                if (mainBoard.checkForWinner(mainPos) || mainBoard.checkForDraw(mainPos)) {
                    System.out.println("Congratulations Player " + mainPos.getPlayer() + "! You won!\n");
                    System.out.println("Would you like to play again? (Y for yes or N for no)\n");
                    in = scan.nextLine();
                    if (in.equals("Y")) {
                        GameBoard nextBoard = new GameBoard();
                    }
                    while (in.equals("y") || in.equals("Y")) {
                        System.out.println(mainBoard);
                        System.out.println("\nPlayer X, Please enter your ROW:");
                        mainRow = scan.nextLine();
                        System.out.println("\nPlayer X, Please enter your COLUMN:");
                        mainColumn = scan.nextLine();
                        mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                Integer.parseInt(String.valueOf(mainColumn)), 'X');
                        mainBoard.placeMarker(mainPos, 'X');

                        while (!mainBoard.checkSpace(mainPos)) {
                            System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                            System.out.println("\nPlayer X, Please enter your ROW:");
                            mainRow = scan.nextLine();
                            System.out.println("\nPlayer X, Please enter your COLUMN:");
                            mainColumn = scan.nextLine();
                            mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                    Integer.parseInt(String.valueOf(mainColumn)), 'X');
                        }
                        mainBoard.placeMarker(mainPos, 'X');
                        System.out.println(mainBoard);
                        System.out.println("\nPlayer O, Please enter your ROW:");
                        mainRow = scan.nextLine();
                        System.out.println("\nPlayer O, Please enter your COLUMN:");
                        mainColumn = scan.nextLine();
                        mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                Integer.parseInt(String.valueOf(mainColumn)), 'O');
                        mainBoard.placeMarker(mainPos, 'O');
                        while (!mainBoard.checkSpace(mainPos)) {
                            System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                            System.out.println("\nPlayer O, Please enter your ROW:");
                            mainRow = scan.nextLine();
                            System.out.println("\nPlayer O, Please enter your COLUMN:");
                            mainColumn = scan.nextLine();
                            mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                    Integer.parseInt(String.valueOf(mainColumn)), 'O');
                        }
                    }
                }
                else {
                        System.out.println(mainBoard);
                        System.out.println("\nPlayer O, Please enter your ROW:");
                        mainRow = scan.nextLine();
                        System.out.println("\nPlayer O, Please enter your COLUMN:");
                        mainColumn = scan.nextLine();
                        mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                Integer.parseInt(String.valueOf(mainColumn)), 'O');
                        mainBoard.placeMarker(mainPos, 'O');

                        while (!mainBoard.checkSpace(mainPos)) {
                            System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                            System.out.println("\nPlayer O, Please enter your ROW:");
                            mainRow = scan.nextLine();
                            System.out.println("\nPlayer O, Please enter your COLUMN:");
                            mainColumn = scan.nextLine();
                            mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                    Integer.parseInt(String.valueOf(mainColumn)), 'O');
//                            if mainBoard.checkSpace(mainPos) {



                            //CONSIDER DOING A DO-WHILE LOOP



                        }
                        }
                    }
                }
        }
    }


