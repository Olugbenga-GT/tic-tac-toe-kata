package it.eparlato.tictactoe;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameWith1x1BoardTest {
	
	private Game game;
	private ByteArrayOutputStream outputBaos;
	private PrintStream printStream;
	private Board board;
	private GameStatusController gameStatusController;
	
	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
		
		board = new Board(printStream, 1, 1);
		gameStatusController = new GameStatusController(board);
		
		game = new Game(board, gameStatusController);
	}
	
	@After
	public void shutdown() throws Exception {
		printStream.close();
		outputBaos.close();
	}

	@Test
	public void a_new_empty_board_is_shown_when_the_game_starts() throws Exception {
		String command = "";
		StringReader inputStream = new StringReader(command);
		
		String outputFlow = 
				"  A\n" +
				"1  \n";
		
		game.run(inputStream);
		
		assertTrue(gameOutput().contains(outputFlow));
	}

	@Test
	public void when_player_moves_a_cell_is_taken() throws Exception {
		String command = "A1\n";
		StringReader inputStream = new StringReader(command);
		
		game.run(inputStream);
		
		String outputFlow = 
				"  A\n" +
				"1 X\n";
		
		assertTrue(gameOutput().contains(outputFlow));
	}
	
	private String gameOutput() throws UnsupportedEncodingException {
		return outputBaos.toString("UTF-8");
	}
	
}
