public class Board {
	
	private char[][] layout;
	private int rows;
	private int columns;
	
	
	public Board(int n, int m, String[] rows) {
		
		this.layout = new char[n][m];
		this.rows = n;
		this.columns = m;
		
		for(int i=0; i<n; i++) {
			String line = rows[i];
			
			for(int j=0; j<line.length(); j++)
			{
				char c = line.charAt(i);
				layout[i][j] = c;
			}
		}
	}
	
	/**
	 * Makes a deep copy of the layout of another Board
	 * @param layout
	 */
	public Board(char[][] layout, int n, int m) {
		
		char[][] copy = new char[n][m];
		this.rows = n;
		this.columns = m;
		
		for(int i=0; i< layout.length; i++) {
			char[] row = new char[layout[i].length];
			System.arraycopy(layout[i], 0, row, 0, layout[i].length);
			copy[i] = row;
		}
		
		this.layout = copy;
	}
	
	public Board moveRow(int rowNumber, int positions, Direction direction) {
		
		String row = String.valueOf(layout[rowNumber]);
		
		switch(direction){
		case LEFT:
			layout[rowNumber] = moveLeft(row, positions);
			break;
		case RIGHT:
			layout[rowNumber] = moveRight(row, positions);
		default:
			break;
		}
		
		return new Board(this.layout, this.rows, this.columns);
	}
	
	public Board moveColumn(int columnNumber, int positions, Direction direction){
		
		StringBuilder originalRow = new StringBuilder();
		char[] modified = new char[layout.length];
		
		for(int i=0; i<layout.length; i++) {
			originalRow.append(layout[i][columnNumber]);
		}
		
		switch(direction) {
		case UP:
			modified = moveLeft(originalRow.toString(), positions);
			break;
		case DOWN:
			modified = moveRight(originalRow.toString(), positions);
			break;
		default:
			break;
		}
		
		for(int i=0; i<layout.length; i++) {
			layout[i][columnNumber] = modified[i];
		}
		
		return new Board(this.layout, this.rows, this.columns);
	}
	
	private char[] moveLeft(String original, int positions) {

		StringBuilder sb = new StringBuilder();
		sb.append(original.substring(original.length() - positions, original.length()));
		sb.append(original.substring(0, original.length() - positions));
		
		return sb.toString().toCharArray();
	}
	
	private char[] moveRight(String original, int positions) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(original.substring(original.length() - positions, original.length()));
		sb.append(original.substring(0, positions));
		
		return sb.toString().toCharArray();		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < rows; i++) {
			for(int j=0; j< columns; j++) {
				sb.append(layout[i][j]);
			}
		}	
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Board)) return false;
		Board otherBoard = (Board)obj;
		
		return this.toString().equals(otherBoard.toString());
	}

	public int getRows() {
		return this.rows;
	}
	
	public int getColumns() {
		return this.columns;
	}
}
