package it.eparlato.tictactoe;

import gameovercondition.GameOverCondition;

public class HasAColumnBeenTakenByAPlayer extends GameOverCondition {

	public HasAColumnBeenTakenByAPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isGameOver() {
		for (int j = 0; j < tot_columns; j++) {
			if (allFieldsAreTakenByAPlayerOnColumn(j)) {
				return true;
			}
		}

		return false;
	}
	
	private boolean allFieldsAreTakenByAPlayerOnColumn(int columnIndex) {

		if (content[0][columnIndex].equals(EMPTY_CELL)) {
			return false;
		}

		String player = content[0][columnIndex];

		for (int i = 1; i < tot_rows; i++) {
			if (!content[i][columnIndex].equals(player)) {
				return false;
			}
		}

		return true;
	}

}
