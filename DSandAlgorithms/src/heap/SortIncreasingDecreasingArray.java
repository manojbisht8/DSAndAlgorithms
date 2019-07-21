package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIncreasingDecreasingArray {
	
	public static List<Integer> sortIncDecArray(List<Integer> inputArray){
		if(inputArray == null || inputArray.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		
		//collect all sub-lists, reverse the decreasing sublists
		List<List<Integer>> sortedArrayLists = new ArrayList<>();
		int startIndex = 0;
		SortType sortType = SortType.INCREASING;
		
		for(int i=1; i <= inputArray.size(); i++) {
			
			//monitor for increasing-decreasing points and store it as start point
			if(i==inputArray.size() //add last sublist
					|| (inputArray.get(i-1) > inputArray.get(i) && sortType == SortType.INCREASING)
					|| (inputArray.get(i-1) <= inputArray.get(i) && sortType == SortType.DECREASING)) {
				
				List<Integer> subList = inputArray.subList(startIndex, i);
				//reverse if it is decreasing array
				if(sortType == SortType.DECREASING) {
					Collections.reverse(subList);
				}
				
				sortedArrayLists.add(subList);
				
				//rest sort Order and start index
				startIndex = i;
				sortType = (sortType == SortType.INCREASING) ? SortType.DECREASING : SortType.DECREASING;
				
			}
		}
		
		return MergeSortedFiles.mergeSortedArrays(sortedArrayLists);
		
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(5); //inc
		input.add(10);
		input.add(16);
		
		input.add(13); //dec
		input.add(9);
		
		input.add(15); //inc
		input.add(19);
		input.add(21);
		input.add(24);
		
		input.add(20); //dec
		input.add(17);
		input.add(14);
		
		input.add(32); //inc
		input.add(35);
		
		List<Integer> result = sortIncDecArray(input);
		result.forEach(System.out::println);
		

	}
	
	private static enum SortType { INCREASING, DECREASING }

}
