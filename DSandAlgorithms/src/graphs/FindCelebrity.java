package graphs;

import java.util.HashSet;
import java.util.Set;

/**
*  
* @see https://leetcode.com/problems/find-the-celebrity/solution/
*/
public class FindCelebrity {
	
    public int findCelebrity(int n) {
    	if(n==0) {
    		return -1;
    	}
    	
    	//determine one mayBeCelebrity with based on if he knows a person or not
    	int mayBeCelebrity = 0;
    	for(int i=1; i < n; i++) {
    		if(knows(mayBeCelebrity, i)){
    			//current mayBeCeliberity cannot be a , because it knows somebody
    			//whereas the other node may be a celebrity
    			mayBeCelebrity = i;
    		}
    	}
    	
    	//further probe mayBeCelebrity to verify if all nodes know it
    	if(isCelebrity(mayBeCelebrity, n)) {
    		return mayBeCelebrity;
    	}
    	
    	return -1;
        
    }
    
    private boolean isCelebrity(int mayBeCelebrity, int n) {
    	
    	for(int i=0; i<n; i++) {
    		if(i==mayBeCelebrity) { //ignore itself
    			continue;
    		}
    		if(!knows(i, mayBeCelebrity)) {
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    boolean knows(int a, int b) {
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
