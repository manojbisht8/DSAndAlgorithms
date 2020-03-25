package dynamicprogramming;

import java.util.Arrays;

/**
 * @see https://leetcode.com/problems/coin-change/
 * @author manojbisht
 *
 */
public class CoinChange {
	
	/**
	 * coins = min[(amount -coin1)+1, , (amount -coin1)+1...]
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length == 0) {
			return -1;
		}
		int[] lookUp = new int[amount+1];
		//fill up array with Max
		Arrays.fill(lookUp, amount+1);
		
		//zero amount
		lookUp[0] = 0;
		
		for(int i=1; i <= amount; i++) {
			for(int j=0; j < coins.length; j++) {
				if(i >= coins[j]) { //if amount is greater than coin amount
					lookUp[i] = Math.min(lookUp[i], lookUp[i-coins[j]]+1);
				}
			}
		}
		return lookUp[amount] > amount? -1: lookUp[amount];
   }

	public static void main(String[] args) {
		int[] coins = {3,5};
		//int[] coins = {186,419,83,408};
				
		System.out.print(coinChange(coins, 4));
		

	}

}
