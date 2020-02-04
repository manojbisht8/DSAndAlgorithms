package graphs;

import java.util.ArrayList;
import java.util.List;

public class FindIslands {
	
	int[] ROWS = {0, 1, 0, -1}; //right, down, left, up
	int[] COLS = {1, 0, -1, 0}; //right, down, left, up
	
	public int numIslands(char[][] grid) {
		int N = grid.length;
		int M = grid[0].length;
		
		boolean[][] visited = new boolean[N][M];
		
		int islands = 0;
		for(int i=0; i < N; i++) {
			for(int j=0; j < M; j++) {
				if(isValidMove(i, j , grid, visited) && grid[i][j] == '1') {
					islands++;
					DFS(i, j, grid, visited);
				}
			}
		}
		return islands;
    }
	
	//perform DFS and mark cells as visited 
	private void DFS(int row, int col, char[][] grid, boolean[][] visited) {
		//mark this cell as visited
		visited[row][col] = true;
		
		//verify all 4 directions
		for(int i=0; i < ROWS.length; i++) {
			int newRow = row + ROWS[i];
			int newCol = col + COLS[i];
			if(isValidMove(newRow, newCol, grid, visited)){
				DFS(newRow,newCol, grid, visited);
			}
		}
	}
	
	private boolean isValidMove(int row, int col, char[][] grid, boolean[][] visited) {
		if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
			if(grid[row][col] == '1' && !visited[row][col]) { //if not yet visited
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] input = {{'1','1','0','0','0'},
						  {'1','1','0','0','0'},
				          {'0','0','1','0','0'},
				          {'0','0','0','1','1'}};
				
		FindIslands findIslands = new FindIslands();
		System.out.println(findIslands.numIslands(input));
	}

}
