package binarysearch;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @see https://leetcode.com/problems/random-pick-with-weight/
 * @author mbisht
 *
 */
public class RandomPickWithWeight {
	
	int totalSum = 0;
	int[] wightSumArr = null;
	
	/**
	 * Visualize the Weighted Random pick is insertion sort.
	 * @param w
	 */
	public RandomPickWithWeight(int[] w) {
		wightSumArr = new int[w.length];
		
		for(int i=0; i< w.length; i++) {
			totalSum += w[i];
			wightSumArr[i] = totalSum;
		}
    }
    
    public int pickIndex() {
    	if(wightSumArr != null) {
    		double target = totalSum * Math.random();
    		int low = 0, high = wightSumArr.length;
    		while(low < high) {
    			int mid = low + (high-low)/2; //avoid overflow
    			
    			if(target > wightSumArr[mid]) {
    				low = mid+1;
    			} else {
    				high = mid;
    			}
    			
    			
    		}
    		return low;
    	}
    	return -1; //this should not occur
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
