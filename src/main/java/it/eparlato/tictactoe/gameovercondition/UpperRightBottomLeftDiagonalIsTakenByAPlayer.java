package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;

public class UpperRightBottomLeftDiagonalIsTakenByAPlayer extends GameOverCondition {

	public UpperRightBottomLeftDiagonalIsTakenByAPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isTrue() {
		if (isEmptyField(0, totColumns - 1)) {
			return false;
		}

		String player = getPlayerAtField(0, 2);

		for (int rowIndex = 1, columnIndex = 1; rowIndex < totRows && columnIndex >= 0; rowIndex++, columnIndex--) {
			if (!getPlayerAtField(rowIndex, columnIndex).equals(player)) {
				return false;
			}
		}

		return true;
	}

}
