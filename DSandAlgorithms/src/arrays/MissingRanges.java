package arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			getRange(lower, upper, result, false);
		}
		
		//add lower range
		if(lower < nums[0]-1) {
			getRange(lower, nums[0], result, false);
			
		}
		
		for(int i=0; i < nums.length-1; i++) {
			getRange(nums[i], nums[i+1], result, false);
		}
		
		//add upper range
		if(upper > nums[nums.length-1]) {
			getRange(nums[nums.length-1], upper, result, true);
		}
		
		return result;
    }
	
	public void getRange(int num1, int num2, List<String> result, boolean isLast) {
		String range = "";
		int diff = num2 - num1;
		if(diff >= 2) {
			range = range + (num1+1);
			if(diff >= 3) {
				int lastNum = isLast ? num2 : (num2-1);
				range = range + "->" + lastNum;
			}
		}
		if(range.length() > 0) {
			result.add(range);
		}
	}

	public static void main(String[] args) {
		int[] input = {0, 1, 3, 50, 75};
		
		MissingRanges ms = new MissingRanges();
		
		List<String> result = ms.findMissingRanges(input,  0, 99);
		result.forEach(System.out::print);

	}

}
