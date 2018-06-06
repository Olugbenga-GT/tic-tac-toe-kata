package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;

public class HasAColumnBeenTakenByAPlayer extends GameOverCondition {

	public HasAColumnBeenTakenByAPlayer(Board board) {
		super(board);
	}

	@Override
	public boolean isTrue() {
		for (int columnIndex = 0; columnIndex < totColumns; columnIndex++) {
			if (allFieldsAreTakenByAPlayerOnColumn(columnIndex)) {
				return true;
			}
		}

		return false;
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
