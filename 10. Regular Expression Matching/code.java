class Solution {
	// T = O(s.length() * p.length())
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		// 对第一行进行处理，这里表示当s的前0个与p的前j个的对应关系
		for(int j = 2; j < dp[0].length; j++){
			if(p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
		}
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
					dp[i][j] = dp[i - 1][j - 1];
				}else if(p.charAt(j - 1) == '*'){
					if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'){
						//这里dp[i][j]的值必须参照dp[i][j - 2], 例如当s = "a" p = "a*a*";
						dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
					}else{
						dp[i][j] = dp[i][j - 2];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}