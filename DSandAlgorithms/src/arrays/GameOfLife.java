package arrays;

public class GameOfLife {
	
	
	static int[] ROWS = {-1, -1, -1, 0, 1, 1, 1, 0}; //
	static int[] COLS = {-1, 0,  1, 1, 1, 0, -1, -1};
	
	public static void gameOfLife(int[][] board) {
		
		int N = board.length;
		int M = board[0].length;
		
		int[][] result = new int[N][M];
		
		for(int i=0; i < N; i++) {
			for(int j=0; j < M; j++) {
				int sum = getNeighbourSum(board, i, j);
				if(sum < 2) {
					result[i][j] = 0;
				}
				if(board[i][j] == 1 && (sum == 2 || sum == 3)) {
					result[i][j] = 3;
				}
				if(sum > 3) {
					result[i][j] = 0;
				}
				if(sum == 3) {
					result[i][j] = 1;
				}
				
			}
		}
		for(int i=0; i < result.length; i++) {
			for(int j=0; j < result[0].length; j++) {
				//System.out.print(result[i][j] + " ");
				board[i][j] = result[i][j];
			}
			//System.out.println();
		}
		
        
    }
	
	private static int getNeighbourSum(int[][] board, int currRow, int currCol) {
		int sum =0;
		
		for(int i=0; i < ROWS.length; i++) {
			int nextRow = currRow + ROWS[i];
			int nextCol = currCol + COLS[i];
			
			if(nextRow >=0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
				sum += board[nextRow][nextCol];
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		int[][] input = {
		                 {0,1,0},
		                 {0,0,1},
		                 {1,1,1},
		                 {0,0,0}
		};
		
		gameOfLife(input);
		
		for(int i=0; i < input.length; i++) {
			for(int j=0; j < input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		
		

	}

}
