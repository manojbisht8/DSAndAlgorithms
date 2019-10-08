package strings;

public class ReverseStringInline {
	
	public static void reverseString(char[] s) {

		if (s == null || s.length < 2) {
			return;
		}

		int start = 0, end = s.length - 1;

		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;

			start++;
			end--;
		}

	}

	public static void main(String[] args) {
		char[] input = {'c', 'r', 'd', 'p'};
		reverseString(input);
		
		for(char c: input) {
			System.out.print(c+ " ");;
		}

	}

}
