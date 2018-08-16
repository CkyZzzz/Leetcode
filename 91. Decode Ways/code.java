class Solution {
	public int numDecodings(String s) {
		long[] dp = new long[s.length() + 1];
		if(s.charAt(0) == '1' || s.charAt(0) == '2') dp[0] = 1;
		if(s.charAt(0) > '0') dp[1] = 1;
		for(int i = 2; i < dp.length; i++){
			int one = s.charAt(i - 1) - '0';
			int two = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
			if(one > 0) dp[i] = dp[i - 1];
			// 其实这里已经限制了dp[i], 不需要上面的 if(s.charAt(0) == '1' || s.charAt(0) == '2') 条件
			if(two >= 10 && two <= 26) dp[i] += dp[i - 2];
		}
		return (int) dp[s.length()];
	}
}