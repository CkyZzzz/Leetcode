class Solution {
	//2019 Google OA
	//其实是Edit Distance这道题的变形，两个字符串靠删除来达到一致，换个思路可以理解为第一个字符串靠添加和删除两种功能来达到和第二个字符串一摸一样
	//定义状态：dp[i][j] 表示word1的前i个字符所组成的字符串(prefix)和word2前j个字符所组成的字符串要多少次添加删除操作可以保持一致
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		dp[0][0] = 0;
		for(int i = 1; i < dp.length; i++) dp[i][0] = i;
		for(int j = 1; j < dp[0].length; j++) dp[0][j] = j;
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				if(word1.charAt(i - 1) == word2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				}else{
					dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}