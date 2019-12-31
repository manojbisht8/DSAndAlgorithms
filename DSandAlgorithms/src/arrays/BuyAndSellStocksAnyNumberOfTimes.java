package arrays;

public class BuyAndSellStocksAnyNumberOfTimes {
	
	public static int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        //keep inditifying maxVal and minVal
        int minVal = 0;
        int maxVal = 0;
        int i=0;
        
        while(i < prices.length-1){
            //find the next minVal
            while(i < prices.length-1 && prices[i] >= prices[i+1]){
               i++; 
            }
            //at this point we have min val
            minVal = prices[i];
            
            //find the next max Val
            while(i < prices.length-1 && prices[i] <= prices[i+1]){
               i++; 
            }
            //at this point we have max val
            maxVal = prices[i];
            
            maxProfit += maxVal-minVal;
            
        }
        return maxProfit;
        
    }

	public static void main(String[] args) {
		int[] input = {7,1,5,3,6,4};
		System.out.print(maxProfit(input));

	}

}
