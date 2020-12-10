package com.shaip27.algo.array.dyamic.program;

import java.util.Arrays;

public class CoinChange {
	
	public int coinChange(int[] coins, int amount) {
		
		if(amount==0) {
			return 0;
		}
		
		int[] combination = new int[amount+1];
		combination[0] = 1;
		
		for(int coin : coins) {
			for(int amt=1;amt<combination.length;amt++) {
				if(amt >= coin) {
					combination[amt] += combination[amt - coin];
					printAmount(combination);
				}
			}
			System.out.println();
		}
	        
		return combination[amount] > amount ? -1 : combination[amount];
	}
	
	public int coinChange1(int[] coins, int amount) {
		int max = amount + 1;
	    int[] dp = new int[amount + 1];
	    Arrays.fill(dp, max);
	    dp[0] = 0;
	    for (int i = 1; i <= amount; i++) {
	      for (int j = 0; j < coins.length; j++) {
	        if (coins[j] <= i) {
	          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	        }
	      }
	    }
	    return dp[amount] > amount ? -1 : dp[amount];
	  }
	
	
	public int coinChange2(int[] coins, int amount) {
		int max = amount + 1;
	    int[] combination = new int[amount + 1];
	    Arrays.fill(combination, max);
	    combination[0] = 0;
	    
	    for(int amt=1;amt<=amount;amt++) {
	    	for (int coin : coins) {
	    		if(coin <= amt) {
	    			combination[amt] = Math.min(combination[amt], combination[amt - coin]+1);
	    		}
	    		
	    	}
	    }
	    return combination[amount] > amount ? -1 : combination[amount];
	    
	}
	
	

	private void printAmount(int[] combination) {
		for(int i=0; i < combination.length; i++) {
			
			System.out.print(combination[i] + " ");
		}
		System.out.println();
	}



	public static void main(String[] args) {
		
		CoinChange cc = new CoinChange();
		
		int[] coins = {1,2,5};
		int amount = 11;
		
		System.out.println("Minimu coin combination requied to make " + amount + " is:" + cc.coinChange1(coins, amount));

	}

}
