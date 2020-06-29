/* Kellen Haas
   Project 4
   CPSC 2150
   6.15.20
 */


package cpsc2150.extendedTicTacToe;
import java.lang.*;
import java.util.*;
import static junit.framework.Assert.*;
import org.junit.Test;


public class TestGameBoardMem {

    private IGameBoard makeBoard(int rows, int cols, int numWin) {
        char player = 'X';
        BoardPosition pos = new BoardPosition(rows, cols);
        IGameBoard gb = new GameBoardMem(rows, cols, numWin);
        Map<Character, List<BoardPosition>> expectedMap = new HashMap<>();
        gb.placeMarker(pos, player);
        assertEquals(gb.toString(),convertToString(gb, expectedMap));
        return gb;
    }



    private String convertToString(IGameBoard gb, Map <Character, List<BoardPosition>> actualMap) {
        String gameBoardStr = " ";
        int strRow = gb.getNumRows();
        int strCol = gb.getNumColumns();

        //Label the column indexes
        for (int i = 0; i < strCol; i++) {
            if (i == 0) {
                gameBoardStr = gameBoardStr + "\t  " + i + " " + '|';
            }
            else if (i < 10) {
                gameBoardStr = gameBoardStr + " " + i + " " + '|';
            }
            else {
                gameBoardStr = gameBoardStr  + " " + i + " " + '|';
            }
        }

        gameBoardStr = gameBoardStr + "\n";

        //Create the rows
        for (int i = 0; i < strRow; i++) {
            if (i < 10) {
                gameBoardStr = gameBoardStr + " " + i + "  " + '|';
            }
            else {
                gameBoardStr = gameBoardStr + " " + i + " " + '|';
            }
            for (int c = 0; c < strCol; c++) {
                BoardPosition stringPos;
                stringPos = new BoardPosition(i, c);
                if (c >= 10) {
                    gameBoardStr = gameBoardStr + " " + gb.whatsAtPos(stringPos) + "  " + '|';
                }
                else {
                    gameBoardStr = gameBoardStr + " " + gb.whatsAtPos(stringPos) + " " + '|';
                }
            }
            gameBoardStr = gameBoardStr + "\n";
        }

        return gameBoardStr;
    }


    @Test
    public void test_checkSpace_OutOfBounds_Too_High() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        BoardPosition testPos = new BoardPosition(11, 11);
        assertFalse(myGB.checkSpace(testPos));
    }


    @Test
    public void test_checkSpace_OutOfBounds_Too_Low() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        BoardPosition testPos = new BoardPosition(-1, -1);
        assertFalse(myGB.checkSpace(testPos));
    }

    @Test
    public void test_checkSpace_space_already_taken () {
        IGameBoard myGB = makeBoard(10, 10, 5);
        BoardPosition testPos = new BoardPosition(4, 4);
        myGB.placeMarker(testPos, 'X');
        assertFalse(myGB.whatsAtPos(testPos) == ' ');
    }


    @Test
    public void check_Horizontal_Win_Dec_Col() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 7;
        int c = 6;
        BoardPosition testPos = new BoardPosition(7, 7);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            c--;
        }
        assertTrue(numOfMatches >= myGB.getNumToWin());
    }


    @Test
    public void check_Horizontal_Win_Inc_Col() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 2;
        int c = 3;
        BoardPosition testPos = new BoardPosition(2, 2);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            c++;
        }
        assertTrue(numOfMatches >= myGB.getNumToWin());
    }

    @Test
    public void check_Vertical_Win_Dec_Row() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 6;
        int c = 7;
        BoardPosition testPos = new BoardPosition(7, 7);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            r--;
            if (r <= 0) {
                break;
            }
        }
        assertTrue(numOfMatches >= 5);
    }


    @Test
    public void check_Vertical_Win_Inc_Row() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 3;
        int c = 2;
        BoardPosition testPos = new BoardPosition(2, 2);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            r++;
            if (r <= 0) {
                break;
            }
        }
        assertTrue(numOfMatches >= 5);
    }


    @Test
    public void check_Diagonal_Win_Inc_Row_And_Col() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 3;
        int c = 3;
        BoardPosition testPos = new BoardPosition(2, 2);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            r++;
            c++;
            if ((r <= 0) || (c <= 0)) {
                break;
            }
        }
        assertTrue(numOfMatches >= 5);
    }


    @Test
    public void check_Diagonal_Win_Dec_Row_And_Col() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 8;
        int c = 8;
        BoardPosition testPos = new BoardPosition(9, 9);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            r--;
            c--;
            if ((r <= 0) || (c <= 0)) {
                break;
            }
        }
        assertTrue(numOfMatches >= 5);
    }


    @Test
    public void check_Diagonal_Win_Dec_Row_And_Inc_Col() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 8;
        int c = 3;
        BoardPosition testPos = new BoardPosition(9, 2);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            r--;
            c++;
            if ((r <= 0) || (c <= 0)) {
                break;
            }
        }
        assertTrue(numOfMatches >= 5);
    }


    @Test
    public void check_Diagonal_Win_Inc_Row_And_Dec_Col() {
        IGameBoard myGB = makeBoard(10, 10, 5);
        int numOfMatches = 0;
        int r = 3;
        int c = 8;
        BoardPosition testPos = new BoardPosition(2, 9);
        myGB.placeMarker(testPos, 'X');
        BoardPosition newTestPos;

        for (int i = 0; i < 5; i++) {
            newTestPos = new BoardPosition(r, c);
            myGB.placeMarker(newTestPos, 'X');
            if (myGB.whatsAtPos(testPos) == myGB.whatsAtPos(newTestPos)) {
                numOfMatches++;
            }
            r++;
            c--;
            if ((r <= 0) || (c <= 0)) {
                break;
            }
        }
        assertTrue(numOfMatches >= 5);
    }

}




