package it.eparlato.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameWith1x1BoardTest {
	
	private Game game;
	private Prompt prompt;

	@Before
	public void init() {
		prompt = new Prompt();
		game = new Game(prompt);
	}

	@Test
	public void a_new_empty_board_is_shown_when_the_game_starts() throws Exception {
		
		String emptyBoard = 
				" 1\n" +
				"A \n";
		
		assertEquals(emptyBoard, game.printBoard());
	}
	
	@Test
	public void when_player_moves_a_cell_is_taken() throws Exception {
		
		game.takeField("A1");
		
		String expected = 
				" 1\n" +
				"AX\n";
		
		assertEquals(expected, game.printBoard());
	}
	
	@Test
	public void when_the_board_is_full_the_game_is_over() throws Exception {
		
		game.takeField("A1");
		
		assertEquals("GAME OVER: all fields have been taken", prompt.printStatus());
	}
}
