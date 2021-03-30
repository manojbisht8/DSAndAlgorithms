package graphs;

/**
 * @see https://leetcode.com/problems/friend-circles/
 * @author mbisht
 *
 */
public class FindCircles {
	
	/*1. Visualize this as undirected connected graph
	 * 2. Circles are same as finding number of islands
	 3. create a visited array to mark existing relationship.
	 */
	public int findCircleNum(int[][] M) {
		
		int N = M[0].length;
		
		//create a visited array
		int[] visited = new int[N];
		
		int numOfCircles = 0;
		
		//for each Friend do a DFS
		for(int i=0; i<N; i++) {
			if(visited[i] == 0) {
				dfs(M, visited, i, N);
				numOfCircles++;
			}
		}
		
		return numOfCircles;
    }
	
	private void dfs(int[][] M, int[] visited, int i, int N) {
		
		for(int j=0; j< N; j++) {
			if(visited[j] == 0) {
				if(M[i][j] == 1){
					visited[j] = 1; //transitive relationship
					dfs(M, visited, j, N);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = {{1,1,0},
		                 {1,1,0},
		                 {0,0,1}};
		
		FindCircles fc = new FindCircles();
		System.out.print(fc.findCircleNum(input));
	}

}
