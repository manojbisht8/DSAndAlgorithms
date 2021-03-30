package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	
	
	
	public List<String> topKFrequent(String[] words, int k) {
		
		if(words == null || words.length == 0 || k < 1) {
			return Collections.EMPTY_LIST;
		}
		
		String[] result = new String[k];
		
		//create a word frequency map
		Map<String, Integer> wordFreqMap = new HashMap<>();
		
		for(String word: words) {
			if(wordFreqMap.containsKey(word)) {
				int counter = wordFreqMap.get(word);
				wordFreqMap.put(word, counter+1);
			} else {
				wordFreqMap.put(word, 1);
			}
		}
		
		//create a PriorityQueue from frequencyMap
		Queue<WordCount> pq = getPriorityQueue(wordFreqMap, k);
		
		int index = k-1;
		while(!pq.isEmpty()) {
			result[index--] = pq.poll().word;
		}
		
		return Arrays.asList(result);
    }
	
	private Queue<WordCount> getPriorityQueue(Map<String, Integer> freqMap, int k){
		Queue<WordCount> pq = new PriorityQueue<>(k, new Comparator<WordCount>() {
			@Override
			public int compare(WordCount wc1, WordCount wc2) {
				int compVal = Integer.compare(wc1.count,  wc2.count);
				if(compVal == 0) {
					return wc2.word.compareTo(wc1.word);
				}
				return compVal;
			}
				
		});
		
		freqMap.keySet().stream().forEach(w ->{
			WordCount wc = new WordCount(w, freqMap.get(w));
			pq.add(wc);
			if(pq.size() > k) {
				pq.poll();
			}
		});
		
	 return pq;
		
	}

	public static void main(String[] args) {
		TopKFrequentWords tfw = new TopKFrequentWords();
		String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
		List<String> result = tfw.topKFrequent(input,  3);
		result.forEach(System.out::println);

	}

}

class WordCount{
	public String word;
	public Integer count;
	
	public WordCount(String word, Integer count) {
		this.word = word;
		this.count = count;
	}
}
