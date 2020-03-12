package arrays;

import java.util.Random;

public class ShuffleAnArray {
	
	int[] array;
	int[] original;
	
	Random random = new Random();
	
	 public ShuffleAnArray(int[] nums) {
		 array = nums;
		 original = array.clone();
		 
	        
	  }
	
	/** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	array = original;
    	original = original.clone();
    	
    	return array;
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	
    	for(int i=0; i < array.length; i++) {
    		
    		//get the index to swap current element with
    		int swapIndex = random.nextInt(array.length-i)+i;
    		swap(i, swapIndex);
    		
    	}
    	return array;
    }
    
    private void swap(int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }

	public static void main(String[] args) {
		 int[] nums = {1,2,3};
		 ShuffleAnArray obj = new ShuffleAnArray(nums);
		 int[] param_1 = obj.reset();
		 int[] param_2 = obj.shuffle();
		 
		 for(int i: param_2) {
			 System.out.println(i);
		 }
	}

}
