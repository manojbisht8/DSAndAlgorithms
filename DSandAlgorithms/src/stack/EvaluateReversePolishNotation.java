package stack;

import java.util.Stack;

/**
 * @see https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @author mbisht
 *
 */
public class EvaluateReversePolishNotation {
	
	public static int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0) {
			return 0;
		}
		if(tokens.length == 1) {
			return Integer.valueOf(tokens[0]);
		}
		
		Stack<Integer> stack = new Stack<>();
		
		//add first 2 values to stack
		stack.push(Integer.valueOf(tokens[0]));
		stack.push(Integer.valueOf(tokens[1]));
		
		for(int i=2; i < tokens.length; i++) {
			
			if("+".equals(tokens[i])) {
				int secondVal = stack.pop();
				int firstVal = stack.pop();
				stack.push(firstVal+secondVal);
			} else if ("-".equals(tokens[i])) {
				int secondVal = stack.pop();
				int firstVal = stack.pop();
				stack.push(firstVal-secondVal);
			} else if ("*".equals(tokens[i])) {
				int secondVal = stack.pop();
				int firstVal = stack.pop();
				stack.push(firstVal*secondVal);
			}else if ("/".equals(tokens[i])) {
				int secondVal = stack.pop();
				int firstVal = stack.pop();
				stack.push(firstVal/secondVal);
			} else {
				//add number to stack
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		
		return stack.pop();
	}

	public static void main(String[] args) {
		//String[] input = {"2", "1", "+", "3", "*"};
		
		//String[] input = {"4", "13", "5", "/", "+"};
		
		String[] input = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.print(evalRPN(input));

	}

}
