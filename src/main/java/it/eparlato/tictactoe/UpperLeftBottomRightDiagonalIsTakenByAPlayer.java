package it.eparlato.tictactoe;

import gameovercondition.GameOverCondition;

public class UpperLeftBottomRightDiagonalIsTakenByAPlayer extends GameOverCondition {

	public UpperLeftBottomRightDiagonalIsTakenByAPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isGameOver() {
		if (content[0][0].equals(EMPTY_CELL)) {
			return false;
		}

		String player = content[0][0];

		for (int i = 1, j = 1; i < tot_rows && j < tot_columns; i++, j++) {

			if (!content[i][j].equals(player)) {
				return false;
			}
		}

		return true;
	}

}
