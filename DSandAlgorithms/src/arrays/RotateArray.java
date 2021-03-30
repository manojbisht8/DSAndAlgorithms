package arrays;

/**
 * @see https://leetcode.com/problems/rotate-array/
 * @author Manoj Bisht
 *
 */
public class RotateArray {
	
	public static void rotate(int[] nums, int k) {
		if(nums == null || nums.length < 2 || k <1) {
			return;
		}
		
		int N = nums.length-1;
		int newPos = k;
		
		for(int i=0; i<= N; i++) {
			swap(nums, i, newPos);
			
			//set new position
			if(newPos > N) {
				newPos = (i+newPos)%N;
			} else {
			    newPos += i;
			}
		}
   }
	
	private static void swap(int[] nums, int origPos, int newPos) {
		int temp = nums[newPos];
		nums[newPos] = nums[origPos];
		nums[origPos] = temp;
	}

	public static void main(String[] args) {
		int[] input = {7,1,2,3,4,5,6};
		rotate(input, 1);
		for(int i: input) {
			System.out.print(i + " ");
		}

	}

}
