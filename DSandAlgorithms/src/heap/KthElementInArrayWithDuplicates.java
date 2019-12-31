package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthElementInArrayWithDuplicates {
	
    public static int findKthLargest(int[] nums, int k) {
    	
    	Queue<Integer> PQ = new PriorityQueue<>(k);
    	
    	for(int i=0; i < nums.length; i++) {
    		if(PQ.size() >= k) {
    			int num = PQ.peek();
    			if(num <= nums[i]) {
    				PQ.poll();
    				PQ.add(nums[i]);
    			}
    		} else {
    			PQ.add(nums[i]);
    		}
    	}
    	return PQ.peek();
        
    }

	public static void main(String[] args) {
		int[] input = {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest(input, 4));

	}

}
