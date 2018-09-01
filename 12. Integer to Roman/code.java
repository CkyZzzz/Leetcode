class Solution {
	public String intToRoman(int num) {
		String[][] dict = new String[][]{
			{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
			{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
			{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
			{"", "M", "MM", "MMM"}
		};
		String result = "";
		String temp = num + "";
		for(int i = temp.length() - 1; i >= 0; i--){
			int value = temp.charAt(temp.length() - 1 - i) - '0';
			result += dict[i][value];
		}
		return result;
	}
}