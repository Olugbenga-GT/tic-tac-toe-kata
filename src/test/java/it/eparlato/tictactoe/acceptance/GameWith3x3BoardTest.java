package it.eparlato.tictactoe.acceptance;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.Game;
import it.eparlato.tictactoe.GameStateController;
import it.eparlato.tictactoe.Prompt;

public class GameWith3x3BoardTest {
	
	private final String EXIT_MESSAGE = "Bye!";
	private Game game;
	private ByteArrayOutputStream outputBaos;
	private PrintStream printStream;
	private Board board;
	private Prompt prompt;
	private String commands;
	private StringReader inputStream;
	private GameStateController gameStatuscontroller;
	
	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
		
		board = new Board(printStream);
		prompt = new Prompt(printStream);
		gameStatuscontroller = new GameStateController(board);
		
		game = new Game(board, gameStatuscontroller, prompt);
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
	
	@Test
	public void a_game_is_over_when_all_fields_in_a_column_are_taken_by_a_player() throws Exception {
		commands = "C1\nA1\nC2\nA2\nC3\n";
		inputStream = new StringReader(commands);
			
		String expected = 
				"  A B C\n" +
				"1 O| |X\n" +
				"2 O| |X\n" +
				"3  | |X\n"
						;
		game.run(inputStream);
		
		assertTrue(gameOutput().contains(expected));
		assertTrue(gameOutput().contains(EXIT_MESSAGE));
	}
	
	private String gameOutput() throws UnsupportedEncodingException {
		return outputBaos.toString("UTF-8");
	}
}
