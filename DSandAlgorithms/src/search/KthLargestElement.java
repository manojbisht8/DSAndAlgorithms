package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class KthLargestElement implements Comparator<Integer>{
	
	@Override
	public int compare(Integer a, Integer b) {
		
		return ((a > b) ? -1 : (a.equals(b)) ? 0 : 1);
		
	}
	
	public static int KthLargest(List<Integer> input, int k) {
		Comparator comp = new KthLargestElement();
		return getKthLargest(input, k, comp);
	}
	
	//partition like quick sort pivot. Don't have to compare if there are exactly k-1 elements on right side of pivot, etc....
	public static int getKthLargest(List<Integer> input, int k, Comparator comp) {
		int L = 0, R = input.size()-1;
		
		Random random = new Random(0);
		
		while(L <= R) {
			int pivot = random.nextInt(R-L + 1) + L;
			
			int newPivot = partitionOnPivot(L, R, pivot, input, comp);
		
			if(newPivot == k-1) {
				return input.get(newPivot);
			} else if(newPivot > k-1) {
				R = newPivot -1;
			} else {
				L = newPivot + 1;
			}
		}
		return -1;
	}
	
	public static int partitionOnPivot(int L, int R, int pivot, List<Integer> input, Comparator comp) {
		
		Integer pivotVal = input.get(pivot);
		int newPivotIndex = L ; //initialize pivot to left
		
		//save new Pivot index at the end
		Collections.swap(input, pivot, R);
		
		//partition
		for(int i = L; i < R; i++ ) {
			if(comp.compare(input.get(i), pivotVal) < 0) {
				Collections.swap(input, i, newPivotIndex++);
				//newPivotIndex++;
			}
		}
		
		//swap r to its correct new index position
		Collections.swap(input, newPivotIndex, R);
		
		return newPivotIndex;
		
	}
	
	
	
	

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(new Integer[]{3, 2, 1, 5, 4});
		System.out.println(KthLargest(input, 2));

	}



	

}
