package gameovercondition;

import it.eparlato.tictactoe.Board;

public abstract class GameOverCondition {
	
	protected int totRows;
	protected int totColumns;
	
	private Board board;
	
	public GameOverCondition(Board board) {
		this.board = board;
		this.totRows = board.getTotRows();
		this.totColumns = board.getTotColumns();
	}
	
	protected boolean isEmptyField(int rowIndex, int columnIndex) {
		return board.isEmptyField(rowIndex, columnIndex);
	}
	
	protected String getPlayerAtField(int rowIndex, int columnIndex) {
		return board.getPlayerAtField(rowIndex, columnIndex);
	}
	
	public abstract boolean isTrue();
}
