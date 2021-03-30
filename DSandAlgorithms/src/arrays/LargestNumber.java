package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see https://leetcode.com/problems/largest-number/
 * @author manojbisht
 *
 */
public class LargestNumber {
	
	/**
	 * Create a custom Comparator
	 * @param nums
	 * @return
	 */
	public String largestNumber(int[] nums) {
		String result = "";
		if(nums == null || nums.length == 0) {
			return "";
		}
		
		//convert int[] to string[]
		String[] strArray = new String[nums.length];
		for(int i=0; i< nums.length; i++) {
			strArray[i] = String.valueOf(nums[i]);
		}
		
		//sort in descending order
		Arrays.sort(strArray, new NumComparator());
		
		//form largest num by appending all nums
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0 ; i< strArray.length; i++) {
			strBuilder.append(strArray[i]);
		}
		//Edge case for "000.."
		if(strBuilder.toString().charAt(0) == '0') {
			return "0"; //whole string is zero
		}
		return strBuilder.toString();
    }



	public static void main(String[] args) {
		int[] input = {3,30,34,5,9};
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(input));
	}

}

class NumComparator implements Comparator<String>{
	
	public int compare(String s1, String s2) {
		String append1 = s1 + s2;
		String append2 = s2 + s1;
		
		//return from largest to smallest order
		return append2.compareTo(append1);
	}
	
}
