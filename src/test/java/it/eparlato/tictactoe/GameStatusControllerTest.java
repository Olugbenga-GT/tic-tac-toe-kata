package it.eparlato.tictactoe;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameStatusControllerTest {
	
	@Test
	public void all_fields_have_been_taken() throws Exception {
		Board board = new Board(new PrintStream(new ByteArrayOutputStream()), 3, 3);
		GameStatusController gsc = new GameStatusController(board);
		
		
		board.takeField("A1", playerX());
		board.takeField("A2", playerX());
		board.takeField("A3", playerX());
		board.takeField("B1", playerX());
		board.takeField("B2", playerX());
		board.takeField("B3", playerX());
		board.takeField("C1", playerX());
		board.takeField("C2", playerX());
		board.takeField("C3", playerX());
		
		assertTrue(gsc.isGameOver());
	}
	
	private String playerX() {
		return "X";
	}
}
