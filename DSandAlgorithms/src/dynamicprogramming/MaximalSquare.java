package dynamicprogramming;

/**
 * @see https://leetcode.com/problems/maximal-square/
 * @author manojbisht
 *
 */
public class MaximalSquare {
	
	//create a dp[] with dp[i,j] holding maximum side length till that point
	//dp[i,j] = Math.min(L,R,D)+1
	public int maximalSquare(char[][] matrix) {
		
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		
		int R = matrix.length;
		int C = matrix[0].length;
		
		int[][] dp = new int[R+1][C+1];
		
		int maxSoFar = 0;
		
		for(int i=1; i<R; i++) {
			for(int j=1; j<C; j++) {
				if(matrix[i-1][j-1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
					maxSoFar = Math.max(maxSoFar, dp[i][j]);
				}
			}
		}
		return maxSoFar*maxSoFar;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
