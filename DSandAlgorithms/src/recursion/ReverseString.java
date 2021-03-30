package recursion;

public class ReverseString {
	
	
	public static void reverse(String input, int index) {
		//base case
		if(index == input.length()) {
			return;
		}
		reverse(input, index+1);
		System.out.print(input.charAt(index));
	}
	
	public static void reverseInplace(char[] s) {
		reverseInplaceHelper(s, 0, s.length-1);
		
	}
	
	public static void reverseInplaceHelper(char[] s, int l, int r) {
		//base case
		if(l > r) {
			return;
		}
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
		reverseInplaceHelper(s, l+1, r-1);
		
	}

	public static void main(String[] args) {
		//reverse("recursion", 0);
		char[] input = "recursion".toCharArray();
		reverseInplace(input);
		for(char c: input) {
			System.out.print(c);
		}
	}

}
