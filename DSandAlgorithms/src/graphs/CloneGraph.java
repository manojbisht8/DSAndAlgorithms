package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	
	public static GraphVertex cloneGraph(GraphVertex input) {
		if(input == null) {
			return null;
		}
		
		//create a look up Map of already added Vertices
		Map<GraphVertex, GraphVertex> lookUpMap = new HashMap<>();
		Queue<GraphVertex> Q = new LinkedList<>();
		
		Q.add(input);
		
		//add to hashmap
		lookUpMap.put(input, new GraphVertex(input.val));
		
		while(!Q.isEmpty()) {
			GraphVertex origVertex = Q.poll();
			
			//for all edges of origVertex, check if it is already added in cloneGrpah/Map
			for(GraphVertex child: origVertex.egdes) {
				if(!lookUpMap.containsKey(origVertex)) {
					//add this new Vertex in clone
					lookUpMap.put(child, new GraphVertex(child.val));
					Q.add(child);
				}
			
			 //add this child as edge
				lookUpMap.get(origVertex).egdes.add(child);
			}
		}
		
		return lookUpMap.get(input);
		
		
	}

	public static void main(String[] args) {
		// Orig graph
		//         5
		//    8         10
		//           6     13
		
		GraphVertex v5 = new GraphVertex(5);
		GraphVertex v8 = new GraphVertex(8);
		GraphVertex v10 = new GraphVertex(10);
		GraphVertex v6 = new GraphVertex(6);
		GraphVertex v13 = new GraphVertex(13);
		
		//wire it up
		v5.egdes.add(v8);
		v5.egdes.add(v10);
		
		v10.egdes.add(v6);
		v10.egdes.add(v13);
		
		GraphVertex clonedGraph = cloneGraph(v10);
		System.out.println("Vertex val :"+ clonedGraph.val);

	}
}
	
	
	class GraphVertex{
		public int val;
		public List<GraphVertex> egdes;
		
		public GraphVertex(int val) {
			this.val = val;
			this.egdes = new ArrayList<>();
		}
	}


