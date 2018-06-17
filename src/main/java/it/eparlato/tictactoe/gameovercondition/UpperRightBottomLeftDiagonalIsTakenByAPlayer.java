package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.GameStateController;

public class UpperRightBottomLeftDiagonalIsTakenByAPlayer extends GameOverCondition {
	
	public UpperRightBottomLeftDiagonalIsTakenByAPlayer(Board board, GameStateController gameStateController) {
		super(board, gameStateController);
	}

	@Override
	public void check() {
		if (isEmptyField(0, totColumns - 1)) {
			return;
		}

		String player = getPlayerAtField(0, totColumns - 1);

		for (int rowIndex = 1, columnIndex = 1; rowIndex < totRows && columnIndex >= 0; rowIndex++, columnIndex--) {
			if (!getPlayerAtField(rowIndex, columnIndex).equals(player)) {
				return;
			}
		}

		gameStateController.gameOverUpperRightBottomLeftDiagonal();
	}

}
