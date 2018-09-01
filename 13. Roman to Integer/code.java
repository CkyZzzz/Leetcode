class Solution {
	public int romanToInt(String s) {
		int result = 0;
		String[][] dict = new String[][]{
			{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
			{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
			{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
			{"", "M", "MM", "MMM"}
		};
		for(int i = 3; i >= 0 && !s.equals(""); i--){
			int j = 9;
			if(i == 3) j = 3;
			for(; j >= 0 && !s.equals(""); j--){
				if(s.startsWith(dict[i][j])){
					result += Math.pow(10, i) * j;
					s = s.substring(dict[i][j].length());
					break;
				}
			}
		}
		return result;
	}
}