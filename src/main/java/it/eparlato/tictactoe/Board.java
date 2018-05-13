package it.eparlato.tictactoe;

import java.io.PrintStream;

public class Board {

	private String content = " ";
	private PrintStream output;

	public Board(PrintStream output) {
		this.output = output;
	}

	public void takeField(String field) {
		content = "X";
	}

	public String getContent() {
		return content;
	}

	public void print() {
		output.println(" 1\n" +
				"A" + content + "\n");
	}

}
