package arrays;

public class DuplicateZeros {
	
    public void duplicateZeros(int[] arr) {
    	
    	if(arr == null || arr.length == 0) {
    		return;
    	}
    	
    	//count the number of relevent zeros
    	int zeroCount = 0;
    	for(int i=0 ;(i+zeroCount)<= arr.length; i++) {
    		if(arr[i] == 0) {
    			zeroCount++;
    		}
    	}
    	
    	//if no zeros return as-is
    	if(zeroCount == 0) {
    		return;
    	}
    	
    	//have a 2 index approach and start from end
    	for(int right = arr.length-1, left = arr.length-1-zeroCount; left >= 0; ) {
    		if(arr[left] == 0) {
    			arr[right] = 0;
    			arr[right-1] = 0;
    			right -= 2;
    			left--;
    		} else {
    			arr[right] = arr[left];
    			right--;
    			left--;
    		}
    	}
    	
    }

	public static void main(String[] args) {
		DuplicateZeros dzs = new DuplicateZeros();
		//int[] input = {1,0,2,3,0,4,5,0};
		int[] input = {8,4,5,0,0,0,0,7};
		dzs.duplicateZeros(input);
		for(int i=0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(" ");
		}

	}

}
