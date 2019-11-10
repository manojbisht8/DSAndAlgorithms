package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FlipColor {
	
	private static int ROWS = 5;
	private static int COLS = 5;
	
	private static int[] rowsPos = {0, 0, -1, 1};
	private static int[] colsPos = {-1, 1, 0, 0}; //left, right, up, down
	
	//apply BFS
	public static void flipColor(char[][] grid, int row, int col) {
		char initialColor = grid[row][col];
		
		Queue<RowCol> Q = new LinkedList<>();
		Q.add(new RowCol(row, col));
		
		//flip color
		grid[row][col] = (initialColor == 'W') ? 'B' : 'W';
			
		while(!Q.isEmpty()) {
			RowCol currentRowCol = Q.poll();
			
			//flip color
			grid[currentRowCol.row][currentRowCol.col] = (initialColor == 'W') ? 'B' : 'W';
			
			//loop over children
			for(int i=0; i<4; i++) {
				int nextRow = currentRowCol.row + rowsPos[i];
				int nextCol = currentRowCol.col + colsPos[i];
				if(isValidMove(grid, nextRow, nextCol, initialColor)) {
					Q.add(new RowCol(nextRow,nextCol));
				}
			}
		}
	}
	
	private static boolean isValidMove(char[][] grid, int row, int col, char initialCol) {
		if(row >=0 && row <ROWS && col >=0 && col < COLS && grid[row][col] == initialCol) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		char M[][] = new char[][]
			{ { 'B', 'W', 'B', 'B', 'B' }, 
			  { 'W', 'W', 'B', 'B', 'B' }, 
			  { 'B', 'B', 'B', 'B', 'B'}, 
			  { 'B', 'W', 'W', 'W', 'B' }, 
			  { 'B', 'W', 'B', 'W', 'B' }};

			 flipColor(M, 0, 4);
		
			 //print flipped color
			 for(int i=0; i< 5; i++) {
				 for(int j=0; j< 5; j++) {
					 System.out.print(M[i][j] + "  ");
				 }
				 System.out.println();
			 }

	}

}

class RowCol{
	int row;
	int col;
	
	public RowCol(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
