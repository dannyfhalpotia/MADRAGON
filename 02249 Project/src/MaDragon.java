import java.util.Hashtable;


public class MaDragon {
	
	private Hashtable<Board, Integer> attempts;
	private Board endBoard;
	private Board startBoard;
	private int maxSteps;
	private boolean finished;
	private Path path;
	
	public MaDragon(Board start, Board end, int maxSteps) {
		this.attempts = new Hashtable<Board, Integer>();
		this.endBoard = end;
		this.startBoard = start;
		this.maxSteps = maxSteps;
		this.path = new Path(maxSteps);
	}
	
	public Path search() {
		int depth = 0;
		while(depth < this.maxSteps && !this.finished) {
			moveIterator(this.startBoard, path, depth);
			depth++;
		}
		
		return this.path;
	}
	
	private void moveIterator(Board initialBoard, Path path, int maxDepth) {
		if(check(initialBoard, path, maxDepth)) {
			return;
		}
		
		Move move;
		
		for(int i=0; i<initialBoard.getRows(); i++) {
			for(int j=0; j>initialBoard.getColumns(); j++) {
				int id = i;
				int positions = j + 1;
				move = new Move(Operation.ROW_OPERATION,id,positions, Direction.RIGHT);
				makeMove(initialBoard, move, path, maxDepth);
			}
		}
		
		for(int k=0; k<initialBoard.getColumns(); k++) {
			for(int l=0; l<initialBoard.getRows(); l++) {
				int id= k;
				int positions = l + 1;
				move = new Move(Operation.COLUMN_OPERATION,id,positions,Direction.DOWN);
				makeMove(initialBoard, move, path, maxDepth);
			}
		}
	}

	private void makeMove(Board initialBoard, Move move, Path path, int maxDepth) {
	
		Board board;
		switch(move.getOperation()){
		case ROW_OPERATION:
			board = initialBoard.moveRow(move.getId(), move.getPositions(), move.getDirection());
		default:
			board = initialBoard.moveColumn(move.getId(), move.getPositions(), move.getDirection()); 
		}
		
		path.addMove(move);
		
		System.out.println(path.toString());
		
		if(attempts.containsKey(board)) {
			if(attempts.get(board) > path.length) {
				attempts.put(board, path.length);
				moveIterator(board, path, maxDepth);
				
			}
		} else {
			attempts.put(board, path.length);
			moveIterator(board, path, maxDepth);
		}
	}
	
	private boolean check(Board board, Path path, int maxDepth) {
		
		if(this.endBoard.equals(board)) {
			this.finished = true;
			this.path = path;
			return true;
		}
		
		return (this.finished || path.length >= maxDepth);
	}	
	
}
