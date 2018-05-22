package it.eparlato.tictactoe;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameWith3x3BoardTest {
	
	private Game game;
	private ByteArrayOutputStream outputBaos;
	private PrintStream printStream;
	private Board board;

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
		
		game.takeField("A1");
		game.takeField("B1");
		
		String expected = 
				"  A B C\n" +
				"1 X|O| \n" +
				"2  | | \n" +
				"3  | | \n"
						;
		
		assertTrue(gameOutput().contains(expected));
	}
	
	private String gameOutput() throws UnsupportedEncodingException {
		return outputBaos.toString("UTF-8");
	}
}
