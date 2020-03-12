package trie;

public class Trie {
	
	char key;
	Trie[] children;
	boolean endOfWord;
	
	public Trie() {
		this.children = new Trie[26];
   }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	
    	Trie currentTrie = this;
    	
    	for(int i=0; i < word.length(); i++) {
    		Trie childTrie = currentTrie.children[word.charAt(i) - 'a'];
    		if(childTrie == null) { //new Trie node needed
    			childTrie = new Trie();
    			childTrie.key = word.charAt(i);
    			currentTrie.children[word.charAt(i) - 'a'] = childTrie;
    		}
    		//increment currentTrie
    		currentTrie = currentTrie.children[word.charAt(i) - 'a'];
    	}
    	currentTrie.endOfWord = true;
    	
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie currentTrie = this;
    	
    	for(int i=0; i < word.length(); i++) {
    		Trie childTrie = currentTrie.children[word.charAt(i) - 'a'];
    		if(childTrie == null) { //new Trie node needed
    			return false;
    		}
    		//increment currentTrie
    		currentTrie = currentTrie.children[word.charAt(i) - 'a'];
    	}
    	return (currentTrie != null && currentTrie.endOfWord);
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie currentTrie = this;
    	
    	for(int i=0; i < prefix.length(); i++) {
    		Trie childTrie = currentTrie.children[prefix.charAt(i) - 'a'];
    		if(childTrie == null) { //new Trie node needed
    			return false;
    		}
    		//increment currentTrie
    		currentTrie = currentTrie.children[prefix.charAt(i) - 'a'];
    	}
    	return true;
    }

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true

	}

}
