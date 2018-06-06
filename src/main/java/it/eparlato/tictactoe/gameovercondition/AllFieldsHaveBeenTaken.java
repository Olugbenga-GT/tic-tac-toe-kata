package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;

public class AllFieldsHaveBeenTaken extends GameOverCondition {

	public AllFieldsHaveBeenTaken(Board board) {
		super(board);
	}

	@Override
	public boolean isTrue() {
		for (int rowIndex = 0; rowIndex < totRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < totColumns; columnIndex++) {

				if (isEmptyField(rowIndex, columnIndex)) {
					return false;
				}
			}
		}

		return true;
	}

}
