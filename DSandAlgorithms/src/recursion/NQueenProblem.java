package recursion;

public class NQueenProblem {

	public static boolean isNQueenPossible(int[][] board, int row) {
		if (row >= board.length) {
			return true; // all rows are explored, Queen placement possible
		}

		// for this row explore all columns
		for (int j = 0; j < board[0].length; j++) {
			if (isValidPos(board, row, j)) {
				board[row][j] = 1;

				if (isNQueenPossible(board, row + 1)) { // explore remaining rows and return true if all rows are
														// explored
					return true;
				}

				// back track from the started row
				board[row][j] = 0;
			}
		}

		// if queen cannot be placed in any column in this row, return false
		return false;
	}

	private static boolean isValidPos(int[][] board, int row, int col) {

		// look for previous rows
		for (int i = row; i >= 0; i--) {
			if (board[i][col] == 1) {
				return false;
			}
		}

		// look for previous columns
		for (int j = col; j >= 0; j--) {
			if (board[row][j] == 1) {
				return false;
			}
		}

		// look for previous diagonal -> left top
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		
		// look for previous diagonal -> left bottom
		for (int i = row, j = col; i <= board.length-1 && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		/*int board[][] = { { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } };*/
		
		int board[][] = { { 0, 0},
				{ 0, 0}};

		boolean solExist = isNQueenPossible(board, 0);
		System.out.println("Solution exist " + solExist);

		int N = 2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}

	}

}
