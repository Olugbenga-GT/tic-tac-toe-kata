package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Game {

	private Board board;
	private String player = "X";
	private GameStatusController gameStatusController;
	
	public Game(Board board, GameStatusController gameStatusController) {
		this.board = board;
		this.gameStatusController = gameStatusController;
	}
	
	public void run(Reader inputStream) throws IOException {
		String command;
		BufferedReader commandReader = new BufferedReader(inputStream);
		
		board.print();
		
		while (!isOver()) {
		
			command = commandReader.readLine();
			
			if (command == null) {
				break;
			}
			
			boolean cellTaken = board.takeField(command, player); 
			
			if (cellTaken) {
				changePlayer();
			}
			
			board.print();
		}
		
		commandReader.close();
	}
	
	public boolean isOver() {
		return gameStatusController.isGameOver();
	}

	private void changePlayer() {
		if ("X".equals(player)) {
			player = "O";
		} else {
			player = "X";
		}
	}

	public void printBoard() {
		board.print();
	}

}
