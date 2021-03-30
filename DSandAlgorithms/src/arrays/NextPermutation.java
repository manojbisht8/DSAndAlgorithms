package arrays;

/**
 * @see https://leetcode.com/problems/next-permutation/
 * @author mbisht
 *
 */
public class NextPermutation {
	
	/*
	 * 1. Start from end of array and find index such that nums[i-1] < nums[i]
	 * 2. Swap nums[i-1] with the number just greater than nums[i-1]
	 * 3. Since still after the swap, all elements to left of nums[i-1] are in descending order, we can reverse these in O(n)
	 */
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length < 2) {
			return;
		}
		
		int N = nums.length;
		
		//find first decreasing num from right
		int firstDec = N-2;
		
		while(firstDec >=0 && (nums[firstDec+1] <= nums[firstDec])) {
			firstDec--;
		}
		if(firstDec >= 0) {
			
		    //find index right of firstDec, which is just greater than nums[firstDec]
			int indexJustGreater = N-1;
			while(indexJustGreater >= 0 && (nums[indexJustGreater] <= nums[firstDec])) {
				indexJustGreater--;
			}
		
			//swap firstDec and indexJustGreater values
			swap(nums, firstDec, indexJustGreater);
		}
		
		//reverse the array from firstDec onwards
		int L= firstDec+1, R=N-1;
		
		while(L < R) {
			swap(nums, L, R);
			L++;
			R--;
		}
    }
	
	private void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}

	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = {1,2,3};
		np.nextPermutation(nums);
		
		for(int i: nums) {
			System.out.print(i + " ");
		}

	}

}
