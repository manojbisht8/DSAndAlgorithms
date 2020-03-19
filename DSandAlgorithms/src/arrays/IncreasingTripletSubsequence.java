package arrays;

/**
 * @see https://leetcode.com/problems/increasing-triplet-subsequence/
 * @author manojbisht
 *
 */
public class IncreasingTripletSubsequence {
	
	/**
	 * Take a 2 pointer approach tracking lower bounds for first and second elements
	 * @param nums
	 * @return
	 */
	public static boolean increasingTriplet(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return false;
		}
		
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		
		for(int i=0; i< nums.length; i++) {
			if(nums[i] <= first) {
				first = nums[i]; //update lower bound of first, smaller than both
			} else if (nums[i] > first &&  nums[i] <= second) {
				second = nums[i]; // greater than first but smaller than second
			} else {
				return true; //found the third number greater than both
			}
		}
		return false;
	}

	public static void main(String[] args) {
		//int[] input = {1,2,3,4,5};
		int[] input = {5,4,3,2,1};
		
		System.out.print(increasingTriplet(input));
		

	}

}
