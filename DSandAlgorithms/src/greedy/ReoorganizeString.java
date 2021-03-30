package greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReoorganizeString {
	
	public String reorganizeString(String S) {
		
		if(S == null || S.length() < 1) {
			return S;
		}
		
		int N = S.length();
		
		//create a char frequency counter
		int[] counter = new int[26];
		for(char c: S.toCharArray()) {
			counter[c-'a'] += 1;
		}
		
		//create a Heap with most frequent chars first (greedy)
		Queue<CharCount> pq = new PriorityQueue<>( (a,b) -> {
			return (a.count == b.count) ? a.character - b.character : b.count - a.count;
		});
		
		for(int i=0; i< 26; i++) {
			int count = counter[i];
			if(count > 0) {
				//return not possible if count > (N+1)/2
				if(count > (N+1)/2) {
					return "";
				}
				CharCount charCount = new CharCount((char) (i+'a'), count);
				pq.add(charCount);
			}
		}
		
		//take first 2 characters from PQ and start arranging these alternatively
		String result = "";
		while(pq.size() > 1) {
			CharCount cc1 = pq.poll();
			CharCount cc2 = pq.poll();
			
			if(result == "" || result.charAt(result.length()-1) != cc1.character){
				result += cc1.character;
				result += cc2.character;
			} else {
				result += cc2.character;
				result += cc1.character;
			}
			
			//reduce counters
			if(--cc1.count > 0) {
				pq.add(cc1);
			}
			if(--cc2.count > 0) {
				pq.add(cc2);
			}
			
		}
		//if still an element left
		if(pq.size() > 0) {
			result += pq.poll().character;
		}
		
		return result;
	}

	public static void main(String[] args) {
		ReoorganizeString rs = new ReoorganizeString();
		System.out.print(rs.reorganizeString("vvvlo"));

	}

}

class CharCount{
	char character;
	int count;
	
	public CharCount(char c, int count) {
		this.character = c;
		this.count = count;
	}
}
