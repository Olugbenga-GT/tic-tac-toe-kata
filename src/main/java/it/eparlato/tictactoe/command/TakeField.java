package it.eparlato.tictactoe.command;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.Field;

public class TakeField implements Command {

	private String fieldCoordinates;
	private Board board;
	private Field field;

	public TakeField(String fieldCoordinates, Board board) {
		this.fieldCoordinates = fieldCoordinates;
		this.board = board;
	}

	@Override
	public void execute() {
		String player = board.currentPlayer();
		
		field = new Field(fieldCoordinates);
		
		if (!board.isEmptyField(field)) {
			return;
		}
		
		board.takeField(field, player);
		board.switchPlayer();
	}

}
