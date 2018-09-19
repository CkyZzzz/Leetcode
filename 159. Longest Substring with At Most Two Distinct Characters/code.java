class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0, maxLen = 0;
		while(end < s.length()){
			char curr = s.charAt(end);
			map.put(curr, map.getOrDefault(curr, 0) + 1);
			while(start <= end && map.size() > 2){
				maxLen = Math.max(maxLen, end - start);
				char prev = s.charAt(start);
				map.put(prev, map.get(prev) - 1);
				if(map.get(prev) == 0) map.remove(prev);
				start++;
			}
			end++;
		}
		return Math.max(maxLen, end - start);
	}
}