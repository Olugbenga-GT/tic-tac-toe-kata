package it.eparlato.tictactoe;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	private ByteArrayOutputStream outputBaos;
	private PrintStream printStream;
	private Board board;
	
	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
	}
	
	@After
	public void shutdown() throws Exception {
		printStream.close();
		outputBaos.close();
	}
	
	@Test
	public void empty_1x1_board() throws Exception {
		board = new Board(printStream, 1, 1);
		
		String expected = 
				"  A\n" +
				"1  \n";
		
		board.print();
		
		assertEquals(expected, outputBaos.toString("UTF-8"));
	}
	
	@Test
	public void empty_3x3_board() throws Exception {
		board = new Board(printStream, 3, 3);
		
		String expected = 
				"  A B C\n" +
				"1  | | \n" +
				"2  | | \n"	+	
				"3  | | \n";
		
		board.print();
		
		assertEquals(expected, outputBaos.toString("UTF-8"));
	}
	
	@Test
	public void a_valid_command_takes_a_field() throws Exception {
		board = new Board(printStream, 3, 3);
		
		board.takeField("A1", playerX());
		board.takeField("B2", playerX());
		board.takeField("C3", playerX());
		
		String expected = 
				"  A B C\n" +
				"1 X| | \n" +
				"2  |X| \n" +
				"3  | |X\n";
		
		board.print();
		
		assertEquals(expected, outputBaos.toString("UTF-8"));
	}
	
	private String playerX() {
		return "X";
	}
}
