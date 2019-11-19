package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TransformOneStringToAnother {
	
	
	public static int transformDistance(Set<String> dict, String input, String dest) {
		
		//keep dictionary set in to-be-visited node
		Set<String> toBeVisited = new HashSet<>(dict);
		toBeVisited.remove(input);
		
		//apply BFS
		Queue<StringDistance> Q = new LinkedList<>();
		Q.add(new StringDistance(input, 0));
		
		while(!Q.isEmpty()) {
			StringDistance currentVertex = Q.poll();
			String currentStr = currentVertex.str;
			
			//check if dest string is found
			if(currentVertex.str.equals(dest)) {
				return currentVertex.distance;
			}
			
			//try all combinations to check if path exist from this string
			for(int i=0; i< currentStr.length(); i++) {
				String startPart = (i==0)? "": currentStr.substring(0, i);
				String endPart = (i+1 < currentStr.length())? currentStr.substring(i+1) : ""; //leave 1 char in between
				
				for(int c=0; c< 26; c++) { //for all chars fro 'a' to 'z'
					String newStr = startPart + (char) ('a' + c) + endPart;
					
					if(toBeVisited.contains(newStr)) {
						//path exist
						Q.add(new StringDistance(newStr, currentVertex.distance+1));
						toBeVisited.remove(newStr);
					}
				}
			}
			
			
		}
		
	
		return -1;
	}
	
	

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("bag");
		dict.add("mag");
		dict.add("mug");
		
		System.out.println(transformDistance(dict, "cat", "bag"));

	}

}

class StringDistance{
	String str;
	int distance;
	
	public StringDistance(String str, int dist) {
		this.str = str;
		this.distance = dist;
	}
	
}
