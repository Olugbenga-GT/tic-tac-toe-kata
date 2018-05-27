package gameovercondition;

import it.eparlato.tictactoe.Board;

public class UpperLeftBottomRightDiagonalIsTakenByAPlayer extends GameOverCondition {

	public UpperLeftBottomRightDiagonalIsTakenByAPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isTrue() {
		if (isEmptyCell(0, 0)) {
			return false;
		}

		String player = getPlayerAtField(0, 0);

		for (int rowIndex = 1, columnIndex = 1; rowIndex < totRows && columnIndex < totColumns; rowIndex++, columnIndex++) {

			if (!getPlayerAtField(rowIndex, columnIndex).equals(player)) {
				return false;
			}
		}

		return true;
	}

}
