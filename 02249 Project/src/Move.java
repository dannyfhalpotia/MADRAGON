
public class Move {

	private Operation operation;
	private int id;
	private int positions;
	private Direction direction;
	
	public Move(Operation op, int id, int positions, Direction direction) {
		this.operation = op;
		this.id = id;
		this.positions = positions;
		this.direction = direction;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPositions() {
		return positions;
	}

	public void setPositions(int positions) {
		this.positions = positions;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	// Override
	public String toString() {
		return "(" + this.operation.toString() + "," + this.id + "," + this.positions + "," 
				+ this.direction.toString() + ")";
	}
	
}
