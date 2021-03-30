package slidingwindow;

import java.util.ArrayDeque;

/**
 * @see https://leetcode.com/problems/sliding-window-maximum/
 * @author mbisht
 *
 */
public class SlidingWindowMaximum {
	
	/* 1. Take a Deque to hold window elements
	 * 2. Delete all elements smaller than the new element being added.
	 * 3. Clean up Deque to just hold window elements
	 */
	
	ArrayDeque<Integer> dq = new ArrayDeque<>();
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length*k == 0) { //either zero
        	return null;
        }
        if(k==1) {
        	return nums;
        }
        
        int N = nums.length;
        
        int[] result = new int[N-k+1];
        
        //fill-up dq with initial k elements
        int maxIndex = 0;
        for(int i=0; i < k; i++) {
        	cleanupDq(nums, i, k);
        	
        	//add from end
        	dq.addLast(i);
        	
        	if(nums[maxIndex] < nums[i]) {
        		maxIndex = i;
        	}
        }
        result[0] = nums[maxIndex];
        
        for(int i=k; i < N; i++) {
        	cleanupDq(nums, i, k);
        	
        	//add from end
        	dq.addLast(i);
        	
        	result[i-k+1] = nums[dq.getFirst()];
        }
        
        return result;
    }
	
	private void cleanupDq(int[] nums, int i, int k) {
		//maintain only window elements
		if(!dq.isEmpty() && dq.getFirst() == i-k) {
			dq.removeFirst(); //outside sliding window
		}
		
		//remove all elements less than nums[i]
		while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
			dq.removeLast();
		}
	}

	public static void main(String[] args) {
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		int[] input = {1,3,-1,-3,5,3,6,7};
		int[] result = swm.maxSlidingWindow(input, 3);
		
		for(int i=0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
