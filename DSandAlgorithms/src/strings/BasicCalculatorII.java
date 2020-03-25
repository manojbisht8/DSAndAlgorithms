package strings;

import java.util.Stack;

/**
 * @see https://leetcode.com/problems/basic-calculator-ii/
 * @author manojbisht
 *
 */
public class BasicCalculatorII {
	
	public static int calculate(String s) {
		
		s = s.trim(); //trim white-spaces
		
		int result =0;
		
		//keep track of prevOperand and prevVal
		char prevOper = '+'; //prevOper in + by default, as all numbers are positive
		int prevVal = 0;
		
		for(int i=0; i< s.length(); i++) {
			char currentChar = s.charAt(i);
			if(currentChar == ' ') {
				continue;
			}
			if(Character.isDigit(currentChar)) {
				//compute current val
				int currentVal = currentChar - '0';
				
				//if next digits are digits, compute these as currentVal
				while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
					currentVal = currentVal*10 + s.charAt(i+1) - '0';
					i++;
				}
				
				if(prevOper == '+') {
					result += prevVal;
					prevVal = currentVal;
				}
				if(prevOper == '-') {
					result += prevVal;
					prevVal = -currentVal;
				}
				if(prevOper == '*') {
					prevVal = prevVal*currentVal;
				}
				if(prevOper == '/') {
					prevVal = prevVal/currentVal;
				}
				
			} else { //its an operand
				prevOper = currentChar;
				
			}
		}
		
		//add last remaining prevVal to result
		result +=prevVal;
		
		return result;
	}

	public static void main(String[] args) {
		String input ="3+2*2";
		System.out.print(calculate(input));

	}

}
