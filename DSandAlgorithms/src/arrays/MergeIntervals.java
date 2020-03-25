package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @see https://leetcode.com/problems/merge-intervals/
 * @author manojbisht
 *
 */
public class MergeIntervals {
	
	/**
	 * sort intervals in ascending order of start time, and then add merge in merged list increasing the intervals end time
	 * @param intervals
	 * @return
	 */
	public static int[][] merge(int[][] intervals) {
		
		if(intervals == null || intervals.length == 0) {
			return new int[0][0]; //return early
		}
		
		//sort array in ascending order of start time
		Arrays.sort(intervals, new IntervalComparator());
		
		LinkedList<int[]> mergedList = new LinkedList<>(); //we can easily fetch the last interval, to increase its end time
		
		for(int[] currentInverval: intervals) {
			
			if(mergedList.size() == 0) {
				mergedList.add(currentInverval); //ad first interval to start
			} else {
				if(mergedList.getLast()[1] >= currentInverval[0]) { //interval can be merged
					mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], currentInverval[1]);
				} else {
					//cannot be merged, add as it is
					mergedList.add(currentInverval);
				}
			}
			
		}
		return mergedList.toArray(new int[mergedList.size()][]);
	}

	public static void main(String[] args) {
		int[][] input = {{1,3},
						{2,6},
						{8,10},
						{15,18}};
		
		int[][] merged = merge(input);
		
		for(int[] interval: merged) {
			System.out.println(interval[0] + " " + interval[1]);
		}
		

	}
}



class IntervalComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] arr1, int[] arr2) {
		return (arr1[0] > arr2[0]) ? 1: (arr1[0] < arr2[0]) ? -1:0;
		
	}
}
