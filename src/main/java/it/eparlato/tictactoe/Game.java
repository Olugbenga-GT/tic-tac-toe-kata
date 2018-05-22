package it.eparlato.tictactoe;

import java.io.IOException;

public class Game {

	private Board board;
	private String player = "X";

	public Game(Board board) {
		this.board = board;
		
		board.print();
	}

	public void takeField(String field) throws IOException {
		
		board.takeField(field, player); 
		
		changePlayer();
		
		board.print();
		
	}
	
	public boolean isGameOver() {
		if (board.haveAllFieldsBeenTaken()) {
			return true;
		}
		
		return false;
	}

	private void changePlayer() {
		if ("X".equals(player)) {
			player = "O";
		} else {
			player = "X";
		}
	}

	public void printBoard() {
		board.print();
	}

}
