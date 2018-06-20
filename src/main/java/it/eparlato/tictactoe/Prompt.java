package it.eparlato.tictactoe;

import java.io.PrintStream;

public class Prompt {
	
	private PrintStream output;

	public Prompt(PrintStream output) {
		this.output = output;
	}

	public void printExitMessage() {
		output.print("\nBye!");
	}

}
