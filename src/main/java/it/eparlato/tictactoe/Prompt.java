package it.eparlato.tictactoe;

import java.io.PrintStream;

public class Prompt {

	private PrintStream output;
	
	public Prompt(PrintStream output) {
		this.output = output;
	}

	public void printGameOverAllFieldsTaken() {
		output.print("GAME OVER: all fields have been taken");
	}

}
