package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthElementInSortedMatrix {
	
	public static int kthSmallest(int[][] matrix, int k) {
		
		//keep a heap, for k items
		Queue<Element> pq = new PriorityQueue<>(new ElementComparator());
		
		int N = matrix[0].length;
		
		//add first column elements in heap
		for(int i=0; i < N; i++) {
			pq.add(new Element(i, 0, matrix[i][0]));
		}
		
		//keep replacing the first k by the min elements from corresponding row
		for(int i=1; i < k; i++) {
			Element currentMin = pq.poll();
			if(currentMin.col < N-1) {
				//add next
				pq.add(new Element(currentMin.row, currentMin.col+1, matrix[currentMin.row][currentMin.col+1]));
			}
		}
		
		return pq.peek().val;
        
    }

	public static void main(String[] args) {
		int[][] matrix = {	{1, 3, 5},
							{2, 4, 6},
							{7, 8, 9}};
		
		System.out.print(kthSmallest(matrix, 6));

	}

}



class Element{
	
	int row;
	int col;
	int val;
	
	public Element(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
	
}

class ElementComparator implements Comparator<Element>{

	@Override
	public int compare(Element o1, Element o2) {
		return Integer.compare(o1.val, o2.val);
	}
	
}
