package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums); //to avoid duplicates
		Set<Integer> set = new HashSet<>(); //to check complementary sum
		Set<List<Integer>> dupLookUpSet = new HashSet<>();
		
		for(int i=0; i < nums.length; i++) {
			int num1 = nums[i];
			for(int j=i+1; j < nums.length; j++) {
				int num2 = nums[j];
				int complement = (num1+num2)*(-1);
				
				if(set.contains(complement)) { //triplet exists
					List<Integer> list = new ArrayList();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(complement);
					
					//check for duplicate
					if(!dupLookUpSet.contains(list)) {
						result.add(list);
						dupLookUpSet.add(list);
					}
					
				}
				
			}
			//add this num to set
			set.add(nums[i]);
		}
		return result;
    }
    
    

	public static void main(String[] args) {
		int[] input = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum(input);
		result.forEach(list -> {
			list.forEach(num -> {
				System.out.print(num + " ");});
			System.out.println();
		});

	}

}
