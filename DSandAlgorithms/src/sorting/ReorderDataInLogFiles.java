package sorting;

import java.util.Arrays;

/**
 * @see https://leetcode.com/problems/reorder-data-in-log-files/
 * @author manojbisht
 *
 */
public class ReorderDataInLogFiles {
	
	public static String[] reorderLogFiles(String[] logs) {
		if(logs == null || logs.length < 2) {
			return logs;
		}
		
		//perform custom sort
		Arrays.sort(logs, (log1, log2) -> {
			String[] logSplit1 = ((String) log1).split("\\s+", 2);
			String[] logSplit2 = ((String) log2).split("\\s+", 2);
			
			//check if digit
			boolean digit1 = Character.isDigit(logSplit1[1].charAt(0));
			boolean digit2 = Character.isDigit(logSplit2[1].charAt(0));
			
			//if both are letters
			if(!digit1 && !digit2) {
				int compVal = logSplit1[1].compareTo(logSplit2[1]);
				if(compVal == 0) { //both are same
					compVal = logSplit1[0].compareTo(logSplit2[0]);;
				}
				return compVal;
			}
			//check other combinations, both digits, one digit one letters
			return digit1 ? (digit2 ? 0 : 1) : -1;
		});
		
		return logs;
    }

	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		String[] sortedlogs = reorderLogFiles(logs);
		for(String s: sortedlogs) {
			System.out.print(s +" ");
		}

	}

}
