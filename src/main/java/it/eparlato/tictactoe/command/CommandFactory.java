package it.eparlato.tictactoe.command;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.GameStateController;

public class CommandFactory {
	
	private Board board;
	private GameStateController gameStateController;
	
	public CommandFactory(Board board, GameStateController gameStateController) {
		this.board = board;
		this.gameStateController = gameStateController;
	}

	public Command next(String input) {
		if (input == null) {
			return new InvalidCommand();
		}
		
		if (input.toUpperCase().matches("[A-C][1-3]")) {
			return new TakeField(input, board);
		}
		
		if ("Q".equals(input.toUpperCase())) {
			return new Quit(gameStateController);
		}
		
		return new InvalidCommand();
	}

}
