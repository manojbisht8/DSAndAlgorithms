package arrays;

public class MaximizeDistanceToClosestPerson {
	
	/**
	 * 
	 * @param seats
	 * @return
	 */
	public static int maxDistToClosest(int[] seats) {

		if (seats == null || seats.length == 0) {
			return 0;
		}

		int startMax = 0, endMax = 0, middleMax = 0;

		int first1Index = -1;
		int last1Index = -1;

		// find the farthest 1 if starting number is 0
		if (seats[0] == 0) {
			for (int i = 1; i < seats.length; i++) {
				if (seats[i] == 0) {
					startMax++;
				} else {
					first1Index = i;
					break;
				}
			}
		} else {
			first1Index = 0;
		}

		// find the farthest 1 if end number is 0
		if (seats[seats.length - 1] == 0) {
			for (int i = seats.length - 2; i >= 0; i--) {
				if (seats[i] == 0) {
					endMax++;
				} else {
					last1Index = i;
					break;
				}
			}
		} else {
			last1Index = seats.length - 1;
		}

		// calculate max gap between 1s in between
		int runningMax = 0;
		for (int i = first1Index + 1; i <= last1Index - 1; i++) {
			if (seats[i] == 0) {
				runningMax++;
			} else {
				runningMax = 0;
			}
			if (runningMax > middleMax) {
				middleMax = runningMax;
			}
		}
		middleMax = (middleMax % 2) == 0 ? middleMax/2 : middleMax/2 + 1;

		return Math.max(Math.max(startMax+1, endMax+1), middleMax);

	}

	public static void main(String[] args) {
		//int[] seatArrangement = {1,0,0,0,1,0,1};
		//int[] seatArrangement = {1,0,0,0};
		//int[] seatArrangement = {1,1,0,1,1};
		int[] seatArrangement = {1,1,0,0,0,1,0};
		System.out.print(maxDistToClosest(seatArrangement));

	}

}
