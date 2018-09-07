class Solution {
	//dp[i][j] 表示下标从i到j的这一段的字符串中不重复的回纹字符串的个数
	public int countPalindromicSubsequences(String S) {
		int mod = 1000000007;
		int[][] dp = new int[S.length()][S.length()];
		for(int i = 0; i < S.length(); i++) dp[i][i] = 1;
		for(int i = 0; i < S.length() - 1; i++) dp[i][i + 1] = 2;
		for(int k = 2; k < S.length(); k++){
			for(int i = 0; i < S.length() - k; i++){
				int j = i + k;
				if(S.charAt(i) == S.charAt(j)){
					int index1 = i + 1;
					int index2 = j - 1;
					while(index1 <= index2 && S.charAt(index1) != S.charAt(j)) index1++;
					while(index1 <= index2 && S.charAt(index2) != S.charAt(j)) index2--;
					if(index1 > index2){
						//e.g. a.............a
						dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
					}else if(index1 == index2){
						//e.g. a......a......a
						dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
					}else{
						//e.g. a..a.......a..a
						//e.g. aabaa
						//aba ---> {a, b, aa, aba} ---> 添加aa ---> {aaa, aba, aaaa, aabaa} ---> {aba}是重复的
						//{aba}的个数对应{b} ---> dp[index1 + 1][index2 - 1]
						//aabaa ---> {a, b, aa, aaa, aaaa, aba, aabaa}
						dp[i][j] = dp[i + 1][j - 1] * 2 - dp[index1 + 1][index2 - 1];
					}
				}else{
					dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]; 
				}
				//Because (a - b) % M = (a % M - b % M) + M when a % M - b % M < 0
				//因为我们要不停的mod, 所以dp[i][j] = dp[i + 1][j - 1] * 2 - dp[index1 + 1][index2 - 1];可能为负数
				//dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];也可能为负数
				dp[i][j] = dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j] % mod;
			}
		}
		return dp[0][S.length() - 1];
	}
}