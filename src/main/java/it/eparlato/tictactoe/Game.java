package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import it.eparlato.tictactoe.command.Command;
import it.eparlato.tictactoe.command.CommandFactory;

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
		
		CommandFactory commandFactory = new CommandFactory(board, gameStateController);
		Command command;
		
		while (gameStateController.isGameRunning()) {
		
			input = bufferedReader.readLine();
			
			command = commandFactory.next(input);
			
			command.execute();
			
			gameStateController.checkForGameOver();
			
			board.print();
		}
		
		bufferedReader.close();
	}
}
