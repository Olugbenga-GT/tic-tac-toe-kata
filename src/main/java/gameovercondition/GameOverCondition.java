package gameovercondition;

import it.eparlato.tictactoe.Board;

public abstract class GameOverCondition {
	
	protected String[][] content;
	protected int tot_rows;
	protected int tot_columns;
	
	// TODO: replace this with a isCellEmpty(row, column) on Board
	protected final String EMPTY_CELL = " ";
	
	public GameOverCondition(Board board) {
		this.content = board.getContent();
		this.tot_rows = content.length;
		this.tot_columns = content[0].length;
	}
	
	public abstract boolean isGameOver();
}
