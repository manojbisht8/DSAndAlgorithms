package miscellaneous;

/**
 * @See https://leetcode.com/problems/string-to-integer-atoi/
 * @author manojbisht
 *
 */
public class StringToInteger {
	
	
	public static int myAtoi(String str) {
		
		int result = 0;
		if(str == null || str.length() == 0) {
			return result;
		}
		
		str = str.trim(); //remove any white spaces
		
		int sign = 1; //1 +ve , -1 -ve
		
		for(int i=0; i< str.length(); i++) {
			if(i==0 && '-' == str.charAt(i)) {
				sign = -1;
				continue;
			}
			if(i==0 && '+' == str.charAt(i)) {
				continue;
			}
			if(!Character.isDigit(str.charAt(i))) {
				return result*sign;
			}
			
		    //handle over flow case
			if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && Integer.MAX_VALUE%10 < (str.charAt(i) - '0'))) {
				return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result*10 + str.charAt(i) - '0';
			
		}
		
		return result*sign;
	}
	

	public static void main(String[] args) {
		System.out.print(myAtoi("  -0012a42"));

	}

}
