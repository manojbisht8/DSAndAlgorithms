package hashmap;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @See https://leetcode.com/problems/lru-cache/
 * @author manojbisht
 *
 */
public class LRUCache {
	
	private static int CAPACITY = 0;
	
	private Map<Integer, CacheNode> map =  new HashMap<>();
	
	private LinkedList<CacheNode> dq = new LinkedList<>();
	
	public LRUCache(int capacity) {
		CAPACITY = capacity;
    }
    
    public int get(int key) {
    	
    	if(map.containsKey(key)) {
    		CacheNode cacheNode = map.get(key);
    		//update Deque
    		dq.remove(cacheNode);
    		dq.addFirst(cacheNode);
    		
    		return cacheNode.value;
    	}
    	return -1;
     }
    
    public void put(int key, int value) {
    	if(map.containsKey(key)) {
    		//update existing cache node
    		//remove from linkedList not from Map
    		CacheNode cacheNode = map.get(key);
    		dq.remove(cacheNode);
    		
    		//update Node and dq
    		cacheNode.value = value;
        	dq.addFirst(cacheNode);
        	
    	} else { //its new key
    		CacheNode cacheNode = new CacheNode(key, value);
    		if(map.size() == CAPACITY) {
    			CacheNode leastRecUsed = dq.getLast();
    			map.remove(leastRecUsed.key);
    			dq.removeLast();
    		}
    		map.put(key, cacheNode);
    		//update dq
    		dq.addFirst(cacheNode);
    	}
    }

	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);    
		cache.put(4, 1);   
		System.out.println(cache.get(1));      
		System.out.println(cache.get(2));      
	}

}

class CacheNode{
	protected int key;
	protected int value;
	protected CacheNode next;
	protected CacheNode prev;
	
	public CacheNode(int key, int val) {
		this.key = key;
		this.value = val;
	}
}
