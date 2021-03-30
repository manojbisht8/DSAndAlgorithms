package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @see https://leetcode.com/problems/partition-labels/
 * @author manojbisht
 *
 */
public class PartitionLabels {
	
	public static List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<>();
		if(S == null || S.length() < 1) {
			return result;
		}
		
		//create a lookup map, containing max position of an element
		int[] lookUpArr = new int[26];
		for(int i=0; i< S.length(); i++) {
			lookUpArr[S.charAt(i) - 'a'] = i;
		}
		
		//apply greedy approach, consider each partition
		int start =0, end =0;
		
		for(int i=0; i< S.length(); i++) {
			end = Math.max(end,  lookUpArr[S.charAt(i)-'a']);
			
			//if reached end of this partition
			if(i == end) {
				result.add(end-start+1);
				start = end+1; //start form next element
			}
		}
		
		return result;
        
    }

	public static void main(String[] args) {
		System.out.print(partitionLabels("abad"));

	}

}
