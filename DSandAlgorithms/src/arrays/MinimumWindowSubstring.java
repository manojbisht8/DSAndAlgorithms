package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @see https://leetcode.com/problems/minimum-window-substring/
 * @author mbisht
 *
 */
public class MinimumWindowSubstring {
	
	/**Sliding window approach, take two pointers.
	 * 1. Contract the sliding window from left, as long as all characters are in the window.
	 * 2. Expand the window from right if few characters are not in window. **/
	public String minWindow(String s, String t) {
		
		if (s.length() == 0 || t.length() == 0) {
	          return "";
	    }
		
		//create a frequency map for desired characters
		Map<Character, Integer> desiredCharMap = new HashMap<>();
		for(int i=0 ; i < t.length(); i++) {
			int count = desiredCharMap.getOrDefault(t.charAt(i), 0);
			desiredCharMap.put(t.charAt(i), count+1);
		}
		
		//variables for house-keeping
		int desiredUniqueChars = desiredCharMap.size();
		int formedUniqueChars = 0;
		
		//take 2 pointers
		int left=0, right = 0;
		
		//take an array for result
		int[] result = new int[3]; //index 0, min window size, 1: left and 2 right
		result[0] = -1;
		result[1] = 0;
		result[2] = 0;
		
		Map<Character, Integer> windowCharMap = new HashMap<>();
		
		//out loop to expand right
		while(right < s.length()) {
			
			//add right to windowMap
			char c = s.charAt(right);
			int count = windowCharMap.getOrDefault(c, 0);
			windowCharMap.put(c, count+1);
			
			//increment formedUniqueChars, if number of chars match
			
		    if(desiredCharMap.containsKey(c) && desiredCharMap.get(c).intValue() ==
			 windowCharMap.get(c).intValue()) { 
				 formedUniqueChars++;
			}
			 
			
			//keep contracting the window from left, till possible
			while(formedUniqueChars == desiredUniqueChars
					&& left <= right) {
				
				char cl = s.charAt(left);
				
				//check for minimum for result
				if(result[0] == -1 || result[0] > right-left+1) {
					result[0] = right-left+1;
					result[1] = left;
					result[2] = right;
				}
				windowCharMap.put(cl, windowCharMap.get(cl)-1);
				
				//decrement formedUniqueChars if chars count is reduces
				if(desiredCharMap.containsKey(cl) && desiredCharMap.get(cl).intValue() >
						 windowCharMap.get(cl).intValue()) { 
							 formedUniqueChars--;
				}
				left++;
			}
			//keep expanding right
			right++;
		}
		
		return result[0] == -1 ? "" : s.substring(result[1] , result[2]+1);
        
    }

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.print(mws.minWindow("ADOBECODEBANC", "ABC"));

	}

}
