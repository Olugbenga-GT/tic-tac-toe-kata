package it.eparlato.tictactoe;

import java.io.IOException;

public class Game {

	private Board board;

	public Game(Board board) {
		this.board = board;
		
		board.print();
	}

	public void takeField(String field) throws IOException {
		
		board.takeField(field); 
		
		board.print();
		
	}

	public void printBoard() {
		board.print();
	}

}
