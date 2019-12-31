package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> result = new ArrayList<>();
		
		Map<String, List<String>> map = new HashMap<>();
		
		for(int i=0; i < strs.length; i++) {
			char[] currentStr = strs[i].toCharArray();
			Arrays.sort(currentStr);
			String sortedStr = new String(currentStr);
			
			if(map.containsKey(sortedStr)) {
				List<String> existingList = map.get(sortedStr);
				existingList.add(strs[i]);
			} else {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(sortedStr, list);
			}
		}
		
		map.values().forEach(list -> {
			result.add(list);
		});
		
		return result;
        
    }

	public static void main(String[] args) {
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> result = groupAnagrams(input);
		
		result.forEach(list -> {
			list.forEach(str -> System.out.print(str + " "));
			System.out.println();
		});
		

	}

}
