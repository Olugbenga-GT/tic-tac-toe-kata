package it.eparlato.tictactoe;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class GameStateControllerTest {
	
	Board board;
	GameStateController gsc;
	
	@Before
	public void setup() {
		board = new Board(new PrintStream(new ByteArrayOutputStream()), 3, 3);
		gsc = new GameStateController(board);
	}
	
	@Test
	public void the_game_is_over_when_all_fields_have_been_taken() throws Exception {
		board.takeField(new Field("A1"), playerX());
		board.takeField(new Field("A2"), playerX());
		board.takeField(new Field("A3"), playerO());
		board.takeField(new Field("B1"), playerO());
		board.takeField(new Field("B2"), playerO());
		board.takeField(new Field("B3"), playerX());
		board.takeField(new Field("C1"), playerX());
		board.takeField(new Field("C2"), playerO());
		board.takeField(new Field("C3"), playerX());
		
		gsc.checkForGameOver();
		
		assertTrue(gsc.isGameOverAllFieldsHaveBeenTaken());
	}
	
	@Test
	public void a_game_is_over_when_all_fields_in_diagonal_upper_right_bottom_left_are_taken_by_a_player() throws Exception {
		
		board.takeField(new Field("A1"), playerX());
		board.takeField(new Field("B2"), playerX());
		board.takeField(new Field("A2"), playerX());
		board.takeField(new Field("C1"), playerX());
		board.takeField(new Field("C3"), playerX());
		board.takeField(new Field("A3"), playerX());
		
		gsc.checkForGameOver();
		
		assertTrue(gsc.isGameOverAllFieldsInDiagonalUpperRightBottomLeftHaveBeenTaken());
	}
	
	@Test
	public void a_game_is_over_when_all_fields_in_diagonal_upper_left_bottom_right_are_taken_by_a_player() throws Exception {
		board.takeField(new Field("A1"), playerX());
		board.takeField(new Field("B1"), playerX());
		board.takeField(new Field("B2"), playerX());
		board.takeField(new Field("C1"), playerX());
		board.takeField(new Field("C3"), playerX());
		
		gsc.checkForGameOver();
		
		assertTrue(gsc.isGameOverAllFieldsInDiagonalUpperLeftBottomRightHaveBeenTaken());
	}
	
	@Test
	public void a_game_is_over_when_all_fields_in_a_column_are_taken_by_a_player() throws Exception {
		board.takeField(new Field("C1"), playerX());
		board.takeField(new Field("C2"), playerX());
		board.takeField(new Field("C3"), playerX());
		
		gsc.checkForGameOver();
		
		assertTrue(gsc.isGameOverAllFieldsInAColumnHaveBeenTaken());
	}
	
	@Test
	public void a_game_is_over_when_all_fields_in_a_row_are_taken_by_a_player() throws Exception {
		board.takeField(new Field("A2"), playerX());
		board.takeField(new Field("B2"), playerX());
		board.takeField(new Field("C2"), playerX());
		
		gsc.checkForGameOver();
		
		assertTrue(gsc.isGameOverAllFieldsInARowHaveBeenTaken());
	}
	
	
	private String playerX() {
		return "X";
	}
	
	private String playerO() {
		return "O";
	}
}
