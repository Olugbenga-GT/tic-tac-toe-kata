package it.eparlato.tictactoe.gameovercondition;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.Field;
import it.eparlato.tictactoe.GameStateController;

public abstract class GameOverCondition {
	
	protected int totRows;
	protected int totColumns;
	protected GameStateController gameStateController;
	
	private Board board;
	
	public GameOverCondition(Board board, GameStateController gameStateController) {
		this.board = board;
		this.totRows = board.getTotRows();
		this.totColumns = board.getTotColumns();
		this.gameStateController = gameStateController;
	}
	
	protected boolean isEmptyField(int rowIndex, int columnIndex) {
		Field field = new Field(rowIndex, columnIndex);
		
		return board.isEmptyField(field);
	}
	
	protected String getPlayerAtField(int rowIndex, int columnIndex) {
		return board.getPlayerAtField(rowIndex, columnIndex);
	}
	
	public abstract void check();
}
