package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset {
	
	public static List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        generateSubsets(nums, result, currentList, 0);
        return result;
    }
    
    private static void generateSubsets(int[] nums, List<List<Integer>> result,
                           List<Integer> currentList, int currentIndex){
        
        if(currentIndex == nums.length){
        	List<Integer> toAdd = new ArrayList(currentList);
            //Collections.copy(toAdd, currentList);
            result.add(toAdd);
            //reinitialize current list
            //currentList = new ArrayList();
            return;
        }
        //pick the current element
        currentList.add(nums[currentIndex]);
        generateSubsets(nums, result, currentList, currentIndex+1);
        
        //DO-NOT pick the current element
        currentList.remove(currentList.size() -1);
        generateSubsets(nums, result, currentList, currentIndex+1);
        
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		subsets(nums);
	}

}
