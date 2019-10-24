package recursion;

public class GenerateAllMatchedParenthesisOfGivenSize {

	
	
	public static void generateAllMatchedParen(String strSoFar, int n, int open, int close) {
		
		if(close == n) {
			System.out.println(strSoFar);
			return;
		}
		
		//see if unmatched, if so match them
		if(open > close) {
			generateAllMatchedParen(strSoFar+")", n, open, close+1);
		}
		
		if(open < n) { //scope to add more
			generateAllMatchedParen("("+strSoFar, n, open+1, close);
		}
		
	}
	
    public static void generateAllMatchedParen2(String strSoFar, int n, int count) {
		
		if(count == n) {
			System.out.println(strSoFar);
			return;
		}
		
		//see if unmatched, if so match them
		
		generateAllMatchedParen2("("+strSoFar+")", n, count+1);
		generateAllMatchedParen2(strSoFar+"()", n, count+1);
	}
    
    public static void generateAllMatchedParen3(char[] strSoFar, int n, int pos, int open, int close) {
		
		if(close == n) {
			for(char c: strSoFar) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		
		//see if unmatched, if so match them
		if(open > close) {
			strSoFar[pos] = ')';
			generateAllMatchedParen3(strSoFar, n, pos+1, open, close+1);
		}
		
		if(open < n) { //scope to add more
			strSoFar[pos] = '(';
			generateAllMatchedParen3(strSoFar, n, pos+1, open+1, close);
		}
		
	}
		
	
	
	public static void main(String[] args) {
		//generateAllMatchedParen("", 3, 0, 0);
		//generateAllMatchedParen2("", 3, 0);
		generateAllMatchedParen3(new char[6], 2, 0, 0, 0);

	}

}
