package binarysearch;

public class FindPeakElement {
	
	public static int findPeakElement(int[] nums) {
        if(nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        int l =0, r = nums.length-1;
        
        //we just have to compare i and i+1 element
        while(l < r) {
        	int mid = (l+r)/2;
        	
        	if(nums[mid] > nums[mid+1]) {
        		r = mid; //peak can only be on left, it can be mid as well
        	} else {
        		l = mid+1; //peak is only on right
        	}
        }
        //in the endi we will be left with one element
        return l;
        
    }

	public static void main(String[] args) {
		int[] input = {1,2,1,3,5,6,4};
		System.out.print(findPeakElement(input));

	}

}
