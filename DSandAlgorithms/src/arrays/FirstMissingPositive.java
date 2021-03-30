package arrays;

/**
 * @see https://leetcode.com/problems/first-missing-positive/
 * @author mbisht
 *
 */
public class FirstMissingPositive {
	
	/**
	 * Use array nums as hash index and signs as present or not present
	 * @param nums
	 * @return
	 */
	public static int firstMissingPositive(int[] nums) {
		
		int N = nums.length;
		
		//cleanup and make all -ve and zeros and nums > N as 1
		
		//find if any 1 present, if not then 1 is answer
		boolean is1Present = false;
		for(int i=0; i< N; i++) {
			if(nums[i] == 1) {
				is1Present = true;
			} 
			if(nums[i] < 1 || nums[i] > N) {
				nums[i] = 1;
			}
		}
		
		if(!is1Present) {
			return 1;
		}
		
		if(N ==1) {
			return 2;
		}
		
		//make nums as hash key and make nums present as -ve
		for(int i=0; i< N; i++) {
			int a = Math.abs(nums[i]);
			
			if(a == N) {
				nums[0] = - Math.abs(nums[0]);
			} else {
				nums[a] = - Math.abs(nums[a]);
			}
		}
		
		//first non-ve index is answer
		for(int i=1; i< N; i++) {
			if(nums[i] > 0) {
				return i;
			}
		}
		
		if(nums[0] > 0) {
			return N;
		}
		
		return N+1; //default case
	}

	public static void main(String[] args) {
		System.out.print(firstMissingPositive(new int[]{7,8,9,11,12}));
	}

}
