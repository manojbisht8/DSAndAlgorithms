package heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class FindMedianFromDataStream {
	
	Queue<Integer> minQ = null;
	Queue<Integer> maxQ = null;
	
	int size = 0;
	
	public FindMedianFromDataStream() {
        minQ = new PriorityQueue<Integer>();
        maxQ = new PriorityQueue<Integer>((n1, n2) -> {
        		return Integer.compare(n2, n1);
        	});
    }
    
    public void addNum(int num) {
    	if(size == 0) {
    		minQ.add(num);
    		size++;
    	} else {
    		Integer minNum = minQ.peek();
    		Integer maxNum = maxQ.peek();
    		
    		if(num < minNum) {
    			//add in minQ
    			maxQ.add(num);
    		} else {
    			minQ.add(num);
    		}
    		size++;
    		//balance Qs
    		if(minQ.size() > size/2) {
    			while(minQ.size() > size/2) {
    				maxQ.add(minQ.poll());
    			}
    		}
    		if(maxQ.size() > size/2) {
    			while(maxQ.size() > size/2) {
    				minQ.add(maxQ.poll());
    			}
    		}
    	}
    }
    
    public double findMedian() {
    	if(size ==0) {
    		return 0.0;
    	}
    	if(size%2 == 0) { //even size
    		return (minQ.peek() + maxQ.peek())/2d;
    	} //odd size
    	if(minQ.size() > maxQ.size()) {
    		return minQ.peek();
    	} else {
    		return maxQ.peek();
    	}
    }

	public static void main(String[] args) {
		FindMedianFromDataStream mds = new FindMedianFromDataStream();
		mds.addNum(1);
		//System.out.println(mds.findMedian());
		mds.addNum(2);
		//System.out.println(mds.findMedian());
		mds.addNum(3);
		//System.out.println(mds.findMedian());
		mds.addNum(4);
		System.out.println(mds.findMedian());

	}

}
