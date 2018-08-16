class Solution {
	public boolean validPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++, j--){
			if(s.charAt(i) != s.charAt(j)){
				if(isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)) return true;
				else return false;
			}
		}
		return true;
	}
	private boolean isPalindrome(String s, int start, int end){
		for(int i = start, j = end; i < j; i++, j--){
			 if(s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}
}