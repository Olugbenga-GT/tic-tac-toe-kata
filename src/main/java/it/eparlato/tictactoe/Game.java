package it.eparlato.tictactoe;

import java.io.IOException;

public class Game {

	private Prompt prompt;
	private Board board;

	public Game(Prompt prompt, Board board) {
		this.prompt = prompt;
		this.board = board;
		
		board.print();
	}

	public void takeField(String field) throws IOException {
		
		board.takeField(field); 
		
		prompt.printGameOverAllFieldsTaken();
		
		board.print();
		
	}

	public void printBoard() {
		board.print();
	}

}
