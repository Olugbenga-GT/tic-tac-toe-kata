package it.eparlato.tictactoe;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameStatusControllerTest {
	
	@Test
	public void all_fields_have_been_taken() throws Exception {
		Board board = new Board(new PrintStream(new ByteArrayOutputStream()), 3, 3);
		GameStateController gsc = new GameStateController(board);
		
		
		board.takeField(new Field("A1"), playerX());
		board.takeField(new Field("A2"), playerX());
		board.takeField(new Field("A3"), playerX());
		board.takeField(new Field("B1"), playerX());
		board.takeField(new Field("B2"), playerX());
		board.takeField(new Field("B3"), playerX());
		board.takeField(new Field("C1"), playerX());
		board.takeField(new Field("C2"), playerX());
		board.takeField(new Field("C3"), playerX());
		
		assertTrue(gsc.isGameOver());
	}
	
	private String playerX() {
		return "X";
	}
}
