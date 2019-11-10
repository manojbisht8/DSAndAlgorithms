package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreetyPrintMinimizeMesiness {
	
	/*Return minimum messiness due to end spaces in each line.
	 * Messiness = (NumOfEndSpaces * NumOfEndSpaces)
	 */
	
	public static int minMessiness(List<String> words, int lineSize) {
		
		//lookup table to hold messiness
		int[] M = new int[words.size()];
		
		//default messiness
		Arrays.fill(M, Integer.MAX_VALUE);
		
		//initialize for first word
		int numOfSpaces = lineSize - words.get(0).length();
		M[0] = numOfSpaces * numOfSpaces;
		
		//for each word 
		for(int i=1; i < words.size(); i++) {
			//case 1, messiness of current word = M[previous word] + remaining spaces square
			numOfSpaces = lineSize - words.get(i).length();
			M[i] = M[i-1] + numOfSpaces * numOfSpaces;
			
			//for case 2, calculate re-adjusting each word i-1, i-2, etc and calculate min messiness
			for(int j = i-1; j >=0; j--) {
				numOfSpaces -= (words.get(j).length() + 1); //+1 for space
				
				if(numOfSpaces < 0) {
					break;
				}
				
				int messinessTillJ = j-1 < 0? 0: M[j-1];
				int currentMesiness = numOfSpaces*numOfSpaces;
				
				//try with readjusted messiness
				M[i] = Math.min(M[i], messinessTillJ + currentMesiness);
			}
		}
		
		return M[words.size()-1];
		
	}

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("aaa");
		words.add("bbb");
		words.add("c");
		words.add("d");
		words.add("ee");
		words.add("ff");
		words.add("ggggggg");
		System.out.print(minMessiness(words, 11));

	}

}
