import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	
	private static int rows;
	private static int columns;
	private static int steps;

	public static void main(String[] args) throws IOException
	{
		try{
			
			Board[] boards = readFile(args[0]);
			
			Board startBoard = boards[0];
			Board endBoard = boards[1];
			MaDragon maDragon = new MaDragon(startBoard, endBoard, steps);
			Path path = maDragon.search();
			
			System.out.println(path.toString());
			System.out.println("Checkpoint");
			System.in.read();
			
		} catch(IOException e) {
			e.printStackTrace();
			return;
		}
		
	}
		
	public static Board[] readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		try {
				
			rows = Integer.parseInt(br.readLine());
			columns = Integer.parseInt(br.readLine());
			steps = Integer.parseInt(br.readLine());
			
			char[][] board1 = new char[rows][columns];
			char[][] board2 = new char[rows][columns];
			
			int lines = 2 * rows;
			for(int i=0; i< lines; i++) {
				char[] line = br.readLine().toCharArray();
				if(line.length > columns) {
					System.out.println(line);
				}
				if(line != null) {
					if(i < rows)
					{
						board1[i] = line;
						
					}
					else {
						board2[i%rows] = line;
					}	
				}
				else {
					break;
				}
			}
			
			Board[] boards = new Board[2];
			boards[0] = new Board(board1,rows,columns);
			boards[1] = new Board(board2,rows,columns);
			
			//System.out.println(boards[0].toString());
			return boards;
			
		} finally {
			br.close();
		}
		
	}
}
