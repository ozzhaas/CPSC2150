package cpsc2150.extendedTicTacToe;

import java.util.Scanner;

public class GameScreen {

    /**
     * @pre [Bounds checking for the users input to
     * make sure it is a valid position on the board]
     * @pre Input: 1st get Row then Col [0,0 is the top left
     * corner]
     * @pre Only enter integers between 0 and 7 are valid
     * @param args
     * @post [Checks if either player has one or if not,
     * it checks if all of the positions are taken. If they
     * are all taken, it prints draw. Else, prints the current
     * game board and prompts next player for their turn]
     * @return integer value of 0
     */
    public static void main(String [] args){
        int mainRow;
        int mainCol;

        System.out.println("Test\n");
        System.out.println("Welcome to Extended Tic Tac Toe!\n");
        System.out.println("Ready to play? (Y for yes or N for no)\n");
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        if (in.equals("n") || in.equals("N")) {
            System.out.println("See you next time! Exiting program...");
            System.exit(0);
        }
        else {
            while (in.equals("y") || in.equals("Y")) {











                System.out.println("Would you like to play again? (Y for yes or N for no)\n");
                in = scan.nextLine();
            }
        }

    }
}
