package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @see https://leetcode.com/problems/word-ladder/solution/
 * @author manojbisht
 *
 */
public class WordLadder {
	
	/**
	 * Construct graph of words differing by just 1 character, and do BFS
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
			return 0;
		}
		int wordSize = beginWord.length(); //as all words are of same size
		
		
		Map<String, List<String>> mapGraph = constructGraph(wordList, wordSize);
		
		//create a queue for BFS
		Queue<GraphNode> Q = new LinkedList<>();
		Q.add(new GraphNode(beginWord, 1));
		
		//track visited
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		
		while(!Q.isEmpty()) {
			GraphNode currentNode = Q.poll();
			String currentWord = currentNode.word;
			int currentLvl = currentNode.level;
			
			//search with all combination of this currentWord
			for(int i=0; i< wordSize; i++) {
				String newWord = currentWord.substring(0, i) + "*" + currentWord.substring(i+1, wordSize);
				
				for(String adjWord: mapGraph.getOrDefault(newWord , new ArrayList<>())){
					
					//check if endWord is found
					if(endWord.equals(adjWord)) {
						return currentLvl+1; //found the word and level
					}
					if(!visited.contains(adjWord)) {
						Q.add(new GraphNode(adjWord, currentLvl+1));
						//mark it as visited
						visited.add(adjWord);
					}
				};
			}
		}
		
		return 0;
        
    }
	
	private Map<String, List<String>> constructGraph(List<String> wordList, int wordSize){
		Map<String, List<String>> mapGraph = new HashMap<>();
		wordList.forEach( word -> {
			for(int i=0; i< wordSize; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i+1, wordSize);
				//key is generic word, and value is list of actual  words which has same generic word 
				List<String> neighbourList = mapGraph.getOrDefault(newWord, new ArrayList<>());
				neighbourList.add(word);
				mapGraph.put(newWord, neighbourList);
				
			}
		});
		return mapGraph;
	}

	public static void main(String[] args) {
		String beginWord = "hot";
		String endWord = "dog";
		String[] wordArray = {"hot","dog","dot"};
		List<String> wordList = Arrays.asList(wordArray);
		
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));

	}

}

class GraphNode{
	String word;
	int level;
	
	public GraphNode(String word, int level) {
		this.word = word;
		this.level = level;
	}
}
