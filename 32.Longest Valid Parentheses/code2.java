class Untitled {
	//T = O(n) S = 0(n)
	public int longestValidParentheses(String s) {
		//定义状态：dp[i]指的是包含第i个字符能组成的最长valid parentheses
		int[] dp = new int[s.length()];
		int result = 0;
		for(int i = 1; i < s.length(); i++){
			char curr = s.charAt(i);
			if(curr == ')'){
				char prev = s.charAt(i - 1); 
				if(prev == '('){
					dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
				}else{
					if(i >= 1 + dp[i - 1] && s.charAt(i - 1 - dp[i - 1]) == '('){
						dp[i] = 2 + dp[i - 1] + (i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
					}
				}
				result = Math.max(result, dp[i]);
			}
		}
		// for(int i = 0; i < dp.length; i++) System.out.print(dp[i] + " ");
		return result;
	}
}