package binarysearch;

/**
 * @see https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @author manojbisht
 *
 */
public class SearchInRotatedSortedArray {
	
	/**
	 * Perform binary search to find pivot of rotation.
	 * Pivot is the minimum integer in array.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		int pivotIndex = findPivotIndex(nums);
		if(target == nums[pivotIndex]) {
			return pivotIndex;
		}
		
		int left=0, right = nums.length-1;
		
		//edge cases
		if(pivotIndex == 0) {
			return searchNum(nums, target, 0, nums.length-1);
		} 
		if(target < nums[0]) {
			return searchNum(nums, target, pivotIndex+1, nums.length-1); //search on right side
		}
		return searchNum(nums, target, left, pivotIndex-1); //search on left side
	}

	private static int searchNum(int[] nums, int target, int left, int right) {
		//perform standard binary search
		while(left <= right) {
			int mid = (left+right)/2;
			if(nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		
		return -1; //not found
	}
	
	private static int findPivotIndex(int[] nums) {
		int left=0, right = nums.length-1;
		
		while(left<= right) {
			int pivot = (left+right)/2;
			if((pivot+1 < nums.length) && (nums[pivot] > nums[pivot+1])) { //rotating point found
				return pivot+1;
			} else if (nums[left] > nums[pivot]) {
				right = pivot; //pivot on left side
			} else {
				left = pivot+1;
			}
		}
		return 0; //no pivot found, start is minimum number
	}

	public static void main(String[] args) {
		//int[] input = {4,5,6,7,0,1,2};
		int[] input = {5,1,3};
		System.out.print(search(input, 5));

	}

}
