package recursion;

/**
 * @see https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @author manojbisht
 *
 */
public class LongestSubstringAtLeastKRepeatChars {
	
    public int longestSubstring(String s, int k) {
    	
    	if(s==null || s.length() == 0) {
    		return 0;
    	}
    	return divide(s, 0, s.length(), k);
        
    }
    
    /**
     * Split the string on not sufficient char, as this can never be on the final substring
     * @param s
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int divide(String s, int start, int end, int k) {
    	//base case 1
    	if(end-start < k) { //substring cannot be smaller than k
    		return 0;
    	}
    	
    	//create a char freq table
    	int[] charCount = new int[26];
    	for(int i=start; i <end; i++) {
    		int index = s.charAt(i)-'a';
    		charCount[index] += 1; 
    	}
    	
    	//loop over all the freq count chars
    	for(int i=0; i< charCount.length; i++) {
    		//identify not sufficient char to split
    		if(charCount[i] > 0 && charCount[i] < k) {
    			
    			//look for each occurance of this char in the substring between start and end
    			for(int j=start; j <end; j++) {
    				if(s.charAt(j) == i+'a') {
    					int left = divide(s, start, j, k);
    					int right = divide(s, j+1, end, k);
        			
    					return Math.max(left, right); //whichever side gives longest string
    				}
    				
    			}
    			
    		}
    	}
    	
    	//base case 2
    	//if every char occurs k times, then this is valid string, return its length
    	return end-start;
    	
    }

	public static void main(String[] args) {
		String input = "aaabb";
		
		LongestSubstringAtLeastKRepeatChars sol = new LongestSubstringAtLeastKRepeatChars();
		System.out.print(sol.longestSubstring(input, 3));
		

	}

}
