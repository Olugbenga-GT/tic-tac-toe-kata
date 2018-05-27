package it.eparlato.tictactoe;

public class GameStatusController {

	private static final String EMPTY_CELL = " ";
	private String[][] content;
	private int tot_rows;
	private int tot_columns;

	public boolean isGameOver(Board board) {
		
		this.content = board.getContent();
		this.tot_rows = content.length;
		this.tot_columns = content[0].length;
				
		if (haveAllFieldsBeenTaken()) {
			return true;
		}

		if (aRowHasBeenTakenByAPlayer()) {
			return true;
		}

		if (aColumnHasBeenTakenByAPlayer()) {
			return true;
		}

		if (upperLeftBottomRightDiagonalIsTakenByAPlayer()) {
			return true;
		}

		if (upperRightBottomLeftDiagonalIsTakenByAPlayer()) {
			return true;
		}

		return false;
	}

	private boolean haveAllFieldsBeenTaken() {
		for (int i = 0; i < tot_rows; i++) {
			for (int j = 0; j < tot_columns; j++) {

				if (content[i][j].equals(EMPTY_CELL)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean aRowHasBeenTakenByAPlayer() {
		for (int i = 0; i < tot_rows; i++) {
			if (allFieldsAreTakenByAPlayerOnRow(i)) {
				return true;
			}
		}

		return false;
	}

	private boolean aColumnHasBeenTakenByAPlayer() {

		for (int j = 0; j < tot_columns; j++) {
			if (allFieldsAreTakenByAPlayerOnColumn(j)) {
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

	private boolean upperLeftBottomRightDiagonalIsTakenByAPlayer() {
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

	private boolean upperRightBottomLeftDiagonalIsTakenByAPlayer() {
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
