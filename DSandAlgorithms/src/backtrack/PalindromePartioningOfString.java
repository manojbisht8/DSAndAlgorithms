package backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioningOfString {
	
	public List<List<String>> partition(String s) {
		
		List<List<String>> result = new ArrayList<>();
		if(s == null || s.length() == 0) {
			return result;
		}
		generatePalindromicPartition(s, 0, new ArrayList<>(), result);
		
		return result;
        
    }
	
	//From each position i in string, compute if the remaining string can be partitioned for palindrome
	public void generatePalindromicPartition(String s, int pos, List<String> currentList, List<List<String>> result) {
		if(pos == s.length()) {
			//complete string is validated
			result.add(new ArrayList<>(currentList));
			return;
		}
		
		//standard backtracking template
		for(int i=pos; i < s.length(); i++) {
			if(isPalindrome(s, pos, i)) {
				currentList.add(s.substring(pos, i+1));
				//try for remaining string
				generatePalindromicPartition(s, i+1, currentList, result);
				
				//backtrack
				currentList.remove(currentList.size()-1); //last added string
				
			}
		}
	}
	
	private boolean isPalindrome(String s, int startPos, int endPos) {
		while(startPos < endPos) {
				if(s.charAt(startPos) != s.charAt(endPos)) {
					return false;
				}
				startPos++;
				endPos--;
			}
		return true;
	}

	public static void main(String[] args) {
		String input = "aab";
		
		PalindromePartioningOfString palidrome = new PalindromePartioningOfString();
		
		List<List<String>> result = palidrome.partition(input);
		result.forEach(list -> {
			list.forEach(System.out::println);
			System.out.println();
		});

	}

}
