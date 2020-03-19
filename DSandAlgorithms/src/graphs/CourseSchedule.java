package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
	
	/*
	 * Apply DFS with backtracking, tracking checked nodes
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		//create adjacency matrix graph with hashmap
		Map<Integer, List<Integer>> graphMap = new HashMap<>();
		
		for(int[] edege: prerequisites) {
			//edege 0, depends on edege 1
			if(graphMap.containsKey(edege[1])) {
				graphMap.get(edege[1]).add(edege[0]);
			} else {
				//create a new LinkedList
				List<Integer> nextCourses = new LinkedList<>();
				nextCourses.add(edege[0]);
				graphMap.put(edege[1], nextCourses);
			}
		}
		
		//create a visited path
		boolean[] visited = new boolean[numCourses];
		
		//create a already checked nodes
		boolean[] checked = new boolean[numCourses];
		
		//do a dfs on each course
		for(int currentCourse = 0;  currentCourse < numCourses; currentCourse++) {
			if(cycleExist(currentCourse, graphMap, visited, checked)) {
				return false;
			}
			
		}
		
		return true;
		
    }
	
	public boolean cycleExist(int currentCourse, Map<Integer, List<Integer>> graphMap,  boolean[] visited, boolean[] checked) {
		//if already checked, then no cycle existed at that node
		if(checked[currentCourse]) {
			return false;
		}
		if(visited[currentCourse]) {
			return true; //same node is visited again, so cycle exist
		}
		if(!graphMap.containsKey(currentCourse)) { //no dependencies for this node
			return false;
		}
		
		visited[currentCourse] = true;
		
		boolean result = false;
		
		for(int childCourse: graphMap.get(currentCourse)) {
			result = cycleExist(childCourse, graphMap, visited, checked);
			if(result) {
				break;
			}
		}
		
		//back track
		visited[currentCourse] = false;
		
		//check of this node is complete, so mark its as visited (PostOrder traversal)
		checked[currentCourse] = true;
		
		return result;
	}

	public static void main(String[] args) {
		int[][] input = {{1,0},
				{0,1}};
		
		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(2, input));

	}

}
