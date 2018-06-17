package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.GameStateController;

public class AllFieldsHaveBeenTaken extends GameOverCondition {

	public AllFieldsHaveBeenTaken(Board board, GameStateController gameStateController) {
		super(board, gameStateController);
	}

	@Override
	public void check() {
		for (int rowIndex = 0; rowIndex < totRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < totColumns; columnIndex++) {

				if (isEmptyField(rowIndex, columnIndex)) {
					return;
				}
			}
		}

		gameStateController.gameOverAllFieldsTaken();
	}

}
