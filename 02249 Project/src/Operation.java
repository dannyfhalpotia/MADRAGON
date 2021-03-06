
public enum Operation {
	

	ROW_OPERATION("Row"), 
	COLUMN_OPERATION("Column");
	
	private final String operation;
	
	private Operation(final String operation){
		this.operation = operation;
	}
	
	@Override
	public String toString() {
		return this.operation;
	}
}
