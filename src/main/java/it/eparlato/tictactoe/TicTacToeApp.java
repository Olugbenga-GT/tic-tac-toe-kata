package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class TicTacToeApp {

	private Game game;
	private BufferedReader reader;
	private Board board;
	private Prompt prompt;
	private GameStateController gameStatusController;

	public TicTacToeApp(Reader inputStream, PrintStream printStream) {
		this.reader = new BufferedReader(inputStream);

		this.board = new Board(printStream, 3, 3);
		this.prompt = new Prompt(printStream);
		this.gameStatusController = new GameStateController(board);
		this.game = new Game(board, gameStatusController, prompt);
	}

	public void run() throws IOException {
		game.run(reader);
	}
	
	public static void main(String[] args) throws IOException {
		new TicTacToeApp(new InputStreamReader(System.in), System.out).run();
	}

}
