package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Game {

	private Prompt prompt;
	private Board board;
	private BufferedReader inputStream;

	public Game(Prompt prompt, Board board) {
		this.prompt = prompt;
		this.board = board;
		
		board.print();
	}

	public Game(Prompt prompt, Board board, Reader inputStream) {
		this.prompt = prompt;
		this.board = board;
		this.inputStream = new BufferedReader(inputStream);
	}

	public void takeField(String field) throws IOException {
		
		if (field == null || field.isEmpty()) {
			field = inputStream.readLine();
		}
		
		board.takeField(field); 
		
		prompt.printGameOverAllFieldsTaken();
		
		board.print();
	}

	public void printBoard() {
		board.print();
	}

}
