package miscellaneous;

/**
 * @see https://leetcode.com/problems/powx-n/
 * @author manojbisht
 *
 */
public class PowerXtoN {
	
	/**
	 * Perform binary recursion
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		
		//handle n -ve
		if(n <0) {
			x = 1/x; //same effect as -ve n
			n = -n; //make it +ve
		}
		
		return power(x,n);
	}
	
	public double power(double x, int n) {
		if(n==0) {
			return 1;
		}
		
		//recursively get half power value
		double halfPowerVal = power(x, n/2);
		
		if(n%2 == 0) { //n multiple of 2
			return halfPowerVal*halfPowerVal; //even
		}
		return halfPowerVal*halfPowerVal*x; //odd 
		
	}

	public static void main(String[] args) {
		
		PowerXtoN power = new PowerXtoN();
		System.out.println(power.myPow(2.00000, -2));
	}

}
