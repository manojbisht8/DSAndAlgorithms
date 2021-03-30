package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
	
	public static int[][] kClosest(int[][] points, int K) {
		
		if(points == null || points.length == 0) {
			return points;
		}
		
		//PriorityQueue to hold nearest K elements
		Queue<Point> maxHeap = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return Double.compare(p2.distance, p1.distance);
			}
		});
		
		for(int i=0; i< points.length; i++) {
			Point p = new Point(points[i]);
			maxHeap.add(p);
			
			if(maxHeap.size() > K) {
				maxHeap.poll(); //remove maxelement
			}
		}
		int[][] result = new int[maxHeap.size()][2];
		
		int count = 0;
		while(!maxHeap.isEmpty()) {
			result[count++] = maxHeap.poll().xy;
		}
		return result;
        
    }

	public static void main(String[] args) {
		int[][] input = {{3,3},
						{5,-1},
						{-2,4}};
		
		int[][] result = kClosest(input, 2);
		for(int[] i : result) {
			System.out.println(i[0] + "," + i[1]);
		}
	}
}

class Point{
	double distance;
	int[] xy;
	
	public Point(int[] pt) {
		this.distance = Math.sqrt(pt[0]*pt[0] + pt[1]*pt[1]);
		this.xy = pt;
	}
}
