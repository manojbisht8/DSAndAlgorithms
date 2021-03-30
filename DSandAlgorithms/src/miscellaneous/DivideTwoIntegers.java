package miscellaneous;

/**
 * @see https://leetcode.com/problems/divide-two-integers/
 * @author manojbisht
 *
 */
public class DivideTwoIntegers {
	
	/**
	 * Perform exponential search
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor) {
		
		int sign = 1;
		
		//handle out of range
		if (dividend == -2147483648 && divisor == -1) {
		    return 2147483647;
		}
		
		int quotient = 0;
		
		while(dividend >= divisor) {
			int value = divisor;
			int timesCounter = 1;
			
			//do exponential search
			while(value + value <= dividend) {
				value += value;
				timesCounter += timesCounter; //we will be able to subtract divisor timesCounter times
				
			}
			quotient += timesCounter;
			dividend -= value;
		}
		
		return sign ==-1 ? -quotient: quotient;
	}

	public static void main(String[] args) {
		System.out.println(divide(7, -3));

	}

}
