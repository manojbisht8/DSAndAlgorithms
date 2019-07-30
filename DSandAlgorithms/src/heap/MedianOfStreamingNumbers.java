package heap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MedianOfStreamingNumbers {
	
	/**
	 * 
	 * @param inputList
	 * @return
	 */
	public static List<Double> getRunningMedian(Iterator<Integer> inputList){
		List<Double> result = new ArrayList<>();
		if(inputList == null) {
			return result;
		}
		/*
		 * Take a 2 heaps approach. Max-heap for all numbers smaller than median.
		 * Min-Heap for all numbers greater than Median.
		 * Regularly balance the heaps. Heap size can differ at-most by 1.
		 */
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		while(inputList.hasNext()) {
			int currentNum = inputList.next();
			
			//always add to min-heap
			minHeap.add(currentNum);
			
			//move min from minHeap to maxHeap
			maxHeap.add(minHeap.remove());
			
			//see if maxHeap is larger in size, then move elements as we pick median from  minHeap
			if(maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.remove());
			}
			
			result.add((maxHeap.size() == minHeap.size()) ? (double) (maxHeap.peek() + minHeap.peek())/2 : (double) minHeap.peek());
			
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(0);
		input.add(3);
		input.add(5);
		input.add(2);
		input.add(0);
		input.add(1);
		
		List<Double> result = getRunningMedian(input.iterator());
		result.forEach(System.out::println);
	}

}
