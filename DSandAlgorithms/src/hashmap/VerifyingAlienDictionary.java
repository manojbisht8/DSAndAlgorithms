package hashmap;

/**
 * @see https://leetcode.com/problems/verifying-an-alien-dictionary/
 * @author mbisht
 *
 */
public class VerifyingAlienDictionary {
	
	/*
	 * Use transitive property
	 * If A <= B < =C, it implies A<=C
	 * So we have to compare just adjacent words using alien dictionary.
	 */
	public boolean isAlienSorted(String[] words, String order) {
		
		int[] dict = new int[26];
		
		//construct dictionary
		for(int i=0; i<26; i++) {
			dict[order.charAt(i)-'a'] = i;
		}
		
		//compare adjacent words
		outer: for(int i=0; i< words.length-1; i++) {
			String firstWord = words[i];
			String secondWord = words[i+1];
			
			//compare position of each character of both words
			for(int j=0; j < Math.min(firstWord.length(), secondWord.length()); j++){
				if(firstWord.charAt(j) != secondWord.charAt(j)) {
					if(dict[firstWord.charAt(j)-'a'] >  dict[secondWord.charAt(j)-'a']){
						return false;
					}
					//words are in sorted order, continue to next set of words
					continue outer;
				}
			}
			if(firstWord.length() > secondWord.length()) {
				return false;
			}
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		VerifyingAlienDictionary va = new VerifyingAlienDictionary();
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(va.isAlienSorted(words, order));

	}

}
