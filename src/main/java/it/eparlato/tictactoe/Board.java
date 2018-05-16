package it.eparlato.tictactoe;

import java.io.PrintStream;

public class Board {

	private static final String EMPTY_CELL = " ";
	private String[][] content;
	private PrintStream output;
	private int tot_rows;
	private int tot_columns;

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
	}

	public void takeField(String field) {
		content[0][0] = "X";
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
			body.append(i + 1).append(EMPTY_CELL);
			
			for (int j = 0; j < tot_columns; j++) {
				body.append(content[i][j]);
				
				if(j < tot_columns - 1) {
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
