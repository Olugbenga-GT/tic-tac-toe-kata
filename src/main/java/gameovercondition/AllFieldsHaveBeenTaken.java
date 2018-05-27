package gameovercondition;

import it.eparlato.tictactoe.Board;

public class AllFieldsHaveBeenTaken extends GameOverCondition {

	public AllFieldsHaveBeenTaken(Board board) {
		super(board);
	}

	@Override
	public boolean isGameOver() {
		for (int i = 0; i < tot_rows; i++) {
			for (int j = 0; j < tot_columns; j++) {

				if (content[i][j].equals(EMPTY_CELL)) {
					return false;
				}
			}
		}

		return true;
	}

}
