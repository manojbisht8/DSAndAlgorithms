package graphs;

/**
@see https://leetcode.com/problems/flood-fill/
*/
public class FloodFill {
	
	private int[] ROWS = {0, 1, 0, -1};
	private int[] COLS = {1, 0, -1, 0};
	
	private int VISITED = -1;
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image == null) {
			return image;
		}
		fill(image, sr, sc, newColor);
		
		//replace all visited by newColor
		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image[i].length; j++) {
				if(image[i][j] == VISITED) {
					image[i][j] = newColor;
				}
			}
		}
		return image;
		
	}
	
	public void fill(int[][] image, int row, int col,int newColor) {
		int oldColor = image[row][col];
		for(int i=0; i< ROWS.length; i++) { //search in all 4 directions
			//mark as visited
			image[row][col] = VISITED;
			if(isValidMove(image, row+ROWS[i], col+COLS[i], oldColor)){
				fill(image, row+ROWS[i], col+COLS[i], newColor);
			}
		}
	}
	
	boolean isValidMove(int[][] image, int row, int col,int oldColor) {
		
		if(row >=0 && row < image.length && col >= 0 && col < image[row].length
				&& image[row][col] == oldColor) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		FloodFill fl = new FloodFill();
		
		int[][] input = {{1,1,1},
				         {1,1,0},
				         {1,0,1}};
		
		/*int[][] input = {{0,0,0},
		         		{0,1,1}};*/
		int[][] result = fl.floodFill(input, 1, 1, 2);
		
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j] + ",");
			}
			System.out.println();
		}
	}

	

}
