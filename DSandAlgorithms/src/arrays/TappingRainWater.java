package arrays;

/**
 * @see https://leetcode.com/problems/trapping-rain-water/solution/
 * @author manojbisht
 *
 */
public class TappingRainWater {
	
	/**
	 * Have 2 pointers array left_max[i] and right_max[i] for each position.
	 * water += min(left_max[i], right_max[i]) - h[i]
	 * @param height
	 * @return
	 */
	public static int trap(int[] height) {
		if(height == null || height.length == 0) {
			return 0;
		}
		
		//create leftMax array
		int size = height.length;
		
		int[] leftMax = new int[size];
		leftMax[0] = height[0];
		
		for(int i=1; i < size; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i-1]);
		}
		
		//create leftMax array
		int[] rightMax = new int[size];
		rightMax[size-1] = height[size-1];
				
		for(int i=size-2; i >= 0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i+1]);
		}
		
		int water = 0;
		//for each array position
		for(int i=1; i < size-1; i++) {
			water += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return water;
        
    }

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.print(trap(height));

	}

}
