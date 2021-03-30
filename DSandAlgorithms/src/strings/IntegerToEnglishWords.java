package strings;

public class IntegerToEnglishWords {
	
	
	public String numberToWords(int num) {
		if(num == 0) {
			return "Zero";
		}
		StringBuilder rb = new StringBuilder();
		
		while(num > 1000) {
			if(num > 1000000000) {
				int quotient = num/1000000000;
				if(quotient > 0) {
					rb.append(ones(quotient) + "Billion ");
				}
				num = num%1000000000;
			} else if (num > 1000000) {
				int quotient = num/1000000;
				if(quotient > 0) {
					rb.append(hundreds(quotient) + "Million ");
				}
				num = num%1000000;
			} else if (num > 1000) {
				int quotient = num/1000;
				if(quotient > 0) {
					rb.append(hundreds(quotient) + "Thousand ");
				}
				num = num%1000;
			}
		}
		rb.append(hundreds(num));
		
		return rb.toString().trim();
        
    }
	
	public String hundreds(int num) {
		StringBuilder rb = new StringBuilder();
		
		while(num > 10) {
			if(num > 100) {
				int quotient = num/100;
				if(quotient > 0) {
					rb.append(ones(quotient) + "Hundred ");
				}
				num = num%100;
			} else if(num >= 20) {
				int quotient = num/10;
				rb.append(twentyAndMore(quotient));
				num = num%10;
			} else if(num >=10 && num < 20) {
				rb.append(teens(num));
			} else {
				rb.append(ones(num));
			}
		}
		if(num > 0) {
			rb.append(ones(num));
		}
		
		return rb.toString();
        
    }
	
	private String ones(int num) {
		switch(num) {
			case 1: return "One ";
			case 2: return "Two ";
			case 3: return "Three ";
			case 4: return "Four ";
			case 5: return "Five ";
			case 6: return "Six ";
			case 7: return "Seven ";
			case 8: return "Eight ";
			case 9: return "Nine ";
		}
		return "default";
	}
	
	private String twentyAndMore(int num) {
		switch(num) {
			case 2: return "Twenty ";
			case 3: return "Thirty ";
			case 4: return "Fourty ";
			case 5: return "Fifty ";
			case 6: return "Sixty ";
			case 7: return "Seventy ";
			case 8: return "Eightty ";
			case 9: return "Ninety ";
		}
		return "default";
	}
	
	private String teens(int num) {
		switch(num) {
			case 10: return "Ten";
			case 11: return "Eleven";
			case 12: return "Twelve";
			case 13: return "Thirteen";
			case 14: return "Fourteen";
			case 15: return "Fifteen";
			case 16: return "Sixteen";
			case 17: return "Seventeen";
			case 18: return "Eighteen";
			case 19: return "Nineteen";
		}
		return "default";
	}

	public static void main(String[] args) {
		IntegerToEnglishWords itiw = new IntegerToEnglishWords();
		System.out.println(itiw.numberToWords(123));

	}

}
