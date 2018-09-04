class Solution {
	public int coinChange(int[] coins, int amount) {
		int[][] dp = new int[coins.length][amount + 1];
		for(int j = 1; j < dp[0].length; j++){
			if(j % coins[0] == 0) dp[0][j] = j / coins[0];
			else dp[0][j] = -1;
		}
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				dp[i][j] = dp[i - 1][j];
				if(j >= coins[i]){
					if(dp[i][j] == -1 && dp[i][j - coins[i]] != -1) dp[i][j] = dp[i][j - coins[i]] + 1;
					else if(dp[i][j] != -1 && dp[i][j - coins[i]] != -1) dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
				}
			}
		}
		return dp[coins.length - 1][amount];
	}
}