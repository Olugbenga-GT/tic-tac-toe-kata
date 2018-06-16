package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.Field;

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
		Field field = new Field(rowIndex, columnIndex);
		
		return board.isEmptyField(field);
	}
	
	protected String getPlayerAtField(int rowIndex, int columnIndex) {
		return board.getPlayerAtField(rowIndex, columnIndex);
	}
	
	public abstract boolean isTrue();
}
