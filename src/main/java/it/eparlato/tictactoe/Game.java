package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import it.eparlato.tictactoe.command.Command;
import it.eparlato.tictactoe.command.CommandFactory;
import it.eparlato.tictactoe.command.InvalidCommand;

public class Game {

	private Board board;
	private GameStateController gameStateController;
	
	public Game(Board board, GameStateController gameStateController) {
		this.board = board;
		this.gameStateController = gameStateController;
	}
	
	public void run(Reader inputStream) throws IOException {
		String input;
		BufferedReader bufferedReader = new BufferedReader(inputStream);
		
		board.print();
		
		CommandFactory commandFactory = new CommandFactory(board);
		Command command;
		
		while (!isOver()) {
		
			input = bufferedReader.readLine();
			
			command = commandFactory.next(input);
			
			if (command instanceof InvalidCommand) {
				break;
			}
			
			command.execute();
			
			board.print();
		}
		
		bufferedReader.close();
	}
	
	public boolean isOver() {
		return gameStateController.isGameOver();
	}

}
