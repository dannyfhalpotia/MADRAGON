/**
 * Directions
 */
public enum Direction {

	LEFT("left"), 
	RIGHT("right"), 
	UP("up"), 
	DOWN("down");
	
private final String direction;
	
	private Direction(final String direction){
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return this.direction;
	}
}
