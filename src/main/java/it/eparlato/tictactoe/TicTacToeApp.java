package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

public class TicTacToeApp {

	private Game game;
	private BufferedReader reader;

	public TicTacToeApp(Reader inputStream, PrintStream printStream) {
		this.reader = new BufferedReader(inputStream);
		
		Board board = new Board(printStream, 3, 3);
		this.game = new Game(board);
	}

	public void run() throws IOException {
		
		String field = reader.readLine();
		
		game.takeField(field);
	}

}
