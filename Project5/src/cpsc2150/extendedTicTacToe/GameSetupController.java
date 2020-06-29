package cpsc2150.extendedTicTacToe;

/**
 * Created by kplis on 4/5/2018.
 */
public class GameSetupController {
	private GameSetupScreen view;
	private final int MEM_CUTOFF = 64;


	public GameSetupController(GameSetupScreen v)
	{
		view = v;
	}

	public void processButtonClick(int rows, int cols, int players, int numWin )
	{
		String errorMsg = "";
		if(rows < IGameBoard.MIN_LEN || rows > IGameBoard.MAX_LEN)
		{
			errorMsg += "Rows must be between " +  3 + " and " + IGameBoard.MAX_LEN;
		}

		if(cols < IGameBoard.MIN_LEN || cols > IGameBoard.MAX_LEN)
		{
			errorMsg += "Columns must be between " +  3 + " and " + IGameBoard.MAX_LEN;
		}

		if (numWin > rows)
		{
			errorMsg += "Can't have more to win than the number of rows";
		}
		if (numWin > rows)
		 {
			errorMsg += "Can't have more to win than the number of Columns";
		 }

		if(numWin < IGameBoard.MIN_LEN)
		{
			errorMsg += "Number to win must be at least " + 3;
		}

		if(!errorMsg.equals(""))
		{
			view.displayError(errorMsg);

		}
		else
		{
			view.closeScreen();
			IGameBoard model;
			if(rows * cols <= MEM_CUTOFF) {
				model = new GameBoard(rows, cols, numWin);
			}
			else
			{
				model = new GameBoardMem(rows, cols, numWin);
			}
			TicTacToeView tview = new TicTacToeView(rows, cols);
			TicTacToeController tcontroller = new TicTacToeController(model, tview, players);

			tview.registerObserver(tcontroller);
		}
	}
}
