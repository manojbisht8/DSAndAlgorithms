package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNonDecresingSubSeq {
	
	public static int longestNonDecSubSeq(List<Integer> input) {
		
		Integer[] L = new Integer[input.size()];
		Arrays.fill(L, 1); //default lengths
		
		for(int i = 0; i< input.size(); i++) {
			for(int j=0; j<i; j++) {
				if(input.get(i) >= input.get(j)) {
					L[i] = Math.max(L[i], L[j]+1);
				}
			}
		}
		
		return Collections.max(Arrays.asList(L));
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		
		Integer[] arr = {0, 8, 4, 12,2,10,6, 14, 1, 9};
		
		System.out.print(longestNonDecSubSeq(Arrays.asList(arr)));

	}

}
