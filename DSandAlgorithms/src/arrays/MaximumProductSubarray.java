package arrays;

public class MaximumProductSubarray {
	
	//n2 solution
	public static int maxProduct1(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		int maxProduct = Integer.MIN_VALUE;
		
		//calculate product from this location for all substrings
		for(int i=0; i< nums.length; i++) {
			int currentProduct = 1;
			for(int j=i; j<nums.length; j++) {
				currentProduct *=nums[j];
				maxProduct = Math.max(maxProduct, currentProduct);
			}
		}
		return maxProduct;
	}
	
	//n solution using max and min
	//because of -ve numbers, min may become max
	public static int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		int maxResult = nums[0];
		
		int maxProduct = nums[0], minProduct = nums[0];
		
		//calculate product from this location
		for(int i=1; i< nums.length; i++) {
			//if -ve number then min may be max
			if(nums[i] < 0) {
				//swap min and max
				int temp = maxProduct;
				maxProduct = minProduct;
				minProduct = maxProduct;
			}
			
			//update values, min/max is either current num of the products
			maxProduct = Math.max(maxProduct*nums[i], nums[i]);
			minProduct = Math.min(minProduct*nums[i], nums[i]);
			
			maxResult = Math.max(maxResult, maxProduct);
			
		}
		return maxResult;
	}

	public static void main(String[] args) {
		//int[] input = {2,3,-2,4};
		int[] input = {-2,0,-1};
		
		System.out.println(maxProduct(input));
		
		

	}

}
