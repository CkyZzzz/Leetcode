class Solution {
	public int minCostII(int[][] costs) {
		if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
		int[][] dp = new int[costs.length][costs[0].length];
		for(int j = 0; j < costs[0].length; j++){
			dp[0][j] = costs[0][j];
		}
		for(int i = 1; i < costs.length; i++){
			for(int j = 0; j < costs[0].length; j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = 0; k < costs[0].length; k++){
					if(k == j) continue;
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
				}
				dp[i][j] += costs[i][j];
			}
		}
		int result = Integer.MAX_VALUE;
		for(int j = 0; j < costs[0].length; j++){
			result = Math.min(result, dp[costs.length - 1][j]);
		}
		return result;
	}
}