package graphs;

public class FindIfPathExist {
	
	static int  ROWS = 5;
	static int  COLS = 5;
	
	static int[] rowPos = {0, 0, -1, 1 };  //left, right, up, down
	static int[] colPos = {-1, 1, 0 ,0 };
	
	private static boolean isValidMove(int[][] grid, int row, int col, int end) {
		
		if(row >=0 && row < ROWS && col >= 0 && col < COLS && ((grid[row][col] == 1 && grid[row][col] != -1) ||
				grid[row][col] == end)){
			return true;
		}
		
		return false;
	}
	
	//Apply DFS
	public static boolean ifPathExist(int[][] grid, int row, int col, int start, int end) {
		
		if(grid[row][col] == end) {
			return true;
		}
		
		//mark cell as visited
		grid[row][col] = -1;
		
		//check for each neighbour
		for(int i=0; i < 4; i++) {
			int nextRow = row + rowPos[i];
			int nextCol = col + colPos[i];
			
			if(isValidMove(grid, nextRow, nextCol, end)) {
				return ifPathExist(grid, nextRow, nextCol, start, end);
			}
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		//9 start, 99 end
		//0 wall, 1 empty
		int M[][] = new int[][] { { 9, 1, 0, 0, 0 }, 
            					  { 0, 1, 1, 0, 99 }, 
            					  { 1, 0, 0, 1, 1}, 
            					  { 0, 0, 0, 0, 0 }, 
            					  { 1, 0, 1, 0, 0 }};
         
        System.out.println(ifPathExist(M, 0, 0, 9, 99));

	}

}
