package dynamicprogramming;

public class KnapSack {
	
	public static int maxValue(int W, int wt[], int val[], int n) {
		
		int[][] knapSack = new int[n+1][W+1];
		
		//fill look up bottom up
		for(int i=1; i <=n; i++) {
			for(int j=1; j <= W; j++) {
				
				if(wt[i-1] <= j) {
					knapSack[i][j] =  Math.max(knapSack[i-1][j], val[i-1] + knapSack[i-1][j-wt[i-1]]);
				} else {
					knapSack[i][j] = knapSack[i-1][j];
				}
				
			}
		}
		
		return knapSack[n][W];
	}

	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120}; 
        int wt[] = new int[]{10, 20, 30}; 
        int  W = 50; 
        int n = val.length; 
        System.out.println(maxValue(W, wt, val, n)); 
    } 

	

}
