package strings;

public class ToLowerCase {
	
	public String toLowerCase(String str) {
        
        if(str == null || str.length() == 0){
            return str;
        }
        
        char[] strArray = str.toCharArray();
        
        for(int i=0; i< strArray.length; i++) {
        	int charInt = strArray[i];
        	if(charInt >= 65 && charInt <= 90) {
        	
        		int charPos = charInt-65;
        	
        		int lowerCharInt = 97 + charPos;
        	
        		strArray[i] = (char) lowerCharInt;
        	}
        }
        
        return String.valueOf(strArray);
        
        
    }

	public static void main(String[] args) {
		ToLowerCase tlc = new ToLowerCase();
		String input = "LOVELY";
		System.out.println(tlc.toLowerCase(input));

	}

}
