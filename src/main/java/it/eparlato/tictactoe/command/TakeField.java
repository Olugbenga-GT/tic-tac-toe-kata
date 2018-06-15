package it.eparlato.tictactoe.command;

import it.eparlato.tictactoe.Board;

public class TakeField implements Command {

	private String field;
	private Board board;

	public TakeField(String field, Board board) {
		this.field = field;
		this.board = board;
	}

	@Override
	public void execute() {
		String player = board.currentPlayer();
		
		int rowIndex = board.getRowIndexFromFieldCoordinates(field);
		int columnIndex = board.getColumnIndexFromFieldCoordinates(field);
		
		if (!board.isEmptyField(rowIndex, columnIndex)) {
			return;
		}
		
		board.takeField(field, player);
		board.switchPlayer();
	}

}
