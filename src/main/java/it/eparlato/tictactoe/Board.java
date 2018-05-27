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
	Map<String, Integer> columnsCoordinates;

	public Board(PrintStream output) {
		this(output, 3, 3);
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
		
		columnsCoordinates = new HashMap<String, Integer>();
		columnsCoordinates.put("A", 0);
		columnsCoordinates.put("B", 1);
		columnsCoordinates.put("C", 2);
	}
	
	public void takeField(String field, String player) {
		if (!field.toUpperCase().matches("[A-C][1-3]")) {
			return;
		}
		
		int rowIndex = getRowIndexFromFieldCoordinates(field);
		int columnIndex = getColumnIndexFromFieldCoordinates(field);
		
		content[rowIndex][columnIndex] = player;
	}

	private int getColumnIndexFromFieldCoordinates(String field) {
		return columnsCoordinates.get(field.substring(0, 1));
	}

	private Integer getRowIndexFromFieldCoordinates(String field) {
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

	public boolean haveAllFieldsBeenTaken() {
		for (int i = 0; i < tot_rows; i++) {
			for (int j = 0; j < tot_columns; j++) {
				
				if (content[i][j].equals(EMPTY_CELL)) {
					return false;
				}
			}
		}
		
		return true;
	}

	public boolean aRowHasBeenTakenByAPlayer() {
		for (int i = 0; i < tot_rows; i++) {
			if (allFieldsAreTakenByAPlayerOnRow(i)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean aColumnHasBeenTakenByAPlayer() {
		
		for (int j = 0; j < tot_columns; j++) {
			if (allFieldsAreTakenByAPlayerOnColumn(j)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean allFieldsAreTakenByAPlayerOnRow(int rowIndex) {
		
		if (content[rowIndex][0].equals(EMPTY_CELL)) {
			return false;
		}
		
		String player = content[rowIndex][0];
		
		for (int j = 1; j < tot_columns; j++) {
			if (!content[rowIndex][j].equals(player)) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean allFieldsAreTakenByAPlayerOnColumn(int columnIndex) {
		
		if (content[0][columnIndex].equals(EMPTY_CELL)) {
			return false;
		}
		
		String player = content[0][columnIndex];
		
		for (int i = 1; i < tot_rows; i++) {
			if (!content[i][columnIndex].equals(player)) {
				return false;
			}
		}
		
		return true;
	}

	public boolean upperLeftBottomRightDiagonalIsTakenByAPlayer() {
		if (content[0][0].equals(EMPTY_CELL)) {
			return false;
		}
		
		String player = content[0][0];
		
		for (int i = 1, j = 1; i < tot_rows && j < tot_columns; i++, j++) {
			
			if (!content[i][j].equals(player)) {
				return false;
			}
		}
		
		return true;
	}

	public boolean upperRightBottomLeftDiagonalIsTakenByAPlayer() {
		if (content[0][tot_columns - 1].equals(EMPTY_CELL)) {
			return false;
		}
		
		String player = content[0][2];
		
		for (int i = 1, j = 1; i < tot_rows && j >= 0; i++, j--) {
			if (!content[i][j].equals(player)) {
				return false;
			}
		}

		return true;
	}
}
