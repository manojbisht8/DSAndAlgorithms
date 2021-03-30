package greedy;

/**
 * @see https://leetcode.com/problems/jump-game-ii/
 * @author mbisht
 *
 */
public class JumpGame2 {
	
	public int jump(int[] nums) {
		if(nums.length < 2) {
			return 0;
		}
		
		//define maxPos to be the maximum position that can be reached from this position i or before i
		int maxPos = nums[0];
		
		//maxSteps possible from current step
		int maxSteps = nums[0];
		
		int minCount = 1;
		
		for(int i=0; i<nums.length; i++){
			
			//if maxSteps from previous steps cann't  reach here, we need 1 mre step
			if(maxSteps < i) { 
				minCount++;
				maxSteps = maxPos; //greedly select the maxPos
			}
			
			maxPos = Math.max(maxPos, i+nums[i]);
		}
		
		return minCount;
   }

	public static void main(String[] args) {
		JumpGame2 j2 = new JumpGame2();
		System.out.print(j2.jump(new int[]{2,3,1,1,4}));

	}

}
