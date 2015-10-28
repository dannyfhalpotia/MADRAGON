import java.util.ArrayList;

public class Path {
	
	private ArrayList<Move> moves;
	public int length;
	
	public Path(int maxSteps){
		moves = new ArrayList<Move>();	
		this.length = moves.size();
	}
	
	public Move[] getPath(){
		return (Move[]) moves.toArray();
	}
	
	public void addMove(Move move) {
		moves.add(move);
		this.length = moves.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for(int i=0;i<this.length; i++) {
			sb.append(this.getPath()[i].toString());
			if(i != this.length - 1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
