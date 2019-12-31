package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetGeneralSolutionsWithBacktracking {
	
	/****************************************SUBSET*******************************************/
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    //Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}
	
	private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
		result.add(new ArrayList<>(tempList));
		
		//for all remaining elements
		for(int i= start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(result, tempList, nums, i+1);
			//backtrack
			tempList.remove(tempList.size()-1);
		}
	}
	/*******************************************************************************************/
	
	/****************************************SUBSET WITH DUPLICATE******************************/
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        //sort list so that dups can be eliminated by comparing adjacent elements
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, new ArrayList<Integer>(), 0, result);
        return result;
        
    }
    
    private void subsetsWithDupHelper(int[] nums, List<Integer> tempList, int start,
                                      List<List<Integer>> result){
        //keep adding temp to result
        result.add(new ArrayList<>(tempList));
        
        //for all remaining elements calculate subsets
        for(int i= start; i < nums.length; i++){
            //do not add duplicate
            if(i > start && nums[i] == nums[i-1])
                continue;
            tempList.add(nums[i]);
            subsetsWithDupHelper(nums, tempList, i+1, result);
            tempList.remove(tempList.size()-1);  
        }
    }
	/*******************************************************************************************/
	

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = subsets(nums);
		result.forEach(list ->{
			list.forEach(i -> {
				System.out.print(i + " ");
			});
			System.out.println();
		});

	}

}
