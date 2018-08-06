// 这是一道dp题，在遍历中，以当前这个index下的字符为开始，向前遍历，意思就是当前字符必须包含在待检查的字符串中。
// 时间复杂度是T = O(n^2) 还有一种T = O(n)的解法，也是dp的方法如果当前是'(', dp[i] = 0; 
// 如果当前是')', 如果s[i - 1] = '(', dp[i] = dp[i - 2] + 2, 
// 如果s[i - 1] = ')' 且s[i - 1 - dp[i - 1] = '(', dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]]; 
// 但是记住有i < 0时 为0
class Solution {
	//T = O(N ^ 2), S = O(1)
	public int longestValidParentheses(String s) {
		int result = 0;
		for(int i = 1; i < s.length(); i++){
			int temp = helper(s, i);
			result = Math.max(result, temp);
		}
		return result;
	}
	private int helper(String s, int index){
		int stack = 0;
		int len = 0;
		int maxLen = 0;
		while(index >= 0){
			if(s.charAt(index) == ')') stack++;
			if(s.charAt(index) == '(') stack--;
			if(stack < 0) break;
			len++;
			if(stack == 0) maxLen = Math.max(maxLen, len);
			index--;
		}
		return maxLen;
	}
}