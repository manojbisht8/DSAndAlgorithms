package stack;

import java.util.Stack;

public class DecodeString {
	
	Stack<Character> stack = new Stack<>();
	
	public String decodeString(String s) {
		if(s == null || s.length() < 2) {
			return s;
		}
		StringBuilder decodedSb = new StringBuilder();
		for(int i=0; i < s.length(); i++) {
			if(s.charAt(i) == '[') {
				continue;
			} else if(s.charAt(i) == ']') {
				String partialStr = constructString();
				if(!stack.isEmpty()) {
					addToStack(partialStr);
				} else {
					decodedSb.append(partialStr);
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		//check for any pending chars
		String remaining = "";
		while(!stack.isEmpty()) {
			remaining = stack.pop() + remaining;
		}
		decodedSb.append(remaining);
		return decodedSb.toString();
    }
	
	private String constructString() {
		String tempStr = "";
		String finalStr = "";
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) { 
				if(!Character.isDigit(stack.peek())) {
					tempStr = stack.pop() + tempStr;
				} else {
					finalStr = expandString(tempStr, Integer.parseInt(String.valueOf(stack.pop())));
					break;
				}
			}
		}
		return finalStr;
	}
	
	private String expandString(String str, int counter) {
		StringBuilder sb = new StringBuilder();
		while(counter > 0) {
			sb.append(str);
			counter--;
		}
		return sb.toString();
	}
	
	private void addToStack(String str) {
		for(int i=0; i< str.length(); i++ ) {
			stack.push(str.charAt(i));
		}
	}

	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("100[leetcode]"));

	}

}
