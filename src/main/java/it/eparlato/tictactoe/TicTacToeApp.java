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
		
		Prompt prompt = new Prompt(printStream);
		Board board = new Board(printStream);
		this.game = new Game(prompt, board);
	}

	public void run() throws IOException {
		
		String field = reader.readLine();
		
		game.takeField(field);
	}

}
