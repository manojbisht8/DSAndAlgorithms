package twoDarrays;

public class SetMatrixZeros {
	
	/**
	 * Store rows, column information on zeroth row/column
	 * In second iteration make all those rows/columns zero.
	 * @param matrix
	 */
	public static void setZeroes(int[][] matrix) {
		
		if(matrix == null || matrix.length == 0) {
			return; //return early, as no elements to process
		}
		
		// make m[0][0] to store first row information,
		// make another variable to store column information
		
		boolean isFirstColumnZero = false;
		
		//first pass make zeroth row/column zero
		for(int i=0; i < matrix.length; i++) {
			
			if(matrix[i][0] == 0) {
				isFirstColumnZero = true; //handled first column
			}
			
			for(int j=1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//second pass, make all row/column zero if zeroth row/column is zero, 
		//********start from row 1 and column 1***************
		for(int i=1; i < matrix.length; i++) {
			for(int j=1; j < matrix[0].length; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(matrix[0][0] == 0) {
			//make entire first row zero
			for(int j=0; j<matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		
		//handle m[0][0] and isFirstColumnZero case
		if(isFirstColumnZero) {
			//make entire first column zero
			for(int i=0; i<matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = {
							 {0,1,2,0},
		                	 {3,4,5,2},
		                	 {1,3,1,5}
		                 };
		                 
		setZeroes(input);
		
		for(int i=0; i < input.length; i++) {
			for(int j=0; j < input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}

}
