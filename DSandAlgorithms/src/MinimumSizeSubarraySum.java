
/**
 * @see https://leetcode.com/problems/minimum-size-subarray-sum/
 * @author mbisht
 *
 */
public class MinimumSizeSubarraySum {
	
	public static int minSubArrayLen(int s, int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		//apply a sliding window approach
		int left =0, right = 0;
		int N = nums.length;
		
		int windowSum = 0;
		
		int minSoFar = Integer.MAX_VALUE;
		
		while(left <= right && right < N) {
			
			while(windowSum < s && right < N) { //keep expanding window right
				windowSum += nums[right];
				right++;
			}
			
			//contract window
			while(windowSum >= s && left <= right) {
				windowSum -= nums[left];
				left++;
				minSoFar = Math.min(minSoFar, right-left+1);
			}
		}
		//check edge case, not possible
		if(left==0 && right == N && windowSum < s) {
			return 0;
		}
		
		return minSoFar;
	}

	public static void main(String[] args) {
		int[] nums = {1,1};
		System.out.print(minSubArrayLen(15, nums));
	}

}
