package it.eparlato.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Game {

	private Board board;
	private String player = "X";

	public Game(Board board) {
		this.board = board;
		
		board.print();
	}
	
	public void run(Reader inputStream) throws IOException {
		String command;
		BufferedReader commandReader = new BufferedReader(inputStream);
		
		while (!isGameOver()) {
		
			command = commandReader.readLine();
			
			if (command == null) {
				break;
			}
			
			board.takeField(command, player); 
			
			changePlayer();
			
			board.print();
		}
		
		commandReader.close();
	}
	
	public boolean isGameOver() {
		if (board.haveAllFieldsBeenTaken()) {
			return true;
		}
		
		if (board.aRowHasBeenTakenByAPlayer()) {
			return true;
		}
		
		if (board.aColumnHasBeenTakenByAPlayer()) {
			return true;
		}
		
		if (board.upperLeftBottomRightDiagonalIsTakenByAPlayer()) {
			return true;
		}
		
		if (board.upperRightBottomLeftDiagonalIsTakenByAPlayer()) {
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
