package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLongestSubArrayWithoutDuplicate {
	
	
	public static int getLongestSubArrayWithoutDuplicate(List<Character> array) {
		if(array == null || array.size() < 1) {
			return 0;
		}
		
		//keep track of last max sub-array index and move forward
		int result = 0, longestSubarrayStartIndex = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i < array.size(); i++) {
			
			if(map.containsKey(array.get(i))) {
				int lastDupIndex = map.get(array.get(i));
				if(lastDupIndex >= longestSubarrayStartIndex) {
					result = Math.max(longestSubarrayStartIndex, i-lastDupIndex);
					longestSubarrayStartIndex = i-lastDupIndex;
				}
			}
			
			//store char and its current index position in map
			map.put(array.get(i), i);
		}
		
		//for last portion of array, if longest sub-array is present at last position
		return Math.max(result, array.size()-longestSubarrayStartIndex);
	}

	public static void main(String[] args) {
		List<Character> input = new ArrayList<>();
		input.add('S');
		input.add('A');
		input.add('T');
		input.add('U');
		input.add('S');
		input.add('I');
		input.add('R');
		input.add('T');
		input.add('P');
		System.out.print(getLongestSubArrayWithoutDuplicate(input));

	}

}
