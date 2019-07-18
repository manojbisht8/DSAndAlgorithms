package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLongestStringsInSequence {
	
	public static List<String> topK(int k, List<String> stringSeq){
		if(stringSeq == null || stringSeq.size() == 0) {
			return null;
		}
		
		//create a min-heap
		PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		for(String str: stringSeq) {
			minHeap.add(str);
			if(minHeap.size() > k) {
				//remove the smallest
				minHeap.poll();
			}
		}
		
		return new ArrayList<>(minHeap);
	}

	public static void main(String[] args) {
		List<String> inputList = new ArrayList<>();
		inputList.add("Washington");
		inputList.add("Texas");
		inputList.add("NewYork");
		inputList.add("Oragon");
		inputList.add("Arizona");
		inputList.add("Alaska");
		
		List<String> result = topK(3, inputList);
		result.forEach(System.out::println);
	}

}
