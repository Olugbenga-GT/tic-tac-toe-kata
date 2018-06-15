package it.eparlato.tictactoe;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Board {

	private static final String EMPTY_CELL = " ";
	private String[][] content;
	private PrintStream output;
	private int totRows;
	private int totColumns;
	private Map<String, Integer> columnsCoordinates;
	private String currentPlayer = "X";

	public Board(PrintStream output) {
		this(output, 3, 3);
	}

	public Board(PrintStream output, int totRows, int totColumns) {
		this.output = output;
		this.totRows = totRows;
		this.totColumns = totColumns;
		
		build();
	}

	private void build() {
		content = new String[totRows][totColumns];
		
		for (int i = 0; i < totRows; i++) {
			for (int j = 0; j < totColumns; j++) {
				content[i][j] = EMPTY_CELL;
			}
		}
		
		columnsCoordinates = new HashMap<String, Integer>();
		columnsCoordinates.put("A", 0);
		columnsCoordinates.put("B", 1);
		columnsCoordinates.put("C", 2);
	}
	
	public boolean takeField(String field, String player) {

		// TODO: field should become an Object
		
		int rowIndex = getRowIndexFromFieldCoordinates(field);
		int columnIndex = getColumnIndexFromFieldCoordinates(field);
		
		if (!isEmptyField(rowIndex, columnIndex)) {
			return false;
		}
		
		content[rowIndex][columnIndex] = player;
		
		return true;
	}

	public int getColumnIndexFromFieldCoordinates(String field) {
		return columnsCoordinates.get(field.substring(0, 1));
	}

	public Integer getRowIndexFromFieldCoordinates(String field) {
		return Integer.parseInt(field.substring(1)) - 1;
	}

	public void print() {
		
		String header = buildHeader();
		String body = buildBody();
		
		output.print(header);
		output.print(body);
	}

	private String buildBody() {
		StringBuilder body = new StringBuilder();
		
		for (int i = 0; i < totRows; i++) {
			
			// Line number
			body.append(i + 1).append(EMPTY_CELL);
			
			for (int j = 0; j < totColumns; j++) {
				body.append(content[i][j]);
				
				if(j < totColumns - 1) {
					// Columns separator
					body.append("|");
				}
			}
			
			body.append("\n");
		}
		
		return body.toString();
	}

	private String buildHeader() {
		StringBuilder header = new StringBuilder(" ");

		for (int i = 0; i < content[0].length; i++) {
			header.append(" ").append((char)('A' + i));
		}
		
		header.append("\n");
		return header.toString();
	}

	public String getPlayerAtField(int rowIndex, int columnIndex) {
		return content[rowIndex][columnIndex];
	}

	public boolean isEmptyField(int rowIndex, int columnIndex) {
		return content[rowIndex][columnIndex].equals(EMPTY_CELL);
	}

	public String currentPlayer() {
		return currentPlayer;
	}
	
	public int getTotRows() {
		return totRows;
	}
	
	public int getTotColumns() {
		return totColumns;
	}

	public void switchPlayer() {
		if ("X".equals(currentPlayer)) {
			currentPlayer = "O";
		} else {
			currentPlayer = "X";
		}
		
	}
}
