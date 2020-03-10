package hashmap;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] nums) {
		
		if(!Optional.ofNullable(nums).isPresent() || nums.length == 0) {
			return 0;
		}
		
		
		Set<Integer> lookUpSet = new HashSet<>();
		
		for(int i=0;i < nums.length; i++) {
			lookUpSet.add(nums[i]);
		}
		
		int longestSeqSoFar = 1;
		
		
		//look for max continuous integers
		for(int num: lookUpSet) {
			
			//skip over numbers already seen as part of consecutive seq. of other number
			if(!lookUpSet.contains(num-1)) {
			
				int currentNum = num;
				int currentSeqLen = 1;
			
				//expand as par as possible from current number
				while(lookUpSet.contains(currentNum+1)) {
					currentNum +=1;
					currentSeqLen++;
				}
			
			 longestSeqSoFar = Math.max(currentSeqLen, longestSeqSoFar);
			}
			
		}
		
		return longestSeqSoFar;
        
    }

	public static void main(String[] args) {
		int[] nums = {-1, 0, 100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(nums));
	}

}
