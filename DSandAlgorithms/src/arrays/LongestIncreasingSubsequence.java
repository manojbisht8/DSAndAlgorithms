 package arrays;

public class LongestIncreasingSubsequence {
	
    public static int lengthOfLIS(int[] nums) {
    	
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	
    	int[] lookUp = new int[nums.length];
    	lookUp[0] = 1;
    	
    	int longestSoFar = 1;
    	
    	for(int i=1; i < nums.length; i++) {
    		int maxVal = 0;
    		for(int j = 0; j < i; j++) { //spread as far as possible
    			if(nums[i] > nums[j]) {
    				maxVal = Math.max(maxVal, lookUp[j]);
    			}
    		}
    		lookUp[i] = maxVal +1; //current element would contribute 1 
    		longestSoFar = Math.max(longestSoFar, lookUp[i]);
    	}
    	
    	return longestSoFar;
        
    }

	public static void main(String[] args) {
		int[] input = {10,9,2,5,3,7,101,18};
		System.out.print(lengthOfLIS(input));

	}

}
