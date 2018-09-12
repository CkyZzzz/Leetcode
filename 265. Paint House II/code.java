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
	
	//找出当前行以来第一小的值和第二小的值
	public int minCostII(int[][] costs) {
		if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
		int rows = costs.length, cols = costs[0].length;
		if(cols == 1) return (rows == 1 ? costs[0][0] : -1);
		int prevMin = 0, prevMinIdx = -1, prevSecMin = 0;
		for(int i = 0; i < rows; i++){
			int min = Integer.MAX_VALUE, minIdx = -1, secMin = Integer.MAX_VALUE;
			for(int j = 0; j < cols; j++){
				int val = costs[i][j] + (j == prevMinIdx ? prevSecMin : prevMin);
				if(val < min){
					secMin = min;
					min = val;
					minIdx = j;
				}else if(val < secMin){
					secMin = val;
				}
			}
			prevMin = min;
			prevMinIdx = minIdx;
			prevSecMin = secMin;
		}
		return prevMin;
	}
}