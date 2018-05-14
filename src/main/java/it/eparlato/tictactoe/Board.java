package it.eparlato.tictactoe;

import java.io.PrintStream;

public class Board {

	private String[][] content = new String[][] {
			{" "}
	};
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
		
		content = new String[tot_rows][tot_columns];
		
		for (int i=0; i<tot_rows; i++) {
			for (int j=0; j<tot_columns; j++) {
				content[i][j] = " ";
			}
		}
	}

	public void takeField(String field) {
		content[0][0] = "X";
	}

	public void print() {
		
		// TODO: please refactor me
		
		String header = "";
		
		if(content[0].length == 1) {
			header = "  A\n";
		}
		if (content[0].length == 3) {
			header = "  A B C\n";
		}
		
		output.print(header);
		
		StringBuilder row;
		for (int i=0; i<tot_rows; i++) {
			row = new StringBuilder();
			
			row.append(i+1).append(" ");
			
			for(int j=0; j<tot_columns; j++) {
				row.append(content[i][j]);
				
				if(j < tot_columns - 1) {
					row.append("|");
				}
			}
			row.append("\n");
			
			output.print(row.toString());
		}
	}

}
