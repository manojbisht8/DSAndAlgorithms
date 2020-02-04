package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
	
	public static int minMeetingRooms(int[][] intervals) {
		
		//Store Intervals with min end time
		PriorityQueue<Interval> heap = new PriorityQueue<>();
		
		List<Interval> intvlList = new ArrayList<>();
		
		for(int i=0; i< intervals.length; i++) {
			intvlList.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		
		//sort by increasing start time
		Collections.sort(intvlList, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		//add first interval to heap
		heap.add(intvlList.get(0));
		
		//iterate over sorted start time interval list
		for(int i=1; i < intvlList.size(); i++) {
			if(heap.peek().end <= intvlList.get(i).start) {
				//same interval/room can be used
				heap.poll();
			}
			//add room to heap
			heap.add(intvlList.get(i));
			
		}
		
		return heap.size();
        
    }

	public static void main(String[] args) {
		int[][] input = {{0, 30},
						{5, 10},
						{15, 20}};
		
		System.out.println(minMeetingRooms(input));
	}
	

	

}

class Interval implements Comparable{
	int start;
	int end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Object o) {
		return this.end - ((Interval) o).end;
	}
}
