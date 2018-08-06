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