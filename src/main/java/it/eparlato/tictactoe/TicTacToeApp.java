package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

public class TicTacToeApp {

	private Game game;
	private BufferedReader reader;
	private Board board;
	
	public TicTacToeApp(Reader inputStream, PrintStream printStream) {
		this.reader = new BufferedReader(inputStream);
		
		this.board = new Board(printStream, 3, 3);
		this.game = new Game(board);
	}

	public void run() throws IOException {
		
		boolean endGame = false;
		
		while (!endGame) {
			String field = reader.readLine();
			
			if (field == null) {
				break;
			}
			
			game.takeField(field);
			
			endGame = game.isGameOver();
		}
		
		
	}

}
