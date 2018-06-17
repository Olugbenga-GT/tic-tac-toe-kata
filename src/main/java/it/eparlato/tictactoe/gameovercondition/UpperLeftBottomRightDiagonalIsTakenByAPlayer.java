package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.GameStateController;

public class UpperLeftBottomRightDiagonalIsTakenByAPlayer extends GameOverCondition {

	public UpperLeftBottomRightDiagonalIsTakenByAPlayer(Board board, GameStateController gameStateController) {
		super(board, gameStateController);
	}

	@Override
	public void check() {
		if (isEmptyField(0, 0)) {
			return;
		}

		String player = getPlayerAtField(0, 0);

		for (int rowIndex = 1, columnIndex = 1; rowIndex < totRows && columnIndex < totColumns; rowIndex++, columnIndex++) {

			if (!getPlayerAtField(rowIndex, columnIndex).equals(player)) {
				return;
			}
		}

		gameStateController.gameOverUpperLeftBottomRightDiagonal();
	}

}
