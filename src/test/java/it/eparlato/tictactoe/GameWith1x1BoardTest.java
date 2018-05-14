package it.eparlato.tictactoe;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameWith1x1BoardTest {
	
	private Game game;
	private Prompt prompt;
	private ByteArrayOutputStream outputBaos;
	private PrintStream printStream;
	private Board board;

	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
		
		prompt = new Prompt(printStream);
		board = new Board(printStream);
		
		game = new Game(prompt, board);
	}
	
	@After
	public void shutdown() throws Exception {
		printStream.close();
		outputBaos.close();
	}

	@Test
	public void a_new_empty_board_is_shown_when_the_game_starts() throws Exception {
		
		String outputFlow = 
				"  A\n" +
				"1  \n";
		
		assertTrue(gameOutput().contains(outputFlow));
	}

	@Test
	public void when_player_moves_a_cell_is_taken() throws Exception {
		
		game.takeField("A1");
		
		String outputFlow = 
				"  A\n" +
				"1 X\n";
		
		assertTrue(gameOutput().contains(outputFlow));
	}
	
	@Test
	public void when_the_board_is_full_the_game_is_over() throws Exception {
		
		game.takeField("A1");
		
		assertTrue(gameOutput().contains("GAME OVER: all fields have been taken"));
	}
	
	private String gameOutput() throws UnsupportedEncodingException {
		return outputBaos.toString("UTF-8");
	}
	
}
