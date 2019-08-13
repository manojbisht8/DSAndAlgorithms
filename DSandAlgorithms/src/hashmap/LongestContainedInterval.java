package hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LongestContainedInterval {
	
	public static int getLongestContainedInterval(List<Integer> input) {
		if(input == null || input.size() == 0) {
			return 0;
		}
		//make a hash lookup table
		Iterator<Integer> iterator = input.iterator();
		Set<Integer> unprocessedSet = new HashSet<>(input);
		
		
		//for each element in input, try to expand both side as much as possible
		int longestInterval = 0;
		while(!unprocessedSet.isEmpty()) {
			int currentInt = iterator.next();
			
			if(unprocessedSet.contains(currentInt)) {
				unprocessedSet.remove(currentInt); //remove to avoid duplicate computation for same element
				
				//compute lower limit
				int lowerLimit = currentInt-1;
				while(unprocessedSet.contains(lowerLimit)) {
					unprocessedSet.remove(lowerLimit);
					--lowerLimit;
				}
				
				//compute upper limit
				int upperLimit = currentInt+1;
				while(unprocessedSet.contains(upperLimit)) {
					unprocessedSet.remove(upperLimit);
					++upperLimit;
				}
				
				longestInterval = Math.max(longestInterval, upperLimit-lowerLimit-1);
			}
		}
		
		return longestInterval;
	}
	

	public static void main(String[] args) {
		//Integer[] intarray = {3,-2,7,9,8,1,2,0,-1,5,8};
		Integer[] intarray = {10,5,3,11,6,10,4};
		List<Integer> input = Arrays.asList(intarray);
		System.out.print(getLongestContainedInterval(input));

	}

}
