package arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @see https://leetcode.com/problems/text-justification/
 * @author mbisht
 *
 */
public class TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		
		List<String> solution = new ArrayList<>();
		
		List<String> buffer = new ArrayList<>();
		
		int runningCount = 0;
		
		for(int i=0; i < words.length; i++) {
			String currentWord = words[i];
			
			//fill buffer up-to max, if adding this current word fits no more add it to solution
			//buffer.size() is minimum number of spaces needed for this line
			if(currentWord.length() + runningCount + buffer.size() > maxWidth) {
				String line = buildLine(buffer, maxWidth-runningCount, false);
				solution.add(line);
				
				//reinitialize
				runningCount = 0;
				buffer.clear();
			}
			
			//add to buffer
			runningCount += currentWord.length();
			buffer.add(currentWord);
			
			//check if last line, last word ndicates the buffer has last line in it
			if(i == words.length -1) {
				solution.add(buildLine(buffer, maxWidth-runningCount, true));
			}
			
		}
		
		return solution;
		
        
    }
	
	private String buildLine(List<String> buffer, int remainingSpaces, boolean isLastine ) {
		
		StringBuilder line = new StringBuilder();
		
		if(isLastine) {
			//just add one space in between
			for(Iterator<String> it = buffer.iterator(); it.hasNext();) {
				line.append(it.next());
                
                if(it.hasNext()) {
                	line.append(" ");
                	remainingSpaces--;
                }
            }
		} else {
			for(int i=0; i< buffer.size(); i++) {
				
				line.append(buffer.get(i));
				
				if(i < buffer.size() -1) {
				
					//calculate spaces that needs to be added to current word
					int spaceSlots = (buffer.size() - i) -1;
					
					//normalize the spaces, give preference to left/current words
					int spaceWithCurrentWord = (remainingSpaces + spaceSlots - 1)/spaceSlots;
					
					for(int j=0; j < spaceWithCurrentWord; j++) {
						remainingSpaces--;
						line.append(" ");
					}
				}
				
				
			}
			
		}
		//last line has just 1 word
		for(int i=0; i< remainingSpaces; i++) {
			line.append(" ");
		}
		
		return line.toString();
			
		
	}

	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = "This, is, an, example, of, text, justification.".split(",");
		List<String> sol = tj.fullJustify(words, 16);
		
		sol.forEach(System.out::println);

	}

}
