package arrays;

/**
 * @see https://leetcode.com/problems/jump-game/
 * @author manojbisht
 *
 */
public class JumpGame {
	
	public static boolean canJump(int[] nums) {
		if(nums == null || nums.length == 0) {
			return true;
		}
		
		boolean[] canReach = new boolean[nums.length];
		
		int N = nums.length-1;
		
		for(int i=nums.length-1; i >=0; i--) {
			int stepcounter = 0;
			while(stepcounter <= nums[i]) {
				if(stepcounter + i == N || canReach[stepcounter + i] == true) { //can reach final from this step
					canReach[i] = true;
					break;
				}
				stepcounter++;
			}
		}
		return canReach[0];
        
    }

	public static void main(String[] args) {
		//int[] input = {2,3,1,1,4};
		int[] input = {3,2,1,0,4};
		System.out.print(canJump(input));

	}

}
