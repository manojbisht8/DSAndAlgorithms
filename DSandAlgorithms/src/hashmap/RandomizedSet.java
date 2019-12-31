package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
	
	Map<Integer, Integer> map =  null;//to check if it is already present
	List<Integer> intHolder = null;
	Random random = null;
	
	public RandomizedSet() {
		map = new HashMap<>();
		intHolder = new ArrayList<>();
		random = new Random();
	}
        
    
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(map.containsKey(val)) {
    		return false;
    	}
    	map.put(val, map.size());
    	intHolder.add(val);
    	return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val)) {
    		return false;
    	}
    	//shift element to be deleted to last
    	int valToDeleteIndex = map.get(val);
    	int currentLastVal = intHolder.get(intHolder.size()-1);
    	map.put(currentLastVal, valToDeleteIndex);
    	intHolder.set(valToDeleteIndex, currentLastVal);
    	
    	//remove the last element
    	map.remove(val);
    	intHolder.remove(intHolder.size()-1);
    	return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	return intHolder.get(random.nextInt(intHolder.size()));
    }

	public static void main(String[] args) {
		
		 //Your RandomizedSet object will be instantiated and called as such:
		 RandomizedSet obj = new RandomizedSet();
		 boolean param_1 = obj.insert(100);
		 boolean param_2 = obj.insert(200);
		 boolean param_3 = obj.insert(50);
		 System.out.println(obj.getRandom());
		 
		 boolean param_4 = obj.remove(100);
		 System.out.println(obj.getRandom());
		 

	}

}
