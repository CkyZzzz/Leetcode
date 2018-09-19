class Solution {
	public String minWindow(String S, String T) {
		String result = "";
		int len = Integer.MAX_VALUE;
		int start = 0, end = 0;
		int index = 0;
		while(end < S.length()){
			char curr = S.charAt(end);
			char target = T.charAt(index);
			if(curr == target) index++;
			//已经遍历出一个含有T序列的子字符串
			if(index == T.length()){
				//index为T最后一个字符的下标
				index--;
				int temp = end;
				//从后往前走，直到找到一个含有T序列的子字符串
				while(temp >= start && index >= 0){
					char prev = S.charAt(temp);
					char targetR = T.charAt(index);
					if(prev == targetR){
						index--;
					}
					temp--;
				}
				//如果这个序列小于之前的len
				if(end - temp < len){
					result = S.substring(temp + 1, end + 1);
					len = end - temp;
				}
				//关键部分
				start = temp + 2;
				end = start - 1;
				index++;
			}
			end++;
		}
		return result;
	}
}