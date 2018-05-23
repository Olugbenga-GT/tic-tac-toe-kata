package it.eparlato.tictactoe;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameWith3x3BoardTest {
	
	private Game game;
	private ByteArrayOutputStream outputBaos;
	private PrintStream printStream;
	private Board board;
	private String commands;
	private StringReader inputStream;
	
	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
		
		board = new Board(printStream);
		
		game = new Game(board);
	}
	
	@After
	public void shutdown() throws Exception {
		printStream.close();
		outputBaos.close();
	}
	
	@Test
	public void when_player_X_has_moved_it_is_player_O_turn() throws Exception {
		commands = "A1\nB1\n";
		inputStream = new StringReader(commands );
		
		game.run(inputStream);
		
		String expected = 
				"  A B C\n" +
				"1 X|O| \n" +
				"2  | | \n" +
				"3  | | \n"
						;
		
		assertTrue(gameOutput().contains(expected));
	}
	
	@Test
	public void a_game_is_over_when_all_fields_in_a_row_are_taken_by_a_player() throws Exception {
		commands = "A2\nB1\nB2\nA1\nC2\n";
		inputStream = new StringReader(commands);
		
		game.run(inputStream);
		
		assertTrue(game.isGameOver());
	}
	
	@Test
	public void a_game_is_over_when_all_fields_in_a_column_are_taken_by_a_player() throws Exception {
		commands = "A1\nB1\nC1\nB2\nC3\nB3\n";
		inputStream = new StringReader(commands);
		
		game.run(inputStream);
		
		assertTrue(game.isGameOver());
	}
	
	
	private String gameOutput() throws UnsupportedEncodingException {
		return outputBaos.toString("UTF-8");
	}
}
