package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSetOfSizeK {
	
	public static void powerSetOfSizeK(List<Integer> input, int size, int selectedIndex, List<Integer> selectedSoFar, int soFarIndex) {
		
		if(soFarIndex == size) {
			for (int j = 0; j < size; j++) 
                System.out.print(selectedSoFar.get(j) + " "); 
            System.out.println("");
			return;
			
		}
		
		 if(selectedIndex >= input.size()) { //stop when selectedIndex reached end
			 return;
		 }
		 
		
		
		//select current element
		selectedSoFar.add(soFarIndex, input.get(selectedIndex));
		powerSetOfSizeK(input, size, selectedIndex+1, selectedSoFar, soFarIndex+1);
		
		//don't select current element
		//selectedSoFar.remove(selectedSoFar.size()-1);
		//selectedSoFar.remove(input.get(selectedIndex));
		powerSetOfSizeK(input, size, selectedIndex+1, selectedSoFar, soFarIndex);
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(0);
		input.add(1);
		input.add(2);

		powerSetOfSizeK(input, 2, 0, new ArrayList<>(), 0);
	}

}
