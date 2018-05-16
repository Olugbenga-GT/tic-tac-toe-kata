package it.eparlato.tictactoe;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Board {

	private static final String EMPTY_CELL = " ";
	private String[][] content;
	private PrintStream output;
	private int tot_rows;
	private int tot_columns;
	Map<String, Integer> rowsCoordinates;

	public Board(PrintStream output) {
		this(output, 1, 1);
	}

	public Board(PrintStream output, int tot_rows, int tot_columns) {
		this.output = output;
		this.tot_rows = tot_rows;
		this.tot_columns = tot_columns;
		
		build();
	}

	private void build() {
		content = new String[tot_rows][tot_columns];
		
		for (int i = 0; i < tot_rows; i++) {
			for (int j = 0; j < tot_columns; j++) {
				content[i][j] = EMPTY_CELL;
			}
		}
		
		rowsCoordinates = new HashMap<String, Integer>();
		rowsCoordinates.put("A", 0);
		rowsCoordinates.put("B", 1);
		rowsCoordinates.put("C", 2);
	}

	public void takeField(String field) {
		if (!field.toUpperCase().matches("[A-C][1-3]")) {
			return;
		}
		
		int rowIndex = getRowIndexFromFieldCoordinates(field);
		int columnIndex = getColumnIndexFromFieldCoordinates(field);
		
		content[rowIndex][columnIndex] = "X";
	}

	private int getColumnIndexFromFieldCoordinates(String field) {
		return Integer.parseInt(field.substring(1)) - 1;
	}

	private Integer getRowIndexFromFieldCoordinates(String field) {
		return rowsCoordinates.get(field.substring(0, 1));
	}

	public void print() {
		
		String header = buildHeader();
		String body = buildBody();
		
		output.print(header);
		output.print(body);
	}

	private String buildBody() {
		StringBuilder body = new StringBuilder();
		
		for (int i = 0; i < tot_rows; i++) {
			
			// Line number
			body.append(i + 1).append(EMPTY_CELL);
			
			for (int j = 0; j < tot_columns; j++) {
				body.append(content[i][j]);
				
				if(j < tot_columns - 1) {
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

}
