package it.eparlato.tictactoe;

public class Field {
	private int rowIndex;
	private int columnIndex;

	public Field(String fieldCoordinates) {
		rowIndex = getRowIndexFromFieldCoordinates(fieldCoordinates);
		columnIndex = getColumnIndexFromFieldCoordinates(fieldCoordinates);		
	}
	
	public Field(int rowIndex, int columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}

	private int getColumnIndexFromFieldCoordinates(String field) {
		String column = field.substring(0, 1);
		
		// TODO: should I use here equalsIgnoreCase to deal with lower-case letters? Write a test.
		
		if ("A".equals(column)) {
			return 0;
		}
		
		if ("B".equals(column)) {
			return 1;
		}
		
		return 2;
	}

	private Integer getRowIndexFromFieldCoordinates(String field) {
		return Integer.parseInt(field.substring(1)) - 1;
	}
	
	public int getRowIndex() {
		return rowIndex;
	}

	public int getColumnIndex() {
		return columnIndex;
	}
}
