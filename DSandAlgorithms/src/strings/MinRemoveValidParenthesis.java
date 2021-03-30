package strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @see https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * @author mbisht
 *
 */
public class MinRemoveValidParenthesis {
	
	/* 1. Store "(" index in stack
	 * 2. Remove any occurrence of ")" from stack
	 * 3. If we find ")" and stack is already empty, this is index to be removed
	 * 4. Any left over "(" indexes are unmatched, needs to be removed
	 */
	public static String minRemoveToMakeValid(String s) {
		if(s == null) {
			return s;
		}
		Stack<Integer> stack = new Stack<>();
		
		//set to store index to remove
		Set<Integer> removeIndexSet = new HashSet<>();
		
		for(int i=0; i< s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}
			if(s.charAt(i) == ')') {
				if(stack.isEmpty()) {
					removeIndexSet.add(i);
				} else {
					stack.pop();
				}
			}
		}
		
		//add any left-over "(" index to set
		while(!stack.isEmpty()) {
			removeIndexSet.add(stack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< s.length(); i++) {
			if(!removeIndexSet.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
     }

	public static void main(String[] args) {
		System.out.print(minRemoveToMakeValid("lee(t(c)o)de)"));

	}

}
