class Solution {
	public int minCost(int[][] costs) {
		if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
		int row = costs.length;
		int col = 3;
		int[][] dp = new int[row][3];
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		for(int i = 1; i < row; i++){
			 dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
			 dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
			 dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
		}
		return Math.min(Math.min(dp[row - 1][0], dp[row - 1][1]), dp[row - 1][2]);
	}
}