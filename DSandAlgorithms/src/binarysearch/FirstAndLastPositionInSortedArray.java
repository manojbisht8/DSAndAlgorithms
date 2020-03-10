package binarysearch;

public class FirstAndLastPositionInSortedArray {
	
  public int[] searchRange(int[] nums, int target) {
	int[] result = {-1,-1};
	if(nums.length == 0) {
		return result;
	}
	
	int leftMost = getLeftMostPosition(nums, target);
	
	//validate boundaries and if target present
	if(leftMost >= nums.length || nums[leftMost] != target) {
		return result; //return early
	}
	
	result[0] = leftMost;
	result[1] = getRightMostPosition(nums, target);
	
	return result;
        
    }

   private int getLeftMostPosition(int[] nums, int target) {
	   int L = 0;
	   int R = nums.length;
	   
	   while(L < R ) {
		   int mid = (L+R)/2;
		   
		   if(nums[mid] > target  || target == nums[mid]) {
			   R = mid; //leftmost position can never be greater than mid in this case
		   } else {
			   L = mid+1;
		   }
	   }
	   return L;
   }
   
   private int getRightMostPosition(int[] nums, int target) {
	   int L = 0;
	   int R = nums.length;
	   
	   while(L < R ) {
		   int mid = (L+R)/2;
		   
		   if(nums[mid] > target) {
			   R = mid; //rightmost position can never be smaller than mid in this case
		   } else {
			   L = mid+1; 
		   }
	   }
	   return L-1;
   }

	public static void main(String[] args) {
		int[] input = {1};
		
		FirstAndLastPositionInSortedArray flpa = new FirstAndLastPositionInSortedArray();
		
		int[] result = flpa.searchRange(input, 1);
		
		System.out.println(result[0]);
		System.out.println(result[1]);

	}

}
