package it.eparlato.tictactoe.command;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.eparlato.tictactoe.Board;
import it.eparlato.tictactoe.GameStateController;

public class CommandFactoryTest {
	
	// TODO: here a couple of mocks could be useful...
	
	private ByteArrayOutputStream outputBaos;
	private PrintStream printStream;
	private Board board;
	private CommandFactory commandfactory;
	private Command command;
	
	@Before
	public void init() {
		outputBaos = new ByteArrayOutputStream();
		printStream = new PrintStream(outputBaos);
		board = new Board(printStream);
		commandfactory = new CommandFactory(board, new GameStateController(board));
	}
	
	@After
	public void shutdown() throws Exception {
		printStream.close();
		outputBaos.close();
	}
	
	@Test
	public void a_command_without_a_letter_or_a_number_is_not_valid() throws Exception {
		
		command = commandfactory.next("A");
		assertTrue(command instanceof InvalidCommand);
		
		command = commandfactory.next("1");
		assertTrue(command instanceof InvalidCommand);
		
		command = commandfactory.next("foo");
		assertTrue(command instanceof InvalidCommand);

		command = commandfactory.next("");
		assertTrue(command instanceof InvalidCommand);
	}
	
}
