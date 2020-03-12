package miscellaneous;

import java.util.Arrays;

public class LeastNumOfPerfectSquares {
	
    public static int numSquares(int n) {
    	
    	//pre-compute number of squares and iterate over these within DP
    	// lookup[i] = min(all lookup[i-j] + 1) where k is num_of_squares
    	
    	int maxSquareNum = (int) Math.sqrt(n) +1;
    	
    	int[] squaresArray = new int[maxSquareNum];
    	
    	//create a squares array
    	for(int k=1; k < maxSquareNum; k++) {
    		squaresArray[k] = k*k;
    	}
    	
    	//create lookup table
    	int[] lookup = new int[n+1];
    	Arrays.fill(lookup, Integer.MAX_VALUE);
    	lookup[0] = 0; //base case
    	
    	for(int i=1; i<=n ; i++) {
    		//try out all squares
    		for(int k=1; k < squaresArray.length; k++) {
    			if(i >= squaresArray[k]) {
    				lookup[i] = Math.min(lookup[i], lookup[i-squaresArray[k]]+1);
    			}
    			
    		}
    	}
    	return lookup[n];
    }

	public static void main(String[] args) {
		System.out.print(numSquares(13));

	}

}
