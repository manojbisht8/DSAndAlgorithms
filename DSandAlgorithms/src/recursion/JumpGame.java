package recursion;

import java.util.Arrays;

public class JumpGame {
	
	public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
			return true;
		}
        
        STATE[] memo = new STATE[nums.length];
        Arrays.fill(memo, STATE.UNKNOWN);
        memo[nums.length-1] = STATE.CAN_REACH; //can reach from last index
        return canJumpFromPosition(0, nums, memo);
	}
	
	private static boolean canJumpFromPosition(int pos, int[] nums, STATE[] memo) {
		
		if(memo[pos] != STATE.UNKNOWN) {
			return memo[pos] == STATE.CAN_REACH ? true : false;
		}
		
		int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPosition = pos + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums, memo)) {
                memo[pos] = STATE.CAN_REACH;
                return true;
            }
        }
			
		//backtrack
		memo[pos] = STATE.CANNOT_REACH;
		return false;
	}

	public static void main(String[] args) {
		//int[] input = {2,3,1,1,4};
		int[] input = {3,2,1,0,4};
		System.out.print(canJump(input));
	}

}

enum STATE {
	CAN_REACH, CANNOT_REACH, UNKNOWN;
}
