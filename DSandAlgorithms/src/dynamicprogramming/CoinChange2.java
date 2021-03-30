package dynamicprogramming;

/**
 * @see https://leetcode.com/problems/coin-change-2/solution/
 * @author mbisht
 *
 */
public class CoinChange2 {
	
	/*dp[current= = dp[current] + dp[amount -coinVal]*/
	public int change(int amount, int[] coins) {
		
		int[] dp = new int[amount+1];
		
		//initialize dp
		dp[0] = 1; //one way to get amount 0
		
		for(int i=0; i<coins.length; i++) {
			for(int val = coins[i]; val <= amount; val++) { //no need to check for val < coins[i]
				dp[val] = dp[val] + dp[val-coins[i]];
			}
		}
		
		return dp[amount];
		
        
    }

	public static void main(String[] args) {
		CoinChange2 cc2 = new CoinChange2();
		System.out.print(cc2.change(5,  new int[]{1,2,5}));

	}

}
