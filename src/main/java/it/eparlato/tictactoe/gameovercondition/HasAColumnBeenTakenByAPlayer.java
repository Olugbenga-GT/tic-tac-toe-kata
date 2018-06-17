package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.GameStateController;

public class HasAColumnBeenTakenByAPlayer extends GameOverCondition {

	public HasAColumnBeenTakenByAPlayer(Board board, GameStateController gameStateController) {
		super(board, gameStateController);
	}

	@Override
	public void check() {
		for (int columnIndex = 0; columnIndex < totColumns; columnIndex++) {
			if (allFieldsAreTakenByAPlayerOnColumn(columnIndex)) {
				gameStateController.gameOverAColumnHasBeenTaken();
			}
		}
	}
	
	private boolean allFieldsAreTakenByAPlayerOnColumn(int columnIndex) {

		if (isEmptyField(0, columnIndex)) {
			return false;
		}

		String player = getPlayerAtField(0, columnIndex);
		
		for (int rowIndex = 1; rowIndex < totRows; rowIndex++) {
			if (!getPlayerAtField(rowIndex, columnIndex).equals(player)) {
				return false;
			}
		}

		return true;
	}

}
