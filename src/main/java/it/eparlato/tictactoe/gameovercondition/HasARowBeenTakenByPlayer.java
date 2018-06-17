package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.GameStateController;

public class HasARowBeenTakenByPlayer extends GameOverCondition {

	public HasARowBeenTakenByPlayer(Board board, GameStateController gameStateController) {
		super(board, gameStateController);
	}

	@Override
	public void check() {
		for (int rowIndex = 0; rowIndex < totRows; rowIndex++) {
			if (allFieldsAreTakenByAPlayerOnRow(rowIndex)) {
				gameStateController.gameOverARowHasBeenTaken();
			}
		}
	}
	
	private boolean allFieldsAreTakenByAPlayerOnRow(int rowIndex) {

		if (isEmptyField(rowIndex, 0)) {
			return false;
		}

		String player = getPlayerAtField(rowIndex, 0);

		for (int columnIndex = 1; columnIndex < totColumns; columnIndex++) {
			if (!getPlayerAtField(rowIndex, columnIndex).equals(player)) {
				return false;
			}
		}

		return true;
	}

}
