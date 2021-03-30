package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @see https://leetcode.com/problems/decode-ways/
 * @author manojbisht
 *
 */
public class DecodeWaysAtoZ {
	
	public int numDecodings(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		
		Map<Integer, Integer> lookUp = new HashMap<>();
		
		return numDecode(s, 0, lookUp);
    }
	
	private int numDecode(String s, int index, Map<Integer, Integer> lookUp) {
		
		//base cases
		//if end of string is reached, its a way to decode
		if(index >= s.length()) {
			return 1;
		}
		
		if(s.charAt(index) == '0') {
			return 0; //solution not possible
		}
		//check lookUp
		if(lookUp.containsKey(index)) {
			return lookUp.get(index);
		}
		int result = numDecode(s, index+1, lookUp);
		
		//if current and next char is valid then add to result
		if(index+2 <= s.length() && Integer.valueOf(s.substring(index, index+2)) <= 26) {
			result += numDecode(s, index+2, lookUp);
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		DecodeWaysAtoZ dAtoZ = new DecodeWaysAtoZ();
		System.out.print(dAtoZ.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));

	}

}
