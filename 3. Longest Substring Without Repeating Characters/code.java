class Solution {
	//T = O(n), S = O(1)
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		Set<Character> set = new HashSet<>();
		int start = 0, end = 0;
		while(end < s.length()){
			char curr = s.charAt(end);
			//发现重复的时候，实际上是把之前遇到的字符进行清洗，一直到清洗掉与curr相同的字符之后在开始加入字符
			if(set.contains(curr)){
				result = Math.max(result, end - start);
				while(start < end){
					char prev = s.charAt(start);
					set.remove(prev);
					start++;
					if(prev == curr) break;
				}
			}
			//不管怎么样都要add(curr)
			set.add(curr);
			end++;
		}
		return Math.max(result, set.size());
	}
}