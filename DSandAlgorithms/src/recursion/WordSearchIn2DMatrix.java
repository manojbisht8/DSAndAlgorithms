package recursion;

public class WordSearchIn2DMatrix {
	
	int[] ROWS = {0, 0, -1, 1}; //right, left, up, down
	int[] COLS = {1, -1, 0, 0};
	
	public boolean exist(char[][] board, String word) {
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(backTrack(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
        
    }
	
	private boolean backTrack(char[][] board, String word, int currentIndex, int row, int col) {
		//if complete word is present
		if(currentIndex >= word.length()) {
			return true;
		}
		char currentChar = word.charAt(currentIndex);
		if(!isValidMove(board, row, col, currentChar)){
			return false;
		}
		
		//mark current cell as visited
		board[row][col] = '*';
		
		boolean found = false;
		
		//try in all 4 directions
		for(int i=0; i<ROWS.length; i++) {
			int nextRow = row + ROWS[i];
			int nextcol = col + COLS[i];
			
			found = backTrack(board, word, currentIndex+1, nextRow, nextcol);
			if(found) {
				break;
			}
		}
		//backtrack
		board[row][col] = currentChar;
		return found;
	}
	
	private boolean isValidMove(char[][] board, int row, int col, char currentChar) {
		if(row >=0 && row < board.length && col >=0 && col < board[0].length && board[row][col] == currentChar) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board =
				{
				  {'A','B','C','E'},
				  {'S','F','C','S'},
				  {'A','D','E','E'}
				};
		
		WordSearchIn2DMatrix ws = new WordSearchIn2DMatrix();
		//System.out.println(ws.exist(board, "ABCCED"));
		//System.out.println(ws.exist(board, "SEE"));
		System.out.println(ws.exist(board, "ABCB"));
	}

}
