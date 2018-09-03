class Solution {
	public String longestPalindrome(String s) {
		int maxLen = 0;
		String result = "";
		for(int i = 0; i < s.length(); i++){
			String tempStr1 = helper(s, i, i);
			String tempStr2 = helper(s, i, i + 1);
			if(maxLen >= tempStr1.length() && maxLen >= tempStr2.length()) continue;
			else if(tempStr1.length() < tempStr2.length()) result = tempStr2;
			else result = tempStr1;
			maxLen = Math.max(tempStr1.length(), tempStr2.length());
		}
		return result;
	}
	private String helper(String str, int left, int right){
		while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
			left--;
			right++;
		}
		left++;
		return str.substring(left, right);
	}
}