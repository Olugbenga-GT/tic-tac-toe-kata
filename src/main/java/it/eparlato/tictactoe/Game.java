package it.eparlato.tictactoe;

public class Game {

	private String board = " ";
	private Prompt prompt;

	public Game(Prompt prompt) {
		this.prompt = prompt;
	}

	public Game() {
		this.prompt = new Prompt();
	}

	public String printBoard() {
		return 
			" 1\n" +
			"A" + board + "\n";
	}

	public void takeField(String string) {
		board = "X";
		
		if (board.equals("X")) {
			prompt.setStatus("GAME OVER: all fields have been taken");
		}
	}

}
