package it.eparlato.tictactoe;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {
	ByteArrayOutputStream outputBaos;
	PrintStream printStream;
	
	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
	}
	
	@After
	public void shudtdown() throws IOException {
		printStream.close();
		outputBaos.close();
	}
	
	@Test
	public void application_accepts_input_from_a_inputstream() throws Exception {
		String command = "A1\n";
		Reader inputStream = new StringReader(command);
		
		TicTacToeApp application = new TicTacToeApp(inputStream, printStream);
		
		application.run();
		
		String expected = 
				"  A B C\n" +
				"1 X| | \n" +
				"2  | | \n" +
				"3  | | \n"
						;
		
		assertTrue(gameOutput().contains(expected));
	}

	@Test
	public void when_player_X_has_moved_it_is_player_O_turn() throws Exception {
		String command = "A1\nB1\n";
		Reader inputStream = new StringReader(command);
		
		TicTacToeApp application = new TicTacToeApp(inputStream, printStream);
		
		application.run();
		
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
