package graphs;

/**
 * @see https://leetcode.com/problems/surrounded-regions/
 * @author manojbisht
 *
 */
public class SurroundedRegion {
	
	private int[] ROWS = {1,-1,0,0};
	private int[] COLS = {0,0,-1,1}; //right,left,up,down
	
	/**
	 * From all 4 borders, do DFS and mark non-flipable cells
	 * @param board
	 */
	public void solve(char[][] board) {
		
		//validate
		if(board.length == 0) {
			return;
		}
		
		//top row
		for(int i=0; i< board[0].length; i++) {
			dfs(board, 0, i);
		}
		//left most col
		for(int i=0; i< board.length; i++) {
			dfs(board, i, 0);
		}
		//bottom row
		for(int i=0; i< board[board.length-1].length; i++) {
			dfs(board, board.length-1, i);
		}
		//right most col
		for(int i=0; i< board.length; i++) {
			dfs(board, i, board[0].length-1);
		}
		
		//mark all '0' as 'X'
		for(int i=0; i < board.length; i++) {
			for( int j=0; j< board[i].length; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if(board[i][j] == '-') {
					board[i][j] = 'O';
				}
			}
		}
        
    }
	
	/**
	 * Do DFS and mark cell as non-flippable "-"
	 * @param board
	 * @param row
	 * @param col
	 */
	private void dfs(char[][] board, int row, int col) {
		//return early for out of board cells
		if(row < 0 || row > board.length-1 || col < 0 || col > board[row].length-1) {
			return;
		}
		if(board[row][col] == 'X' || board[row][col] == '-') {
			return; //if already visited or "X"
		}
		//mark this cell as non-flippable "-"
		board[row][col] = '-';
		
		//iterate for all children
		for(int i=0; i < ROWS.length; i++) {
			int newRow = row + ROWS[i];
			int newCol = col + COLS[i];
			
			dfs(board, newRow, newCol);
		}
		
	}

	public static void main(String[] args) {
		/*char[][] board = {{'X','O','X','O','X','O'},
						  {'O','X','O','X','O','X'},
						  {'X','O','X','O','X','O'},
						  {'O','X','O','X','O','X'}};*/
		char[][] board = {{'O','O','O','O','X','X'},
				  		  {'O','O','O','O','O','O'},
				  		  {'O','X','O','X','O','O'},
				          {'O','X','O','O','X','O'},
				          {'O','X','O','X','O','O'},
				          {'O','X','O','O','O','O'}};
		
		SurroundedRegion sr = new SurroundedRegion();
		sr.solve(board);
		for(int i=0; i < board.length; i++) {
			for( int j=0; j< board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}
