package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TimeBasedKeyValueStore {
	
	    Map<String, List<ValTime>> map;
	
	 	public TimeBasedKeyValueStore() {
	 		this.map = new HashMap<>();
	    }
	    
	    public void set(String key, String value, int timestamp) {
	    	List<ValTime> list = null;
	    	ValTime valTime = new ValTime(value, timestamp);
	    	if(map.containsKey(key)) {
	    		list = map.get(key);
	    	} else {
	    		 list = new ArrayList<>();
	    	}
	    	list.add(valTime);
	    	map.put(key, list);
	    }
	    
	    public String get(String key, int timestamp) {
	    	List<ValTime> list = map.get(key);
	    	if(list == null || list.size() == 0) {
	    		return "";
	    	}
	    	
	    	int index = Collections.binarySearch(list, new ValTime("X", timestamp), 
	    										new Comparator<ValTime>() {
	    										@Override
	    										public int compare(ValTime a, ValTime b) {
	    												return Integer.compare(a.timestamp, b.timestamp);
	    										}
	    		                               });
	    	
	    	if(index >=0) { //found value
	    	 return list.get(index).value;
	    	}
	    	else if (index == -1) {
	    		return "";
	    	} else { //binarysearch will return (-insertionPoint-1)
	    		return list.get(-index-2).value;
	    	}
	        
	    }

	    public static void main(String[] args) {
		  /*List<Integer> numList = new ArrayList<>();
		  numList.add(2); numList.add(5); numList.add(7);
		  System.out.print(Collections.binarySearch(numList, 0));*/
	    	
	    	TimeBasedKeyValueStore tkv = new TimeBasedKeyValueStore();
	    	tkv.set("foo", "bar", 1);
	    	System.out.println(tkv.get("foo", 1));
	    	System.out.println(tkv.get("foo", 3));
	    	tkv.set("foo", "bar2", 4);
	    	System.out.println(tkv.get("foo", 4));
	    	System.out.println(tkv.get("foo", 5));

	    }

}

class ValTime{
	String value;
	int timestamp;
	
	public ValTime(String value, int timestamp) {
		this.value = value;
		this.timestamp = timestamp;
	}
}
