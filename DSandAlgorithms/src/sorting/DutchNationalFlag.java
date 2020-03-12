package sorting;

public class DutchNationalFlag {
	
	public static void sortColors(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		
		//take 3 pointers approach
		//all 0s at start, all 1s in middle and all 2's at end
		//zeroPointer, current, twoPointer
		
		int zeroPointer = 0, current = 0;
		int twoPointer = nums.length-1;
		
		while(current <= twoPointer) {
			//replace 0 with zeroPointer
			if(nums[current] == 0) {
				int temp = nums[zeroPointer];
				nums[zeroPointer] = nums[current];
				nums[current] = temp;
				zeroPointer++;
				current++;
			} else if(nums[current] == 2) {
				int temp = nums[twoPointer];
				nums[twoPointer] = nums[current];
				nums[current] = temp;
				twoPointer--;
			} else {
				current++;
			}
		}
        
    }

	public static void main(String[] args) {
		int[] input = {2,0,2,1,1,0};
		sortColors(input);
		
		for(int i: input) {
			System.out.print(i + " ");
		}

	}

}
