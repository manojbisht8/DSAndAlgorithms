package arrays;

/**
 * @see https://leetcode.com/problems/gas-station/
 * @author manojbisht
 *
 */
public class GasStation {
	
	/**
	 * 1) If we cannot reach from point A -> B, then a point C in between A and B also cannot reach B. So B can be the next starting point.
	 * 2) If total_tank > 0, then there must be a solution.
	 * @param gas
	 * @param cost
	 * @return
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length == 0) {
			return -1;
		}
		
		int numberOfStations = gas.length;
		
		int startingStation = 0;
		
		int totalTank = 0;
		int currentTank = 0;
		
		for(int i=0; i < numberOfStations; i++) {
			totalTank +=gas[i] - cost[i];
			currentTank +=gas[i] - cost[i];
			
			if(currentTank < 0) {
				//reset startingStation and currentTank
				startingStation = i+1; //make next station as the starting station
				currentTank = 0;
			}
		}
		return totalTank >= 0 ? startingStation: -1;
    }

	public static void main(String[] args) {
		int[] gas  = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		
		//int[] gas  = {2,3,4};
		//int[] cost = {3,4,3};
		
		System.out.print(canCompleteCircuit(gas, cost));

	}

}
