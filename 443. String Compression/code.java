class Solution {
	public int compress(char[] chars) {
		if(chars == null || chars.length == 0) return 0;
		int start = 0, end = 0;
		while(end < chars.length){
			char curr = chars[end];
			int count = 0;
			while(end < chars.length && chars[end] == curr){
				count++;
				end++;
			}
			chars[start++] = curr;
			if(count > 1){
				String temp = count + "";
				for(int i = 0; i < temp.length(); i++) chars[start++] = temp.charAt(i);
			}
		}
		return start;
	}
}