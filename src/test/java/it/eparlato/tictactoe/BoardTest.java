package it.eparlato.tictactoe;

import static org.junit.Assert.assertEquals;

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
		board = new Board(printStream);
		
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
}
