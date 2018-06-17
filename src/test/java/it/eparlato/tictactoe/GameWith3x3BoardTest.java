package it.eparlato.tictactoe;

import static org.junit.Assert.*;

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
	private GameStateController gameStatuscontroller;
	
	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
		
		board = new Board(printStream);
		gameStatuscontroller = new GameStateController(board);
		
		game = new Game(board, gameStatuscontroller);
	}
	
	@After
	public void shutdown() throws Exception {
		printStream.close();
		outputBaos.close();
	}
	
	@Test
	public void when_player_X_has_moved_it_is_player_O_turn() throws Exception {
		commands = "A1\nB1\nQ\n";
		inputStream = new StringReader(commands);
		
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
	public void commands_lower_case_letters_are_valid() throws Exception {
		commands = "a2\nQ\n";
		inputStream = new StringReader(commands);
		
		game.run(inputStream);
		
		String expected = 
				"  A B C\n" +
				"1  | | \n" +
				"2 X| | \n" +
				"3  | | \n"
						;
		
		assertTrue(gameOutput().contains(expected));
	}
	
	@Test
	public void if_a_cell_is_occupied_skip_the_move() throws Exception {
		commands = "A1\nA1\nB1\nQ\n";
		inputStream = new StringReader(commands);
			
		String expected = 
				"  A B C\n" +
				"1 X|O| \n" +
				"2  | | \n" +
				"3  | | \n"
						;
		game.run(inputStream);
		
		assertTrue(gameOutput().contains(expected));
	}
	
	private String gameOutput() throws UnsupportedEncodingException {
		return outputBaos.toString("UTF-8");
	}
}
