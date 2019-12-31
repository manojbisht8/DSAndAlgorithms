package twoDarrays;

public class RotateImage90 {
	
	public void rotate(int[][] matrix) {
        
        int N = matrix[0].length;
        
        //Number of circular rings needed = N/2
        for(int x = 0; x < N/2; x++){
            //for each value in ring
            for(int y= x; y < N-x-1; y++){
                
                //store top-most to temp
                int temp = matrix[x][y];
                
                //move from left to top
                matrix[x][y] = matrix[N-y-1][x];
                
                //move from bottom to left
                matrix[N-y-1][x] = matrix[N-x-1][N-y-1];
                
                //move from right to bottom
                matrix[N-x-1][N-y-1] = matrix[y][N-1-x];
                
                //move from top to right
                matrix[y][N-1-x] = temp;
            }
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
