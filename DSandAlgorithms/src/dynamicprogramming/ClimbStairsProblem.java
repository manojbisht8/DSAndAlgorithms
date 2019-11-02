package dynamicprogramming;

public class ClimbStairsProblem {
	
	
	//top-down approach
	public static int numOWays(int n, int steps, int[] lookUp) {
		
		if(n <= 1) {
			return 1;
		}
		
		if(lookUp[n] == 0) {
			
			for(int i = 1; i <= steps && (n - i >= 0); i++) {
				
				lookUp[n] = lookUp[n] + numOWays(n-i, steps, lookUp);
			}
		}
		return lookUp[n];
	}
	
	//bottom-up approach
	public static int numOWaysBottomUp(int n, int steps) {
		
		int[] lookUp = new int[n+1];
		
		lookUp[0] = 1;
		
		for(int i=1; i <= n; i++) {
			for(int j=1; j <= steps && (i-j) >=0; j++) {
				lookUp[i] = lookUp[i] + lookUp[i-j];
			}
		}
			
		return lookUp[n];
	}

	public static void main(String[] args) {
		
       int n=5;
       int steps=2;
	   int[] lookUp = new int[n+1];
	   
	   //System.out.println(numOWays(n, steps, lookUp));
	   System.out.println(numOWaysBottomUp(n, steps));

	}

}
