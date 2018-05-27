package it.eparlato.tictactoe;

import gameovercondition.GameOverCondition;

public class UpperRightBottomLeftDiagonalIsTakenByAPlayer extends GameOverCondition {

	public UpperRightBottomLeftDiagonalIsTakenByAPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isGameOver() {
		if (content[0][tot_columns - 1].equals(EMPTY_CELL)) {
			return false;
		}

		String player = content[0][2];

		for (int i = 1, j = 1; i < tot_rows && j >= 0; i++, j--) {
			if (!content[i][j].equals(player)) {
				return false;
			}
		}

		return true;
	}

}
