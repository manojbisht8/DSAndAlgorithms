package dynamicprogramming;

public class LevenshteinDistance {
	
	public static int getLevenshteinDistance(String A, String B) {
		
		if(A == null || A.length() == 0) {
			return B.length();
		}
		if(B == null || B.length() == 0) {
			return A.length();
		}
		
		int[][] levenshteinLookup = new int[A.length()+1][B.length()+1];
		
		//fill up the lookup table
		for(int row=0; row <= A.length(); row++) {
			for(int col=0; col <= B.length(); col++) {
				if(row == 0) {
					levenshteinLookup[row][col] = col; //same as if B is empty
					continue;
				}
				if(col == 0) {
					levenshteinLookup[row][col] = row; //same as if A is empty
					continue;
				}
				
				//if characters are same, move to next
				if((A.charAt(row-1) == B.charAt(col-1))) {
					levenshteinLookup[row][col] = levenshteinLookup[row-1][col-1];
				} else {
					levenshteinLookup[row][col] = 1 + Math.min(levenshteinLookup[row-1][col-1], 
							Math.min(levenshteinLookup[row-1][col], levenshteinLookup[row][col-1]));
				}
			}
		}
		
		return levenshteinLookup[A.length()][B.length()];
	}

	public static void main(String[] args) {
		int lDist = getLevenshteinDistance("sunday", "saturday");
		System.out.println(lDist);

	}

}
