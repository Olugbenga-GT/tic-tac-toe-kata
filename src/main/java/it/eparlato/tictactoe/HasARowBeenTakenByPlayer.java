package it.eparlato.tictactoe;

import gameovercondition.GameOverCondition;

public class HasARowBeenTakenByPlayer extends GameOverCondition {

	public HasARowBeenTakenByPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isGameOver() {
		for (int i = 0; i < tot_rows; i++) {
			if (allFieldsAreTakenByAPlayerOnRow(i)) {
				return true;
			}
		}

		return false;
	}
	
	private boolean allFieldsAreTakenByAPlayerOnRow(int rowIndex) {

		if (content[rowIndex][0].equals(EMPTY_CELL)) {
			return false;
		}

		String player = content[rowIndex][0];

		for (int j = 1; j < tot_columns; j++) {
			if (!content[rowIndex][j].equals(player)) {
				return false;
			}
		}

		return true;
	}

}
