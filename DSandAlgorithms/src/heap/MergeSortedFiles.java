package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeSortedFiles {
	
	/**
	 * 
	 * @param sortedArrays
	 * @return
	 */
	public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays){
		List<Integer> result = new ArrayList<>();
		
		if(sortedArrays == null || sortedArrays.size() == 0) {
			return result;
		}
		
		//create a min-heap
		PriorityQueue<ArrayElement> minHeap = getMinHeap(sortedArrays);
		
		//populate min-heap with first element from each array
		for(int i=0; i < sortedArrays.size(); i++) {
			minHeap.add(new ArrayElement(sortedArrays.get(i).get(0), i, 0));
		}
		
		//keep polling smallest from min-heap and keep adding to result
		while(!minHeap.isEmpty()) {
			ArrayElement headElement = minHeap.poll();
			result.add(headElement.val);
			//array is not-complete
			if(headElement.arrayIndex < sortedArrays.get(headElement.arrayNum).size()-1) {
				minHeap.add(new ArrayElement(sortedArrays.get(headElement.arrayNum).get(headElement.arrayIndex+1), 
						headElement.arrayNum, headElement.arrayIndex+1));
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param sortedArrays
	 * @return
	 */
	private static PriorityQueue<ArrayElement> getMinHeap(List<List<Integer>> sortedArrays){
		PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>(sortedArrays.size(),
				new Comparator<ArrayElement>() {
						@Override
						public int compare(ArrayElement ae1, ArrayElement ae2) {
							return Integer.compare(ae1.val, ae2.val);
						}
					});
		return minHeap;
	}
	
	

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(-5);
		list1.add(15);
		list1.add(20);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(16);
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(0);
		list3.add(6);
		list3.add(28);
		
		input.add(list1);
		input.add(list2);
		input.add(list3);
		
		List<Integer> result = mergeSortedArrays(input);
		result.forEach(System.out::println);
		

	}

}

//Helper class to hold element, array number and array index
class ArrayElement {
	int val;
	int arrayNum;
	int arrayIndex;
	
	public ArrayElement(int value, int arrayNum, int arrayIndex) {
		this.val = value;
		this.arrayNum = arrayNum;
		this.arrayIndex = arrayIndex;
	}
}
