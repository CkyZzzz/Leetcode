class Solution {
	//根本在于从原字符串里从后往前找第一个子字符串是回文字符串，然后把后半部分取反加在开头部位，就形成了新的最短的回文字符串
	public String shortestPalindrome(String s) {
		for(int i = s.length() - 1; i >= 0; i--){
			if(helper(s, 0, i)){
				String prefix = new StringBuilder(s.substring(i + 1)).reverse().toString();
				return prefix + s;
			}
		}
		return s;
	}
	private boolean helper(String s, int start, int end){
		while(start < end){
			if(s.charAt(start++) != s.charAt(end--)) return false;
		}
		return true;
	}
}