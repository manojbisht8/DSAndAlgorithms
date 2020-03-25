package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @see https://leetcode.com/problems/course-schedule-ii/
 * @author manojbisht
 *
 */
public class CourseSchedule2 {
	
	/**
	 * Perform Topological order algorithm using in-degree count. 
	 * Because non-dependent/non-conflicting courses has zero in-degree.
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int[] topologicalOrder = new int[numCourses];
		
		int[] inDegreeLookup = new int[numCourses];
		
		//create a adjacency list graph with Hashmap
		Map<Integer, List<Integer>> graphMap = new HashMap<>();
		for(int[] relation: prerequisites) {
			List<Integer> list = graphMap.getOrDefault(relation[1], new LinkedList<>());
			list.add(relation[0]);
			graphMap.put(relation[1], list);
			
			inDegreeLookup[relation[0]] += 1; //add 1 degree
		}
		
		//create a Q of all nodes with zero-degree
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=0; i < inDegreeLookup.length; i++) {
			if(inDegreeLookup[i] == 0) {
				Q.add(i);
			}
		}
		
		int index = 0;
		while(!Q.isEmpty()) {
			int currentCourse = Q.poll();
			topologicalOrder[index++] = currentCourse;
			
			if(graphMap.containsKey(currentCourse)) {
				//explore all child nodes of currentCourse
				for(int childCourse: graphMap.get(currentCourse)) {
					//reduce in-degree
					inDegreeLookup[childCourse] -=1;
				
					//if in-degree =0, add it to Q
					if(inDegreeLookup[childCourse] == 0) {
						Q.add(childCourse);
					}
				}
			}
		}
		
		//if all nodes are in topological order
		if(index == numCourses) {
			return topologicalOrder;
		}
		return new int[0]; //return empty list, as no order is possible
	}
	
   public static void main(String[] args) {
		int[][] prerequisites = {{1,0}};
		
		CourseSchedule2 cs2 = new CourseSchedule2();
		int[] result = cs2.findOrder(2, prerequisites);
		for(int c: result) {
			System.out.println(c);
		}

	}

}
