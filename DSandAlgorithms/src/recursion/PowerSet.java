package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	
	public static void powerSet(List<Integer> input, int selectedIndex, List<Integer> selectedSoFar) {
		
		if(selectedIndex >= input.size()) {
			selectedSoFar.forEach(n -> {
				System.out.print(n + " ");
			});
			System.out.println();
			return;
		}
		
		//select current element
		selectedSoFar.add(input.get(selectedIndex));
		powerSet(input, selectedIndex+1, selectedSoFar);
		
		//don't select current element
		selectedSoFar.remove(selectedSoFar.size()-1);
		//selectedSoFar.remove(input.get(selectedIndex));
		powerSet(input, selectedIndex+1, selectedSoFar);
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(0);
		input.add(1);
		input.add(2);

		powerSet(input, 0, new ArrayList<>());
	}

}
