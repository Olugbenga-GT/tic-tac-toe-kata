package it.eparlato.tictactoe.command;

import it.eparlato.tictactoe.Board;

public class CommandFactory {
	
	private Board board;
	
	public CommandFactory(Board board) {
		this.board = board;
	}

	public Command next(String input) {
		
			
		if (input == null) {
			return new InvalidCommand();
		}
		
		if (input.toUpperCase().matches("[A-C][1-3]")) {
			return new TakeField(input, board);
		}
		
		
		return new InvalidCommand();
	}

}
