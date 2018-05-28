package gameovercondition;

import it.eparlato.tictactoe.Board;

public class HasARowBeenTakenByPlayer extends GameOverCondition {

	public HasARowBeenTakenByPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isTrue() {
		for (int rowIndex = 0; rowIndex < totRows; rowIndex++) {
			if (allFieldsAreTakenByAPlayerOnRow(rowIndex)) {
				return true;
			}
		}

		return false;
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
